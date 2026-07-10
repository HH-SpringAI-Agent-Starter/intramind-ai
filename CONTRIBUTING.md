# Contributing to IntraMind AI

感谢你关注 IntraMind AI！欢迎所有形式的贡献——代码、文档、Issue、想法。

## 📋 目录
1. [行为准则](#1-行为准则)
2. [如何开始](#2-如何开始)
3. [开发流程](#3-开发流程)
4. [代码规范](#4-代码规范)
5. [提交 PR](#5-提交-pr)

## 1. 行为准则

本项目遵循 [Contributor Covenant](https://www.contributor-covenant.org/) 行为准则。
请保持尊重、包容、建设性的讨论环境。

## 2. 如何开始

```bash
# Fork 仓库
git clone https://github.com/你的用户名/intramind-ai.git
cd intramind-ai
cp intramind-ai/.env.example intramind-ai/.env

# 启动依赖
docker compose -f intramind-ai/docker-compose.yml up -d

# 启动应用
cd intramind-ai
mvn spring-boot:run
```

**环境要求**：JDK 21+ · Maven 3.9+ · Docker · Ollama

## 3. 开发流程

```
feature/xxx → develop → master
```

1. 从 `master` 创建功能分支：`git checkout -b feature/xxx`
2. 开发完成后提 PR 到 `develop` 分支
3. 至少 1 人 Code Review 后合并

## 4. 代码规范

- **Java**：遵循 [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)
- **提交信息**：`type(scope): description`（feat/fix/docs/refactor/test/chore）
- **测试覆盖**：新功能需包含单元测试 ≥ 80%

## 5. 提交 PR

1. 确保所有测试通过：`mvn test`
2. 更新 `CHANGELOG.md`
3. 详细的 PR 描述，包含改动原因和影响范围
4. 关联 Issue（如有）

---

> 详细贡献指南见 [intramind-ai/CONTRIBUTING.md](./intramind-ai/CONTRIBUTING.md)
