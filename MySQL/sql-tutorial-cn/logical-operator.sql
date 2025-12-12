select concat(e.first_name, ' ', e.last_name) as EmpName, e.salary
from employees e
where e.salary >= 5000
  and e.salary <= 7000
order by e.salary desc;

select concat(e.first_name, ' ', e.last_name) as EmpName, e.salary
from employees e
where e.salary = 7000
   or e.salary = 8000;

select concat(e.first_name, ' ', e.last_name) as EmpName, e.phone_number
from employees e
where e.phone_number is null;

select concat(e.first_name, ' ', e.last_name) as EmpName, e.salary
from employees e
where e.salary between 9000 and 12000
order by e.salary desc;

select concat(e.first_name, ' ', e.last_name) as EmpName, e.department_id
from employees e
where e.department_id in (8, 9)
order by e.department_id desc;


select concat(e.first_name, ' ', e.last_name) as EmpName
from employees e
where e.first_name like concat('Jo', '%');

select concat(e.first_name, ' ', e.last_name) as EmpName
from employees e
where e.first_name like concat('_', 'h', '%');

select concat(e.first_name, ' ', e.last_name) as EmpName, e.salary
from employees e
where e.salary >= all (select salary from employees where department_id = 8);

select round(avg(e.salary), 2) as deptAvgSalary
from employees e
group by e.department_id
order by deptAvgSalary desc;

/* some 是 any 的别名, 可以替换 */
select concat(e.first_name, ' ', e.last_name) as EmpName, e.salary
from employees e
where e.salary >= some (select round(avg(e.salary), 2) as deptAvgSalary
                        from employees e
                        group by e.department_id
                        order by deptAvgSalary desc)
order by e.salary asc;


select concat(e.first_name, ' ', e.last_name) as EmpName
from employees e
where exists(select 1 from dependents d where e.employee_id = d.employee_id);

select concat(e.first_name, ' ', e.last_name) as EmpName, e.salary
from employees e
where not (e.salary < 5000 or e.salary > 7000)
order by e.salary desc;