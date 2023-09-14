# Projeto Santander Boot Camp - Sistema de Gerenciamento de Tarefas Pessoais

## Descrição do Projeto

O Gerenciamento de Tarefas Pessoais é um sistema de gerenciamento de tarefas pessoais desenvolvido em Java. Este sistema permite aos usuários criar, organizar e monitorar suas tarefas diárias, semanais e mensais de forma eficiente.

## Objetivo do Projeto

O principal objetivo deste projeto é fornecer aos usuários uma ferramenta prática para o gerenciamento eficaz de suas tarefas pessoais. Ele visa simplificar o processo de criação, organização e acompanhamento de tarefas, aumentando a produtividade e a organização pessoal.

## Funcionalidades Principais

O sistema de gerenciamento de tarefas pessoais oferece diversas funcionalidades, incluindo:

* **Cadastro de Tarefas:** Os usuários podem criar tarefas, fornecendo informações como título, descrição, data de vencimento, prioridade, categoria, entre outros detalhes.

* **Organização de Tarefas:** O sistema permite que os usuários organizem suas tarefas em listas ou categorias personalizadas, facilitando a gestão.

* **Lembretes e Notificações:** Os usuários recebem lembretes e notificações sobre tarefas pendentes ou próximas do prazo de vencimento, ajudando a manter o controle das responsabilidades.

* **Visualização de Tarefas:** As tarefas podem ser visualizadas de diferentes maneiras, como em forma de lista, calendário ou kanban, de acordo com as preferências do usuário.

* **Marcação de Tarefas Concluídas:** Os usuários podem marcar tarefas como concluídas e arquivá-las para referência futura.

## Dependências

Este projeto utiliza as seguintes dependências:

* Linguagem de Programação: Java (Versão 20)
* Spring Boot: Framework Java para desenvolvimento de aplicativos web.
* Spring Cloud OpenFeign: Biblioteca para comunicação entre microserviços.
* H2 Database: Banco de dados em memória para desenvolvimento e testes.
* Spring Boot Test: Biblioteca para testes de aplicativos Spring Boot.
* Springdoc OpenAPI UI: Biblioteca para documentação de APIs com o OpenAPI (anteriormente conhecido como Swagger).
* Spring Boot Thymeleaf: Biblioteca para criação de páginas web com Thymeleaf.
* Spring Security Core: Biblioteca para segurança de aplicativos Spring.

## Design Patterns Utilizados

Este projeto utiliza os seguintes padrões de design para criar uma estrutura robusta e flexível:

* **Observer Pattern:** Implementa o padrão Observer para notificar os usuários sobre lembretes e atualizações de tarefas, mantendo-os sempre informados.

* **Factory Method Pattern:** Utiliza o padrão Factory Method para criar objetos de tarefa e categoria de forma flexível e encapsulada, simplificando a criação de novos elementos.

* **Strategy Pattern:** Implementa o padrão Strategy para oferecer diferentes estratégias de notificação, como notificações por e-mail ou notificações por push, permitindo personalização.

* **Decorator Pattern:** Utiliza o padrão Decorator para adicionar funcionalidades adicionais às tarefas, como anexação de arquivos, adição de comentários, entre outros, sem complicar a classe base.

* **Singleton Pattern:** Garante a existência de apenas uma instância do sistema de gerenciamento de tarefas em toda a aplicação, evitando duplicações e mantendo a consistência.

## Tecnologias Adicionais

Para melhorar a experiência do usuário, é possível criar uma interface de usuário (UI) para o sistema usando JavaFX ou outra biblioteca de GUI Java. Além disso, para armazenar informações sobre tarefas, categorias e configurações do usuário, é recomendado o uso de um banco de dados, como SQLite.

Este projeto oferece uma excelente oportunidade de prática de design patterns em um contexto real, ao mesmo tempo em que proporciona uma ferramenta útil para a organização pessoal e aumento da produtividade.

Fique à vontade para contribuir com ideias e melhorias neste projeto e aproveite a oportunidade para aprimorar suas habilidades de desenvolvimento em Java e design de software.

## Estado Atual do Projeto

Este projeto ainda está em desenvolvimento e está sujeito a mudanças significativas. Novas funcionalidades podem ser adicionadas, bugs podem ser corrigidos e melhorias podem ser feitas. Sinta-se à vontade para acompanhar as atualizações ou contribuir para o projeto conforme ele evolui.

Se você tiver sugestões, problemas ou quiser colaborar de alguma forma, por favor, entre em contato com a equipe de desenvolvimento. Estamos ansiosos para tornar este sistema de gerenciamento de tarefas pessoais ainda melhor!

# Creator
@pedrozandonai