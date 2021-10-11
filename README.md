# cadastro-api
API RESTful em java para cadastramento de usuários utilizando springboot framework, Docker para conteinerização de contêineres e Kubernetes para orquestração de contêineres.

## Requisitos
* Java 11
* postgresql 13*
* Maven 4.0
* Spring Boot 2.5.2
* Docker
* Kubernetes

## Preparando Ambiente de Desenvolvimento
* ```mvn clean install```
* Crie o banco com o nome ```cadastro-api```
* Observe o usuário e senha no arquivo ```application.yml```

## Preparando Ambiente de Produção
* ```mvn clean```
* ```mvn install -DskipTests=true```
* Gere a imagem do Docker ```docker build -t cadastro-api.jar .```
* Organize a imagem ```docker tag código_da_imagem usuário/cadastro-api:1.0```
* Suba a imagem para o repositório remoto docker ```docker push usuário/cadastro-api:1.0```
* Faça o upload dos 4 arquivos na Google Cloud usando o Kubernetes:
* 1- postgres-configmap.yaml; 2- postgres-credentials.yaml; 3- postgres-deployment.yaml; 4- deployment.yaml

## Instruções Iniciais para testar a api
* Utilize o ```postman``` criando um request para testar o funcionamento da api utilizando os métodos HTTP: GET, POST, PUT e DELETE.
