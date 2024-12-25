CREATE TABLE users (
                       user_id SERIAL PRIMARY KEY,
                       username varchar(45) NOT NULL,
                       password varchar(64) NOT NULL,
                       role varchar(45) NOT NULL,
                       enabled BOOLEAN DEFAULT NULL
);

INSERT INTO users (username,password,role,enabled)
VALUES ('user', '$2a$10$MmPG2Wl4fIVN8wdXq/qmIeON4c8yFnlQplwtz/gAqdR6w4Q2fS3CK', 'ROLE_USER', true);