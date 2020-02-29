INSERT INTO PROFILE(name,description) VALUES('Product Owner','O product owner diz o que precisa ser feito, o que � priorit�rio e o que deve ficar de lado. Cabe a ele guiar um projeto desde o papel at� transform�-lo em um produto pr�tico, que pode ser vendido, negociado e trazer lucro para a empresa.');
INSERT INTO PROFILE(name,description) VALUES('Desenvolvedor','O Desenvolvedor de software (ou programador) � respons�vel pela programa��o, que � o processo de escrita, teste e manuten��o de um programa de computador. Utiliza como subs�dio o levantamento de requisitos e as an�lises feitas pelo analista de sistemas.');

INSERT INTO SKILL(DESCRIPTION,NAME) VALUES('Java','Java � uma linguagem de programa��o orientada a objetos que atualmente faz parte do n�cleo da Plataforma Java');
INSERT INTO SKILL(DESCRIPTION,NAME) VALUES('Flutter','O Flutter, um framework desenvolvido pelo Google na linguagem Dart, permite o desenvolvimento de aplica��es nativas tanto para Android quanto para iOS a partir da composi��o de Widgets');

INSERT INTO USER(BIRTH_DATE,FIRST_NAME,GENDER,LAST_NAME,PROFILE_PROFILE_ID)
VALUES('1999-10-10','Gimpy','Male','Linux',1);
INSERT INTO USER(BIRTH_DATE,FIRST_NAME,GENDER,LAST_NAME,PROFILE_PROFILE_ID)
VALUES('1999-01-10','Alexa','Female','Rebello',2);

INSERT INTO CONTACT(CELLPHONE,EMAIL,GITHUB_LINK,LINKEDIN_LINK,TELEPHONE,USER_USER_ID) VALUES('(12)1234-5472','teste2@gmail.com','https://github.com/Teste2','https://www.linkedin.com/in/teste2','(12)3456-7892',1);
INSERT INTO CONTACT(CELLPHONE,EMAIL,GITHUB_LINK,LINKEDIN_LINK,TELEPHONE,USER_USER_ID) VALUES('(12)1234-5473','teste3@gmail.com','https://github.com/Teste3','https://www.linkedin.com/in/teste3','(12)3456-7893',2);

INSERT INTO USER_SKILL
VALUES(1,1);
INSERT INTO USER_SKILL
VALUES(1,2);
INSERT INTO USER_SKILL
VALUES(2,2);

INSERT INTO EXPERIENCE (DESCRIPTION,END_DATE,INITIAL_DATE,TITLE,USER_USER_ID)
VALUES('Desenvolvendo REST APIs para serem consumidas por aplicações mobile','2020-02-24','2016-02-01','Desenvolvedor Java Pleno na empresa FATEC',1);

INSERT INTO EXPERIENCE (DESCRIPTION,END_DATE,INITIAL_DATE,TITLE,USER_USER_ID)
VALUES('Desenvolvendo Frontends e coordenando designers à  elaborar interfaces para sistemas mobile na FATEC','2020-02-24','2016-02-01','Desenvolvedor Front-End Sênior na empresa FATEC',2);

INSERT INTO PROJECT(DESCRIPTION,ENDING_DATE,INITIAL_DATE,STATUS,TITLE,USER_ID)
VALUES('Criação de um sistema de contabilidade para fazer balanço','2022-09-04','2020-02-25',2,'Contabil-Z',2);--2 == NEW
INSERT INTO PROJECT(DESCRIPTION,ENDING_DATE,INITIAL_DATE,STATUS,TITLE,USER_ID)
VALUES('Criação de um sistema Android para apontamento de horas trabalhadas','2021-01-31','2020-02-25',2,'Hournator',2);

INSERT INTO PROJECT_SKILL
VALUES(2,2);
INSERT INTO PROJECT_SKILL
VALUES(2,1);