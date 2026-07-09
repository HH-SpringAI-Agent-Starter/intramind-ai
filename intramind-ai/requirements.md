# IntraMind AI - 功能需求文档

## 1. 系统概述
IntraMind AI 是企业知识管理 AI Agent + RAG 系统，基于 Spring AI 2.0 + Agent Tool Calling + PGVector RAG 构建。

## 2. 功能需求

### 2.1 文档智能问答
| ID | 需求 | 优先级 | 状态 |
|----|------|--------|------|
| F-001 | 多格式文档上传（PDF/Word/MD/HTML/TXT） | P0 | ✅ |
| F-002 | 文档自动分块与向量化 | P0 | ✅ |
| F-003 | PGVector 语义检索（HNSW index） | P0 | ✅ |
| F-004 | 检索结果引用溯源 | P0 | ✅ |
| F-005 | 多轮对话上下文 | P1 | ✅ |

### 2.2 知识图谱
| ID | 需求 | 优先级 | 状态 |
|----|------|--------|------|
| F-010 | 实体自动提取（人员/部门/流程） | P0 | ✅ |
| F-011 | 关系映射与图存储 | P1 | ✅ |
| F-012 | 增量更新 | P1 | ✅ |

### 2.3 会议纪要
| ID | 需求 | 优先级 | 状态 |
|----|------|--------|------|
| F-020 | 录音上传（MP3/WAV/M4A） | P0 | ✅ |
| F-021 | ASR 语音转文字 | P0 | ✅ |
| F-022 | 关键点提取 | P0 | ✅ |
| F-023 | 行动项跟踪 | P1 | ✅ |

### 2.4 多租户
| ID | 需求 | 优先级 | 状态 |
|----|------|--------|------|
| F-050 | 数据隔离 | P0 | ✅ |
| F-051 | RBAC 权限 | P1 | ✅ |
| F-052 | 审计日志 | P1 | ✅ |

## 3. 技术架构
Agent Layer: Query Agent | Tool Layer: Doc/KGraph/Meeting | Infra: PGVector/MinIO/Ollama

## 4. 技术栈
| 层级 | 技术 | 版本 |
|------|------|------|
| Agent | Spring AI | 2.0.0 |
| Boot | Spring Boot | 4.0.0 |
| Lang | Java | 21 |
| LLM | Ollama | latest |
| Vector | PGVector | latest |
| DB | PostgreSQL | 16 |
| Storage | MinIO | latest |
