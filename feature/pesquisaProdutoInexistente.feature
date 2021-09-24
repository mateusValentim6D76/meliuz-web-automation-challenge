#language: pt
Funcionalidade: Procurar produto inexistente

  Contexto: 
    Dado que estou na tela home
    Quando busco por um produto

  @BuscaProdutoTriste
  Cenario: Busca por produto que nao existe no site
    E preencho o campo com produto inexistente
      | produto   |
      | naoExiste |
    Entao verifico a mensagem que o produto nao existe
