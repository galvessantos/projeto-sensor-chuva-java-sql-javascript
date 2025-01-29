# Estação Meteorológica | Java, JavaScript & SQL - 4° Projeto | Universidade Paulista
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/galvessantos/projeto-consumo-javascript/blob/main/LICENSE) 

# Sobre o projeto

O tema da disciplina de Atividades Práticas Supervisionadas no quarto semestre do curso de Ciência da Computação da Universidade Paulista trata de 'Estação Meteorológica', uma aplicação que consiste em captar dados meteorológicos reais e enviar para o programa, fazendo com que ele apresente ao usuário e registre os dados coletados em um banco de dados. 

Para o desenvolvimento do projeto, utilizamos o Arduino, DHT22 e um Sensor de Chuva para registro das variáveis Temperatura, Umidade e Precipitação. 

Depois de coletar as informações dos sensores, o Arduino, programado em linguagem C, envia os dados para o Java. A comunicação acontece via USB, e utilizamos o NetBeans IDE 21 para processar esses dados no computador.

Os dados coletados são armazenados em uma base de dados usando Microsoft SQL Server e o framework Hibernate, o que permite uma comunicação tranquila entre o Java e o banco de dados.

Por fim, desenvolvemos uma interface para que o usuário possa visualizar as informações da estação meteorológica em tempo real de forma clara e acessível. Além disso, incluímos uma seção "Sobre nós", com o objetivo de apresentar os integrantes do grupo e compartilhar um pouco mais sobre o trabalho em equipe. Utilizamos o framework JSF para integrar o Java com HTML, CSS e JavaScript, criando uma plataforma web que é ao mesmo tempo funcional, estética e de fácil navegação.

## Layout 

https://github.com/user-attachments/assets/516388f1-7b6b-4c48-9dfd-477522596730

# Tecnologias utilizadas

## Back end
- Java
- C (Arduino IDE)

## Front end
- HTML
- CSS
- JavaScript

## Frameworks
- JavaServer Faces
- Hibernate

## Banco de Dados
- SQLServer

## Hardware
- Arduino Uno
- DHT22 (Temperatura e Umidade)
- Sensor de Chuva (Precipitação)

  
# Como executar o projeto
```
# para que o projeto funcione corretamente, você precisará dos mesmos hardwares que utilizamos
  para o registro das variáveis. 

  bash
# clonar repositório
  git clone https://github.com/galvessantos/projeto-consumo-javascript.git

# abra o projeto em um ambiente de desenvolvimento integrado (IDE) - IntelliJ | NetBeans | Eclipse

# dentro da IDE, execute o projeto.

```


# Autores

Gabriel Alves
https://www.linkedin.com/in/galvessantos/

Nicholas Brites
https://www.linkedin.com/in/nicholasbrites/

Cassiano Melo
https://www.linkedin.com/in/cassiano-melo-679938326/
