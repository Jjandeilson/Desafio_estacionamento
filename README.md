Esse projeto foi realizado utilizando o framework spring boot, spring data, spring mcv e páginas criadas com thymeleaf.
O banco de dados utilizado foi o mysql e persistência a jpa e hibernate como implementação.

A página inicial contém uma barra superior dividido em funcionalidades como home, estacionamento, veiculo pagamento e relatório.

Na opção de estacionamento tem as funções de visualizar quantidade de vagas livres do estacionamento, quantidade de vagas ocupadas e 
adicionar um veiculo a uma determinada vaga livre.

Nessa opção de estacionar veiculo irá informa a placa, vaga e hora que o veiculo está oculpando a vaga, se tentar cadastrar um veiculo a uma vaga
e ele já estiver ocupando um deternimada vaga será exibido uma menssagem informando tal.

Na opção de Veiculo pode-se cadastra o veiculo informando nome do dono, placa do carro, cidade e estado, e lista os veiculos cadastrado.

Na opção de pagamento irá procurar o veiculo exibindo placa do veiculo, vaga oculpada pelo mesmo,hora de entrada e para finalizar a sua saida
informa a hora de saida, após isso será exibido uma menssagem informando a saida do veivulo e valor a pagar.

A opção de relatório enviar informações de quantidade de vagas disponiveis no estacionamento e valor acumulado com o pagamento de estacionamento.

Na tale principal também tem um campo para pesquisar o veiculo se já estiver cadastrado no banco irá direcionar para a tela de resgistrar nas vagas
livres do estacionamento.

Na tela inicial existe um espaço indicando quantidade de vagas livres no estacionamento, quando uma veiculo é alocado a uma vaga ele atualiza a quantidade de vagas disponíveis.

Utilizando o flyway que é uma ferramenta de versionamento de banco ele fica responsavél por roda o escripte que criamos referente ao banco, para criar o banco um criar o database no mysql com o nome desafio_conpay e rodar a aplicação e o flyway ficará responsavél por
criar as tablas do banco.

