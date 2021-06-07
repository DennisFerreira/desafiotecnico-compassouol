<!-- Informações prévias -->

### Pre-requisitos

Versão do java utilizada: 11

### Base de dados

Como a base de dados utilizada foi o H2, não será necessário instalação ou configuração.

### Instalação

1. Clone o repositório
   ```sh
   git clone https://github.com/DennisFerreira/desafiotecnico-compassouol.git
   ```
2. Execute a classe: 
   ```sh
   DesafioJavaSpringbootApplication.java
   ```
   
### Endpoints


|   Verbo HTTP  | Resource path |       Descrição       |
| ------------- | ------------- | --------------------- |
|      POST     |   /products   | Criação de um produto |
|      PUT      |   /products/  | Atualização de um produto |
|      GET      |   /products/  | Busca de um produto por ID |
|      GET      |   /products  | Lista de produtos |
|      GET      |   /products/search  | Lista de produtos filtrados |
|      DELETE      |   /products/  | Deleção de um produto |

