select concat(e.first_name, ' ', e.last_name) as 'Emp Name',
       e.salary                                  '薪 水',
       e.salary * 1.1                            'new 薪水'
from employees e;

select e.first_name, e.last_name, e.salary * 1.1 as newSalary
from employees e
where newSalary > 5000; /*计算顺序: FROM > WHERE > SELECT > ORDER BY */

select e.first_name, e.last_name, e.salary * 1.1 as newSalary
from employees e
order by newSalary desc;

select e.first_name, e.last_name
from employees as e;

select concat(e.first_name, ' ', e.last_name) as EmpName, d.department_name as deptName
from employees as e
         inner join departments as d on e.department_id = d.department_id;