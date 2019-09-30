CREATE TABLE artist (
    id INT NOT NULL AUTO_INCREMENT,
    name varchar(600),
    gender varchar(1),
    birthday DATE,
    update_time TIMESTAMP,
    PRIMARY KEY (id)
);