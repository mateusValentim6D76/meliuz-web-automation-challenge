#language: pt


Funcionalidade: Procurar produto existente

  Contexto:
    Dado que estou na tela home
    Quando busco por um produto

  @BuscaPorProdutoFeliz
  Esquema do Cenario: Busca por um produto com sucesso
    E preencho o campo com o produto existente "<produtoExistente>"
    E sera exibido o resultado da pesquisa
    Entao vou adicionar o produto ao carrinho
   
    Exemplos:
      | produtoExistente | 
      | Blouse  |
      
     