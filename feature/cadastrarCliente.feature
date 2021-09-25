#language: pt
Funcionalidade: Registrar cliente

  Contexto: 
    Dado que estou na tela home

  @RegistrarCliente
  Esquema do Cenario: Registrar cliente
    Quando clico em 'Signin'
    E preencho os campos com os dados "<dados>"
    Entao clico em 'Register' para finalizar o cadastro

    Exemplos: 
      | dados    |
      | Valentim |
