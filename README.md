# ⚓ Sistema de Gestão de Sócios — Clube Náutico Capibaribe

Projeto desenvolvido em Java para disciplina de Programação Orientada a Objetos.

O sistema permite o gerenciamento de sócios do Clube Náutico Capibaribe, incluindo cadastro, edição, exclusão e consulta de categorias e sócios.
O projeto aplica conceitos de POO, persistência, collections, tratamento de exceções, padrões e threads.

## 👨‍💻 Integrantes do Grupo
- Joao da Fonte Queiroz
- Heitor Meira
- Marcelo Caldas
- Addson Cardoso

Curso: Ciências da Computação — UNICAP — 2025

## 🧱 Tecnologias Utilizadas
- Java 17+
- Paradigma Orientado a Objetos
- Threads
- Collections
- Serialização (I/O)
- Singleton
- CLI

## 📌 Funcionalidades
### 👤 Sócio
- Visualizar informações
- Atualizar nome e categoria
- Consultar benefícios

### 🛠️ Administrador
- Cadastrar sócio
- Editar sócio
- Excluir sócio
- Listar sócios
- Gerenciar categorias

## 🧬 Conceitos de POO
✔️ Herança  
✔️ Abstração  
✔️ Polimorfismo  
✔️ Encapsulamento  

## 🧩 Padrões de Projeto
- Singleton (`SistemaSocios`)
- Thread Daemon (`AutoSaveThread`)

## 💾 Persistência
- `socios.dat`
- `categorias.dat`

Realizada via serialização binária.

## 🧵 Threads
`AutoSaveThread` executa salvamentos periódicos em background.

## 📂 Execução
1. Importar o projeto
2. Executar `Main`
```
login: admin
senha: 1234
```

## 🧾 Diagramas UML
- Diagrama de Classes: https://drive.google.com/file/d/1NYZLVUbe7Bt6H9J6Ul4SgvqjaF1lqBpx/view?usp=sharing
- Diagrama de Caso de Uso: https://drive.google.com/file/d/1yJZoxdZb9Wph1DpmLcd-ahDBf01LC_lb/view?usp=sharing

## 🎥 Evidências
video: https://drive.google.com/file/d/1426ifEZPnV04pToTNqiVbNagvYi_qKqF/view?usp=sharing

## 🔮 Futuras Melhorias
- GUI com JavaFX
- Banco de dados real
- Estatísticas

## 📄 Licença
Uso acadêmico.
