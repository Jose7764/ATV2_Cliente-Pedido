git # 📚 Atividade 2 — Cadastro Encadeado com Validação

## 🧠 Sobre o Projeto

Este projeto tem como objetivo praticar o cadastro encadeado entre entidades utilizando **Spring Boot + JPA/Hibernate**, com foco em validação de relacionamento.

O cenário simula uma regra comum em sistemas reais:

- Um **Cliente** pode ter vários **Pedidos**
- Um **Pedido** pertence a apenas um **Cliente**

---

## 🎯 Objetivo da Atividade

- Praticar relacionamentos entre entidades
- Validar existência de dados antes de persistir
- Trabalhar com DTOs de entrada
- Utilizar métodos derivados do Spring Data JPA

---

## 🏗️ Estrutura do Projeto

### 📦 Entidades

#### Cliente
- Representa o cliente do sistema
- Possui uma lista de pedidos

#### Pedido
- Representa uma solicitação feita por um cliente
- Possui referência a um cliente
- Contém a chave estrangeira (FK)

---

## 🔗 Relacionamento

- `@OneToMany` → Cliente → Pedidos  
- `@ManyToOne` → Pedido → Cliente  

📌 Regra importante:  
> O **Pedido é o dono da relação**, pois contém a chave estrangeira.

---

## ⚙️ Funcionalidades Implementadas

### ✅ Cadastro

- Criar cliente  
- Criar pedido informando o **id do cliente**  

📌 Validação obrigatória:
> Não é permitido cadastrar pedido para cliente inexistente

---

### 📄 Listagem

- Listar todos os clientes  
- Listar pedidos com dados básicos do cliente  

---

### 🔍 Busca

- Buscar pedido por ID  
- Buscar pedidos de um cliente específico  

---

### 🔎 Filtros

- Buscar pedidos por:
  - Nome do cliente  
  - ID do cliente  

---

### 🧠 Métodos no Repository

Utilização de queries derivadas:

```java

List<Pedido> findByClienteId(Long clienteId);

List<Pedido> findByClienteNome(String nome);
