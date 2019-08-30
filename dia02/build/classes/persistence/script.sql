create database if not exists BDOICOTYMY;

use BDOICOTYMY;

create table usuario(
idusuario int primary key auto_increment, 
nome varchar(50), 
email varchar(50) unique, 
perfil enum ('usu', 'adm'), 
senha varchar(250), 
dataCadastro date
);

insert into usuario values
(null, 'lu', 'lu@gmail.com', 'usu', md5('123'), '2016-05-25'),
(null, 'teste', 'teste@gmail.com', 'adm', md5('abc'), '2018-07-25');
