CREATE TABLE user_mng
(
    idx         BIGINT AUTO_INCREMENT PRIMARY KEY,
    username    VARCHAR(50)  not null,
    password    VARCHAR(100) not null,
    login_pin   VARCHAR(100),
    login_type  VARCHAR(2)   not null,
    created_at   DATETIME default CURRENT_TIMESTAMP,
    modified_at DATETIME default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP
);