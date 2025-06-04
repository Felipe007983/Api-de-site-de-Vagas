# 📂 Portal de Vagas - API Backend

API desenvolvida com **Spring Boot** para gerenciamento de **usuários** e **vagas de emprego**, conectada ao **SQL Server**. Esta versão é o esqueleto funcional da aplicação, com base para evoluções futuras.

---

## ⚙️ Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- SQL Server
- Maven

---

## 📦 Funcionalidades

### 👤 Usuários

- `POST /api/usuarios`: Cadastrar um novo usuário  
- `GET /api/usuarios`: Listar todos os usuários  
- `PUT /api/usuarios/{id}`: Atualizar dados de um usuário  
- `DELETE /api/usuarios/{id}`: Remover um usuário  

### 💼 Vagas

- `POST /api/vagas`: Cadastrar uma nova vaga  
- `GET /api/vagas`: Listar todas as vagas  
- `PUT /api/vagas/{id}`: Atualizar uma vaga  
- `DELETE /api/vagas/{id}`: Deletar uma vaga  

---

✅ O que funciona até agora
Cadastro, edição, listagem e exclusão de usuários e vagas

Conexão com banco SQL Server

Validação básica no backend

---

🔐 Melhorias Futuras - Para Aplicação Robusta e Segura
Segurança
 Autenticação e Autorização com Spring Security + JWT

 Proteção de endpoints por role (ADMIN, USER)

 Criptografia de senha com BCrypt

 Configuração segura de CORS

 Rate limiting (evitar brute-force em login)

 Documentação automática com Swagger/OpenAPI

 Testes unitários (JUnit + Mockito)

 Testes de integração

