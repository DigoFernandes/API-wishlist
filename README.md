# API Wishlist

API REST para gerenciar wishlist de clientes, com Spring Boot e MongoDB.

## Tecnologias

- Java 17
- Spring Boot 3.4.x (Web, Validation, Data MongoDB)
- MongoDB
- Springdoc OpenAPI (Swagger UI)
- Maven
- Docker / Docker Compose

## Como executar

### 1) Subir com Docker Compose

```powershell
docker compose up --build
```

A API sobe em `http://localhost:8080`.
O MongoDB sobe em `mongodb://localhost:27017/wishlistdb`.

Para encerrar:

```powershell
docker compose down
```

### 2) Rodar localmente (sem Docker)

1. Suba o MongoDB localmente.
2. Defina a variável de ambiente com a URI do Mongo:

```powershell
$env:SPRING_DATA_MONGODB_URI="mongodb://localhost:27017/wishlistdb"
```

3. Inicie a aplicação:

```powershell
./mvnw spring-boot:run
```

## Endpoints

Base: `/wishlist`

- `POST /wishlist/{clienteId}/produtos` adiciona produto à wishlist.
- `POST /wishlist/{clienteId}/produtos/{produtoId}` remove produto da wishlist.
- `GET /wishlist/{clienteId}/produtos` lista produtos da wishlist do cliente.
- `GET /wishlist/consulta/{produtoId}` retorna `200` se o produto existir em alguma wishlist, `404` caso não exista.

## Swagger

Swagger UI: `http://localhost:8080/swagger-ui/index.html`

## Estrutura do projeto

- `src/main/java/.../controller` controllers REST
- `src/main/java/.../service` regras de negócio
- `src/main/java/.../repository` acesso ao MongoDB
- `src/main/java/.../entity` entidades

## Licenca

Uso livre para fins de estudo.
