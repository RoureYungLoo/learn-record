/*
AVG()
COUNT()
MIN()
MAX()
SUM()
除count()外, 其他聚合函数会忽略NULL
*/

select d.department_name       as deptName,
       round(avg(e.salary), 2) as 'deptAvgSalary',
       round(min(e.salary), 2) as 'deptMinSalary',
       round(max(e.salary), 2) as 'deptMaxSalary',
       round(sum(e.salary), 2) as 'deptSumSalary'
FROM employees e
         inner join departments d
                    on e.department_id = d.department_id
group by e.department_id
order by e.department_id;

select d.department_name as '部门名称', count(e.department_id) as '员工数'
from employees e
         inner join departments d on e.department_id = d.department_id
group by e.department_id
order by 员工数 desc;

/* AVG() */
select round(avg(e.salary), 2) as 'avgSalary'
from employees e;

select round(avg(all e.salary), 2) as 'avgSalary'
from employees e;

select round(avg(distinct e.salary), 2) as 'avgSalary'
from employees e;

select round(avg(e.salary), 2) as avgSalary
from employees e
where e.department_id = 5;
-- group by e.department_id

select round(avg(e.salary), 2) as avgSalary
from employees e
where e.job_id = 6;
-- group by e.job_id

select e.department_id, round(avg(e.salary), 2) as deptAvgSalary
from employees e
group by e.department_id;

select e.department_id, d.department_name as deptName, round(avg(e.salary), 2) as deptAvgSalary
from employees e
         INNER join departments d on e.department_id = d.department_id
group by e.department_id
order by deptAvgSalary desc;

select e.department_id, d.department_name, round(avg(e.salary), 2) as deptAvgSalary
from employees e
         inner join departments d on e.department_id = d.department_id
group by e.department_id
having round(avg(e.salary), 2) < 5000
order by deptAvgSalary desc;

select round(avg(e.salary), 2) as deptAvgSalary
from employees e
group by e.department_id;

select round(avg(deptAvgSalary), 2) avgSalary
from (select round(avg(e.salary), 2) as deptAvgSalary
      from employees e
      group by e.department_id) t;

/* COUNT() */
select count(*)
from employees;

select count(*)
from employees e
where e.department_id = 6;

select count(*) as empCount
from employees e
where e.job_id = 9;

select e.department_id, count(*) as empCount
from employees e
group by e.department_id
order by empCount desc;

select e.department_id, d.department_name as deptName, count(*) as empCount
from employees e
         inner join departments d on e.department_id = d.department_id
group by e.department_id
order by empCount desc;

select e.department_id, d.department_name as deptName, count(*) as empCount
from employees e
         inner join departments d on e.department_id = d.department_id
group by e.department_id
having count(*) > 5
order by empCount desc;

select count(job_id)
from employees;

select count(all job_id)
from employees;

select count(distinct job_id)
from employees;

select count(distinct manager_id)
from employees;

/* MAX() */
select max(salary)
from employees e;

select *
from employees
where salary = (select max(salary) from employees);

select e.department_id, d.department_name, max(e.salary) deptMaxSalary
from employees e
         inner join departments d on e.department_id = d.department_id
group by e.department_id
order by deptMaxSalary desc;

select e.department_id, d.department_name, max(e.salary) deptMaxSalary
from employees e
         inner join departments d on e.department_id = d.department_id
group by e.department_id
having max(e.salary) > 12000
order by deptMaxSalary desc;

/* MIN() */
select min(salary)
from employees;

select *
from employees
where salary = (select min(salary) from employees);

select e.department_id, d.department_name, min(e.salary) as deptMinSalary
from employees e
         inner join departments d on e.department_id = d.department_id
group by e.department_id
having min(e.salary) < 3000
order by min(e.salary) desc;

/* SUM() */
select sum(salary)
from employees;

select sum(salary)
from employees
where department_id = 5;

select e.department_id,
       sum(e.salary) as deptTotalSalary
from employees e
group by e.department_id;

select e.department_id,
       d.department_name,
       sum(e.salary) as deptTotalSalary
from employees e
         inner join departments d on e.department_id = d.department_id
group by e.department_id
order by deptTotalSalary desc;

select e.department_id,
       d.department_name,
       sum(e.salary) as deptTotalSalary
from employees e
         inner join departments d on e.department_id = d.department_id
group by e.department_id
having sum(e.salary) > 30000
order by deptTotalSalary desc;

/* ANY_VALUE 从一组值中选择一个任意值。 */
select e.department_id, any_value(concat(e.first_name, ' ', e.last_name)) as empName
from employees e
group by e.department_id
order by e.department_id;

select department_name deptName, any_value(concat(e.first_name, ' ', e.last_name)) as empName
from employees e
         inner join departments d on e.department_id = d.department_id
group by e.department_id
order by e.department_id;

select e.department_id, any_value(e.first_name)
from employees e
group by e.department_id;