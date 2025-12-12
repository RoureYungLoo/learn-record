/*
 =
 <>, !=
 >, >=
 <, <=
 */

select concat(e.first_name, ' ', e.last_name) as EmpName
from employees e
where e.last_name = 'Himuro';

select concat(e.first_name, ' ', e.last_name) as EmpName, e.department_id
from employees e
where e.department_id != 8
order by e.department_id;

select concat(e.first_name, ' ', e.last_name) as EmpName, e.department_id
from employees e
where e.department_id <> 8
order by e.department_id;

select concat(e.first_name, ' ', e.last_name) as EmpName, e.salary
from employees e
where e.salary >= 10000
order by e.salary desc;

select concat(e.first_name, ' ', e.last_name) as EmpName, e.salary
from employees e
where e.salary > 10000
  and e.department_id = 8
order by e.salary desc;

select concat(e.first_name, ' ', e.last_name) as EmpName, e.salary
from employees e
where e.salary <= 10000
  and e.department_id = 8
order by e.salary desc;