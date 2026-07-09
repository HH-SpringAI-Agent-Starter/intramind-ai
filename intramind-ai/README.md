# IntraMind AI Community

        企业制度流程智能客服 Agent：基于 **Spring AI 2.0 + Agent Tool Calling + PGVector RAG + Ollama** 的智能客服与问答项目模板。


        ## 场景定位

        接入飞书、语雀、云 OSS、制度流程文档，让 Agent 精准解答员工关于制度、流程、报销、请假、采购、权限申请等问题。

        ## 版本定位：开源版


- 单租户或轻量租户 Header 演示
- 本地 Ollama 模型，适合开发和 Demo
- 基础 RAG 知识库、基础工具调用、REST API
- Apache-2.0 友好的开源项目结构
- 可作为 Open Core 的免费获客漏斗

        ## 技术栈

| 层级 | 技术 | 版本 | 用途 |
|------|------|------|------|
| Agent 框架 | Spring AI | 2.0.0 | Agent 编排与 Tool Calling |
| 应用框架 | Spring Boot | 4.0.0 | 微服务底座 |
| 语言 | Java | 21 | 开发语言 |
| 构建工具 | Maven | 3.9+ | 依赖与构建 |
| LLM | Ollama (qwen2.5:7b) | latest | 本地模型推理 |
| Embedding | Ollama (mxbai-embed-large) | latest | 文档向量化 |
| 向量数据库 | PGVector | latest | 语义检索 HNSW |
| 关系数据库 | PostgreSQL | 16 | 业务数据 |
| 对象存储 | MinIO / Aliyun OSS | latest | 文档存储 |
| 会话缓存 | Redis | 7 | 对话上下文 |
| 可观测性 | Prometheus / Actuator | latest | 监控与健康 |
| 数据库迁移 | Flyway | 10.x | Schema 版本管理 |

> 📖 详细架构见 [docs/architecture.md](docs/architecture.md) · API 文档见 [docs/api.md](docs/api.md) · 部署指南见 [docs/deployment.md](docs/deployment.md)

---

        ## 核心能力

        - Spring AI `ChatClient` Agent 编排
        - `@Tool` 工具调用
        - PGVector 私有知识库 RAG
        - Ollama 本地模型默认配置
        - Docker Compose 一键启动基础设施
        - Flyway 数据库初始化
        - Prometheus / Actuator 可观测性

        ## 工具清单

        - `feishu_doc_search`
- `yuque_page_fetch`
- `oss_policy_doc_loader`
- `hr_policy_lookup`
- `workflow_router`
- `ticket_suggestion`

        ## 连接器方向

        - Feishu/Lark Docs
- Yuque
- Aliyun OSS / MinIO
- 企业工单系统

        ## API

        | Method | Path | Description |
        |---|---|---|
        | POST | `/api/agent/ask` | 员工制度/流程问答 |
| POST | `/api/kb/sync` | 同步飞书/语雀/OSS 知识库 |
| GET | `/api/tickets/suggest` | 根据问题推荐工单流转 |
        | POST | `/api/kb/sync` | 同步知识库 |
        | GET | `/api/kb/search?q=` | 检索知识库 |

        ## 本地运行

        ```bash
        cp .env.example .env
        docker compose up -d
        ollama pull qwen2.5:7b
        ollama pull mxbai-embed-large
        mvn spring-boot:run
        ```

        ## 示例调用

        ```bash
        curl -s -X POST http://localhost:8080/api/agent/ask \
          -H 'Content-Type: application/json' \
          -H 'X-Tenant-Id: demo' \
          -d '{
            "question": "报销差旅费需要哪些材料？超过 30 天还能报销吗？",
            "userId": "u_1001",
            "sessionId": "s_demo"
          }' | jq
        ```

        ## 目录结构

        ```text
        src/main/java/.../agent        Agent 编排
        src/main/java/.../tools        工具调用
        src/main/java/.../rag          RAG 服务
        src/main/java/.../tenant       多租户上下文
        src/main/resources/kb          示例知识库
        src/main/resources/db          Flyway 初始化 SQL
        docs/                          架构、API、部署、定价、演示脚本
        ```

        ## GitHub 上传

        ```bash
        git init
        git add .
        git commit -m "Initial commit: IntraMind AI Community"
        gh repo create intramind-ai --public --source=. --remote=origin --push
        ```

## 架构图

```mermaid
graph TD
    Client[员工 / API Client] --> Gateway[Spring Boot API Gateway]
    Gateway --> Agent[Agent Orchestrator ChatClient]
    Agent --> Tools[Tool Registry]
    Tools --> Feishu[飞书文档 Tool]
    Tools --> Yuque[语雀文档 Tool]
    Tools --> OSS[OSS 制度文档 Tool]
    Tools --> HR[HR 政策 Tool]
    Tools --> Workflow[工单路由 Tool]
    Agent --> RAG[RAG Service]
    RAG --> Embed[Embedding mxbai-embed-large]
    RAG --> PGVector[(PGVector 向量库)]
    Agent --> LLM[LLM Ollama qwen2.5]
    Gateway --> Redis[(Redis 会话缓存)]
    Gateway --> DB[(PostgreSQL)]
```

## 许可

- **社区版**：[Apache-2.0](LICENSE)
- 作者：[HH-SpringAI-Agent-Starter](https://github.com/HH-SpringAI-Agent-Starter)