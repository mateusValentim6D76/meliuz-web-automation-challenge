#language: pt
Funcionalidade: Adicionar e remover produto no carrinho

  Contexto: 
    Dado que estou na tela home
    Quando busco por um produto

 @AdicionarProdutoCarrinho
  Cenario: Busca por produto que  existe no site e adicionar ao carrinho
    E preencho o campo com um produto 
      | produto   |
      | t-shirt |
      E adiciono ele ao carrinho
    Entao verifico a mensagem da tela de confirmacao

  @RetirarProdutoCarrinho
  Cenario: Retirar produto do carrinho
    E clico no icone do carrinho de compras
    Entao retiro o produto desejado do carrinho de compras
