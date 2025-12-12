/* 窗口函数
值窗口函数
   first_value()
   last_value()
   lag()
   lead()
排名窗口函数
   rank()
   dense_rank()
   percent_rank()
   row_number()
   cume_dist()
   ntile()
聚合窗口函数
   avg()
   count()
   min()
   max()
   sum()
   */
select sum(e.salary) as total
from employees e;

select e.first_name,
       e.last_name,
       e.salary,
       sum(e.salary) over () total_salary
from employees e;

/*
window_function_name ( expression or column ) OVER (
    partition by clause 将行划分为窗口函数应用的分区
    order by clause 指定每个分区中行的顺序
    frame clause 当前分区的一个子集
)
*/

/* first_value() 返回有序值集中的第一个值 */
select e.first_name,
       e.last_name,
       e.salary,
       first_value(e.first_name) over (
           order by e.salary
           ) lowest_salary
from employees e;

select concat(e.first_name, ' ', e.last_name) as empName,
       d.department_name                      as deptName,
       e.salary,
       first_value(concat(e.first_name, ' ', e.last_name)) over (
           partition by d.department_name
           order by e.salary
           )                                  as dept_lowest_salary
from employees e
         inner join departments d on e.department_id = d.department_id;

/* LAG() 当前行之前特定物理偏移位置的行的访问能力(类比limit)*/
select *
from basic_pays;
drop table if exists basic_pays;
create table if not exists basic_pays
(
    employee_id bigint,
    fiscal_year bigint,
    salary      decimal(10, 2),
    primary key (employee_id, fiscal_year)
);
INSERT INTO basic_pays(employee_id, fiscal_year, salary)
VALUES (100, 2017, 24000),
       (101, 2017, 17000),
       (102, 2017, 17000),
       (103, 2017, 9000),
       (104, 2017, 6000),
       (105, 2017, 4800),
       (106, 2017, 4800),
       (107, 2017, 4200),
       (108, 2017, 12000),
       (109, 2017, 9000),
       (110, 2017, 8200),
       (111, 2017, 7700),
       (112, 2017, 7800),
       (113, 2017, 6900),
       (114, 2017, 11000),
       (115, 2017, 3100),
       (116, 2017, 2900),
       (117, 2017, 2800),
       (118, 2017, 2600),
       (119, 2017, 2500),
       (120, 2017, 8000),
       (121, 2017, 8200),
       (122, 2017, 7900),
       (123, 2017, 6500),
       (126, 2017, 2700),
       (145, 2017, 14000),
       (146, 2017, 13500),
       (176, 2017, 8600),
       (177, 2017, 8400),
       (178, 2017, 7000),
       (179, 2017, 6200),
       (192, 2017, 4000),
       (193, 2017, 3900),
       (200, 2017, 4400),
       (201, 2017, 13000),
       (202, 2017, 6000),
       (203, 2017, 6500),
       (204, 2017, 10000),
       (205, 2017, 12000),
       (206, 2017, 8300),
       (100, 2018, 25920),
       (101, 2018, 18190),
       (102, 2018, 18360),
       (103, 2018, 9720),
       (104, 2018, 6060),
       (105, 2018, 4992),
       (106, 2018, 5040),
       (107, 2018, 4284),
       (108, 2018, 12360),
       (109, 2018, 9540),
       (110, 2018, 8692),
       (111, 2018, 7931),
       (112, 2018, 8580),
       (113, 2018, 7107),
       (114, 2018, 11440),
       (115, 2018, 3131),
       (116, 2018, 3161),
       (117, 2018, 2940),
       (118, 2018, 2652),
       (119, 2018, 2650),
       (120, 2018, 8800),
       (121, 2018, 8364),
       (122, 2018, 8611),
       (123, 2018, 6565),
       (126, 2018, 2808),
       (145, 2018, 14560),
       (146, 2018, 14580),
       (176, 2018, 9202),
       (177, 2018, 8988),
       (178, 2018, 7630),
       (179, 2018, 6448),
       (192, 2018, 4320),
       (193, 2018, 4173),
       (200, 2018, 4620),
       (201, 2018, 13000),
       (202, 2018, 6360),
       (203, 2018, 7085),
       (204, 2018, 10100),
       (205, 2018, 12360),
       (206, 2018, 8632),
       (100, 2020, 26179.2),
       (101, 2020, 19463.3),
       (102, 2020, 19278),
       (103, 2020, 10206),
       (104, 2020, 6605.4),
       (105, 2020, 5391.36),
       (106, 2020, 5191.2),
       (107, 2020, 4498.2),
       (108, 2020, 13472.4),
       (109, 2020, 9826.2),
       (110, 2020, 9561.2),
       (111, 2020, 8248.24),
       (112, 2020, 9352.2),
       (113, 2020, 7107),
       (114, 2020, 12012),
       (115, 2020, 3224.93),
       (116, 2020, 3287.44),
       (117, 2020, 3175.2),
       (118, 2020, 2864.16),
       (119, 2020, 2782.5),
       (120, 2020, 9152),
       (121, 2020, 8531.28),
       (122, 2020, 8697.11),
       (123, 2020, 6630.65),
       (126, 2020, 2920.32),
       (145, 2020, 16016),
       (146, 2020, 14871.6),
       (176, 2020, 9938.16),
       (177, 2020, 9167.76),
       (178, 2020, 7858.9),
       (179, 2020, 6641.44),
       (192, 2020, 4406.4),
       (193, 2020, 4339.92),
       (200, 2020, 4712.4),
       (201, 2020, 14040),
       (202, 2020, 6614.4),
       (203, 2020, 7155.85),
       (204, 2020, 10908),
       (205, 2020, 12730.8),
       (206, 2020, 8890.96);

/* 查询当前年度和上一年度的薪资 */
select employee_id,
       fiscal_year,
       lag(salary) over (
           partition by employee_id
           order by fiscal_year
           ) as previous_salary
from basic_pays;

/* 查询薪资涨幅情况 */
select employee_id,
       fiscal_year,
       salary,
       previous_salary,
       concat(round((salary - previous_salary) * 100 / previous_salary, 0), '%') YoY
from (select employee_id,
             fiscal_year,
             salary,
             lag(salary, 1, 0) over (
                 partition by employee_id
                 order by fiscal_year
                 ) previous_salary
      from basic_pays) t;

/* last_value() */
select concat(e.first_name, ' ', e.last_name) as empName,
       last_value(e.first_name) over (
           order by e.salary
           range between unbounded preceding and
               unbounded following
           )                                  as highest_salary
from employees e;

select concat(e.first_name, ' ', e.last_name) as empName,
       d.department_name                      as deptName,
       e.salary                               as salary,
       last_value(concat(e.first_name, ' ', e.last_name)) over (
           partition by d.department_name
           order by e.salary
           range between unbounded preceding and unbounded following
           )                                  as deptMaxSalary
from employees e
         inner join departments d on e.department_id = d.department_id;

/* lead() 当前行之后特定物理偏移量处行的访问 */
select concat(e.first_name, ' ', e.last_name) as empName,
       e.hire_date,
       lead(e.hire_date, 1) over (
           order by hire_date
           )                                  as nextEmpHireDate
from employees e;

select concat(e.first_name, ' ', e.last_name) as empName,
       d.department_name,
       e.hire_date,
       lead(e.hire_date, 1, 'N/A') over (
           partition by d.department_name
           order by e.hire_date
           )                                  as next_hire_date
from employees e
         inner join departments d on e.department_id = d.department_id;

/* CUME_DIST() 计算一组值中某个值的累积分布 */
create view dept_headcounts as
select d.department_name,
       count(e.employee_id) headcount
from employees e
         inner join departments d on e.department_id = d.department_id
group by e.department_id;

select *
from dept_headcounts;

select dh.department_name,
       dh.headcount,
       round(
               cume_dist() over (order by headcount)
           , 2) as cume_dist_val
from dept_headcounts dh;

/* dense_rank() 对分区中的行进行排名，且排名值没有间隙 */
drop table if exists dense_rank_demos;
create table if not exists dense_rank_demos
(
    v varchar(255)
);
insert into dense_rank_demos
values ('A'),
       ('B'),
       ('B'),
       ('C'),
       ('D'),
       ('D'),
       ('E');

select *
from dense_rank_demos;

select v,
       dense_rank() over (order by v) _dense_rank,
       rank() over (order by v)       _rank
from dense_rank_demos;

select concat(e.first_name, ' ', e.last_name)      as empName,
       e.salary                                    as salary,
       dense_rank() over (order by e.salary desc ) as salary_rank
from employees e;

select concat(e.first_name, ' ', e.last_name) as empName,
       d.department_name                      as deptName,
       e.salary                               as salary,
       dense_rank() over (
           partition by d.department_name
           order by e.salary desc
           )                                  as salary_rank
from employees e
         inner join departments d on e.department_id = d.department_id;

select *
from (select concat(e.first_name, ' ', e.last_name) as empName,
             d.department_name                      as deptName,
             e.salary                               as salary,
             dense_rank() over (
                 partition by d.department_name
                 order by e.salary desc
                 )                                  as salary_rank
      from employees e
               inner join departments d on e.department_id = d.department_id) t
where salary_rank = 1;

/* ntile() 将结果集划分为指定数量的分桶 */
create table if not exists nums
(
    col bigint not null
);
select *
from nums;
insert into nums
values (1),
       (2),
       (3),
       (4),
       (5),
       (6),
       (7),
       (8),
       (9),
       (10);

select col,
       ntile(3) over (
           order by col
           ) as _ntile
from nums;

select col,
       ntile(2) over (
           order by col
           ) as bucket
from nums;
select col,
       ntile(4) over (
           order by col
           ) as bucket
from nums;

select concat(e.first_name, ' ', e.last_name) as empName,
       e.salary,
       ntile(5) over (
           order by e.salary desc
           )                                  as salary_bucket
from employees e;

select concat(e.first_name, ' ', e.last_name) as empName,
       d.department_name                      as deptName,
       e.salary,
       ntile(2) over (
           partition by d.department_name
           order by e.salary desc
           )                                  as deptSalaryBucket
from employees e
         inner join departments d on e.department_id = d.department_id;

/* percent_rank() 计算结果集中行的百分位排名 */
select concat(e.first_name, ' ', e.last_name)                               as empName,
       e.salary,
       concat(round(percent_rank() over (order by e.salary) * 100, 1), '%') as _percent_rank
from employees e;

select concat(e.first_name, ' ', e.last_name) as empName,
       d.department_name                      as deptName,
       e.salary                               as empSalary,
       concat(
               round(
                       percent_rank() over (
                           partition by d.department_name
                           order by e.salary
                           )
                           * 100, 1)
           , '%')
from employees e
         inner join departments d on e.department_id = d.department_id;

/* RANK() 返回结果集中每一行的排名 */
drop table if exists t;
create table if not exists t
(
    col char
);
insert into t
values ('A'),
       ('B'),
       ('B'),
       ('C'),
       ('D'),
       ('D'),
       ('E');

select col,
       rank() over (
           order by col
           )                            as t_rank,
       dense_rank() over (order by col) as t_dense_rank
from t;

select concat(e.first_name, ' ', e.last_name) as empName,
       e.salary,
       rank() over (
           order by e.salary desc
           )                                  as salary_rank
from employees e;

select concat(e.first_name, ' ', e.last_name) as empName,
       d.department_name                      as deptName,
       e.salary,
       rank() over (
           partition by d.department_name
           order by e.salary
           )                                  as deptSalaryRank
from employees e
         inner join departments d on e.department_id = d.department_id;

with payroll as (select concat(e.first_name, ' ', e.last_name) as empName,
                        e.department_id                        as deptId,
                        e.salary,
                        rank() over (
                            partition by e.department_id
                            order by e.salary
                            )                                  as deptSalaryRank
                 from employees e)
select empName, department_name, salary
from payroll p
         inner join departments d on p.deptId = d.department_id
where p.deptSalaryRank = 2;

/* row_number() 为查询结果集中的每一行分配一个连续的序号, 即 分配行号*/
select row_number() over (order by e.salary)  as rowNum,
       concat(e.first_name, ' ', e.last_name) as empName,
       e.salary
from employees e;

with res as (select row_number() over (order by e.salary)  as rowNum,
                    concat(e.first_name, ' ', e.last_name) as empName,
                    e.salary
             from employees e)
select *
from res
where res.rowNum > 10
  and res.rowNum <= 20;

SELECT *
FROM (SELECT ROW_NUMBER() OVER (
    ORDER BY
        salary
    ) row_num,
             first_name,
             last_name,
             salary
      FROM employees) t
WHERE row_num > 10
  AND row_num <= 20;

/* 公用表表达式 common table expression */
WITH t AS (SELECT ROW_NUMBER() OVER (
    ORDER BY
        salary
    ) row_num,
                  first_name,
                  last_name,
                  salary
           FROM employees)
SELECT *
FROM t
WHERE row_num > 10
  AND row_num <= 20;

select concat(e.first_name, ' ', e.last_name) as empName,
       d.department_name                      as deptName,
       e.salary,
       row_number() over (
           partition by d.department_name
           order by e.salary desc )           as row_num
from employees e
         inner join departments d
                    on e.department_id = d.department_id;

select *
from (select concat(e.first_name, ' ', e.last_name) as empName,
             d.department_name                      as deptName,
             e.salary,
             row_number() over (
                 partition by d.department_name
                 order by e.salary desc )           as row_num
      from employees e
               inner join departments d
                          on e.department_id = d.department_id) tmp
where row_num = 1;

/* partition by, 用于窗口函数结果集分区 */
/*

window_function (expression) OVER (
  PARTITION BY
    column1,
    column2
  ORDER BY
    column3,
    column4
)

*/
select *
from salary_reports;

select sr.state,
       sr.job,
       sr.salary,
       round(avg(sr.salary) over (), 2) avg_salary
from salary_reports sr
order by sr.state, sr.job;

select sr.state,
       sr.job,
       sr.salary,
       round(avg(sr.salary) over (partition by sr.job), 2) avg_salary
from salary_reports sr
order by sr.job, sr.state;

select sr.state,
       sr.job,
       sr.salary,
       round(avg(sr.salary) over (partition by sr.state), 2) avg_salary
from salary_reports sr
order by sr.state, sr.job;

select concat(e.first_name, ' ', e.last_name)               as empName,
       d.department_name                                    as deptName,
       e.salary,
       sum(e.salary) over ( partition by d.department_name) as dept_total_salary
from employees e
         inner join departments d on e.department_id = d.department_id
order by dept_total_salary;
