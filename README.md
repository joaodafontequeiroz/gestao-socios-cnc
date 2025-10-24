# 🧭 Projeto: Sistema de Gestão de Sócios - Clube Náutico Capibaribe

## 👥 Integrantes
- João da Fonte Queiroz  
- Addson Cardoso  
- Heitor Meira  
- Marcelo Caldas  

📁 **Repositório GitHub:**  
https://github.com/joaodafontequeiroz/gestao-socios-cnc

---

## 🎯 Objetivo do Projeto
Este projeto tem como objetivo desenvolver um **sistema de gestão de sócios** para o **Clube Náutico Capibaribe**, contemplando o cadastro, consulta e controle básico de informações sobre os sócios do clube.  
Trata-se da **Etapa 3 do Projeto Final da disciplina de Programação Orientada a Objetos**, correspondendo à **primeira versão funcional (protótipo)** do sistema.

O foco principal desta etapa é a **implementação da estrutura inicial em Java**, com organização de pacotes, classes básicas, métodos principais e uma **interface de texto (CLI)** que permita interação simples com o usuário.

---

## 🧱 Estrutura de Pacotes
O projeto segue uma arquitetura **MVC (Model–View–Controller)**, distribuída da seguinte forma:

- **model** → classes de domínio do sistema, representando os principais elementos do clube, como `Socio`, `Categoria` e `Administrador`.  
- **service** → classes responsáveis pela lógica de negócio e manipulação dos dados dos sócios (`SocioService`, `SistemaSocios`).  
- **controller** → camada de controle que gerencia o fluxo entre a interface e as regras de negócio.  
- **view** → interface de texto (CLI) que permite interação inicial com o usuário (`InterfaceCLI`).  
- **util** → classes auxiliares e funções genéricas usadas em todo o sistema (`InputUtil`, `DateUtil`, etc.).  

---

## ⚙️ Tecnologias Utilizadas
- **Linguagem:** Java (JDK 8 ou superior)  
- **Paradigma:** Programação Orientada a Objetos (POO)  
- **Ambiente de Desenvolvimento:** VS Code / IntelliJ / Eclipse  
- **Estrutura:** MVC  

---

## ▶️ Como Executar
1. Certifique-se de ter o **Java JDK 8 ou superior** instalado.  
2. Baixe ou clone este repositório em sua máquina:
   ```bash
   git clone https://github.com/joaodafontequeiroz/gestao-socios-cnc.git
