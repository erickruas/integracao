# LuizaLabs - Desafio técnico tribo pedidos e integrações

## Desafio

Temos uma demanda para integrar dois sistemas. O sistema legado que possui um arquivo
de pedidos desnormalizado, precisamos transformá-lo em um arquivo json normalizado. E
para isso precisamos satisfazer alguns requisitos .Faça um sistema que receba um arquivo ou diretório e processe-os para o novo formato.

## TECNOLOGIAS, PADRÕES E DEPENDENCIAS UTILIZADAS

Java 13

Maven Project

Framework Spring 2.6.4

GIT/GITHUB

JUNIT5/Mockito

JACKSON

## INSTRUÇÕES PARA CONFIGURAR O AMBIENTE E EXECUTAR OS TESTES

 - Faça o download/clone do repositório do GitHub para a sua máquina.
 - Na raiz do projeto, abra o arquivo .env e configure a pasta que será utilizada para a entrada e saida de arquivos. (Passo não necessário quando rodar em máquinas com SO Windows)
 - O sistema lê um arquivo de input por vez, por tanto insira na pasta selecionada o arquivo de entrada com o nome input.txt.
 - Abra o terminal na raiz do projeto e execute o comando : mvn clean package -e OU mvnw clean package -e.
 - Ainda no terminal, execute o comando docker-compose up -d para subir o container do sistema.
 - Será gerado um output com os dados em json na pasta configurada na variavel de ambiente.
 - Caso queira converter um novo arquivo, basta inserir colocar um novo arquivo na pasta e rodar o comando docker start integracao_app_1 no terminal.








