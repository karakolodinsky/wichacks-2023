DROP DATABASE IF EXISTS dressUp;

CREATE DATABASE dressUp;
USE dressUp;

-- CHARACTER & CLOTHING TABLES
DROP TABLE IF EXISTS userCharacter;
CREATE TABLE userCharacter(
    characterID INT(7) NOT NULL AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    catchphrase VARCHAR(45) NULL,
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
    clothingID INT(5) NOT NULL,
    categoryID INT(2) NOT NULL,
    name VARCHAR(45) NOT NULL,
    link VARCHAR(100) NOT NULL,
    PRIMARY KEY (clothingID, categoryID),
    CONSTRAINT category_clothingItem_fk FOREIGN KEY (categoryID) REFERENCES categories (categoryID)
);

DROP TABLE IF EXISTS keywords;
CREATE TABLE keywords(
    keywordID INT(2) NOT NULL,
    keyword VARCHAR(30) NOT NULL,
    PRIMARY KEY (keywordID)
);

DROP TABLE IF EXISTS clothingKeywords;
CREATE TABLE clothingKeywords(
    clothingID INT(5) NOT NULL,
    keywordID INT(2) NOT NULL,
    PRIMARY KEY (clothingID, keywordID),
    CONSTRAINT clothingItem_clothingKeywords_fk FOREIGN KEY (clothingID) REFERENCES clothingItem (clothingID),
    CONSTRAINT keywords_clothingKeywords_fk FOREIGN KEY (keywordID) REFERENCES keywords (keywordID)
);

DROP TABLE IF EXISTS characterClothing;
CREATE TABLE characterClothing(
    characterID INT(7) NOT NULL,
    clothingID INT(5) NOT NULL,
    PRIMARY KEY (characterID, clothingID),
    CONSTRAINT character_characterClothing_fk FOREIGN KEY (characterID) REFERENCES userCharacter (characterID),
    CONSTRAINT clothingItems_characterClothing_fk FOREIGN KEY (clothingID) REFERENCES clothingItem (clothingID)
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
    CONSTRAINT character_userCharacters_fk FOREIGN KEY (characterID) REFERENCES userCharacter (characterID)
);