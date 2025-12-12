/*
获取日期/时间
CURRENT_DATE() – 返回表示当前日期的日期值。
CURRENT_TIME() – 返回表示当前时间的时间值。
CURRENT_TIMESTAMP() – 返回表示当前日期和时间的时间戳。
*/

/*
提取日期/时间
EXTRACT – 从日期和时间值中提取特定部分，包括年、月、日、小时、分钟和秒。
DATEPART – 从给定日期中提取部分日期，如年、月和日。
*/

/*
计算日期/时间
DATEADD – 向日期/时间值添加一个时间间隔。
DATEDIFF – 返回两个日期或时间之间的差值。
DATE_TRUNC – 将日期/时间值截断到指定的精度，如年、月、日、小时、分钟和秒
*/

/*
转换日期/时间
将字符串转换为日期.
将日期转换为字符串。
从日期时间中提取日期.
*/

/* CURRENT_DATE() */
select current_date() as today;

select *
from salary_changes;
drop table if exists salary_changes;
create table if not exists salary_changes
(
    employee_id bigint auto_increment,
    changed_at  date default (current_date),
    old_salary  decimal(10, 2),
    new_salary  decimal(10, 2),
    primary key (employee_id, changed_at)
);

insert into salary_changes(employee_id, new_salary)
values (101, 23456),
       (102, 23000),
       (103, 15000);

select concat(e.first_name, ' ', e.last_name) as deptName,
       e.salary                               as oldSalary,
       sc.new_salary                          as newSalary,
       sc.changed_at                          as changeAt
from salary_changes sc
         inner join employees e on sc.employee_id = e.employee_id
where sc.changed_at < CURRENT_DATE;

-- MySQL不支持
SELECT CURRENT_DATE + INTERVAL '7 DAY' AS next_week,
       CURRENT_DATE - INTERVAL '7 DAY' AS last_week;

/* CURRENT_TIME() */
select current_time;
select current_time();

/* CURRENT_TIMESTAMP */
select current_timestamp;
select current_timestamp();

select *
from posts;
drop table if exists posts;
create table if not exists posts
(
    id         bigint primary key auto_increment,
    title      varchar(255) not null,
    created_at datetime default current_timestamp
);
insert into posts(title)
values ('title3'),
       ('title4');

/* EXTRACT() */
select extract(year from current_timestamp)   as year,
       extract(month from current_timestamp)  as month,
       extract(day from current_timestamp)    as date,
       extract(hour from current_timestamp)   as hour,
       extract(minute from current_timestamp) as minute,
       extract(second from current_timestamp) as second;

select extract(quarter from current_timestamp) as quarter,
       extract(week from current_timestamp)    as week;

select concat(e.first_name, ' ', e.last_name) as empName,
       extract(year from e.hire_date)         as hireYear
from employees e
order by hireYear;

select concat(e.first_name, ' ', e.last_name) as empName
from employees e
where extract(year from e.hire_date) = 2023;

select concat(e.first_name, ' ', e.last_name) as empName,
       extract(month from e.hire_date)        as hireMonth
from employees e
order by hireMonth;

select extract(month from e.hire_date) as hireMonth, count(*) as count
from employees e
group by extract(month from e.hire_date)
order by hireMonth;

select concat(e.first_name, ' ', e.last_name) as empName,
       extract(day from e.hire_date)          as hireDay
from employees e;

select extract(hour from current_timestamp)   as h,
       extract(minute from current_timestamp) as m,
       extract(second from current_timestamp) as s;

/* 提取年份 extract() year() */
select extract(year from current_date) as year;
select extract(year from '2023-01-19') as year;

select e.employee_id,
       extract(year from hire_date) as hireYear
from employees e;

select year(current_date) as year;
select e.employee_id,
       year(e.hire_date) as hireYear
from employees e;
/* 提取月份 extract() month() */
select extract(month from current_date) as month;
select e.employee_id, extract(month from e.hire_date) as hireMonth
from employees e;
select month(current_date) as month;
select monthname(current_date) as month;
select e.employee_id, month(e.hire_date) as hireMonth, monthname(e.hire_date) as monthName
from employees e
order by hireMonth asc;
/* 提取天 extract()  day() */
select extract(day from current_date) as day;
select e.employee_id,
       extract(day from e.hire_date) as hireDay
from employees e
order by hireDay;
select day(current_date) as day;
select e.employee_id,
       day(e.hire_date)     as hireDay,
       dayname(e.hire_date) as hireDayName
from employees e
order by hireDay;

/* DATE_ADD() */
select date_add(current_date, interval 15 day);
select date_add(current_date, interval 2 month);
select date_add(current_date, interval 1 year);
/* DATE_SUB*/
select date_sub(current_date, interval 15 day);
select date_sub(current_date, interval 2 month);
select date_sub(current_date, interval 1 year);

/* DATEDIFF() */
SELECT ABS(DATEDIFF('1998-02-16', CURRENT_DATE)) AS RES;
SELECT ABS(DATEDIFF('1998-02-16', CURRENT_DATE)) / 365 AS 年龄;
SELECT ABS(DATEDIFF('1998-02-16', CURRENT_DATE)) / 30 AS 月龄;
select concat(e.first_name, ' ', e.last_name)           as empName,
       round(datediff('2026-01-01', e.hire_date) / 365) as workYear
from employees e
order by workYear desc;

/* DATE_TRUNCATE(), MySQL不支持 */
select date_truncate();

/* DATEPART() MySQL不支持*/
select datepart();

/* 转换日期和字符串  string to date */
select cast('2018' as year) as year;
select cast('2018-01-01' as date) as date;
select cast('2018-01-01 12:00:59' as datetime) as datetime;
select str_to_date('2025#12#12 12#23#59', '%Y#%m#%d %H#%i#%s');
select str_to_date('2025/12/23', '%Y/%m/%d');
/* date to string */
select cast(current_date as char) as date;
select cast(current_timestamp as char) as datetime;
select date_format(current_timestamp, '%Y.%m.%d %H:%i:%s');

/* 提取日期 */
select cast('2025-01-12 23:00:59' as date);
select cast('2025-01-12 23:00:59' as year);
select date('2025-01-12 23:00:59');
select month('2025-01-12 23:00:59');
select monthname('2025-01-12 23:00:59');
select year('2025-01-12 23:00:59');