## Desafio Livraria Virtual

Este projeto consiste em implementar um sistema de gerenciamento de uma livraria virtual, explorando os conceitos de composição, herança e polimorfismo.

### Funcionalidades

O sistema possui um menu com as seguintes opções:

1 - **Cadastrar Livro**: Permite o usuário cadastrar livros do tipo impresso, eletrônico ou ambos.<br />
2 - **Realizar Vendas**: Permite o usuário realizar vendas de um ou mais livros.<br />
3 - **Lista Livros**: Lista todos os livros cadastrados, sejam eles impressos ou eletrônicos.<br />
4 - **Lista Vendas**: Lista todas as vendas realizadas.<br />
5 - **Sair do programa**: Encerra a execução do programa.

### Estrutura

#### Classes

1 - **Livro**: Classe abstrata com atributos como título, autores, editora e preço. Contém o método `toString()` para a representação textual.<br />
2 - **Impresso**: Extende `Livro` e adiciona atributos como frete e estoque. Implementa o método `atualizarEstoque()` e `toString()`<br />
3 - **Eletrônico**: Extende `Livro` e adiciona o atributo tamanho do arquivo. Implementa o método `toString()`<br />
4 - **Venda**: Gerencia as informações de uma venda, incluindo número da venda, cliente, valor total e livros vendidos. Contém métodos para adicionar livros e lista detalhes da venda.<br />
5 - **Livraria Virtual**: A classe principal que gerencia o cadastro de livros, a realização de vendas e a listagem de livros e vendas. Contém o método `main()` para execução do programa.

## Requisitos

- java 8 ou superior.
