DROP TABLE if exists users;
CREATE TABLE users
(
    idx         BIGINT AUTO_INCREMENT PRIMARY KEY,
    username    VARCHAR(50)  not null,
    password    VARCHAR(100) not null,
    email       VARCHAR(255) NOT NULL,
    login_pin   VARCHAR(100),
    login_type  VARCHAR(10)   not null,
    created_at   DATETIME default CURRENT_TIMESTAMP,
    modified_at DATETIME default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP
);

DROP TABLE if exists event_log;
CREATE TABLE event_log
(
    idx         BIGINT AUTO_INCREMENT PRIMARY KEY,
    message     VARCHAR(3000)  not null,
    topic       VARCHAR(100) not null,
    created_at   DATETIME default CURRENT_TIMESTAMP
);
