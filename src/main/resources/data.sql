insert into PROFILE(name,description) values('PRODUCT OWNER','O product owner diz o que precisa ser feito, o que � priorit�rio e o que deve ficar de lado. Cabe a ele guiar um projeto desde o papel at� transform�-lo em um produto pr�tico, que pode ser vendido, negociado e trazer lucro para a empresa.');
insert into PROFILE(name,description) values('DESENVOLVEDOR','O Desenvolvedor de software (ou programador) � respons�vel pela programa��o, que � o processo de escrita, teste e manuten��o de um programa de computador. Utiliza como subs�dio o levantamento de requisitos e as an�lises feitas pelo analista de sistemas.');

insert into SKILL(NAME,DESCRIPTION,PROFILE_ID) values('Java','Java � uma linguagem de programa��o orientada a objetos que atualmente faz parte do n�cleo da Plataforma Java',2);
insert into SKILL(NAME,DESCRIPTION,PROFILE_ID) values('Flutter','O Flutter, um framework desenvolvido pelo Google na linguagem Dart, permite o desenvolvimento de aplica��es nativas tanto para Android quanto para iOS a partir da composi��o de Widgets',2);

insert into B_USER(BIRTH_DATE,CELLPHONE,EMAIL,FIRST_NAME,LAST_NAME,TELEPHONE,PROFILE_PROFILE_ID)
VALUES('1999-10-10','(10)99470-7213','gimpy@gmail.com','Gimpy','Linux','(24)6666-6666',1);
insert into B_USER(BIRTH_DATE,CELLPHONE,EMAIL,FIRST_NAME,LAST_NAME,TELEPHONE,PROFILE_PROFILE_ID)
VALUES('1999-01-10','(19)99470-7213','alexa@gmail.com','Alexa','Rebello','(24)6666-6666',2);

insert into LINK(LINK,LINK_TYPE,USER_USER_ID)
values('https://github.com/GIMPY','GITHUB',1);
insert into LINK(LINK,LINK_TYPE,USER_USER_ID)
values('https://www.linkedin.com/in/alexa-3b1500143/','LINKEDIN',2);

insert into EXPERIENCE (DESCRIPTION,END_DATE,INITIAL_DATE,TITLE,USER_USER_ID)
values('Desenvolvendo REST APIs para serem consumidas por aplicações mobile','2020-02-24','2016-02-01','Desenvolvedor Java Pleno na empresa FATEC',1);

insert into EXPERIENCE (DESCRIPTION,END_DATE,INITIAL_DATE,TITLE,USER_USER_ID)
values('Desenvolvendo Frontends e coordenando designers à  elaborar interfaces para sistemas mobile na FATEC','2020-02-24','2016-02-01','Desenvolvedor Front-End Sênior na empresa FATEC',2);

insert into PROJECT(DESCRIPTION,ENDING_DATE,INITIAL_DATE,STATUS,TITLE,USER_ID)
values('Criação de um sistema de contabilidade para fazer balanço','2022-09-04','2020-02-25','NEW','Contabil-Z',2);--2 == NEW
insert into PROJECT(DESCRIPTION,ENDING_DATE,INITIAL_DATE,STATUS,TITLE,USER_ID)
values('Criação de um sistema Android para apontamento de horas trabalhadas','2021-01-31','2020-02-25','OPEN','Hournator',2);

insert into PROJECT_SKILL
values(2,2);
insert into PROJECT_SKILL
values(2,1);