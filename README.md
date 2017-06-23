[![Build Status](https://travis-ci.org/dhiegohenrique/suntech-front.svg?branch=master)](https://travis-ci.org/dhiegohenrique/suntech-front)

Requisitos:
1) Java 8;
2) Maven 3 ou superior;
3) MySQL 5.7 ou superior e seu serviço deve estar rodando;
4) Em src/main/resources/application.properties:
	- "spring.datasource.url" deve corresponder a URL da sua instância do MySQL;
	- "spring.datasource.username" e "spring.datasource.password" devem corresponder ao username e password da sua instância do MySQL;
	
Para rodar:
1) Importar como projeto Maven, clicar com o direito em SuntechBackApplication e "Run as Java Application";

A aplicação estará rodando em: http://localhost:3000

A cada commit, serão realizados testes unitários no Travis. Se passarem, o deploy será realizado em https://suntech-back.herokuapp.com/