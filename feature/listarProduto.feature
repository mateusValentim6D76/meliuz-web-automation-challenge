#language: pt
Funcionalidade: Listar produto do tipo Women

  Contexto: 
    Dado que estou na tela home
    Quando busco por um produto

  @ListarSubProdutoFeliz
  Cenario: Listar um produto do publico feminino
    E abro a lista dentro da categoria Women
    E clico no tipo de subproduto
      | subCategoria   |
      | Summer Dresses |
    Entao verifico se estou na tela referente aquele produto
