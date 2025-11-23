# CareerPath

API de Gerenciamento de Habilidades Digitais (Skills Manager).

## Tecnologias

- Java 21+ (compatível com a versão usada no projeto)
- Spring Boot
- Spring Data JPA
- Oracle JDBC (configurado no projeto)
- Gradle (wrapper incluso)
- SpringDoc / Swagger UI

## Requisitos

- JDK 21 ou superior instalado
- Conexão com um banco Oracle (ou ajuste a `spring.datasource.*` para outro DB)
- Gradle wrapper incluído no projeto (use o `gradlew.bat` no Windows)

## Configuração

As configurações de conexão com o banco estão em `src/main/resources/application.properties`.
O projeto atualmente aponta para uma instância Oracle (ex.: `spring.datasource.url=jdbc:oracle:thin:@//oracle.fiap.com.br:1521/ORCL`).

Você pode substituir as propriedades de conexão por variáveis de ambiente (ou editar o arquivo diretamente).

## Como rodar

1. Ajuste as variáveis de ambiente ou `application.properties` com as credenciais do banco.

A aplicação iniciará na porta padrão `8080` (se não configurado de outro modo).

## Endpoints principais

Base: http://localhost:8080

- Habilidades
  - GET  /habilidades/todas — listar todas as habilidades
  - GET  /habilidade/nome - listar as habilidades com o nome passado como parâmetro
  - POST /habilidades — criar habilidade (JSON no body)
  - PUT  /habilidades/{id} — atualizar habilidade
  - DELETE /habilidades/{id} — deletar habilidade

- Profissionais
  - GET  /profissionais/todos — listar todos os profissionais
  - GET  /profissionais/nome  - listar os profissionais com o nome passado como parâmetro
  - POST /profissionais — criar profissional (JSON no body)
  - PUT  /profissionais/{id} — atualizar profissional
  - DELETE /profissionais/{id} — deletar profissional

- ProfissionalHabilidade
  - GET  /profissionais-habilidades — listar todas as relações
  - POST /profissionais-habilidades — criar relação (JSON no body)
  - PUT  /profissionais-habilidades/{id} — atualizar relação
  - DELETE /profissionais-habilidades/{id} — deletar relação

## Estrutura do projeto

Principais pacotes (em `src/main/java`):

- `br.com.fiap.CareerPath.controller` — controllers REST
- `br.com.fiap.CareerPath.service` — regras de negócio
- `br.com.fiap.CareerPath.repository` — repositórios JPA
- `br.com.fiap.CareerPath.entity` — entidades JPA


## Integrantes

- Daniel K S Araki - 553043
- Jonas K Isiki - 560560
- Marcos V A Marques - 560475

---
