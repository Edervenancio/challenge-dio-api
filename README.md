# Desafio final DIO

Este repositório contém o código fonte do desafio final de um bootcamp de desenvolvimento de software da DIO. O desafio consiste na criação de um sistema que realiza o relacionamento entre autores e livros, para identificação.


<img src="https://hermes.dio.me/assets/diome/logo.png" width="200px">

## Tecnologias utilizadas

* Java
* Spring Boot
* MySQL
* Postman
* Git

## Conceitos abordados
* Mapeamento de dados
* Modelagem de banco de dados
* Testes unitários
* Versionamento


## Status

Este é um protótipo e ainda há correções futuras e outras atualizações previstas.

## Como utilizar

Para utilizar o programa, siga os passos abaixo:



 <ol>
    <li><strong>Clonar o Repositório:</strong> <code>git clone https://github.com/Edervenancio/challenge-dio-api</code></li>
    <li><strong>Importar o Projeto:</strong> Abra sua IDE (Eclipse ou IntelliJ) e importe o projeto clonado.</li>
    <li><strong>Criar o Banco de Dados:</strong> Execute o arquivo SQL fornecido para criar o banco de dados necessário para o funcionamento do sistema.</li>
    <li><strong>Instalar o Postman:</strong> Baixe e instale o Postman para acessar os endpoints da aplicação.</li>
    <li><strong>Executar a Aplicação:</strong> Inicie o servidor de aplicação em sua IDE.</li>
    
</ol>


## Endpoints

A aplicação possui os seguintes endpoints:

* **<b>/author</b>**
    * **<b>/add</b>:** Adiciona um novo autor
    * **<b>/findById/{id_author}</b>:** Obtém um autor pelo ID
    * **<b>/findAll</b>:** Obtém todos os autores
    * **<b>/delete/{id_author}</b>:** Exclui um autor pelo ID
    * **<b>/update</b>:** Atualiza um autor
* **<b>/book</b>**
    * **<b>/add</b>:** Adiciona um novo livro
    * **<b>/findById/{id_book}</b>:** Obtém um livro pelo ID
    * **<b>/findAll</b>:** Obtém todos os livros
    * **<b>/delete/{id_book}</b>:** Exclui um livro pelo ID
    * **<b>/update</b>:** Atualiza um livro
    * **<b>/{id_book}/author/{id_author}</b>:** Associa um autor a um livro

## Exemplos de uso

### Adicionar um novo Autor

Para adicionar um novo autor, use o seguinte comando:

O corpo da solicitação deve conter um objeto JSON com os seguintes campos:

* `author_name`: O nome do autor.
* `author_age`: A idade do autor.

<hr>

### Adicionar um novo livro

Para adicionar um novo livro, use o seguinte comando:

O corpo da solicitação deve conter um objeto JSON com os seguintes campos:

* `book_name`: O nome do livro.
* `book_category`: A categoria do livro.
* `book_description`: A descrição do livro.
* `pages`: O número de páginas do livro.

