# estoque-micro

API REST para gerenciamento de estoque de microempreendedores.

!\[CI](https://github.com/lucasdaoura/estoque-micro/actions/workflows/ci.yml/badge.svg)

## Problema

Microempreendedores frequentemente perdem o controle do estoque por falta de ferramentas simples e acessíveis. Esta API resolve isso com um cadastro básico de produtos.

## Tecnologias

* Java 21
* Spring Boot 3.4.5
* Spring Data JPA
* MySQL (Railway)
* Lombok
* JUnit 5 + Mockito

## Endpoints

|Método|Rota|Descrição|
|-|-|-|
|GET|/produtos|Lista todos os produtos|
|GET|/produtos/{id}|Busca produto por ID|
|POST|/produtos|Cadastra novo produto|
|PUT|/produtos/{id}|Atualiza produto|
|DELETE|/produtos/{id}|Remove produto|

## Como rodar localmente

### Pré-requisitos

* Java 21
* Maven
* MySQL local ou Railway

### Configurar variáveis de ambiente

```bash
export DB\_URL=jdbc:mysql://localhost:3306/estoque
export DB\_USERNAME=root
export DB\_PASSWORD=sua\_senha
```

### Executar

```bash
./mvnw spring-boot:run
```

### Rodar testes

```bash
./mvnw test
```

## Deploy

Aplicação publicada em: https://estoque-micro-production.up.railway.app

## Integrantes

* Lucas Daoura

