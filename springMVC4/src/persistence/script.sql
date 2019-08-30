conn system/coti
select user from dual;

create user oialuno identified by coti
 default tablespace users
 quota 100m on users;
 
 grant create table, create session, create procedure, create sequence,
  create trigger, create view to oialuno;
  
   conn oialuno/coti
   
   select user from dual;
   
     create table filme(idFilme number (15) primary key,
         nomeFilme varchar (50) unique, preco number (10,2),
         categoria varchar (50), imagem varchar (255),
         trailer varchar (255));
         
         create sequence seq_filme;
         
create or replace function  gravarFilme(
vnome in varchar, vpreco  in number, vcategoria in varchar,
 vimagem in varchar, vtrailer in varchar)  return number
 as
  vcodigo number (15) :=0;
 begin
     select   idFilme into vcodigo from filme
             where  nomeFilme = vnome;
        return -1;
 Exception when others then 
   insert into filme values
   (seq_filme.nextval, vnome, vpreco,vcategoria, vimagem, vtrailer); 
   commit;
   return 1;
end; 
/         
var resultado number;
exec :resultado := gravarfime('minions',8,'infantil', 'https://a-static.mlcdn.com.br/618x463/boneco-de-vinil-minions-bob-lider-lider/toymania2/70107/dac77436106356ffb613cfc4e2d87478.jpg',null);




    
    
    
    
         
         
         
         
         
         
         
         
         
  
 
 
 