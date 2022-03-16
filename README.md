# LuizaLabs - Desafio técnico tribo pedidos e integrações

## Desafio

Temos uma demanda para integrar dois sistemas. O sistema legado que possui um arquivo
de pedidos desnormalizado, precisamos transformá-lo em um arquivo json normalizado. E
para isso precisamos satisfazer alguns requisitos.Faça um sistema que receba um arquivo ou diretório e processe-os para o novo formato.

## TECNOLOGIAS, PADRÕES E DEPENDENCIAS UTILIZADAS

Java 13

Maven Project

Framework Spring 2.6.4

GIT/GITHUB

JUNIT5/Mockito

Jackson

Docker

## INSTRUÇÕES PARA CONFIGURAR O AMBIENTE E EXECUTAR OS TESTES

 - Faça o download/clone do repositório do GitHub para a sua máquina.
 - Na raiz do projeto, abra o arquivo .env e configure a pasta que será utilizada para a entrada e saida de arquivos atraves da variavel HOST_INPUT_OUTPUT_FOLDER. (Passo não necessário quando rodar em máquinas com SO Windows)
 - Insira os arquivos de input dentro da pasta. (Caso for Windows, e não for alterado o HOST_INPUT_OUTPUT_FOLDER, dentro da pasta terá dois arquivos de input)
 - Abra o terminal na raiz do projeto e execute o comando : mvn clean package -e OU mvnw clean package -e.
 - Ainda no terminal, execute o comando docker-compose up -d para subir o container do sistema.
 - O sistema processará todos arquivos txt do diretório configurado e criará os JSON correspondentes no mesmo local.








