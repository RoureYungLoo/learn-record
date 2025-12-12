show create table leave_requests;

DROP TABLE if exists leave_requests;
CREATE TABLE if not exists leave_requests
(
    id          bigint DEFAULT NULL,
    employee_id bigint      NOT NULL,
    start_date  date        NOT NULL,
    end_date    date        NOT NULL,
    leave_type  varchar(50) NOT NULL
);

alter table leave_requests
    modify column `id` bigint primary key auto_increment;