# Changelog

## v1.0.0 (2026-06-30)

### ✨ 新功能
- 多格式文档上传与智能问答（PDF/Word/MD/HTML/TXT）
- PGVector 语义检索 + HNSW 索引
- 实体自动提取与知识图谱构建
- 会议录音上传 → ASR 转写 → 关键点提取
- 多轮对话上下文支持
- 多租户数据隔离与 RBAC 权限

### 🚀 架构
- Spring AI 2.0 Agent + Tool Calling 架构
- Ollama 本地 LLM 接入
- MinIO 对象存储，PostgreSQL 16 + PGVector

### 📦 部署
- Docker Compose 一键启动
- .env 配置化
- 社区版 Apache-2.0 开源

## v0.5.0 (2026-05-15)

### ✨ 新功能
- Agent Tool Calling 框架搭建
- 文档分块与向量化引擎
- 基础 RAG 问答链路
- LDAP/OAuth2 登录集成

### 🐛 修复
- 大文档分块性能优化
- 多轮对话上下文丢失修复

---

> 完整更新记录见 [intramind-ai/CHANGELOG.md](./intramind-ai/CHANGELOG.md)
