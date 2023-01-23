# Boas vindas ao repositório do projeto Address Register
[![Continuos Integration with GitHub](https://github.com/Humberto-Bonadiman/address_register/actions/workflows/docker.yml/badge.svg)](https://github.com/Humberto-Bonadiman/address_register/actions/workflows/docker.yml)

---

## Descrição do projeto

Neste projeto eu fui responsável por criar uma API REST responsável por gerenciar endereços de pessoas utilizando Java com Spring-boot e o banco de dados PostgreSQL.
</br>
Também utilizei o conceito de Rest Template, onde pude pegar os dados da api **https://brasilapi.com.br/api/cep/v1/{cep}** onde é possível fornecer o cep e receber os dados como estado, cidade, rua entre outros. Com isso, utilizei essas informações para completar os dados do endereço.

---

## Instalação do projeto localmente

Após cada um dos passos, haverá um exemplo do comando a ser digitado para fazer o que está sendo pedido.

1. Realize o clone do projeto no diretório de sua preferência:
```javascript
git clone git@github.com:humberto-bonadiman/address_register.git
```

2. Acesse o diretório do projeto e depois utilize o comando **mvn install** para instalar todas as dependências necessárias:
```javascript
  cd address_register
  mvn install
```

3. Após empacote o código compilado com o comando **mvn package**:
```javascript
mvn package
```

## Comandos para utilizar o Docker

Caso o PostgreSQL esteja ativo em sua máquina é necessário realizar o comando:
```javascript
sudo service postgresql stop
```

Para criar e iniciar os contêineres:
</br>
Obs.: Com o comando abaixo o docker fica rodando no terminal.
```javascript
docker-compose up
```

Para criar e iniciar os contêineres em stand-by:
```javascript
docker-compose up -d
```

Para realizar apenas a etapa de build das imagens que serão utilizadas:
```javascript
docker-compose build
```

Para paralisar e remover todos os contêineres e seus componentes como rede, imagem e volume:
```javascript
docker-compose down
```
---

## Utilizando o Spring-boot sem o Docker

Primeiramente, ative o PostgreSQL:
```javascript
sudo service postgresql start
```
No arquivo que está no caminho **/src/main/resources/application.yml** você deve alterar a 6ª(username) e a 7ª(password) linha com o usuário e senha do seu PostgrSQL:
```javascript
spring:
  datasource:
    username: username
    password: password
```

Entre no PostgreSQL intalado na sua máquina e crie a tabela **address_register**:
```javascript
sudo -u postgres psql
```
```javascript
CREATE DATABASE address_register OWNER <seu_usuário_postgresql>;
```

Saía da linha de comando do postgresql com **\q** e rode o Spring-Boot com o comando:
```javascript
mvn spring-boot:run
```

---

## Realização dos testes

Para realizar todos os testes da aplicação você pode utilizar o seguinte comando:
```javascript
mvn clean test
```

Para realizar somente um teste específico você deve utilizar o comando:
```javascript
mvn test -Dtest=O_nome_do_teste_vai_aqui
```

Exemplo:
```javascript
mvn test -Dtest=CreateAddressTest
```

Para realizar mais de um teste basta adicionar uma vírgula ao final do teste conforme o exemplo:
```javascript
mvn test -Dtest=CreateAddressTest,DeleteAddressByIdTest
```

Para realizar os testes do pacote **addressTest** você deve utilizar o seguinte comando:
```javascript
mvn test -Dtest="com.br.address_register.addressTests.**"
```

Para realizar os testes do pacote **personTests** você deve utilizar o seguinte comando:
```javascript
mvn test -Dtest="com.br.address_register.personTests.**"
```

## Documentação

![Documentação Swagger](swagger_address_register.png)

Para acessar a documentação pelo swagger rode o comando **mvn spring-boot:run** ou **docker-compose up** e acesse o projeto via browser, no caminho http://localhost:8081/swagger-ui/index.html ou pelo caminho http://localhost:8081/v3/api-docs.
