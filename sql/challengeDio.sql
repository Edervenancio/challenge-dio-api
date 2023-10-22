-- Drop the database if it exists
DROP DATABASE IF EXISTS challengeApiDio;

-- Create the database if it does not exist
CREATE DATABASE IF NOT EXISTS challengeApiDio;
-- Use the created database
USE challengeApiDio;

-- Create the tbBook table
CREATE TABLE tb_Book (
    id_book INT NOT NULL AUTO_INCREMENT,
    book_name VARCHAR(255),
    book_category VARCHAR(255),
    book_description VARCHAR(255),
    book_pages INT,
    PRIMARY KEY (id_book)
);

-- Create the tbAuthor table
CREATE TABLE tb_Author (
    id_author INT NOT NULL AUTO_INCREMENT,
    author_name VARCHAR(255),
    author_age INT,
    PRIMARY KEY (id_author)
);

