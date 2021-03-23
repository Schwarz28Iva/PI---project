DROP TABLE departamente cascade constraints;
DROP TABLE aptitudini cascade constraints;
DROP TABLE tasks cascade constraints;
DROP TABLE voluntari;
DROP TABLE angajati;

DROP SEQUENCE s_idv;
DROP SEQUENCE s_ida;
DROP SEQUENCE s_id_dep;
DROP SEQUENCE s_id_ap;
DROP SEQUENCE s_id_task;

CREATE TABLE departamente (
	id_dep number(11),
    nume_dep char(100) not null UNIQUE,
    CONSTRAINT id_dep_pk PRIMARY KEY(id_dep)
);

CREATE TABLE aptitudini (
	id_ap number(11),
    nume_ap char(100) not null UNIQUE,
    CONSTRAINT id_ap_pk PRIMARY KEY(id_ap)
);

CREATE TABLE tasks (
	id_t number(11),
    nume_t char(100) not null UNIQUE,
    id_ap number(11) not null,
    CONSTRAINT id_ap_fk FOREIGN KEY(id_ap) REFERENCES aptitudini(id_ap),
    CONSTRAINT id_t_pk PRIMARY KEY(id_t)
);

CREATE TABLE voluntari (
	id number(11),
    nume char(100) not null,
    prenume char(100) not null,
    datan date,
    id_dep number(11) ,
    id_ap number(11),
    id_t number(11),
    CONSTRAINT id_ap_fkv FOREIGN KEY(id_ap) REFERENCES aptitudini(id_ap),
    CONSTRAINT id_dep_fkv FOREIGN KEY(id_dep) REFERENCES departamente(id_dep),
    CONSTRAINT id_task_fkv FOREIGN KEY(id_t) REFERENCES tasks(id_t),
    CONSTRAINT id_pkv PRIMARY KEY (id)
);

CREATE TABLE angajati (
	id number(11),
    nume char(100) not null,
    prenume char(100) not null,
    datan date,
    id_dep number(11),
    id_ap number(11),
    id_t number(11),
    functie char(11), 
    salariu number(11),
    CONSTRAINT id_ap_fka FOREIGN KEY(id_ap) REFERENCES aptitudini(id_ap),
    CONSTRAINT id_dep_fka FOREIGN KEY(id_dep) REFERENCES departamente(id_dep),
    CONSTRAINT id_task_fka FOREIGN KEY(id_t) REFERENCES tasks(id_t),
    CONSTRAINT sal_checka CHECK(salariu BETWEEN 800 AND 10000),
    CONSTRAINT id_pka PRIMARY KEY(id)
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

INSERT INTO voluntari VALUES (s_idv.NEXTVAL,'Indrei','Valentina',TO_DATE('1999/11/28','YYYY/MM/DD'),2,30,null);
INSERT INTO voluntari VALUES (s_idv.NEXTVAL,'Draghicescu','Andrei',TO_DATE('2001-04-21','YYYY/MM/DD'),3,10,null);
INSERT INTO voluntari VALUES (s_idv.NEXTVAL,'Agavriloaie','Nicola',TO_DATE('1999-01-05','YYYY/MM/DD'),5,40,null);
INSERT INTO voluntari VALUES (s_idv.NEXTVAL,'Popescu','Rebeca',TO_DATE('2000-06-18','YYYY/MM/DD'),1,60,null);
INSERT INTO voluntari VALUES (s_idv.NEXTVAL,'Mircea','Ionela',TO_DATE('2000-07-07','YYYY/MM/DD'),4,50,null);
INSERT INTO voluntari VALUES (s_idv.NEXTVAL,'Ionescu','Mihai',TO_DATE('1998-03-23','YYYY/MM/DD'),2,10,null);
INSERT INTO voluntari VALUES (s_idv.NEXTVAL,'Vilan','Maria',TO_DATE('2001-10-01','YYYY/MM/DD'),3,20,null);
INSERT INTO voluntari VALUES (s_idv.NEXTVAL,'Tufis','Daria',TO_DATE('2001-12-17','YYYY/MM/DD'),5,30,null);
INSERT INTO voluntari VALUES (s_idv.NEXTVAL,'Dobre','Vlad',TO_DATE('2000-07-22','YYYY/MM/DD'),1,40,null);
INSERT INTO voluntari VALUES (s_idv.NEXTVAL,'Dobrean','Marius',TO_DATE('1998-04-10','YYYY/MM/DD'),4,50,null);

INSERT INTO angajati VALUES (s_ida.NEXTVAL,'Pop','Loredana',TO_DATE('1999-11-20','YYYY/MM/DD'),1,30,null,'stagiat',1000);
INSERT INTO angajati VALUES (s_ida.NEXTVAL,'Zdrenghea','Andrei',TO_DATE('2000-05-18','YYYY/MM/DD'),1,10,null,'coordonator',8000);
INSERT INTO angajati VALUES (s_ida.NEXTVAL,'Leahu','Antonia',TO_DATE('1999-01-09','YYYY/MM/DD'),2,40,null,'junior',2000);
INSERT INTO angajati VALUES (s_ida.NEXTVAL,'Beica','Mihaela',TO_DATE('2001-06-16','YYYY/MM/DD'),2,60,null,'senior',5500);
INSERT INTO angajati VALUES (s_ida.NEXTVAL,'Burta','Cosmin',TO_DATE('1998-07-23','YYYY/MM/DD'),3,50,null,'coordonator',8500);
INSERT INTO angajati VALUES (s_ida.NEXTVAL,'Popa','Iasmina',TO_DATE('1998-03-29','YYYY/MM/DD'),3,10,null,'stagiat',1000);
INSERT INTO angajati VALUES (s_ida.NEXTVAL,'Dulean','Victor',TO_DATE('2000-11-23','YYYY/MM/DD'),4,20,null,'junior',2000);
INSERT INTO angajati VALUES (s_ida.NEXTVAL,'Georgescu','Bogdana',TO_DATE('2001-12-30','YYYY/MM/DD'),4,30,null,'senior',5000);
INSERT INTO angajati VALUES (s_ida.NEXTVAL,'Dumitrescu','Patric',TO_DATE('2000-07-01','YYYY/MM/DD'),5,40,null,'senior',5000);
INSERT INTO angajati VALUES (s_ida.NEXTVAL,'Sufana','Amelia',TO_DATE('1999-05-02','YYYY/MM/DD'),5,50,null,'stagiat',1500);

CREATE OR REPLACE VIEW vedere (id, nume, prenume, datan, id_dep, id_ap, id_task) 
AS SELECT id, nume, prenume, datan, id_dep, id_ap, id_t
FROM voluntari NATURAL JOIN angajati;