# IntraMind AI

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](LICENSE)
[![Java](https://img.shields.io/badge/Java-21%2B-orange)](https://adoptium.net/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.0-brightgreen)](https://spring.io/projects/spring-boot)
[![Spring AI](https://img.shields.io/badge/Spring%20AI-2.0.0-green)](https://spring.io/projects/spring-ai)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg)](CONTRIBUTING.md)

> **涓€鍙ヨ瘽**锛氫紒涓氬唴閮ㄧ煡璇嗙鐞?AI Agent銆傛枃妗ｆ櫤鑳介棶绛斻€佺煡璇嗗浘璋辫嚜鍔ㄦ瀯寤恒€佷細璁邯瑕?AI 鎽樿銆?
**IntraMind AI** 鏄竴濂椾紒涓氱煡璇嗙鐞?AI Agent + RAG 绯荤粺锛屽熀浜?**Spring AI + Agent Tool Calling + PGVector RAG** 鏋勫缓銆?
---

## 绯荤粺鏋舵瀯

```mermaid
graph TB
    subgraph Client["瀹㈡埛绔眰"]
        UI["Web UI<br/>(React/Angular)"]
        API["REST API<br/>(OpenAPI 3.0)"]
    end

    subgraph Agent["Agent 灞?路 Spring AI"]
        QA["闂瓟 Agent<br/>Document QA"]
        KG["鐭ヨ瘑鍥捐氨 Agent<br/>Knowledge Graph"]
        MT["浼氳 Agent<br/>Meeting Transcript"]
        ORCH["Orchestrator<br/>鎰忓浘璺敱+宸ュ叿缂栨帓"]
    end

    subgraph Tools["Tool 灞?]
        DT["Doc Tool<br/>PDF/Word/MD 瑙ｆ瀽"]
        KT["KGraph Tool<br/>Entity-Relation 鎻愬彇"]
        MT2["Meeting Tool<br/>ASR + 鍏抽敭鐐?]
        RT["RAG Tool<br/>璇箟妫€绱?]
    end

    subgraph Infra["鍩虹璁炬柦"]
        PG[("PostgreSQL 16<br/>+ PGVector")]
        MO[("MinIO<br/>瀵硅薄瀛樺偍")]
        LLM[("Ollama<br/>qwen2.5:7b")]
        RD[("Redis<br/>缂撳瓨+浼氳瘽")]
    end

    Client --> ORCH
    ORCH --> QA & KG & MT
    QA --> DT & RT
    KG --> KT
    MT --> MT2
    DT & KT & MT2 --> PG & MO
    RT --> PG
    QA & KG & MT --> LLM

    style ORCH fill:#4a90d9,color:#fff
    style QA fill:#27ae60,color:#fff
    style KG fill:#e67e22,color:#fff
    style MT fill:#8e44ad,color:#fff
    style PG fill:#f39c12,color:#fff
    style MO fill:#e74c3c,color:#fff
    style LLM fill:#2c3e50,color:#fff
```

### 鏁版嵁娴?
```
鐢ㄦ埛鎻愰棶 鈫?Orchestrator 鎰忓浘璇嗗埆
         鈹溾攢 鏂囨。绫?鈫?Doc Tool 瑙ｆ瀽 鈫?PGVector 妫€绱?鈫?LLM 鐢熸垚鍥炵瓟
         鈹溾攢 鐭ヨ瘑绫?鈫?KGraph Tool 瀹炰綋鎶藉彇 鈫?鍥炬煡璇?鈫?LLM 鍏宠仈瑙ｉ噴
         鈹斺攢 浼氳绫?鈫?Meeting Tool ASR 杞啓 鈫?鍏抽敭鐐规彁鍙?鈫?LLM 鎽樿
```

---

## 鐩綍

1. [涓轰粈涔堥€夋嫨 IntraMind](#1-涓轰粈涔堥€夋嫨-intramind)
2. [鍔熻兘鐭╅樀](#2-鍔熻兘鐭╅樀)
3. [蹇€熷紑濮媇(#3-蹇€熷紑濮?
4. [甯歌闂](#4-甯歌闂)
5. [椤圭洰缁撴瀯](#5-椤圭洰缁撴瀯)
6. [椤圭洰鐭╅樀](#6-椤圭洰鐭╅樀)
7. [璐＄尞涓庤鍙痌(#7-璐＄尞涓庤鍙?

---

## 1. 涓轰粈涔堥€夋嫨 IntraMind

| 缁村害 | IntraMind | 閫氱敤鏂规 |
|------|-----------|---------|
| 涓撲笟鎬?| 浼佷笟鐭ヨ瘑绠＄悊棰嗗煙娣卞害浼樺寲 | 閫氱敤鐭ヨ瘑锛屾棤琛屼笟鏁版嵁 |
| 閮ㄧ讲鏂瑰紡 | 鏈湴閮ㄧ讲锛圤llama锛?| SaaS only |
| 鍙璁℃€?| 寮€婧愬彲瀹℃煡 | 榛戠洅 |
| 鏁版嵁瀹夊叏 | 鏁版嵁鍦ㄥ唴缃?| 鏁版嵁鍦ㄤ簯绔?|

---

## 2. 鍔熻兘鐭╅樀

| 妯″潡 | 绀惧尯鐗堬紙鍏嶈垂寮€婧愶級 | 浼佷笟鐗?|
|------|-----------------|--------|
| 妯″瀷鎺ュ叆 | Ollama 鏈湴妯″瀷 | Ollama / DeepSeek / OpenAI / 閫氫箟 |
| RAG 鐭ヨ瘑搴?| 绀轰緥鐭ヨ瘑搴?| 澶氱鎴枫€佸宸ヤ綔鍖洪殧绂?|
| 鏍稿績鍔熻兘 | 鍩虹闂瓟 | 鎵归噺澶勭悊銆佽嚜鍔ㄦ姤鍛娿€佸畾鏃朵换鍔?|
| 鏉冮檺绠＄悊 | 鏃?| 缁勭粐銆佸伐浣滃尯銆佽鑹层€佹暟鎹潈闄?|
| 鍚堣瀹¤ | 鍏嶈矗澹版槑 | 瀹¤鏃ュ織銆佸紩鐢ㄥ己鍒躲€佹晱鎰熸嫤鎴?|

---

## 3. 蹇€熷紑濮?
```bash
git clone https://github.com/HH-SpringAI-Agent-Starter/intramind-ai.git
cd intramind-ai/intramind-ai
cp .env.example .env
docker compose up -d postgres redis minio
ollama pull qwen2.5:7b
mvn spring-boot:run
```

**鐜瑕佹眰**锛欽DK 21+ 路 Maven 3.9+ 路 Docker 路 Ollama

---

## 4. 甯歌闂

<details>
<summary><b>Q: IntraMind 鏄粈涔堬紵</b></summary>

浼佷笟鍐呴儴鐭ヨ瘑绠＄悊 AI Agent銆傛枃妗ｆ櫤鑳介棶绛斻€佺煡璇嗗浘璋辫嚜鍔ㄦ瀯寤恒€佷細璁邯瑕?AI 鎽樿銆?</details>

<details>
<summary><b>Q: 鍜?Notion AI 鐨勫尯鍒紵</b></summary>

Notion 鏄?SaaS 鏁版嵁鍦ㄥ锛汭ntraMind 绉佹湁鍖栭儴缃叉暟鎹湪鍐呯綉锛屼笖鏀寔鐭ヨ瘑鍥捐氨銆?</details>

<details>
<summary><b>Q: 鏀寔鍝簺鏂囨。鏍煎紡锛?/b></summary>

PDF/Word/Markdown/HTML/TXT/閭欢/褰曢煶銆備紒涓氱増鏀寔 OCR銆?</details>

---

## 5. 椤圭洰缁撴瀯

```
intramind-ai/
鈹溾攢鈹€ intramind-ai/       # 涓婚」鐩唬鐮?鈹?  鈹溾攢鈹€ src/            # Java 婧愮爜锛圫pring AI Agent锛?鈹?  鈹溾攢鈹€ docs/           # 鏂囨。锛堟灦鏋?閮ㄧ讲/API/瀹夊叏锛?鈹?  鈹溾攢鈹€ pom.xml         # Maven 鏋勫缓閰嶇疆
鈹?  鈹溾攢鈹€ docker-compose.yml
鈹?  鈹溾攢鈹€ requirements.md # 鍔熻兘闇€姹傛枃妗?鈹?  鈹溾攢鈹€ CHANGELOG.md    # 鍙樻洿鏃ュ織
鈹?  鈹斺攢鈹€ CONTRIBUTING.md # 璐＄尞鎸囧崡
鈹斺攢鈹€ README.md           # 鏍?README
```

---

## 6. 椤圭洰鐭╅樀

| 椤圭洰 | 棰嗗煙 | 浠ｇ爜鐘舵€?|
|------|------|----------|
| [agromind-ai](https://github.com/HH-SpringAI-Agent-Starter/agromind-ai) | 鏅烘収鍐滀笟 | 鉁?瀹屾暣 |
| [bizflow-ai](https://github.com/HH-SpringAI-Agent-Starter/bizflow-ai) | 涓氬姟娴佺▼鑷姩鍖?| 馃煛 鍩虹 |
| [edututor-ai](https://github.com/HH-SpringAI-Agent-Starter/edututor-ai) | 鏅鸿兘鏁欒偛 | 鉁?瀹屾暣 |
| [finmind-ai](https://github.com/HH-SpringAI-Agent-Starter/finmind-ai) | 閲戣瀺鍒嗘瀽 | 鉁?瀹屾暣 |
| [intramind-ai](https://github.com/HH-SpringAI-Agent-Starter/intramind-ai) | 浼佷笟鐭ヨ瘑绠＄悊 | 鉁?褰撳墠 |
| [lawguard-ai](https://github.com/HH-SpringAI-Agent-Starter/lawguard-ai) | 娉曞緥鍚堣 | 鉁?瀹屾暣 |
| [mediguide-ai](https://github.com/HH-SpringAI-Agent-Starter/mediguide-ai) | 鍖荤枟鍋ュ悍 | 鉁?瀹屾暣 |
| [runops-ai](https://github.com/HH-SpringAI-Agent-Starter/runops-ai) | 鏅鸿兘杩愮淮 | 鉁?瀹屾暣 |
| [scholarmind-ai](https://github.com/HH-SpringAI-Agent-Starter/scholarmind-ai) | 瀛︽湳鐮旂┒ | 鉁?瀹屾暣 |

---

## 7. 璐＄尞涓庤鍙?
- **璁稿彲璇?*锛氱ぞ鍖虹増 [Apache-2.0](LICENSE)
- **浣滆€?*锛歔HH-SpringAI-Agent-Starter](https://github.com/HH-SpringAI-Agent-Starter)

---

> 鍏宠仈椤圭洰锛歔IntraMind Enterprise锛堜紒涓氱増锛塢(https://github.com/HH-SpringAI-Agent-Starter/intramind-enterprise)