drop database if exists liaoxuefeng;
CREATE DATABASE IF NOT EXISTS liaoxuefeng;

USE liaoxuefeng;

DROP TABLE IF EXISTS tb_class;

DROP TABLE IF EXISTS tb_student;

CREATE TABLE
    tb_class
(
    id   BIGINT       NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE
    tb_student
(
    id       BIGINT       NOT NULL AUTO_INCREMENT,
    class_id BIGINT       NOT NULL,
    name     VARCHAR(100) NOT NULL,
    gender   VARCHAR(1)   NOT NULL,
    score    INT          NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO tb_class (id, name)
VALUES (1, '一班');

INSERT INTO tb_class (id, name)
VALUES (2, '二班');

INSERT INTO tb_class (id, name)
VALUES (3, '三班');

INSERT INTO tb_class (id, name)
VALUES (4, '四班');

INSERT INTO tb_student (id, class_id, name, gender, score)
VALUES (1, 1, '小明', 'M', 90);

INSERT INTO tb_student (id, class_id, name, gender, score)
VALUES (2, 1, '小红', 'F', 95);

INSERT INTO tb_student (id, class_id, name, gender, score)
VALUES (3, 1, '小军', 'M', 88);

INSERT INTO tb_student (id, class_id, name, gender, score)
VALUES (4, 1, '小米', 'F', 73);

INSERT INTO tb_student (id, class_id, name, gender, score)
VALUES (5, 2, '小白', 'F', 81);

INSERT INTO tb_student (id, class_id, name, gender, score)
VALUES (6, 2, '小兵', 'M', 55);

INSERT INTO tb_student (id, class_id, name, gender, score)
VALUES (7, 2, '小林', 'M', 85);

INSERT INTO tb_student (id, class_id, name, gender, score)
VALUES (8, 3, '小新', 'F', 91);

INSERT INTO tb_student (id, class_id, name, gender, score)
VALUES (9, 3, '小王', 'M', 89);

INSERT INTO tb_student (id, class_id, name, gender, score)
VALUES (10, 3, '小丽', 'F', 85);

SELECT 'ok' as 'result:';

select *
from tb_class;
select *
from tb_student;

select *
from tb_student s
where s.score > 80
  and s.gender = 'M'
  and s.class_id not in (2);

select *
from tb_student s
where s.score between 80 and 90
  and s.gender = 'M';

-- 投影查询
select s.name, s.score
from tb_student s
where s.score > 70
  and s.score < 90
  and s.gender = 'F';

select s.name '姓名', s.score '分数'
from tb_student s
where s.score > 70
  and s.score < 90
  and s.gender = 'F'
order by s.score desc;

select *
from tb_student s
order by s.score desc, s.id desc
limit 3 offset 0;;

select *
from tb_student s
order by s.score desc, s.id desc
limit 0,3;

select count(*)
from tb_student s;

-- 查询男生女生有多少80分以上的学生
select s.gender        as '性别',
       count(s.gender) as '人数',
       avg(s.score)    as '平均成绩',
       max(s.score)    as '最高分',
       min(s.score)    as '最低分',
       sum(s.score)    as '总成绩'
from tb_student s
where s.score > 80
group by s.gender;

-- 统计每个班的人数
select s.class_id as '班级id', c.name, count(s.class_id) as '学生人数'
from tb_student s
         left join tb_class c on s.class_id = c.id
group by s.class_id;

-- 统计每个班男生女生的人数
select c.name, s.gender as '性别', count(s.gender) as '人数'
from tb_student s
         left join tb_class c on s.class_id = c.id
group by s.class_id, s.gender;

-- 查询每个班的平均分
select c.name, s.gender, round(avg(s.score), 2) as '平均分'
from tb_student s
         left join tb_class c on s.class_id = c.id
group by s.class_id, s.gender;

-- 笛卡尔积, cross join, 没什么意义
select *
from tb_student,
     tb_class;

drop table if exists tb_digit;
drop table if exists tb_alhpa;
create table if not exists tb_digit
(
    digit bigint
);
insert into tb_digit
values (1),
       (2),
       (3);
create table if not exists tb_alpha
(
    alpha varchar(50)
);
insert into tb_alpha
values ('a'),
       ('b'),
       ('c');
select *
from tb_digit;
select *
from tb_alpha;
select *
from tb_digit d,
     tb_alpha a
order by d.digit;

-- 关联表
drop table if exists tb_digit_alpha;
create table if not exists tb_digit_alpha
(
    digit_id bigint      not null,
    alpha_id varchar(50) not null
);
insert into tb_digit_alpha
values (1, 'a'),
       (2, 'b'),
       (3, 'c');
select *
from tb_digit_alpha;

select *
from tb_digit_alpha da
         left join tb_digit d on da.digit_id = d.digit
         left join tb_alpha a on da.alpha_id = a.alpha;

select s.name, c.name
from tb_student s
         inner join tb_class c on s.class_id = c.id;
select *
from tb_student s
         left join tb_class c on s.class_id = c.id;
select *
from tb_student s
         right join tb_class c on s.class_id = c.id;
-- 模拟的full outer join
select *
from tb_student s
         left join tb_class c on s.class_id = c.id
union
select *
from tb_student s
         right join tb_class c on s.class_id = c.id;

-- CRUD
insert into tb_student
values (null, 4, '李四', 'M', 79),
       (null, 3, '李贵', 'F', 88),
       (null, 2, '赵云', 'M', 75);

select *
from tb_student s
order by s.score desc;

update tb_student s
set s.score = 88
where s.score > 80
  and s.score < 90;

update tb_student s
set s.score = s.score - rand() * 10
where s.score between 80 and 90;

delete
from tb_student s
where s.name = '李贵';

delete
from tb_student
where id > 1;

-- 7 MYSQL
show databases;
drop database if exists test_db;
create database if not exists test_db;
use test_db;
show tables;
drop table if exists tb_test1;
drop table if exists tb_test2;

create table if not exists tb_test1
(
    id       bigint,
    clazz_id bigint,
    name     varchar(50),
    gender   varchar(50),
    score    double
);
create table if not exists tb_test2
(
    id   bigint,
    name varchar(50)
);

show tables;
describe tb_test1;
describe tb_test2;

show create table tb_test1;
show create table tb_test2;

alter table tb_test1
    add column birthday date;
alter table tb_test1
    change column birthday birth varchar(50);
alter table tb_test1
    modify column birth date;
alter table tb_test1
    drop column birth;

-- 实用SQL语句