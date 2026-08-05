## [1.1.0] - 2026-08-05

### Added
- Real PGVector RAG retrieval in `KnowledgeBaseService`
  - Wire Spring AI `VectorStore.similaritySearch()` with tenant metadata filter
  - Graceful fallback when VectorStore is not configured (demo keeps working)
- `KnowledgeBaseService.add()` to index tenant-scoped documents into the vector store
- Unit tests: `KnowledgeBaseServiceTest` (fallback + missing-vector-store paths)

### Changed
- `KnowledgeBaseService` upgraded from demo stub to VectorStore-backed implementation

---

## [1.0.1] - 2026-07-23

### Documentation
- Update root README with cross-project matrix table
- Fix emoji rendering issues in README
- Clean up formatting and add project structure section

# Changelog

All notable changes to IntraMind AI Community Edition will be documented in this file.

## [0.1.0] - 2026-07-09

### Added
- Initial Community Edition release
- Document intelligent Q&A with RAG pipeline
  - PDF/Word/Markdown/HTML/TXT document parsing
  - PGVector vector store for semantic search
  - Ollama local model integration (Qwen2.5:7b recommended)
- Knowledge graph auto-construction
  - Entity extraction and relationship mapping
  - Graph-based knowledge exploration
- Meeting minutes AI summarization
  - Voice recording transcription pipeline
  - Key point extraction and action item tracking
- Multi-tenant isolation architecture
  - Tenant-aware data partitioning
  - Role-based access control (RBAC)
- Agent Tool Calling framework
  - Document search tool, Knowledge graph tool, Meeting tool
- External system connectors (Feishu, Yuque, OSS)
- RESTful API with OpenAPI 3.0 specification
- Docker Compose one-click deployment
