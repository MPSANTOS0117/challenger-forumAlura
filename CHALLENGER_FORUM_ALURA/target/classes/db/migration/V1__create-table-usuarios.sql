CREATE table usuarios (
    id BIGINT NOT NULL AUTO_INCREMENT,
    email VARCHAR(25) NOT NULL,
    senha VARCHAR(100) NOt NULL,

    PRIMARY KEY(id)
);