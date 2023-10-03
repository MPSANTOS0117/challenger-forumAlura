<h1 align="center">Oracle Next Educatio Challenge - Forum </h1>

<br>

<div align="center">

![java](https://github.com/loolcas/OracleNE-Forum/assets/118030896/65a3142d-42d1-4e19-b844-683b90fc2d6f) ![spring](https://github.com/loolcas/OracleNE-Forum/assets/118030896/7bd00acb-a595-447b-8d13-f784f0a18c3e) ![image](https://github.com/loolcas/OracleNE-Forum/assets/118030896/797fb206-d388-4208-acab-bdbf1de22b0c) ![jsonrequest](https://github.com/loolcas/OracleNE-Forum/assets/118030896/323a2715-fd0c-4a39-a2e0-aeeb8515109b) ![mysql](https://github.com/loolcas/OracleNE-Forum/assets/118030896/f30cb0ba-71af-402d-a388-f5459f8e75e8)

</div>

<br>

### 🔐 *Requisitos*
- Possuir o Java Development Kit 17+, caso não tenha baixe o instalador para *<a href="">Windows</a>* ou para *<a href="https://www.oracle.com/br/java/technologies/downloads/#jdk21-windows">Linux ou Mac</a>*.
- Possuir o MySQL instalado, caso não tenha baixe *<a href="https://downloads.mysql.com/archives/get/p/25/file/mysql-installer-community-8.0.32.0.msi">por aqui</a>* 
 (Pacote Developer Default).

<br>

## *Passo a passo*

### 👨‍💻 *Preparos*
- Windows + Pause/Break -> Configurações avançadas do sistema -> Variáveis de ambiente -> Path -> Editar
- Criar um novo caminho para o JDK e para o MySQL e passar os respectivos endereço dos arquivos.

<br>

### ⬇ Baixe o projeto por *<a href="https://github.com/loolcas/OracleNE-Forum/archive/refs/tags/v2.0.0.zip"> aqui </a>*
> Extrair no Desktop / Área de Trabalho

<br>

### ⚙ Iniciando o servidor
##### Abra o Prompt de Comandos do sistema
> Pressione Windows+R, digite cmd e pressione enter
##### Digite as linhas de comandos abaixo uma por vez:
> Estou considerando username e password padrão, caso contrário basta modificar
```sql
mysql -u root -p
```
```sql
Password: root
```
> Obrigatório usar o mesmo nome para o banco de dados
```sql
create database forum;
```
```sql
exit
```
```shell
cd Desktop/OracleNE-Forum-2.0.0
```
> Caso username e password = root execute a primeira linha de comando a seguir, do contrário execute a segunda
```java
java -jar target/forum-0.0.1-SNAPSHOT.jar
```
```java
java -Dspring.profile.active=prod -DDATASOURCE_USERNAME='outrousername' -DDATASOURCE_PASSWORD='outrasenha' -jar target/forum-0.0.1-SNAPSHOT.jar
```
> Após servidor iniciar minimize o CMD

<br>

### ▶ Acessando a aplicação
##### Enquanto o servidor está ligado, acesse o navegador e entre no endereço abaixo
```javascript
localhost:8080/swagger-ui.html
```

<br>

### 👨🏻‍💻 Autenticação

##### Acesse o método POST /login e pressione o botão "Try Out"
##### Email e senha disponíveis para execução:
```java
[
   {
     "email":"admin@one.com",
     "senha":"123456"
   }
]
```
##### Feito isto, copie o token recebido e insira-o na seção "Authorize" localizada na parte de cima da página
##### Agora é só testar as funcionalidades!

<br>

### Funcionalidades

- [X] Cadastro de novo tópico
- [X] Atualização de tópico
- [X] Busca única por tópico
- [X] Listagem de tópicos abertos
- [X] Exclusão de tópicos

<br>

<div align="center">

![swagger](https://i.imgur.com/gBGculH.png)
  
</div>

### Não feche o servidor pelo X
> Volte ao CMD, pressione Ctrl+C e digite:
```java
exit
```
