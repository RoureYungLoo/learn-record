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