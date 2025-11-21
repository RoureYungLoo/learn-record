-- https://www.runoob.com/sql/sql-quickref.html
-- 选择数据库
use sql_tutorial;

-- 删除表
drop table if exists websites;
-- 创建表
create table websites
(
    id      bigint        not null,
    name    varchar(512)  not null,
    url     varchar(1024) not null,
    alexa   int           not null default 0,
    country varchar(255)
);
-- 查询所有
select *
from websites;

-- 插入数据
insert into websites
values (1000100101, 'baidu', 'https://www.baidu.com', 1, '中国'),
       (1000100102, 'bing', 'https://www.bing.com', 12, '美国'),
       (1000100103, 'google', 'https://www.google.com', 6, '美国'),
       (1000100104, 'bilibili', 'https://www.bilibili.com', 13, '中国'),
       (1000100105, 'souhu', 'https://www.souhu.com', 17, '中国'),
       (1000100106, 'sina', 'https://www.sina.com', 11, '中国'),
       (1000100107, 'toutiao', 'https://www.toutiao.com', 14, '中国'),
       (1000100108, 'tencent', 'https://www.tencent.com', 15, '中国'),
       (1000100109, 'facebook', 'https://www.facebooktencent.com', 15, '美国'),
       (10001001010, 'x', 'https://www.x.com', 9, '美国'),
       (10001001011, 'apple', 'https://www.apple.com', 8, '美国'),
       (10001001012, 'dajiang', 'https://www.dajiang.com', 7, '中国');

-- 删除表
drop table if exists access_log;
-- 创建表
create table access_log
(
    aid     bigint not null,
    site_id bigint not null,
    count   bigint not null,
    date    date,
    primary key (aid)
);

-- 插入数据
insert into access_log
values (200231231001, 1000100101, 123, '2024-01-09'),
       (200231231002, 1000100101, 234, '2024-02-09'),
       (200231231003, 1000100101, 345, '2024-03-09'),
       (200231231004, 1000100102, 456, '2024-04-09'),
       (200231231005, 1000100102, 567, '2024-05-09'),
       (200231231006, 1000100102, 678, '2024-06-09'),
       (200231231007, 1000100103, 789, '2024-07-09'),
       (200231231008, 1000100104, 789, '2024-07-09'),
       (200231231009, 1000100105, 789, '2024-07-09'),
       (200231231010, 1000100106, 789, '2024-07-09');
-- 查询所有
select *
from access_log al;
-- 删除表
drop table if exists apps;
-- 创建表
create table apps
(
    id       bigint not null,
    app_name varchar(36),
    url      varchar(255),
    country  varchar(255)
);
-- 开启事务
begin;
insert into apps
values (203941001, '腾讯微视', 'http://pp.myapp.com/ma_icon/0/icon_10261931_1758596675/256', 'CN'),
       (203941002, 'QQ阅读', 'http://pp.myapp.com/ma_icon/0/icon_10555_1762393201/256', 'CN'),
       (203941003, '中国建设银行', 'http://pp.myapp.com/ma_icon/0/icon_10647_1762480822/256', 'CN'),
       (203941004, '快手极速版', 'http://pp.myapp.com/ma_icon/0/icon_52750274_1762439413/256', 'CN'),
       (203941005, '网易新闻', 'http://pp.myapp.com/ma_icon/0/icon_7267_1762335077/256', 'CN'),
       (203941006, '携程旅行', 'http://pp.myapp.com/ma_icon/0/icon_6240_1762487306/256', 'CN'),
       (203941007, '芒果TV', 'http://pp.myapp.com/ma_icon/0/icon_200479_1762564399/256', 'CN');
-- 提交事务
commit;
-- 查询所有
select *
from apps;
-- 排序
select *
from websites
order by url desc,
         country desc;
-- 查看建表语句
show create table websites;
-- 插入数据
insert into websites(id, name, url, alexa, country)
values (1000100110, 'amazon', 'https://www.amazon.com', 23, '美国');
-- 更新表
update websites w
set w.country = 'US'
where name = 'amazon';
-- 查询所有
select *
from websites w
where w.name = 'amazon';
-- 删除数据
delete
from websites w
where w.name = 'amazon';
-- 修改表结构-添加列
alter table websites
    add create_time datetime;
-- 修改表结构-删除列
alter table websites
    drop create_time;

-- drop table if exists websites;
-- 查看执行计划
explain
select *
from websites w
where name = 'baidu';
create index idx_name on websites (name);
drop index idx_name on websites;
-- 分组查询,聚合查询,分组过滤
select w.country        as '国家',
       count(w.country) as '数量',
       max(w.alexa)     as '最大排名',
       min(w.alexa)     as '最小排名',
       avg(w.alexa)     as '排名均值',
       sum(w.alexa)     as '排名求和'
from websites as w
group by country
having sum(w.alexa) > 15;
-- 查询所有
select *
from websites;
-- 查询去重
select distinct alexa
from websites;
-- 查询所有
select *
from websites;
-- 查询列
select name, url
from websites;
-- 查询去重
select distinct w.alexa
from websites w;
-- 条件查询
select *
from websites
where country = '中国';
-- 条件查询
select *
from websites
where alexa = 4;
-- IN 查询
select *
from websites
where alexa in (4, 5);
-- between and 查询
-- 闭区间
select *
from websites
where alexa between 4 and 6;
-- 不等查询
select *
from websites
where alexa != 5;
-- 模糊查询like
select *
from websites
where name like '%in%';

-- and查询
select *
from websites
where alexa > 8
  and country = '中国';
-- or查询
select *
from websites
where alexa > 8
   or country = '中国';
-- 条件混合查询 and / or / <> / >
select *
from websites
where alexa > 6
  and (country = '中国' or country = '美国');
-- 查询排序
select *
from websites
order by alexa desc, country asc;
-- 查询排序
select *
from websites
order by country, alexa desc;

select *
from websites w
order by w.id;
-- 插入数据
insert into websites (id, name, url, alexa, country) value (10001001013, 'youtube', 'https://www.youyube.com', 18, '美国');
-- 修改表字段
alter table websites
    modify column id bigint primary key auto_increment;
-- 插入数据
insert into websites
values (null, 'github', 'https://www.github.com', 19, '美国');

-- 更新表数据
update websites w
set w.country = 'USA'
where w.name = 'github';
-- 更新表结构-添加列
alter table websites
    add column deleted tinyint default 0;
-- 查询所有
select *
from websites;
-- 更新表数据
update websites w
set w.deleted = 0
where w.id > 0;

-- 删除表数据
delete
from websites w
where w.id = 10001001014;
delete
from websites w
where w.deleted = 1;

-- limit offset, count
-- 限制查询条数
select *
from websites w
limit 3 offset 0;
-- 限制查询条数 limit count offset
select *
from websites w
limit 6, 3;

-- 删除表
drop table if exists employee;
-- 创建表
CREATE TABLE employee
(
    employee_id   INT PRIMARY KEY,
    employee_name VARCHAR(100) NOT NULL,
    salary        DECIMAL(10, 2)
);

-- 插入数据
INSERT INTO employee (employee_id, employee_name, salary)
VALUES (1, 'John Smith', 50000.00),
       (2, 'Jane Doe', 60000.00),
       (3, 'Mike Johnson', 55000.00),
       (4, 'Sarah Williams', 62000.00),
       (5, 'David Brown', 58000.00);

-- 查询所有
SELECT *
FROM employee;
-- 查询所有限制条数
select *
from employee
limit 0,3;

-- 删除表
drop table if exists product;
-- 创建表
CREATE TABLE product
(
    product_id   CHAR(12) PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    category     VARCHAR(20) CHECK (Category IN ('手机', '电脑'))
);

-- 插入数据
INSERT INTO product (product_id, product_name, category)
VALUES ('P001', 'iPhone 15 Pro', '手机'),
       ('P002', 'Samsung Galaxy S24', '手机'),
       ('P003', 'MacBook Air M2', '电脑'),
       ('P004', 'Dell XPS 13', '电脑'),
       ('P005', 'Huawei MateBook X', '电脑');

-- 查询所有
SELECT *
FROM product;
-- 模糊查询
select *
from product p
where p.product_name like 'iPhone%';
-- 模糊查询
select *
from product p
where p.product_name like '_e%';
-- 模糊查询
select *
from product p
where p.product_name like '%Book%';
-- 模糊查询
select *
from websites w
where w.name like 'g%';
-- 模糊查询
select *
from websites w
where w.name like '%k';
-- 模糊查询
select *
from websites w
where w.name like '%oo%';

-- 通配符 % _ 正则表达式
select *
from websites w;
select *
from websites w
where w.url like 'https://%';
select *
from websites w
where w.url like '%oo%';
select *
from websites w
where w.url like '%_oogle%';
select *
from websites w
where w.name like '_oogle';
select *
from websites w
where w.name regexp '^[gfs]';
select *
from websites w
where w.name regexp '^[BT]';


-- IN 查询
select *
from websites w
where w.name in ('baidu', 'google');
select *
from websites w
where w.alexa in (1, 3, 5, 7, 9);
-- between and 范围查询
select *
from websites w
where w.alexa not between 7 and 9;
select *
from websites w
where w.alexa between 7 and 9;
select *
from websites w
where (w.alexa between 7 and 9)
  and w.country in ('美国');
select *
from websites w
where w.name between 'B' and 'G';
select *
from websites w
where w.name not between 'B' and 'G';
-- 限制查询条数 limit
select *
from access_log
limit 10;
select *
from access_log al
where al.`date` between '2024-04-01' and '2024-06-01';

-- 别名, 列别名,表别名
select w.name as '网站', w.alexa as '排名', w.country as '国家'
from websites as w;
select w.name as '网站', concat(w.name, w.url, w.alexa, w.country) as '网站信息'
from websites w;

select w.name, w.url, al.count as '访问量', al.`date` as '日期'
from access_log al,
     websites w
where al.site_id = w.id;

-- 顾客表
drop table if exists customer; -- 删除表
create table if not exists customer -- 创建表
(
    customer_id bigint primary key auto_increment,
    name        varchar(50) not null
);
-- 查询所有
select *
from customer;
-- 插入数据
insert into customer value (20251111001, '张三');
insert into customer
values (null, '李四'),
       (null, '王五'),
       (null, '赵六');
-- 订单表
drop table if exists tb_order; -- 删除表
create table if not exists tb_order -- 创建表
(
    order_id    bigint primary key auto_increment,
    customer_id bigint       not null,
    product     varchar(255) not null
);
-- 查询所有
select *
from tb_order;
-- 插入数据
insert into tb_order value (202511112341001, 20251111001, 'iPhone 15');
insert into tb_order
values (null, 20251111002, '华为 MATE 70'),
       (null, 20251111003, 'OPPO Find X9'),
       (null, 20251111005, 'VIVO X300');
-- 删除数据
delete
from tb_order o
where o.order_id >= 202511112341005;
-- 学生表
drop table if exists student; -- 删除表
create table if not exists student -- 创建表
(
    student_id bigint primary key auto_increment,
    name       varchar(50) not null,
    age        int         not null
);
-- 查询所有
select *
from student;
-- 插入数据
insert into student
values (1001, '张三', 23),
       (1002, '李四', 24),
       (1003, '王五', 25);
-- 选课表
drop table if exists enrollment;-- 删除表
create table if not exists enrollment -- 创建表
(
    enrollment_id bigint primary key auto_increment,
    student_id    bigint      not null,
    course        varchar(50) not null
);
-- 查询所有
select *
from enrollment;
-- 插入数据
insert into enrollment
values (2001, 1001, 'Math'),
       (2002, 1002, 'Chinese'),
       (2003, 1004, 'English');

-- 连接查询join / inner join
-- where连接, 内连接
select *
from websites w,
     access_log al
where w.id = al.site_id;
select *
from websites w
         inner join access_log al on w.id = al.site_id;
select *
from customer c
         inner join tb_order o on c.customer_id = o.customer_id;
select *
from student s
         inner join enrollment e on s.student_id = e.student_id;
-- left join 左(外)连接
select *
from websites w
         left join access_log al on w.id = al.site_id;

select *
from access_log al
         left join websites w on w.id = al.site_id;
-- 修改表结构
alter table access_log
    modify column aid bigint not null auto_increment;
-- 插入数据
insert into access_log
values (null, 1000100302, 999, now()),
       (null, 1000100300, 888, now()),
       (null, 1000100301, 777, now());

select c.name, o.product
from customer c
         left join tb_order o on c.customer_id = o.customer_id;
-- right join, 右(外)连接
drop table if exists department; -- 删除表
create table if not exists department -- 创建表
(
    department_id   bigint primary key auto_increment,
    department_name varchar(50) not null
);
insert into department -- 插入数据
values (10, '财务部'),
       (11, '营销部'),
       (12, '广告部');
insert into department value (13, '技术部');
-- 查询所有
select *
from employee;
-- 修改表结构-添加列
alter table employee
    add column department_id bigint;
-- 查询所有
select *
from department;
-- 查询所有部门的员工, 右外连接
select *
from employee e
         right join department d on e.department_id = d.department_id;
-- 查询所有员工所属的部门, 右外连接
select e.*, d.*
from department d
         right join employee e
                    on d.department_id = e.department_id;
-- 查询所有访问日志的网站信息
select *
from websites w
         right join access_log al on w.id = al.site_id;
-- 查询所有网站的访问日志
select *
from access_log al
         right join websites w on al.site_id = w.id;

-- full outer join 查询2个表的所有记录 [MySQL 不支持]
select *
from student s full outer join enrollment e
on s.student_id = e.student_id;
-- MySQL不支持全外连接, 使用 union 实现
select *
from student s
         left join enrollment e on s.student_id = e.student_id
union
select *
from student s
         right join enrollment e on s.student_id = e.student_id;
-- union 求并集并去重
select w.country
from websites w
union
-- all -- union all 求并集,不去重
select a.country
from apps a;
-- union all 求并集,不去重
select w.country, w.name
from websites w
union all
select a.country, a.app_name
from apps a;

drop table if exists digit; -- 删除表
drop table if exists alphabet; -- 删除表
create table if not exists digit -- 创建表
(
    no bigint
);
create table if not exists alphabet -- 创建表
(
    alpha varchar(32)
);
insert into digit -- 插入数据
values (1001),
       (1002),
       (1003);
insert into alphabet -- 插入数据
values ('A'),
       ('B'),
       ('C');

-- cross join, 交叉连接, 笛卡尔积, 无连接条件
select *
from websites w,
     access_log al;
select *
from websites w
         cross join access_log al;
-- 查询所有
select *
from digit;
-- 查询所有
select *
from alphabet;
-- 排序
select *
from digit d,
     alphabet a
order by d.no;
-- 交叉连接,排序
select *
from alphabet a
         cross join digit d
order by a.alpha;

-- self join, 自连接查询, 自己连接自己的查询
drop table if exists node; -- 删除表
create table if not exists node -- 创建表
(
    node_id        bigint primary key auto_increment,
    node_name      varchar(255) not null,
    parent_node_id bigint       not null
);
insert into node -- 插入数据
values (1001, '节点1', 0),
       (1002, '节点2', 1001),
       (1003, '节点3', 2);
-- 查询所有
select *
from node;
-- 查询所有, 内连接查询
select *
from node n1
         join node n2 on n1.parent_node_id = n2.node_id
where n1.node_id = 1003;

-- natural join

-- select into [MySQL不支持]
select *
into websites_bk
from websites;
-- insert into ... select [向已存在表中添加数据]
truncate websites_bk_2041; -- 重置表, 会重置ID
select *
from websites_bk_2041;
-- 查询所有数据
-- 添加数据
insert into websites_bk_2041
select *
from websites;
insert into websites_bk_2041(name, url)
select a.app_name, a.url
from apps a;


-- create table as [备份表]
create table websites_bk as
select *
from websites;
select *
from websites_bk;
-- 查询所有

-- create database 创建数据库
create database if not exists test_db;
use test_db; -- 选择数据库
drop database if exists test_db; -- 删除数据库

use sql_tutorial; -- 选择数据库
show create database sql_tutorial;
-- 查看建表语句
-- create table
drop table if exists person; -- 删除表
create table if not exists person -- 创建表
(
    id         bigint primary key auto_increment,
    first_name varchar(255) not null,
    last_name  varchar(255) not null,
    address    varchar(255) not null default '郑州',
    phone      varchar(15)  not null default '18834892845',
    email      varchar(36)  not null default 'your_email@address.com'
);
-- 插入数据
insert into person value (2025111221041001, 'san', 'zhang', 'zhengzhou', '18812342368', 'zhangsan@qq.com');
select *
from person;
-- 查询所有

-- 常见约束 constraints
-- 主键约束 primary key
-- 非空约束 not null
-- 唯一约束 unique
-- 默认值约束 default value
-- 外键约束 foreign key
-- 条件约束 check
-- 索引约束 index

-- 字典类型表
drop table if exists dict_type; -- 删除表
create table if not exists dict_type -- 创建表
(
    id   bigint primary key,
    type varchar(32) unique, -- 字典类型
    name varchar(32) unique  -- 字典类型名称
);
insert into dict_type
values (1001, 'gender', '性别'),
       (1002, 'status', '状态'),
       (1003, 'result', '结果'); -- 插入数据
select *
from dict_type;
-- 查询所有

-- 字典值表
drop table if exists dict_type_value; -- 删除表
create table if not exists dict_type_value -- 创建表
(
    id           bigint primary key not null unique,
    dict_type_id bigint,                                 -- 字典类型ID
    value        varchar(32)        not null,            -- 字典值
    foreign key (dict_type_id) REFERENCES dict_type (id) -- 外键约束
);
-- 插入数据
insert into dict_type_value
values (2025111221211001, 1001, '男'),
       (2025111221211002, 1001, '女'),
       (2025111221211003, 1002, '启用'),
       (2025111221211004, 1002, '禁用'),
       (2025111221211005, 1003, '成功'),
       (2025111221211006, 1003, '失败'),
       (2025111221211007, 1003, '取消');
-- 查询所有
select *
from dict_type_value;

-- 查询字典类型及其字典值, 连接查询
select dt.name, dtv.value
from dict_type dt
         left join dict_type_value dtv on dt.id = dtv.dict_type_id;

-- check 约束
drop table if exists product;
CREATE TABLE if not exists product
(
    id       CHAR(12) PRIMARY KEY,
    name     VARCHAR(100) NOT NULL,
    category VARCHAR(20) CHECK (Category IN ('phone', 'laptop')), -- check 约束
    price    decimal(10, 2) check ( price >= 0 )
);
-- 插入数据
insert into product
VALUES ('P001', 'iPhone 15 Pro', 'phone', 6999),
       ('P002', 'Samsung Galaxy S24', 'phone', 10999),
       ('P003', 'MacBook Air M2', 'laptop', 19999),
       ('P004', 'Dell XPS 13', 'laptop', 7999),
       ('P005', 'Huawei MateBook X', 'laptop', 0);
-- 查询所有
select *
from product;

-- defaul 默认值约束
drop table if exists customer; -- 删除表
create table if not exists customer -- 创建表
(
    id          bigint primary key auto_increment,
    name        varchar(50) not null unique,
    create_time datetime default now(),
    entry_date  date     default (current_date)
);

-- 存储过程 procedure
delimiter // -- 修改分隔符

create procedure insert_customer_data() -- 创建存储过程
begin
    declare i int default 1;
    declare name_var varchar(50);

    while i <= 50000
        do
            set name_var = concat(
                    substring('ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789', floor(rand() * 62 + 1),
                              1),
                    substring('ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789', floor(rand() * 62 + 1),
                              1),
                    substring('ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789', floor(rand() * 62 + 1),
                              1),
                    substring('ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789', floor(rand() * 62 + 1),
                              1),
                    substring('ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789', floor(rand() * 62 + 1),
                              1),
                    substring('ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789', floor(rand() * 62 + 1),
                              1),
                    substring('ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789', floor(rand() * 62 + 1),
                              1),
                    substring('ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789', floor(rand() * 62 + 1),
                              1)
                           );
            insert into customer (name) values (name_var); -- 插入数据
            set i = i + 1;
        end while;
end //

delimiter ; -- 修改分隔符
-- 调用存储过程
call insert_customer_data();
-- 插入数据
insert into customer(id, name)
values (1, 'lisi');
-- 插入数据
insert into customer(name)
values ('zhangsan'),
       ('wangwu');
-- 查询所有
select *
from customer;
-- 聚合查询
select count(*)
from customer;

-- index , 索引约束
-- 查看执行计划
explain
select *
from customer
where name like 'a1%';
-- 创建索引
create index idx_name on customer (name);
-- 删除索引
drop index idx_name on customer;

-- not null, 非空约束
-- 查看建表语句
show create table person;
-- 修改表结构 修改列
alter table person
    modify column first_name varchar(32) null;
alter table person
    modify column first_name varchar(32) not null;
-- 修改表结构 添加约束
alter table person
    add unique (email);
-- 添加 unique 约束
alter table person
    add constraint unik unique (phone, email);
-- 删除 unique 约束
alter table person
    drop constraint unik;
-- 删除约束
alter table person
    drop index email;

-- unique约束
-- 查看建表语句
show create table person;

-- 创建表的时候添加
drop table if exists person; -- 删除表
CREATE TABLE if not exists person -- 创建表
(
    `id`         bigint unique,
    `first_name` varchar(32),
    `last_name`  varchar(255),
    `address`    varchar(255) unique,
    `phone`      varchar(15) unique,
    `email`      varchar(36) unique,
    PRIMARY KEY (`id`),
    constraint unique_name unique (first_name, last_name)
);
-- 插入数据
insert into person
values (101, 'li', 'si', 'address', 'phone', 'email'),
       (102, 'li', 'si', 'address2', 'phone2', 'email2');


-- 修改表字段添加
drop table if exists person; -- 删除表
CREATE TABLE if not exists person -- 创建表
(
    `id`         bigint,
    `first_name` varchar(32),
    `last_name`  varchar(255),
    `address`    varchar(255),
    `phone`      varchar(15),
    `email`      varchar(36),
    PRIMARY KEY (`id`)
);
-- 添加 unique 约束
alter table person
    add constraint unique_name unique (first_name, last_name);
-- 删除 unique 约束
alter table person
    drop constraint unique_name;
-- 删除 unique 约束
alter table person
    drop index unique_name;
-- 查看建表语句
show create table person;

-- primary key 等价于 not null unique
drop table if exists person; -- 删除表
CREATE TABLE if not exists person -- 创建表
(
    `id`         bigint,
    `first_name` varchar(32),
    `last_name`  varchar(255),
    `address`    varchar(255),
    `phone`      varchar(15),
    `email`      varchar(36)
);
show create table person;
-- 查看建表语句
-- 修改表结构, 添加主键约束
alter table person
    add constraint pk_id primary key (id, first_name);
-- 修改表结构, 添加主键约束
alter table person
    add primary key (id);
-- 删除主键约束
alter table person
    drop primary key;
-- 删除约束
alter table person
    drop constraint pk_id;

-- foreign key
drop table if exists person; -- 删除表
create table if not exists person -- 创建表
(
    `id`         bigint primary key auto_increment,
    `first_name` varchar(32),
    `last_name`  varchar(255),
    `address`    varchar(255),
    `phone`      varchar(15),
    `email`      varchar(36)
);

-- 插入数据
insert into person
values (2025111221041001, '三', '张', '郑州', '18812342368', 'zhangsan@qq.com'),
       (2025111221041002, '四', '李', '合肥', '18812342369', 'lisi@qq.com'),
       (2025111221041003, '五', '王', '南京', '18812342370', 'wangwu@qq.com');
-- 查询所有
select *
from person;

drop table if exists tb_order; -- 删除表
create table if not exists tb_order -- 创建表
(
    id        bigint primary key auto_increment,
    order_no  varchar(64),
    person_id bigint
);
-- 插入数据
insert into tb_order
values (10001, 'order_3f40j898', 2025111221041003),
       (10002, 'order_3f40j899', 2025111221041003),
       (10003, 'order_3f40j900', 2025111221041002),
       (10004, 'order_3f40j901', 2025111221041001);
-- 查询所有
select *
from tb_order;
-- 查看建表语句
show create table tb_order;

-- 修改表结构, 添加外键
alter table tb_order
    add constraint fk_person_id foreign key (person_id) references person (id);
-- 修改表结构, 添加外键
alter table tb_order
    add foreign key (person_id) references person (id);
-- 删除外键
alter table tb_order
    drop constraint fk_person_id;
-- 删除外键
alter table tb_order
    drop foreign key fk_person_id;
-- 删除外键
alter table tb_order
    drop foreign key tb_order_ibfk_2;


-- 查询所有person的订单编号, 连接查询
select concat(p.last_name, p.first_name) as '姓名', o.order_no as '订单编号'
from person p
         left join tb_order o on p.id = o.person_id;

-- 查询所有订单所属的person, 连接查询
select o.order_no as '订单编号', concat(p.last_name, p.first_name) as '姓名'
from tb_order o
         left join person p on o.person_id = p.id;

drop table if exists driver; -- 删除表
create table if not exists driver -- 创建表
(
    id         bigint primary key auto_increment,
    name       varchar(50),
    age        int check ( age between 18 and 55 ),
    gender     int check ( gender between 0 and 5),
    license_no varchar(50)
);
-- 插入数据
insert into driver
values (1003, 'lisi', 18, 1, 'fjmsacrm0m9qw4mc'),
       (1002, 'lisi', 55, 1, 'fjmsacrm0m9qw4mc');
-- 查询所有
select *
from driver;
-- 添加 check 约束
alter table driver
    add check ( age between 18 and 55 );
-- 添加 check 约束
alter table driver
    add constraint chk_gender check ( gender between 0 and 5);
-- 删除 check 约束
alter table driver
    drop check chk_gender;
-- 删除 check 约束
alter table driver
    drop constraint chk_gender;
-- 删除 check 约束
alter table driver
    drop constraint driver_chk_1;
-- 删除 check 约束
alter table driver
    drop check driver_chk_2;

-- default, 默认值约束
drop table if exists employee; -- 删除表
create table if not exists employee -- 创建表
(
    id          bigint,
    name        varchar(50),
    date        date,
    create_time datetime
);
-- 查看建表语句
show create table employee; -- 输出如下:
CREATE TABLE `employee` -- 建表语句
(
    `id`          bigint      DEFAULT NULL,
    `name`        varchar(50) DEFAULT NULL,
    `date`        date        DEFAULT NULL,
    `create_time` datetime    DEFAULT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
-- 修改列, 添加 default 约束
alter table employee
    alter column date set default (current_date);
-- 修改列, 添加 default 约束
alter table employee
    alter column create_time set default (current_timestamp);
-- 修改列, 删除 default 约束
alter table employee
    alter column date drop default;
-- 修改列, 添加 default 约束
alter table employee
    alter column date set default null;
-- 查询所有
select *
from employee;
-- 插入数据
insert into employee(id, name)
values (1, 'lisi');
-- 聚合查询
select count(c.id)
from customer c;
-- 查看执行计划, 模糊查询
explain
select *
from customer c
where c.name like 'a1%';
-- 创建普通索引, 加速查询, 可以重复
create index idx_customer_name on customer (name);
-- 删除索引
drop index idx_customer_name on customer;
-- 查询所有
select *
from driver;
-- 创建 unique 索引
create unique index unique_idx_name on driver (license_no);
-- 删除唯一索引
drop index unique_idx_name on driver;
-- 创建组合唯一索引, 组合列的值不能重复
create unique index uni_idx_name on person (first_name, last_name);
-- 查询所有
select *
from person;
-- 插入数据
insert into person(first_name, last_name) value ('三', '张');

-- 删除数据库
drop database if exists test_db;
-- 创建数据库
create database if not exists test_db;

-- 清空表, 重置表, 重置ID
truncate table tb_order;
-- 查看建表语句
show create table tb_order;

-- alter, 修改表, 添加列
alter table tb_order
    add column addr varchar(255) default '';
-- 修改表, 删除列
alter table tb_order
    drop column addr;
-- 修改表, 添加列
alter table tb_order
    add column weight varchar(50);
-- 修改表, 删除列
alter table tb_order
    drop column weight;

-- mysql 不兼容
alter table tb_order
    alter column weight int;

-- MySQL兼容, 修改表, 修改列
alter table tb_order
    modify column weight int;
-- 删除表
drop table if exists teacher;
-- 创建表
create table if not exists teacher
(
    id         bigint,
    first_name varchar(50),
    last_name  varchar(50),
    addr       varchar(255),
    email      varchar(255)
);
-- 查看建表语句
show create table teacher;
-- 修改表, 添加列
alter table teacher
    add column birth varchar(8);
-- 修改表, 修改列
alter table teacher
    modify column birth year;
-- 修改表, 修改列
alter table teacher
    modify column birth date;
-- 修改表, 修改列
alter table teacher
    modify column birth datetime;
-- 修改表, 删除列
alter table teacher
    drop column birth;
-- 查看建表语句
show create table teacher;
-- auto_increment, 修改表, 修改列
alter table teacher
    modify column id bigint primary key auto_increment;
-- 修改表, 修改主键自增ID
alter table teacher
    auto_increment = 202511142153001;
-- 插入数据
insert into teacher
    (last_name, first_name, addr, email)
values ('张', '三', '郑州', 'zhangsan@qq.com'),
       ('李', '四', '郑州', 'zhangsan@qq.com'),
       ('王', '五', '郑州', 'zhangsan@qq.com');
-- 查询所有
select *
from teacher;
-- 查询所有, 连接查询
select *
from person p
         left join tb_order o on p.id = o.person_id;
-- VIEW 视图
-- 创建视图
create view view_person_order as
select p.id as pid,
       p.*
from person p
where p.id > 2025111221041002;
-- 查询所有
select *
from view_person_order;
-- 删除视图
drop view if exists view_person_order;

-- 连接表可以创建视图吗[可以]
-- 创建视图
create view view_person_left_join_order as
select p.id,
       p.first_name,
       p.last_name,
       p.address,
       p.phone,
       p.email,
       o.id        as oid,
       o.person_id as opid,
       o.order_no,
       o.weight
from person p
         left join tb_order o on p.id = o.person_id
where p.id >= 2025111221041002;

-- 查询所有
select *
from view_person_left_join_order;

-- 修改视图
    alter view view_person_left_join_order as
    select p.id,
           p.first_name,
           p.last_name,
           concat(p.first_name, p.last_name) as 'pname',
           p.address,
           p.phone,
           p.email,
           o.id                              as oid,
           o.person_id                       as opid,
           o.order_no,
           o.weight
    from person p
             left join tb_order o on p.id = o.person_id
    where p.id >= 2025111221041002;
-- 插入数据
insert into person
values (null, '六', '张', '北京', '188456578239', 'zhaoliu@qq.com');
-- 插入数据
insert into tb_order
values (null, 'order_3f40h899', 2025111221041005, null);
-- 去重查询[后面列的组合重复, 才算一个重复]
select distinct first_name, address
from person
limit 0,3;
-- 去重查询
select distinct first_name, address
from person
limit 3 offset 1;
-- 查询所有
select *
from view_person_left_join_order;

-- date函数
select now(); -- 当前日期和时间
select curdate(); -- 当前日期
select curtime(); -- 当前时间
select date(now()); -- 获取当前日期
select extract(year from now()); -- 提取时间
select extract(day from now()); -- 提取天
select extract(second from now()); -- 提取秒
select date_add(curdate(), interval 3 day); -- 三天后
select date_sub(curdate(), interval 3 day); -- 三天前
select datediff('2025-11-11', '2025-11-19'); -- 计算天数差
select date_format(curtime(), '%Y-%m-%d %H:%m:%s');
-- 格式化时间

-- 查看建表语句
show create table tb_order;
-- 修改表结构, 添加列
alter table tb_order
    add column create_time datetime not null default now();
-- 1天前
select date_sub(curdate(), interval 1 day);
-- 查询所有
select *
from tb_order;
-- 查询所有
select *
from tb_order o
where o.create_time between
          '2025-11-13 00:00:00'
          and '2025-11-14 23:59::00';
-- 查询所有
select *
from tb_order o
where o.create_time between
          date_sub(curdate(), interval 1 day)
          and curdate();
-- null
-- 查看建表语句
show create table person;
-- 查询所有
select *
from person;
-- 插入数据
insert into person
values (null, '云', null, '苏州', '18834569845', 'zhaoyun@qq.com'),
       (null, null, '张', '杭州', '18834561234', 'zhangfei@qq.com');
-- 查询所有
select *
from person
where first_name is null;
-- 查询所有
select *
from person
where last_name is null;
-- 更新表数据
update person p
set p.address = '杭州'
where p.address = '合肥';
-- 查询所有
select *
from person p;
-- 更新表数据
update person p
set p.address = null
where p.address = '北京';
-- 查询所有
select *
from person p
where p.address is not null;

-- null 函数
-- 删除表
drop table if exists product;
-- 创建表
create table if not exists product
(
    id         bigint primary key auto_increment,
    name       varchar(255),
    unit_price decimal(10, 2),
    stock      int,
    sold_count int
) auto_increment = 202511161121001;
-- 查看建表语句
show create table product;
-- 查询所有
select *
from product;
-- 插入数据
insert into product
values (null, 'iPhone 15', 4799, 16, 13),
       (null, 'OPPO FindX9', 3799, 23, null),
       (null, 'VIVO X300', 3699, 9, 23);
-- 查询
select p.name as '产品名', p.unit_price * (p.stock + p.sold_count) as '商品总价'
from product p;

-- ifnull(), coalesce()
-- 跳过null值
select p.name                                             as '产品名',
       p.unit_price * (p.stock + ifnull(p.sold_count, 0)) as '商品总价'
from product p;
-- 跳过null值
select p.name                                               as '产品名',
       p.unit_price * (p.stock + coalesce(p.sold_count, 0)) as '商品总价'
from product p;

select coalesce(null, null, '1', 2, 4);

-- sql函数
-- avg(), count(), first(), last(), max(), min(), sum()
-- first() last() MySQL不支持
-- 查询所有
select *
from access_log;
-- 查询平均值, 没有分组默认所有记录为一组
select avg(al.count)
from access_log al;
-- 子查询
select *
from access_log al
where count > (select avg(al2.count) from access_log al2);

-- count, 计数查询
-- 查询所有
select *
from access_log al;
-- 查询一个
select *
from access_log al
where site_id = 10001001011;
-- 查询数量
select count(*)
from access_log
where site_id = 10001001011;
-- 查询总数
select count(*)
from access_log;
-- distinct 查询
select count(distinct al.site_id, count)
from access_log al;
-- 查询复合列的数量
select count(al.site_id, al.count)
from access_log al;

-- first() , MySQL不支持, 需要使用 LIMIT 1
select first(al.count)
from access_log al;
-- 限制数量
select *
from access_log al
limit 1;
-- 限制数量
select *
from websites
limit 1;
-- 限制数量
select *
from websites
limit 1 offset 0;
-- last(), MySQL不支持, 使用order by column_name desc limit 1
select *
from websites w
order by w.name desc
limit 1;
-- max()
select *
from websites w;
-- 查询最大值
select max(w.alexa)
from websites w;
-- 查询最小值
select min(w.alexa)
from websites w;
-- 查询平均值
select avg(w.alexa)
from websites w;
-- 求和
select sum(w.alexa)
from websites w;
-- 查询所有
select *
from access_log al;
-- 查询每个网站的访问量
select al.site_id, sum(al.count)
from access_log al
group by al.site_id;
-- 查询每月每个网站的访问量
select al.date, al.site_id, w.name, sum(al.count)
from access_log al
         left join websites w on al.site_id = w.id -- 连接查询
group by al.date, al.site_id;

-- 查询每个网站每个月份的访问量
select w.name, al.date, sum(al.count)
from access_log al
         left join websites w on al.site_id = w.id -- 连接查询
group by al.site_id, al.date;

-- group by
-- 统计每个网站的访问总量
select site_id, sum(count)
from access_log
group by site_id;
-- 分组统计, 求和
select w.name, sum(al.count)
from websites w
         left join access_log al on w.id = al.site_id
where al.site_id is not null
group by w.name;
-- 分组统计求和
select w.name, sum(al.count) as total
from websites w
         left join access_log al on w.id = al.site_id
where al.site_id is not null
group by w.name;
-- 查询所有
select *
from access_log;
-- 查询所有
select *
from websites;
-- 连接查询
select *
from access_log al
         left join websites w on al.site_id = w.id;

-- having
-- 分组过滤
select w.name, w.url, sum(al.count) as total
from access_log al
         left join websites w on al.site_id = w.id
group by al.site_id
having total between 400 and 800;
-- 分组过滤
select w.name, w.url, sum(al.count) as total
from access_log al
         left join websites w
                   on al.site_id = w.id
where w.alexa < 200
group by al.site_id
having total between 400 and 800;

-- exists
-- 判断是否存在, 存在则为true
select exists(select * from access_log);

-- 怎么执行的???
select w.name, w.url, count
from access_log al,
     websites w
where w.id = al.site_id
  and count < 300;
-- 子查询
select w.name, w.url
from websites w
where exists(select count
             from access_log al
             where w.id = al.site_id
               and count < 300);
-- 子查询
select w.name, w.url
from websites w
where not exists(select count
                 from access_log al
                 where w.id = al.site_id
                   and count > 200);
-- 查询所有
select *
from websites;
-- uppercase(), lowercase()
-- 大小写转换
select ucase(name),
       lcase(name),
       UCASE(url),
       LCASE(url)
from websites w;

-- mid(), substr(), substring()
select *
from websites;
-- 字符串截取
select mid(w.url, 1, 6)
from websites w;
-- 字符串截取
select substr(w.url, 1, 5)
from websites w;
-- 字符串截取
select substring(w.url, 1, 5)
from websites w;

-- length()
-- 求字符串长度
select w.name, length(w.name), w.url, length(w.url)
from websites w;
-- round()
-- 四舍五入
select round(avg(count), 2)
from access_log al;

select round(17 / 7, 1);
select round(17 / 7, 0);
select round(9 / 2, 0);
select round(4.4, 1);
-- now()
-- 取时间中的某个时间类型
select year(now()),
       month(now()),
       day(now()),
       hour(now()),
       minute(now()),
       second(now()),
       microsecond(now());

-- format()
-- 格式化，保留几位小数
select format(123, 6);
-- 日期格式化
select date_format(now(), '%Y-%m-%d');
-- 删除表
drop table if exists tb_user;
-- 创建表
create table if not exists tb_user
(
    id          bigint primary key auto_increment,
    name        varchar(50),
    age         int,
    deleted     tinyint,
    phone       varchar(50),
    email       varchar(50),
    create_user bigint,
    create_time datetime,
    update_user bigint,
    update_time datetime
);

-- 查询所有
select *
from tb_user;

-- 向tb_user中插入10条数据
-- 插入数据
insert into tb_user (name, age, deleted, phone, email, create_user, create_time, update_user, update_time)
values ('张三', 25, 0, '13800138001', 'zhangsan@example.com', 1, now(), 1, now()),
       ('李四', 30, 0, '13800138002', 'lisi@example.com', 1, now(), 1, now()),
       ('王五', 28, 0, '13800138003', 'wangwu@example.com', 1, now(), 1, now()),
       ('赵六', 35, 0, '13800138004', 'zhaoliu@example.com', 1, now(), 1, now()),
       ('钱七', 22, 0, '13800138005', 'qianqi@example.com', 1, now(), 1, now()),
       ('孙八', 27, 0, '13800138006', 'sunba@example.com', 1, now(), 1, now()),
       ('周九', 31, 0, '13800138007', 'zhoujiu@example.com', 1, now(), 1, now()),
       ('吴十', 29, 0, '13800138008', 'wushi@example.com', 1, now(), 1, now()),
       ('郑一', 26, 0, '13800138009', 'zhengyi@example.com', 1, now(), 1, now()),
       ('王二', 33, 0, '13800138010', 'wanger@example.com', 1, now(), 1, now());

-- 查询所有
select *
from tb_user u
where u.id > 5
  and u.deleted = 0;
-- 修改表结构，添加列
alter table tb_user
    add column avatar varchar(255);
-- 查询列
select u.name as '姓名', u.phone as '手机'
from tb_user u;
-- 查询列
select u.name as '姓名', u.age as '年龄'
from tb_user u
where u.age between 30 and 50;
-- 删除数据库
drop database if exists test_db;
-- 创建数据库
create database if not exists test_db;
-- 查询所有
select count(*)
from customer;
-- 查看执行计划
explain
select *
from customer c
where c.name like 'a1%';
-- 创建索引
create index idx_customer_name on customer (name);
-- 删除索引
alter table customer
    drop index idx_customer_name;
-- 创建视图
create view view_customer as
select c.name, c.entry_date
from customer c;
-- 查询所有
select *
from view_customer;
-- 查询所有
select *
from person;
-- 根据条件删除
delete
from person p
where p.address is null;
-- 根据条件删除
delete
from tb_user u
where u.deleted = 1;
-- 查询所有
select *
from tb_user;
-- 删除表
drop table if exists test_table;

-- 查找重复的人名
-- 分组过滤查询
select c.name, count(c.name) as counts
from customer c
group by c.name
having counts > 1;
-- 查看执行计划
explain
select *
from customer c
where c.name in (select c.name
                 from customer c
                 group by c.name
                 having count(c.name) > 1)
order by c.name;
-- 分组查询, 过滤
select c.name, count(c.name)
from customer c
group by c.name
having count(c.name) > 1;

-- 向 customer 中添加5条数据
-- 添加数据
insert into customer (name)
values ('宋江'),
       ('卢俊义'),
       ('吴用'),
       ('公孙胜'),
       ('关胜');
-- 查询所有, 排序
select *
from customer c
order by c.create_time desc;
-- UNION查询, 模拟全外连接
select *
from student s
         left join enrollment e on s.student_id = e.student_id
union
select *
from student s
         right join enrollment e on s.student_id = e.student_id;
-- 内连接查询
select *
from person p
         inner join tb_order o on p.id = o.person_id;
-- 左表所有数据匹配右表数据，匹配不到结果为 <null>
-- 左外连接
select *
from person p
         left join tb_order o on p.id = o.person_id;

-- 右表所有数据匹配左表数据，匹配不到结果为 <null>
-- 右外连接
select *
from person p
         right join tb_order o on p.id = o.person_id;

-- 内连接
select *
from student s
         inner join
     enrollment e on s.student_id = e.student_id;
-- 左表所有数据匹配右表数据，匹配不到结果为 <null>
-- 左外连接
select *
from student s
         left join enrollment e on s.student_id = e.student_id;

-- 右表所有数据匹配左表数据，匹配不到结果为 <null>
-- 右外连接
select *
from student s
         right join enrollment e on s.student_id = e.student_id;

-- full join 全外连接
select *
from student s
         left join enrollment e on s.student_id = e.student_id
union
select *
from student s
         right join enrollment e on s.student_id = e.student_id;

-- 查询重名的人
select count(c.name) as num1, count(distinct c.name) as num2
from customer c;
-- 查询所有
select *
from student;
select *
from websites;

-- select into mysql不支持
select w.name, w.alexa as ags
into student
from websites w;
-- 查询列
select w.country
from websites w;
select a.country
from apps a;
-- UNION 模拟全外连接
select w.country
from websites w
union
-- all -- all 表示不去重
select a.country
from apps a;
-- 查询所有
select *
from student;
-- 更新表, 更新表数据
update student
set age = 99
where age >= 25;