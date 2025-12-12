/*
https://sqltutorial.cn/wp-content/uploads/2016/04/SQL-cheat-sheet.pdf
*/
show tables;

/* 单表查询 */
select e.first_name, e.last_name
from employees e;

select *
from employees e;

select *
from employees e
where e.salary >= 10000;

select col
from t;

select distinct col
from t;

select distinct col
from t
order by col desc;

select *
from employees e
limit 5 offset 0;

select e.department_id, round(avg(e.salary), 2)
from employees e
group by e.department_id;

select e.department_id, round(avg(e.salary), 2)
from employees e
group by e.department_id
having round(avg(e.salary), 2) between 10000 and 15000;

/* 多表查询 */

select concat(e.first_name, ' ', e.last_name) as emp_name,
       d.department_name                      as dept_name
from employees e,
     departments d
where e.department_id = d.department_id;

select concat(e.first_name, ' ', e.last_name) as emp_name,
       d.department_name                      as dept_name
from employees e
         /*inner*/
         join departments d on e.department_id = d.department_id;

select concat(e.first_name, ' ', e.last_name) as emp_name,
       d.department_name                      as dept_name
from employees e
         left /*outer*/
         join departments d on e.department_id = d.department_id;

select concat(e.first_name, ' ', e.last_name) as emp_name,
       d.department_name                      as dept_name
from employees e
         right /*outer*/
         join departments d on e.department_id = d.department_id;

/* mysql 不支持 full outer join */
select concat(e.first_name, ' ', e.last_name) as emp_name,
       d.department_name                      as dept_name
from employees e full outer
         join departments d
on e.department_id = d.department_id;

select concat(e.first_name, ' ', e.last_name) as emp_name,
       d.department_name                      as dept_name
from employees e
         left /*outer*/
         join departments d on e.department_id = d.department_id
union
select concat(e.first_name, ' ', e.last_name) as emp_name,
       d.department_name                      as dept_name
from employees e
         right /*outer*/
         join departments d on e.department_id = d.department_id;

select *
from t;
select *
from nums;

select *
from nums,
     t;

select *
from nums
         cross join t;

/* 自连接查询 */
# select e2.employee_id, e1.employee_id
select concat(e1.first_name, ' ', e1.last_name) as emp_name,
       concat(e2.first_name, ' ', e2.last_name) as manager_name
from employees e1
         inner join employees e2 on e1.manager_id = e2.employee_id
order by manager_name;

/* SQL 操作符 */
select *
from t
union
select *
from nums;

select *
from nums intersect
select *
from nums
where col % 2 <> 0;

select *
from nums MINUS -- mysql 不支持 minus 操作符
select *
from nums
where col % 2 <> 0;

select *
from employees e
where e.first_name like concat('%', 'na');

select *
from employees e
where e.first_name not like concat('%', 'hn', '%');

select *
from employees e
where e.department_id not in (3, 6, 9);

select *
from employees e
where e.salary not between 10000 and 15000;

select *
from employees e
where e.department_id is null;

select *
from employees e
where e.phone_number is null;

/* manage table */
select *
from goods;
drop table if exists goods;
create table if not exists goods
(
    id    bigint         not null,
    name  varchar(255)   not null,
    price decimal(10, 2) not null
);

alter table goods
    add column create_time datetime not null default current_timestamp;

alter table goods
    drop column create_time;

alter table goods
    add constraint pk_goods_id primary key goods (id);

alter table goods
    drop primary key;

alter table goods
    rename to goods_new;

alter table goods_new
    rename column name to goods_name;

truncate table goods_new;

/* manage constraint */
select *
from student;

select *
from class;

drop table if exists student;
drop table if exists class;


/* 主表 */
create table if not exists class
(
    class_id   bigint /* primary key */,
    class_name varchar(255)
    -- , primary key (class_id)
);

/* 子表 */
create table if not exists student
(
    student_id       bigint /* primary key */,
    student_name     varchar(255),
    student_birthday date,
    class_id         bigint
    -- ,primary key (student_id)
    -- ,foreign key (class_id) references class (class_id)
);

insert into class
values (1001, '5(1)班'),
       (1002, '5(2)班'),
       (1003, '5(3)班');

insert into student
values (2001, '张三', '1998-02-16', 1001),
       (2002, '李四', '1998-08-16', 1002),
       (2003, '王五', '1999-05-16', 1003),
       (2004, '赵六', '1997-07-22', null);

alter table class
    add constraint primary key (class_id);

alter table student
    add constraint primary key (student_id);
alter table student
    add constraint foreign key (class_id) references class (class_id);

alter table student
    add constraint unique (student_name, class_id);

alter table class
    add constraint unique (class_name);

alter table student
    add constraint stu_chk_1 check ( student_birthday between '1997-01-01' and '2025-01-01');

insert into student
values (2005, '田七', '1999-02-16', 1001);

/* CRUD
Create
READ
UPDATE
DELETE
*/

insert into class(class_id, class_name)
values (4001, '四(1)班'),
       (4002, '四(2)班'),
       (4003, '四(3)班');

select *
from student;

update student s
set s.student_birthday = '1999-09-09'
where s.student_id = 2003;

delete
from student
where student_id % 2 = 1;

/* manage view */
create view view_student(stuName, birth, className)
as
select s.student_name     as stuName,
       s.student_birthday as birth,
       c.class_name       as className
from student s
         inner join class c on s.class_id = c.class_id;

drop view if exists view_student;

/* manage index */
create index idx_stu_name on
    student (student_name, student_birthday);

create unique index uni_idx_stu on student (student_name, student_birthday);

drop index idx_stu_name on student;
drop index uni_idx_stu on student;

/* aggregation function */
select e.department_id,
       avg(e.salary),
       min(e.salary),
       max(e.salary),
       sum(e.salary)
from employees e
group by e.department_id;

select e.department_id,
       count(e.employee_id)
from employees e
group by e.department_id;

/* manage trigger */