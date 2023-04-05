# **Sobre o Projeto**
O projeto em questão é dividido em duas partes: 

 * **Alura Stickers:** Um programa responsável por extrair dados de APIs e gerar figurinhas; 
 * **Api Languages:** Uma API responsável por fornecer informações de um ranking de liguagens de programação baseado no [*PYPL PopularitY of Programming Language*](https://pypl.github.io/PYPL.html). 
 
 O projeto foi desenvolvido com base nos conhecimentos adquiridos através das aulas gratuitas **Imersão Java 2 da Alura**, realizada entre os dias 27/03/2023 a 31/03/2023.

# **Descrição do projeto**

## **Alura Stickers**

O primeiro projeto consiste em extrair dados de APIs que possuem imagens para fazer figurinhas delas. Como padrão, o projeto possui três APIs para o usuário escolher quais imagens deseja: 

* A API de ranking de filmes, feita pela Alura com base no ranking da imDB;
* A API da [NASA](https://api.nasa.gov/), que disponibiliza fotos do Universo;
* A API de Ranking de linguagens de programção, desenvolvida durante a Imersão Java 2 (pasta api-languages).

É possível adicionar mais APIs nesse projeto com o intuito de gerar outras figurinhas. Consulte a sessão **Como utilizar** para mais detalhes.

## **API Languages**

O segundo projeto foi desenvolvido a partir do Framework [Spring](spring.io), um framework Java que facilita o desenvolvimento de aplicativos corporativos, com recursos como inversão de controle, injeção de dependência e integração com outros frameworks. Atualmente, ele funciona somente no servidor local e em conjunto com o [MongoDB Cloud](https://account.mongodb.com/account/login).


# **Status do Projeto** 
🚧🚧**Em desenvolvimento** 🚧🚧  
Ambas as partes do projeto estão concluídas. Esse projeto foi de extrema importância para mim, pois aprendi a consumir e criar uma API usando Java. Ainda falta uma parte crucial, a hospedagem da API, que pretendo fazer no futuro. Quando a API estiver hospedada, não será necessário executar o projeto API Languages toda vez, tornando a aplicação mais prática para quem desejar criar figurinhas com logotipos de linguagens de programação.

# **Como utilizar**
## **Alura Stickers**  
Para iniciar, basta executar a classe *App.java*. A partir disso, a aplicação permitirá o usuário escolher a API desejada para obter as imagens. Após escolher uma das opções, o usuário deverá escolher se ele deseja colocar um texto personalizado na figurinha que será gerada e se ele deseja obter uma imagem específica da API ou todas as imagens. Lembrando que, caso opte por escolher uma imagem específica, o usuário **deverá colocar o nome igual como está na API assim que for solicitado**, caso o contrário, a aplicação será finalizada.

![Tela do gerador de figurinhas](https://i.imgur.com/dyrmSfY.png)

Após fazer o procedimento, abra a pasta *'saída'* em \alura-stickers\stickers e veja o resultado:

![Resultado](https://i.imgur.com/heiuaxX.png)


### **Como colocar outras APIs**  
Caso desejar inserir na aplicação outra API que possua imagens, basta informar o link dela em uma nova constante na enum *API.java* e criar uma nova classe que implementa a interface **ExtractorContent**. Como forma de facilitar a criação de novos extratores, copie o código de um dos extratores já existentes e altere os parâmetros **atributos.get()** do return de acordo como está na API desejada.

![Onde colocar o link](https://i.imgur.com/qfkJEPE.png)

![Substitua esses parâmetros](https://i.imgur.com/U79yxRH.png)


## **API Languages**
A forma mais rápida de executar essa API é abrir o Prompt de Comando na pasta **\api-languages\target** e realizar o seguinte comando:  
```cmd
java -jar api-languages-0.0.1-SNAPSHOT.jar
```
Após esse comando, ele abrirá o servidor local e você poderá utilizar ele em conjunto com o Alura Stickers para gerar as figurinhas desse projeto. Caso queira consultar a API, vá em seu navegador e digite http://localhost:8080/languages  


# **Tecnologias utilizadas**
**Eclipse IDE**  

**Maven:** É uma ferramenta de gerenciamento e construção baseado em um modelo de projeto para Java e que permite gerar as dependências, plugins e configurações de construção da comunicação entre a aplicação e o banco de dados;  

**Spring Web:**  É um framework de desenvolvimento para Java que facilita a criação de aplicações com a utilização de diversos módulos independentes. Nesse projeto, ele foi usado para permitir a visualização e o CRUD de dados armazenados em um servidor remoto (MongoDB).  

**MongoDB:** É um banco de dados NoSQL orientado a documentos que neste caso foi utilizado para armazenar dados em formato JSON;  

**Postman:** É uma plataforma que facilita a manipulação de APIs. Foi utilizada para testar e realizar o CRUD no Banco de Dados da aplicação.




# Autor
**Guilherme Vaiano Nogueira Mendonça**  
LinkedIn: https://www.linkedin.com/in/guilherme-mendon%C3%A7a-12a83720b/  
