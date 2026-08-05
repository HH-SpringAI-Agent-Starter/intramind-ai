package com.agentstack.intramind.rag;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class KnowledgeBaseServiceTest {

    @Test
    void searchFallsBackGracefullyWithoutVectorStore() {
        KnowledgeBaseService service = new KnowledgeBaseService();
        List<String> results = service.search("报销流程");
        assertThat(results).isNotEmpty();
        assertThat(results.get(0)).contains("tenant=demo");
    }

    @Test
    void addThrowsWhenVectorStoreNotConfigured() {
        KnowledgeBaseService service = new KnowledgeBaseService();
        assertThatThrownBy(() -> service.add(List.of()))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("VectorStore not configured");
    }
}
