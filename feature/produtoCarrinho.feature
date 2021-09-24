#language: pt
Funcionalidade: Adicionar e remover produto no carrinho

  Contexto: 
    Dado que estou na tela home
    Quando busco por um produto

  @AdicionarProdutoCarrinho 
  Cenario: Busca por produto que  existe no site e adicionar ao carrinho
    E preencho o campo com um produto
      | produto |
      | t-shirt |
    E adiciono ele ao carrinho
    Entao verifico a mensagem da tela de confirmacao

  @RetirarProdutoCarrinho 
  Cenario: Retirar produto do carrinho
    E preencho o campo com um produto
      | produto |
      | t-shirt |
    E adiciono ao carrinho
    Quando clico em 'Continue shopping'
    E clico no logo localizado ao canto superior esquerdo
    Entao clico no carrinho localizado na home
    E retiro o produto do carrinho
