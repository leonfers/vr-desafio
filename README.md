# VR- DESAFIO
Mini autorizador de transações.

## Projeto
Este projeto foi documentado através da aba de projetos do github e a WIKI (Estão as respostas teóricas do teste), mostrando o que foi feito e o que será feito futuramente.

## Rodando o projeto
### Descrição
Projeto springboot com java 10

### Requisitos
* [JAVA 10 ](https://www.oracle.com/java/technologies/downloads/)
* [Docker](https://docs.docker.com/get-started/)
* [Docker Composer](https://docs.docker.com/compose/)

Obs. Configurar variáveis do ambiente do java

### Comandos (Linux)
Clonar projeto em uma pasta
> git clone https://github.com/leonfers/vr-desafio.git

Iniciar o banco de dados com docker-compose  (A partir da raiz do projeto)

> cd docker

> docker compose up

Iniciar o projeto (A partir da raiz do projeto)

> cd autorizador

> ./mvnw  spring-boot:run

### Testes
Ao todo foram criados 15 testes na aplicação.
Para rodar usar o comando  (A partir da raiz do projeto)

> cd autorizador

> ./mvnw  test


### REST
O autorizador utliza uma interface rest para comunicação com os seguintes endpoints

> /cartoes [POST]  --- Criar novo cartão

> /cartoes/2213213213213 [GET] --- Obter saldo do Cartão

> /transacoes [POST] --- Realizar uma Transação

a especificacao básica pode ser encontrada nesse caminho 
> /swagger-ui.html


### Detalhes

#### Criar novo cartão
```
Method: POST
URL: http://localhost:8080/cartoes
Body (json):
{
    "numeroCartao": "6549873025634501",
    "senha": "1234"
}
```
##### Possíveis respostas:
```
Criação com sucesso:
   Status Code: 201
   Body (json):
   {
      "senha": "1234",
      "numeroCartao": "6549873025634501"
   } 
-----------------------------------------
Caso o cartão já exista:
   Status Code: 422
   Body (json):
   {
      "senha": "1234",
      "numeroCartao": "6549873025634501"
   } 
```

#### Obter saldo do Cartão
```
Method: GET
URL: http://localhost:8080/cartoes/{numeroCartao} , onde {numeroCartao} é o número do cartão que se deseja consultar
```

##### Possíveis respostas:
```
Obtenção com sucesso:
   Status Code: 200
   Body: 495.15 
-----------------------------------------
Caso o cartão não exista:
   Status Code: 404 
   Sem Body
```

#### Realizar uma Transação
```
Method: POST
URL: http://localhost:8080/transacoes
Body (json):
{
    "numeroCartao": "6549873025634501",
    "senhaCartao": "1234",
    "valor": 10.00
}
```

##### Possíveis respostas:
```
Transação realizada com sucesso:
   Status Code: 201
   Body: OK 
-----------------------------------------
Caso alguma regra de autorização tenha barrado a mesma:
   Status Code: 422 
   Body: SALDO_INSUFICIENTE|SENHA_INVALIDA|CARTAO_INEXISTENTE (dependendo da regra que impediu a autorização)
```

### Implementação
O processo de desenvolvimento foi feito, criando testes para cada uma das regras e endpoints do desafio, onde era desenvolvido uma versão básica do endpoint, depois um teste que contemplasse a regra e em seguida o endpoint era ajustado até que ele conseguisse passar no teste.

Após todos os requisitos atendidos, foi feita uma refatoração para organizar o projeto e remover a necessidade de IFs na solução. Para isso foram usados 2 padrões de projeto ([Factory](https://www.gofpatterns.com/creational/patterns/factory-method-pattern.php) e [Command](https://www.gofpatterns.com/behavioral/patterns/command-pattern.php)) criando validadores independentes para cada regra.

Foram criadas pull requests para cada momento relevantes de atualização.


### Transações concorrentes
Não foi implementado uma solução para transações concorrentes, para esse cenário possíveis soluções seriam:

Criar um lock na linha de saldo na base de dados:

   Pros: Mais simples de implementar
   
         Impede que o bando de dados fique inconsistente

   Cons: Pode criar deadlocks no banco de dados
   
         Impede que o bando de dados seja distribuído, limitando a escala.

Usar o [Saga design pattern](https://docs.microsoft.com/en-us/azure/architecture/reference-architectures/saga/saga), onde é criado uma estrutura de eventos que caso uma incosistencia seja detectada, serão realizadas novas transações afim de realizar a correção e atingir uma consistência eventual, como no caso de transações de cartão de crédito poderiam ser estornos:

   Pros: Não trava transações

   Cons: Complexo de implementar
         Permite que o sistema esteja em um estado de incosistencia temporária.





