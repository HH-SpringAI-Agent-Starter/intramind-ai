# IntraMind AI — 功能需求文档

## 1. 概述

IntraMind AI 是企业内部知识管理 AI Agent 系统，基于 Spring AI Agent Tool Calling + RAG 架构。

## 2. 核心功能

### 2.1 文档智能问答
- **描述**：支持 PDF/Word/Markdown/HTML/TXT/邮件格式文档上传，自动分块嵌入，语义检索问答
- **输入**：文档文件 + 自然语言问题
- **输出**：带引用的生成式回答
- **优先级**：P0

### 2.2 知识图谱自动构建
- **描述**：从文档中自动抽取实体-关系三元组，构建企业知识图谱，支持图查询
- **输入**：文档/多轮对话
- **输出**：知识图谱可视化 + GraphQL 查询接口
- **优先级**：P1

### 2.3 会议纪要 AI 摘要
- **描述**：上传会议录音，ASR 转写，关键点提取，生成会议摘要
- **输入**：音频文件（MP3/WAV）
- **输出**：会议摘要 + 行动项列表
- **优先级**：P1

### 2.4 智能漏斗与路由
- **描述**：Orchestrator Agent 根据用户意图自动路由到对应子 Agent
- **优先级**：P0

## 3. 架构设计

### 3.1 Agent 架构

```
用户请求 → Tenant Filter（租户隔离）
         → Orchestrator Agent（意图识别 + 路由）
            ├── 文档问答子 Agent
            │   ├── Doc Tool（文档解析）
            │   ├── RAG Tool（PGVector 语义检索）
            │   └── 回答生成
            ├── 知识图谱子 Agent
            │   ├── KGraph Tool（实体-关系抽取）
            │   └── 图查询
            └── 会议子 Agent
                ├── Meeting Tool（ASR 转写）
                └── 关键点提取
```

### 3.2 数据流

```
文档上传 → 文档解析器（Tika/PDFBox）
         → 文本分块（RecursiveCharacterTextSplitter）
         → Embedding（mxbai-embed-large）
         → PGVector 存储（cosine distance, HNSW 索引）

用户提问 → 意图识别
         → 检索（相似度搜索 + 关键词匹配）
         → 上下文组装
         → LLM 生成 + 引用标注
```

## 4. 技术栈

| 层 | 技术 |
|---|------|
| 框架 | Spring Boot 4.0 + Spring AI 2.0 |
| Agent | Spring AI Tool Calling + Orchestrator |
| RAG | PGVector (PostgreSQL 16) + HNSW 索引 |
| LLM | Ollama (qwen2.5:7b 本地) |
| 存储 | PostgreSQL + MinIO + Redis |
| 部署 | Docker Compose |

## 5. 多租户设计

- 租户隔离级别：数据级（Row-Level Security 或 metadata filter）
- 租户识别：HTTP Header `X-Tenant-Id`
- 默认租户：`demo`

## 6. 开放核心理念

- 社区版：Apache-2.0 开源，支持 Ollama 本地模型 + 基础 RAG
- 企业版：多模型接入、批量处理、自动报告、定时任务、权限审计
