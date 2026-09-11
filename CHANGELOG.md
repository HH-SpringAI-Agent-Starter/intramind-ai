# Changelog

## v1.1.2 (2026-09-11)

### 维护
- 每日轮转巡检维护（HH-SpringAI-Agent-Starter 每日轮转）
- 新增根目录 SECURITY.md：支持版本表、漏洞报告流程、多租户/RBAC/审计等安全设计说明
- 新增根目录 CODE_OF_CONDUCT.md：贡献者行为准则（Contributor Covenant 2.1）
- 文档体系补全确认：根目录 README / CHANGELOG / CONTRIBUTING / requirements.md / LICENSE 已齐全

## v1.1.1 (2026-08-27)

### 🔧 维护
- 轮转巡检维护（HH-SpringAI-Agent-Starter 每日轮转）
- 根目录 `.gitignore` 从 40B 简版扩充为完整 Java/Maven/IDE/Docker/Secrets 忽略规则
- 修复 CHANGELOG / CONTRIBUTING 中的 emoji 编码乱码
- LICENSE 升级为 Apache-2.0 官方全文
- 子项目 README 清除多余行首缩进（修复 GitHub 渲染为代码块的问题）、移除重复 API 行
- 子项目 CHANGELOG 修复章节顺序

## v1.1.0 (2026-07-24)

### ✨ 增强
- 新增 Apache-2.0 LICENSE 文件，明确开源许可
- 修复 README 中文编码乱码问题
- 优化项目文档结构，完善快速开始指引
- 全仓库代码结构统一与标准化

### 🔧 修复
- 修复 README.md GBK 编码导致的乱码显示

## v1.0.0 (2026-06-30)

### 🆕 新功能
- 多格式文档上传与智能问答（PDF/Word/MD/HTML/TXT）
- PGVector 语义检索 + HNSW 索引
- 实体自动提取与知识图谱构建
- 会议录音上传 → ASR 转写 → 关键点提取
- 多轮对话上下文支持
- 多租户数据隔离与 RBAC 权限

### 🏗️ 架构
- Spring AI 2.0 Agent + Tool Calling 架构
- Ollama 本地 LLM 接入
- MinIO 对象存储，PostgreSQL 16 + PGVector

### 🚀 部署
- Docker Compose 一键启动
- .env 配置化
- 社区版 Apache-2.0 开源

## v0.5.0 (2026-05-15)

### 🆕 新功能
- Agent Tool Calling 框架搭建
- 文档分块与向量化引擎
- 基础 RAG 问答链路
- LDAP/OAuth2 登录集成

### 🔧 修复
- 大文档分块性能优化
- 多轮对话上下文丢失修复

---

> 完整更新记录见 [intramind-ai/CHANGELOG.md](./intramind-ai/CHANGELOG.md)
