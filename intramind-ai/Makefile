.PHONY: build run test clean docker-up docker-down lint

build: docker-up
	mvn clean install -DskipTests

run:
	mvn spring-boot:run

test:
	mvn test

docker-up:
	docker compose up -d postgres redis minio

docker-down:
	docker compose down

docker-logs:
	docker compose logs -f

clean:
	mvn clean

init: docker-up
	ollama pull qwen2.5:7b
	mvn clean install

dev: docker-up run
