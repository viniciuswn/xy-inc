# xy-inc
Teste Backend

# Descrição do teste 

```sh
A XY Inc. é uma empresa especializada na produção de excelentes receptores GPS (Global
Positioning System). A diretoria está empenhada em lançar um dispositivo inovador que
promete auxiliar pessoas na localização de ponto de interesse (POIs), e precisa muito de sua
ajuda.

Você foi contratado para desenvolver a plataforma que fornecerá toda a inteligência ao
dispositivo. Esta plataforma deve ser baseada em serviços, de forma a flexibilizar a integração.

1. Serviço para cadastrar pontos de interesse, com 3 atributos: 
Nome do POI, 
coordenada X (inteiro não negativo) e 
coordenada Y (inteiro não negativo).
Os POIs devem ser armazenados em uma base de dados.

2. Serviço para listar todos os POIs cadastrados.

3. Serviço para listar POIs por proximidade. 
Este serviço receberá uma coordenada X e uma coordenada Y, especificando um ponto de referência, em como uma distância máxima (d-max) em metros. 
O serviço deverá retornar todos os POIs da base de dados que estejam a uma distância menor ou igual a d-max a partir do ponto de referência. Exemplo:

Base de Dados:  

'Lanchonete' (x=27, y=12)
'Posto' (x=31, y=18)
'Joalheria' (x=15, y=12)
'Floricultura' (x=19, y=21)
'Pub' (x=12, y=8)
'Supermercado' (x=23, y=6)
'Churrascaria' (x=28, y=2)

Dado o ponto de referência (x=20, y=10) indicado pelo receptor GPS, e uma distância máxima d
e 10 metros, o serviço deve retornar os seguintes POIs:

Lanchonete
Joalheria
Pub
Supermercado
```
 
## 1. Dependências

Instalar as seguintes ferramentas:

    1. JDK 1.8
    2. Maven
    3. Docker compose
    
O projeto utiliza o banco Mysql.
 
## 2. Executando o Projeto
 IDEA Intellij pode ser recomendado
Após baixar o projeto, para executá-lo é necessário rodar os seguintes comandos dentro da pasta raiz.

```sh
$ docker-compose up   
$ mvn clean install   
$ mvn spring-boot:run 
```
## 3. Testando os serviços
Realizar a chamada dos serviços. 
Para testar os serviços o navegador padrão pode ser utilizado ou se preferir utilizar o software postman.


GET / - Listar todos os ponto de encontro 
```sh
$ curl localhost:8080/poi/listaTodos

```

GET - Busca todos os POIs com uma max-dist= 10 
```sh
No postman:
$ curl http://localhost:8080/pois/distance?coordinateReferenceX=20&coordinateReferenceY=10&distance=10

No navegador:

```

POST - Cria um novo POIs 
No postman:
```sh
$ curl -H "Content-Type: application/json" -X POST -d '

http://localhost:8080/pois

{  
  "nome": "ZupTI",
  "pontoX": 23, 
  "pontoY": 4
}

```

## 4.Encerrar o docker
```sh
$ docker-compose down

```