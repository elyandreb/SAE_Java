DROP TABLE IF EXISTS 'PARTICIPEA';
DROP TABLE IF EXISTS 'PARTICIPEEQ';
DROP TABLE IF EXISTS 'EQUIPE';
DROP TABLE IF EXISTS 'ATHLETE';
DROP TABLE IF EXISTS 'SPORT';
DROP TABLE IF EXISTS 'EPREUVE';
DROP TABLE IF EXISTS 'PAYS';

CREATE TABLE 'PAYS' (
    'nomP' varchar(50) NOT NULL,
    'medailleOR' int DEFAULT 0,
    'medailleARGENT' int DEFAULT 0,
    'medailleBRONZE' int DEFAULT 0,
    PRIMARY KEY('nomP')
);

CREATE TABLE 'EQUIPE' (
    'nomEq' varchar(50) NOT NULL,
    'sexeE' varchar(1) NOT NULL,
    'nomP' varchar(50) NOT NULL,
    PRIMARY KEY('nomEq'),
    FOREIGN KEY ('nomP') REFERENCES PAYS('nomP')
);

CREATE TABLE 'ATHLETE' (
    'idA' int NOT NULL,
    'nomA' varchar(50) NOT NULL,
    'prenomA' varchar(50) NOT NULL,
    'sexeA' varchar(1) NOT NULL,
    'force' int NOT NULL,
    'agilite' int NOT NULL,
    'endurance' int NOT NULL,
    'nomEq' varchar(50) NOT NULL,
    'nomP' varchar(50) NOT NULL,
    PRIMARY KEY('idA'),
    FOREIGN KEY ('nomEq') REFERENCES EQUIPE('nomEq'),
    FOREIGN KEY ('nomP') REFERENCES PAYS('nomP')
);

CREATE TABLE 'SPORT' (
    'idS' int NOT NULL,
    'nomS' varchar(50) NOT NULL,
    'categorie' varchar(10) NOT NULL,
    'nombreJoueurs' int DEFAULT 1,
    PRIMARY KEY('idS')
);

CREATE TABLE 'EPREUVE' (
    'nomEp' varchar(50) NOT NULL,
    'genre' varchar(1) NOT NULL,
    'idS' int NOT NULL,
    PRIMARY KEY('nomEp', 'genre'),
    FOREIGN KEY 'idS' REFERENCES SPORT('idS')
);

CREATE TABLE 'PARTICIPEA' (
    'idA' int NOT NULL,
    'nomEp' varchar(50) NOT NULL,
    'genre' varchar(1) NOT NULL,
    PRIMARY KEY('idA','nomEp','genre'),
    FOREIGN KEY 'idA' REFERENCES ATHLETE('idA'),
    FOREIGN KEY 'nomEp' REFERENCES EPREUVE('nomEp'),
    FOREIGN KEY 'genre' REFERENCES EPREUVE('genre')
);

CREATE TABLE 'PARTICIPEEQ' (
    'idEq' int NOT NULL,
    'nomEp' varchar(50) NOT NULL,
    'genre' varchar(1) NOT NULL,
    PRIMARY KEY('idEq','nomEp','genre'),
    FOREIGN KEY 'idEq' REFERENCES EQUIPE('idEq'),
    FOREIGN KEY 'nomEp' REFERENCES EPREUVE('nomEp'),
    FOREIGN KEY 'genre' REFERENCES EPREUVE('genre')
);

CREATE TABLE 'SCORE' (
    'idA' int NOT NULL,
    'nomEp' int NOT NULL,
    'genre' varchar(1) NOT NULL,
    'resultats' int,
    FOREIGN KEY 'idA' REFERENCES ATHLETE('idA'),
    FOREIGN KEY 'nomEp' REFERENCES EPREUVE('nomEp'),
    FOREIGN KEY 'genre' REFERENCES EPREUVE('genre')
)