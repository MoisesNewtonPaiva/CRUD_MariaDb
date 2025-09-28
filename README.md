# API REST para Gerenciamento de Alunos e Cursos

## [cite_start]📖 Descrição do Projeto [cite: 46]

Este projeto é uma API RESTful desenvolvida com Spring Boot para gerenciar o cadastro de cursos e alunos. A aplicação permite realizar operações CRUD (Create, Read, Update, Delete) completas para ambas as entidades, modelando o relacionamento onde um aluno está vinculado a um único curso. A persistência dos dados é feita em um banco de dados MariaDB.

Este projeto foi desenvolvido como parte de um estudo sobre a construção de APIs com o ecossistema Spring.

---

## 🛠️ Tecnologias Utilizadas

* **Java 17**
* **Spring Boot**
* **Spring Web:** Para a criação de endpoints REST.
* **Spring Data JPA:** Para a persistência de dados e comunicação com o banco.
* **MariaDB:** Como banco de dados SQL.
* **Lombok:** Para reduzir o código boilerplate.
* **Maven:** Para gerenciamento de dependências.

---

## [cite_start]⚙️ Instruções para Executar a Aplicação [cite: 47]

Siga os passos abaixo para executar o projeto localmente.

### Pré-requisitos

* JDK 17 ou superior instalado.
* Maven instalado.
* Servidor de banco de dados MariaDB rodando.

### Passos

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/seu-usuario/seu-repositorio.git](https://github.com/seu-usuario/seu-repositorio.git)
    cd seu-repositorio
    ```

2.  **Configure o Banco de Dados:**
    * Acesse seu cliente MariaDB e crie o banco de dados para a aplicação:
        ```sql
        CREATE DATABASE universidade;
        ```
    * Abra o arquivo `src/main/resources/application.properties` e altere as seguintes propriedades com suas credenciais:
        ```properties
        spring.datasource.username=seu_usuario
        spring.datasource.password=sua_senha
        ```

3.  **Execute a Aplicação:**
    * Utilize o Maven para iniciar o servidor Spring Boot:
        ```bash
        mvn spring-boot:run
        ```
    * A API estará disponível em `http://localhost:8080`.

---

## [cite_start]🚀 Exemplos de Requisições (via curl) [cite: 48]

Aqui estão alguns exemplos de como interagir com a API.

### Cursos

* **Cadastrar um novo curso:**
    ```bash
    curl -X POST http://localhost:8080/cursos \
    -H "Content-Type: application/json" \
    -d '{
      "nome": "Análise e Desenvolvimento de Sistemas",
      "cargaHoraria": 2800
    }'
    ```

* **Listar todos os cursos:**
    ```bash
    curl -X GET http://localhost:8080/cursos
    ```

### Alunos

* **Cadastrar um novo aluno (vincule ao curso com `id=1`):**
    ```bash
    curl -X POST "http://localhost:8080/alunos?cursoId=1" \
    -H "Content-Type: application/json" \
    -d '{
      "nome": "João da Silva",
      "email": "joao.silva@email.com",
      "dataNascimento": "2002-05-20"
    }'
    ```

* **Listar todos os alunos:**
    ```bash
    curl -X GET http://localhost:8080/alunos
    ```
