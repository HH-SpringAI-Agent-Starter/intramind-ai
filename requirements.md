# IntraMind AI — 功能需求文档

> **企业知识管理 AI Agent** — 私有化部署，文档智能问答、知识图谱、会议纪要。

## 核心功能

| 模块 | 社区版 | 企业版 |
|------|--------|--------|
| 文档智能问答 | ✅ 多格式上传 + RAG + 引用溯源 | ✅ + 批量处理 |
| 知识图谱 | ✅ 实体提取 + 关系映射 | ✅ + 增量更新 |
| 会议纪要 | ✅ ASR + 关键点提取 + 行动项 | ✅ + 自动报告 |
| 权限管理 | ❌ | ✅ RBAC + 多租户 |
| 审计合规 | ⚠️ 免责声明 | ✅ 审计日志 + 敏感拦截 |

## 技术架构

```
User → [Agent Layer] → [Tool Layer] → [Infrastructure]
                        ├ Doc Tool      ├ PGVector
                        ├ KGraph Tool   ├ MinIO
                        └ Meeting Tool  └ Ollama LLM
```

## 技术栈

| 层级 | 技术 | 版本 |
|------|------|------|
| Agent 框架 | Spring AI | 2.0.0 |
| Web 框架 | Spring Boot | 4.0.0 |
| 语言 | Java | 21 |
| LLM | Ollama (qwen2.5) | latest |
| 向量数据库 | PGVector | latest |
| 关系数据库 | PostgreSQL | 16 |
| 对象存储 | MinIO | latest |
| 构建工具 | Maven | 3.9+ |

## 部署架构

- Docker Compose 一键部署
- 支持本地 Ollama 或云端模型
- 数据完全私有化

---

> 详细需求文档见 [intramind-ai/requirements.md](./intramind-ai/requirements.md)
