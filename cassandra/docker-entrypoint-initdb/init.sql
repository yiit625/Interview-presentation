CREATE KEYSPACE springcloud
    WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};

use springcloud;

CREATE TABLE accounts(
                         id uuid PRIMARY KEY,
                         uname text,
                         sname text,
                         email text,
                         pwd text,
                         created_at timestamp,
                         is_active boolean,
                         updated_at timestamp,
                         roles text,
);