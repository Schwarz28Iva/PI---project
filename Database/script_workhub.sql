CREATE TABLE users
( id int,
  nume varchar(250),
  prenume varchar(250),
  departament varchar(250),
  statut varchar(250),
  email varchar(250),
  datan date,
  dataa date,
  sex char(2),
  aptitudini varchar(250)
);

CREATE TABLE users
( 
  parola varchar(250),
  companie varchar(250),
  username varchar(250),
  nume varchar(250),
  prenume varchar(250),
  departament varchar(250),
  statut varchar(250),
  email varchar(250),
  datan date,
  dataa date,
  sex char(2),
  aptitudini varchar(250)
);

INSERT INTO login (id, company, username, password)
VALUES (1, 'OSUT', 'Vale', '2');

select DATE_FORMAT(curdate(), '%m-%d-%Y');
SELECT nume, prenume, DATE_FORMAT(datan, '%m-%d-%Y') as 'Datan', dataa, email from users order by Datan; 
--BUN
SELECT nume, prenume, DATE_FORMAT(datan, '%m-%d-%Y') as 'datan', email from users where Datan > DATE_FORMAT(curdate(), '%m-%d-%Y') order by datan limit 10;

SELECT nume, prenume, DATE_FORMAT(datan, '%M-%d-%Y') as 'Dataa', dataa, email from users order by Dataa;
SELECT nume, prenume, DATE_FORMAT(datan, '%m-%d-%Y') as 'Dataa', dataa, email from users where Dataa < CURDATE() order by datan limit 10;

SELECT nume, prenume, datan, dataa, email from users where users.datan = DATE_SUB(CURDATE(), INTERVAL 3 MONTH);
SELECT nume, prenume, datan, dataa, email from users where DATE_FORMAT(datan '%d-%m') < CURDATE() order by datan limit 10;
SELECT nume, prenume, datan, dataa, email from users where DATE_FORMAT(datan '%d-%m') < CURDATE() order by datan limit 10;

SELECT * FROM users;
SELECT * FROM login;
SELECT * FROM organigrama;