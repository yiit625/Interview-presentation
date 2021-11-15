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
                         created_at date,
                         is_active boolean,
);
