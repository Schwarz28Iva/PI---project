CREATE DATABASE proiect_bd;

DROP TABLE departamente;
DROP TABLE aptitudini;
DROP TABLE tasks;
DROP TABLE voluntari;
DROP TABLE angajati;

CREATE TABLE departamente (
	id_dep int(11),
    nume_dep varchar(100) not null UNIQUE,
    CONSTRAINT id_dep_pk PRIMARY KEY(id_dep)
);

CREATE TABLE aptitudini (
	id_ap int(11),
    nume_ap varchar(100) not null UNIQUE,
    CONSTRAINT id_ap_pk PRIMARY KEY(id_ap)
);

CREATE TABLE tasks (
	id_t int(11),
    nume_t varchar(100) not null UNIQUE,
    id_ap int(11) not null,
    CONSTRAINT id_ap_fk FOREIGN KEY(id_ap) REFERENCES aptitudini(id_ap),
    CONSTRAINT id_t_pk PRIMARY KEY(id_t)
);

CREATE TABLE voluntari (
	id int(11),
    nume varchar(100) not null,
    prenume varchar(100) not null,
    datan date,
    id_dep int(11) ,
    id_ap int(11),
    id_task int(11),
    CONSTRAINT id_ap_fk FOREIGN KEY(id_ap) REFERENCES aptitudini(id_ap),
    CONSTRAINT id_dep_fk FOREIGN KEY(id_dep) REFERENCES departamente(id_dep),
    CONSTRAINT id_task_fk FOREIGN KEY(id_task) REFERENCES tasks(id_task),
    CONSTRAINT id_pk PRIMARY KEY (id)
);

CREATE TABLE angajati (
	id int(11),
    nume varchar(100) not null,
    prenume varchar(100) not null,
    datan date,
    id_dep int(11),
    id_ap int(11),
    id_task int(11),
    functie varchar(11), 
    salariu int(11),
    CONSTRAINT id_ap_fk FOREIGN KEY(id_ap) REFERENCES aptitudini(id_ap),
    CONSTRAINT id_dep_fk FOREIGN KEY(id_dep) REFERENCES departamente(id_dep),
    CONSTRAINT id_task_fk FOREIGN KEY(id_task) REFERENCES tasks(id_task),
    CONSTRAINT sal_chk CHECK(salariu BETWEEN 800 AND 10000),
    CONSTRAINT id_pk PRIMARY KEY(id)
);

CREATE SEQUENCE s_idv INCREMENT BY 15 START WITH 100 MAXVALUE 495 NOCYCLE NOCACHE;
CREATE SEQUENCE s_ida INCREMENT BY 15 START WITH 500 NOCYCLE NOCACHE;
CREATE SEQUENCE s_id_dep INCREMENT BY 1 START WITH 1 NOCYCLE NOCACHE;
CREATE SEQUENCE s_id_ap INCREMENT BY 10 START WITH 10 NOCYCLE NOCACHE;
CREATE SEQUENCE s_id_task INCREMENT BY 1 START WITH 1 NOCYCLE NOCACHE;

INSERT INTO departamente VALUES (s_id_dep.NEXTVAL,'IMAGINE');
INSERT INTO departamente VALUES (s_id_dep.NEXTVAL,'IT');
INSERT INTO departamente VALUES (s_id_dep.NEXTVAL,'HR');
INSERT INTO departamente VALUES (s_id_dep.NEXTVAL,'FR');
INSERT INTO departamente VALUES (s_id_dep.NEXTVAL,'PR');

INSERT INTO aptitudini VALUES (s_id_ap.NEXTVAL,'engleza');
INSERT INTO aptitudini VALUES (s_id_ap.NEXTVAL,'algoritmica');
INSERT INTO aptitudini VALUES (s_id_ap.NEXTVAL,'programare');
INSERT INTO aptitudini VALUES (s_id_ap.NEXTVAL,'marketing');
INSERT INTO aptitudini VALUES (s_id_ap.NEXTVAL,'contabilitate');
INSERT INTO aptitudini VALUES (s_id_ap.NEXTVAL,'design');

INSERT INTO tasks VALUES (s_id_task.NEXTVAL,'reclama',40);
INSERT INTO tasks VALUES (s_id_task.NEXTVAL,'retea',30);
INSERT INTO tasks VALUES (s_id_task.NEXTVAL,'site',60);

INSERT INTO voluntari VALUES (s_idv.NEXTVAL,'Indrei','Valentina',1999-11-28,2,30,null);
INSERT INTO voluntari VALUES (s_idv.NEXTVAL,'Draghicescu','Andrei',2001-04-21,3,10,null);
INSERT INTO voluntari VALUES (s_idv.NEXTVAL,'Agavriloaie','Nicola',1999-01-05,5,40,null);
INSERT INTO voluntari VALUES (s_idv.NEXTVAL,'Popescu','Rebeca',2000-06-18,1,60,null);
INSERT INTO voluntari VALUES (s_idv.NEXTVAL,'Mircea','Ionela',2000-07-07,4,50,null);
INSERT INTO voluntari VALUES (s_idv.NEXTVAL,'Ionescu','Mihai',1998-03-23,2,10,null);
INSERT INTO voluntari VALUES (s_idv.NEXTVAL,'Vilan','Maria',2001-10-01,3,20,null);
INSERT INTO voluntari VALUES (s_idv.NEXTVAL,'Tufis','Daria',2001-12-17,5,30,null);
INSERT INTO voluntari VALUES (s_idv.NEXTVAL,'Dobre','Vlad',2000-07-22,1,40,null);
INSERT INTO voluntari VALUES (s_idv.NEXTVAL,'Dobrean','Marius',1998-04-10,4,50,null);

INSERT INTO angajati VALUES (s_ida.NEXTVAL,'Pop','Loredana',1999-11-20,1,30,null);
INSERT INTO angajati VALUES (s_ida.NEXTVAL,'Zdrenghea','Andrei',2000-05-18,1,10,null);
INSERT INTO angajati VALUES (s_ida.NEXTVAL,'Leahu','Antonia',1999-01-09,2,40,null);
INSERT INTO angajati VALUES (s_ida.NEXTVAL,'Beica','Mihaela',2001-06-16,2,60,null);
INSERT INTO angajati VALUES (s_ida.NEXTVAL,'Burta','Cosmin',1998-07-23,3,50,null);
INSERT INTO angajati VALUES (s_ida.NEXTVAL,'Popa','Iasmina',1998-03-29,3,10,null);
INSERT INTO angajati VALUES (s_ida.NEXTVAL,'Dulean','Victor',2000-11-23,4,20,null);
INSERT INTO angajati VALUES (s_ida.NEXTVAL,'Georgescu','Bogdana',2001-12-30,4,30,null);
INSERT INTO angajati VALUES (s_ida.NEXTVAL,'Dumitrescu','Patric',2000-07-01,5,40,null);
INSERT INTO angajati VALUES (s_ida.NEXTVAL,'Sufana','Amelia',1999-05-02,5,50,null);

CREATE OR REPLACE VIEW vedere (id, nume, prenume, datan, id_dep, id_ap, id_task) 
AS SELECT id, nume, prenume, datan, id_dep, id_ap, id_task
FROM voluntari NATURAL JOIN angajati GROUP BY id;

