#POSTGRESQl

create database bdoicotinovosexta;

\c  bdoicotinovosexta


\dt
# mostra as tabelas

\d
# mostra tudo (tabela e sequence)

\list
q

select user;
select version();

--Herança no Próprio Banco de Dados
create table pessoa(
 nome varchar (50),
 email varchar (50)
 );
   create table usuario(
   idusuario int primary key,
   perfil varchar (15)
   ) inherits (pessoa);
   \d usuario
      insert into usuario values ('lu','lu@gmail.com',100,'adm');

select * from pessoa;
   nome |    email     
  ------+--------------
   lu   | lu@gmail.com

select * from usuario;
 nome |    email     | idusuario | perfil 
------+--------------+-----------+--------
 lu   | lu@gmail.com |       100 | adm

   
   
   
   
   
  
  
  



















