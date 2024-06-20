-- Supprimer les tables si elles existent déjà
DROP TABLE IF EXISTS SCOREEQ;
DROP TABLE IF EXISTS SCOREA;
DROP TABLE IF EXISTS EPREUVE;
DROP TABLE IF EXISTS SPORT;
DROP TABLE IF EXISTS ATHLETE;
DROP TABLE IF EXISTS EQUIPE;
DROP TABLE IF EXISTS PAYS;

-- Créer les tables avec corrections
CREATE TABLE PAYS (
    nomP varchar(50) NOT NULL,
    medailleOR int DEFAULT 0,
    medailleARGENT int DEFAULT 0,
    medailleBRONZE int DEFAULT 0,
    PRIMARY KEY(nomP)
);

CREATE TABLE EQUIPE (
    idEq int NOT NULL AUTO_INCREMENT,
    nomEq varchar(50) NOT NULL,
    sexeE varchar(1) NOT NULL,
    nomP varchar(50) NOT NULL,
    PRIMARY KEY(idEq),
    FOREIGN KEY (nomP) REFERENCES PAYS(nomP)
);

CREATE TABLE ATHLETE (
    idA int NOT NULL AUTO_INCREMENT,
    nomA varchar(50) NOT NULL,
    prenomA varchar(50) NOT NULL,
    sexeA varchar(1) NOT NULL,
    forceA int NOT NULL,  -- Renommé de 'force' à 'forceA'
    agilite int NOT NULL,
    endurance int NOT NULL,
    nomP varchar(50) NOT NULL,
    nomEq int,  -- Change nomEq to int to reference idEq in EQUIPE
    PRIMARY KEY(idA),
    FOREIGN KEY (nomEq) REFERENCES EQUIPE(idEq),
    FOREIGN KEY (nomP) REFERENCES PAYS(nomP)
);

CREATE TABLE SPORT (
    idS int NOT NULL AUTO_INCREMENT,
    nomS varchar(50) NOT NULL,
    categorie varchar(10) NOT NULL,
    nombreJoueurs int DEFAULT 1,
    PRIMARY KEY(idS)
);

CREATE TABLE EPREUVE (
    nomEp varchar(50) NOT NULL,
    genre varchar(1) NOT NULL,
    idS int NOT NULL,
    PRIMARY KEY(nomEp, genre),
    FOREIGN KEY (idS) REFERENCES SPORT(idS)
);

CREATE TABLE SCOREA (
    idA int NOT NULL,
    nomEp varchar(50) NOT NULL,
    genre varchar(1) NOT NULL,
    resultatsA int,
    PRIMARY KEY(idA, nomEp, genre),
    FOREIGN KEY (idA) REFERENCES ATHLETE(idA),
    FOREIGN KEY (nomEp, genre) REFERENCES EPREUVE(nomEp, genre)
);

CREATE TABLE SCOREEQ (
    idEq int NOT NULL,
    nomEp varchar(50) NOT NULL,
    genre varchar(1) NOT NULL,
    resultatsEq int,
    PRIMARY KEY(idEq, nomEp, genre),
    FOREIGN KEY (idEq) REFERENCES EQUIPE(idEq),
    FOREIGN KEY (nomEp, genre) REFERENCES EPREUVE(nomEp, genre)
);
