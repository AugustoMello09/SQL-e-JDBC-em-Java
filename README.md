# SQL e JDBC com JAVA

Iniciando os estudos em SQL e JDBC em java usando o Banco de Dados  PostgreSQL.

#### Objetivo do repositório

CRUD simples para ajudar a reforçar os Conhecimentos tanto em Java como SQL

## Introdução ao SQL

Subconjuntos da linguagem SQL

#### DDL (Date Definition Language)

- CREATE TABLE;
- ALTER TABLE;
- DROP TABLE;

#### DML (Date Manipulation Language)

- INSERT;
- DALETE;
- UPDATE;

#### DQL (Date Query Language)

- SELECT;

#### DCL (Date Control Language)

- CREATE USER;
- ALTER USER;

#### DTL (Date Transaction Language)

- BEGIN TRANSACTION;
- COMMIT;
- ROLLBACK;

## Criando Banco de Dados

Criando nosso Banco de Dados usando PostgreSQL.

~~~SQL
create database userposjava(
with owner = postgres
    encoding = 'UTF8'
    tablespace = pg_ddefault
    connection limit = -1;
)
~~~
#### Criação de uma tabela

DDL (Date Definition Language) (tabela pai)

~~~SQL
create table userposjava(
  id bigint not null,
  nome character varying(255),
  email character varying(255),
  constraint user_pk primary key (id)
)
~~~

#### Manipulação de dados da tebela

DML (Date Manipulation Language)

~~~SQL
insert into userposjava (id, nome, email)
values (1, 'José', 'example@gmail.com');  
~~~

#### Trabalhando com SEQUENCE

Passando a criação de usuários de modo manual para automático no Banco.

~~~SQL
CREATE SEQUENCE public.usersequence
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 7
  CACHE 1;
ALTER TABLE public.usersequence
  OWNER TO postgres;
~~~

#### transformando o id para único

Nela será aplicado o conceito de um para muitos.

~~~SQL
alter table userposjava add unique (id);
~~~

#### Criando a tabela de telefones

(tabela pai)

~~~SQL
create table telefoneuser
(
id bigint not null,
numero character varying (255) not null,
tipo character varying (255) not null,
usuariopessoa bigint not null,
constraint telefone_id primary key (id));
~~~

#### Transformando o usuariopessoa em uma Forign Key

Tranformando em forign key usuariopessoa referenciando a tabela Pai o tributo id.

~~~SQL
alter table telefoneuser  add foreign key (usuariopessoa) references userposjava(id)
~~~

#### SEQUENCE para telefones

Gerando a criação de telefones automático no Banco.

~~~SQL
CREATE SEQUENCE user_telefone_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE user_telefone_seq
  OWNER TO postgres;
~~~

#### Transformando o user_telefone_seq em uma Forign Key

Tranformando em forign key user_telefone_seq referenciando a tabela Pai o tributo id.

~~~SQL
ALTER TABLE telefoneuser  ALTER COLUMN id SET DEFAULT nextval('user_telefone_seq'::regclass);
~~~

#### INSERT na tebela Pai

~~~SQL
INSERT INTO public.userposjava( nome, email) VALUES ('test10', 'example10@gmail.com');
~~~

#### INSERT na tebela telefone

~~~SQL
INSERT INTO public.telefoneuser(numero, tipo, usuariopessoa)
    VALUES (' (25) 9 9865-7823', 'celular', '10');

INSERT INTO public.telefoneuser(numero, tipo, usuariopessoa)
        VALUES (' (25) 9 8881-7823', 'celular', '10');

INSERT INTO public.telefoneuser(numero, tipo, usuariopessoa)
        VALUES (' (18) 9 3659-4587', 'celular', '9');

INSERT INTO public.telefoneuser(numero, tipo, usuariopessoa)
        VALUES (' (17) 9 4521-8975', 'celular', '9');

INSERT INTO public.telefoneuser(numero, tipo, usuariopessoa)
        VALUES (' (19) 9 3684-7841', 'celular', '9');                
~~~
#### INSERT na tebela Pai

Trabalhando com relacionamento de tabela com INNER JOIN.

~~~SQL
select * from telefoneuser as fone
inner join userposjava as userp
on fone.usuariopessoa = userp.id
~~~

#### DELETE com tabelas relacionadas

primeiro deletando as filhas e depois o Pai.

~~~SQL
delete from telefoneuser where usuariopessoa = 10
delete from userposjava where id = 10  
~~~
## Ferramentas e Tecnologias usadas nesse repositório 🌐
<div style="display: inline_block"><br>

<img align="center" alt="Augusto-Java" height="60" width="60" src=https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg >
<img align="center" alt="Augusto-POSTGRESQL" height="60" width="60" src="https://raw.githubusercontent.com/devicons/devicon/1119b9f84c0290e0f0b38982099a2bd027a48bf1/icons/postgresql/postgresql-original-wordmark.svg">
</div>    

## Teste o projeto 👁‍🗨

Download do projeto para testar em sua máquina: xxx

## Entre em contado 👋
  
<div>
  
  <a href = "joseaugusto.mello01@gmail.com"><img src="https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white" target="_blank"></a>
  <a href="https://www.linkedin.com/in/jos%C3%A9-augusto-794a94234/" target="_blank"><img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a>   

  </div>
