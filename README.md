# ⚓ Sistema de Gestão de Sócios - Clube Náutico Capibaribe

## 👥 Integrantes
- **João da Fonte Queiroz**  
- **Addson Cardoso**  
- **Heitor Meira**  
- **Marcelo Caldas**  

**Curso:** Ciências da Computação  
**Disciplina:** Programação Orientada a Objetos  

📁 **Repositório GitHub:**  
https://github.com/joaodafontequeiroz/gestao-socios-cnc

---

## 🎯 ETAPA 4 - Versão Beta Funcional

### ✅ Funcionalidades Implementadas

#### 🔧 Módulo Administrativo
- **Cadastro de Sócios** com validação de CPF e nome
- **Edição de Sócios** com tratamento de erros
- **Exclusão de Sócios** com confirmação
- **Listagem Completa** de todos os sócios
- **Gerenciamento de Categorias** (CRUD completo)

#### 👤 Módulo do Sócio
- **Acesso por CPF** com validação
- **Visualização de dados** pessoais e mensalidade
- **Atualização de informações** e categoria
- **Consulta de benefícios** da categoria atual

#### 💾 Sistema
- **Persistência em arquivos** (dados salvos automaticamente)
- **Tratamento de exceções** em todas as operações
- **Validações robustas** de entrada de dados
- **Interface amigável** com menus intuitivos

---

## 🏷️ CATEGORIAS OFICIAIS IMPLEMENTADAS

O sistema inclui as **8 categorias oficiais** do Clube Náutico Capibaribe:

1. **100% TIMBA** - R$ 399,90/mês - 100% desconto TODOS setores + camisas oficiais 2025
2. **BRANCO DE PAZ** - R$ 99,90/mês - 100% desconto Hexa, Vermelho e Caldeirão
3. **PATRIMONIAL** - R$ 79,90/mês - 70% desconto Vermelho e Hexa (Jóia: R$ 3.000,00)
4. **VERMELHO DE LUTA** - R$ 39,90/mês - 100% desconto Caldeirão + 60% Hexa/Vermelho
5. **SÓCIO CALDEIRÃO** - R$ 24,90/mês - 100% desconto Setor Caldeirão
6. **AQUISIÇÃO DE CADEIRA** - Gratuito - Prioridade 1ª ingresso (Jóia: R$ 3.000,00)
7. **TODO MUNDO É NÁUTICO** - Gratuito - Prioridade 4ª ingresso (Taxa: R$ 25,00 carteira)
8. **TIMBU +** - Gratuito - 100% desconto titular + 1 acompanhante (PCD)

---

## 🏗️ Arquitetura do Sistema

SISTEMA_SOCIOS/
├── src/
│ ├── model/ → Entidades do sistema
│ │ ├── Administrador.java
│ │ ├── Categoria.java (Atualizada com preço mensal)
│ │ └── Socio.java (Atualizada com mensalidade)
│ ├── service/ → Lógica de negócio
│ │ └── SistemaSocios.java (Categorias reais implementadas)
│ ├── util/ → Utilitários
│ │ ├── DateUtil.java
│ │ ├── FileManager.java
│ │ └── Validador.java
│ ├── view/ → Interface
│ │ └── InterfaceCLI.java
│ └── Main.java
├── data/ → Arquivos de persistência
│ ├── socios.dat
│ └── categorias.dat
└── README.md

---

## 🚀 Como Executar

### Pré-requisitos
- Java JDK 8 ou superior

### Compilação e Execução
```bash
# Compilar
javac -d bin -cp "src" src/Main.java src/model/*.java src/util/*.java src/service/*.java src/view/*.java

# Executar
java -cp bin Main

#video codigo funcionando: 
