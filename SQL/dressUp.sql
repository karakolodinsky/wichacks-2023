DROP DATABASE IF EXISTS dressUp;

CREATE DATABASE dressUp;
USE dressUp;

-- CHARACTER & CLOTHING TABLES
DROP TABLE IF EXISTS charcter;
CREATE TABLE character(
    characterID INT(7) NOT NULL AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    catchphrase VARCHAR(45) NULL,
    -- clothes

    PRIMARY KEY (characterID)
);

DROP TABLE IF EXISTS categories;
CREATE TABLE categories(
    categoryID INT(2) NOT NULL,
    categoryName VARCHAR(15) NOT NULL,
    PRIMARY KEY (categoryID)
);

DROP TABLE IF EXISTS clothingItem;
CREATE TABLE clothingItem(
    clothingID NOT NULL
);



-- USER TABLES
DROP TABLE IF EXISTS userInfo;
CREATE TABLE userInfo(
    userID INT(5) NOT NULL AUTO_INCREMENT,
    username VARCHAR(30) NOT NULL,
    password VARCHAR(30) NOT NULL,
    country VARCHAR(45) NULL,
    PRIMARY KEY (userID)
);

DROP TABLE IF EXISTS userCharacters;
CREATE TABLE userCharacters(
    userID INT(5) NOT NULL,
    characterID INT(5),
    PRIMARY KEY (userID, characterID),
    CONSTRAINT userInfo_userCharacters_fk FOREIGN KEY (userID) REFERENCES userInfo (userID),
    CONSTRAINT character_userCharacters_fk FOREIGN KEY (characterID) REFERENCES character (characterID)
);