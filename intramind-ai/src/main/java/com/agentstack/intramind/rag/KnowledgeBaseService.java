package com.agentstack.intramind.rag;

import com.agentstack.intramind.tenant.TenantContext;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KnowledgeBaseService {

    @Autowired(required = false)
    private VectorStore vectorStore;

    /**
     * Semantic search over the tenant-scoped knowledge base.
     * <p>When a VectorStore (PGVector) is configured this performs a real
     * similarity search filtered by the current tenant id; otherwise it
     * returns a deterministic fallback so the demo keeps working without
     * infrastructure.</p>
     */
    public List<String> search(String query) {
        String tenantId = TenantContext.getTenantId();
        if (vectorStore == null) {
            return List.of(
                    "tenant=" + tenantId + "; matched policy chunk for query: " + query,
                    "kb://" + tenantId + "/sample-doc/1"
            );
        }
        SearchRequest request = SearchRequest.builder()
                .query(query)
                .topK(5)
                .filterExpression("tenant_id == '" + tenantId + "'")
                .build();
        return vectorStore.similaritySearch(request).stream()
                .map(doc -> "[tenant=" + tenantId + ", score=" + String.valueOf(doc.getScore()) + "] " + doc.getText())
                .toList();
    }

    /**
     * Indexes documents into the vector store, tagging each with the current
     * tenant id so retrieval stays isolated per tenant.
     */
    public void add(List<Document> documents) {
        if (vectorStore == null) {
            throw new IllegalStateException(
                    "VectorStore not configured; check spring.ai.vectorstore.pgvector settings");
        }
        String tenantId = TenantContext.getTenantId();
        documents.forEach(doc -> doc.getMetadata().put("tenant_id", tenantId));
        vectorStore.add(documents);
    }
}
