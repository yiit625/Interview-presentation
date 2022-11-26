CREATE SCHEMA IF NOT EXISTS ticket;
CREATE USER 'test_user'@'%' IDENTIFIED WITH mysql_native_password BY 'microservice-app';
GRANT ALL ON ticket.* TO 'test_user'@'%';

/* Make sure the privileges are installed */
FLUSH PRIVILEGES;

USE ticket;

CREATE TABLE ticket (
                        id VARCHAR(250) PRIMARY KEY,
                        description VARCHAR(600),
                        notes VARCHAR(1000),
                        assignee VARCHAR(50),
                        ticket_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                        priority_type INT(6),
                        ticket_status INT(6)
);