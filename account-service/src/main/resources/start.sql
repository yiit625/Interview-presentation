CREATE KEYSPACE springcloud
    WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};

use springcloud;

CREATE TABLE emp(
                    emp_id int PRIMARY KEY,
                    emp_name text,
                    emp_city text,
                    emp_sal varint,
                    emp_phone varint
);

select * from emp;

CREATE TABLE accounts(
                         id varchar PRIMARY KEY,
                         uname text,
                         sname text,
                         email text,
                         pwd text,
                         created_at timestamp,
                         is_active boolean,
                         updated_at timestamp,
);


use ticket;

CREATE TABLE ticket (
                        id VARCHAR(250) PRIMARY KEY,
                        description VARCHAR(600),
                        notes VARCHAR(1000),
                        assignee VARCHAR(50),
                        ticket_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                        priority_type INT(6),
                        ticket_status INT(6)
)

