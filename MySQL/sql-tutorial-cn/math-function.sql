/*
ABS()	返回绝对值
ACOS()	返回参数的反余弦值
ASIN()	返回参数的反正弦值
ATAN()	返回参数的反正切值
CEIL(),CEILING()	将一个浮点数向上取整到最接近的整数值
COS()	返回参数的余弦值
COT()	返回参数的余切值
EXP()	返回常数 e (2.71828…) 的指定数字次幂
LN()	返回参数的自然对数
LOG()	返回第一个参数的自然对数
LOG10()	返回参数的以 10 为底的对数
LOG2()	返回参数的以 2 为底的对数
MOD()	返回一个数除以另一个数的余数（模）
PI()	返回 pi 的值，即 3.14159265358979
POWER()	返回一个数的指定数字次幂
RAND()	返回一个随机浮点数值
ROUND()	将一个数字四舍五入到指定的精度
SIGN()	返回参数的符号
SIN()	返回参数的正弦值
SQRT()	返回参数的平方根
TAN()	返回参数的正切值
TRUNCATE()	截断到指定的小数位数
*/

/* ROUND() */
select round(2.545, 3);
select round(2.545, 2);
select round(2.545, 1);
select round(2.545, 0);
select round(100.19, 1);
select round(100.14, 1);
select round(109.14, -1);
select round(109.54);
select round(109.44);

select d.department_name       as deptName,
       round(avg(e.salary), 0) as deptAvgSalasy
from employees e
         inner join departments d on e.department_id = d.department_id
group by d.department_name
order by d.department_name;

/* RAND() */
select rand();
select rand(1);
select rand(now());
select random_bytes(8);

-- 生成范围随机数[10,50]
select round(10 + rand() * (50 - 10));
-- [1,100]
select round(1 + rand() * (100 - 1));

select e.employee_id, concat(e.first_name, ' ', e.last_name) as empName
from employees e
order by rand()
limit 5 offset 0;

/*
ACOS() 反余弦值
COS() 余弦值
*/
select acos(0.5);
select degrees(acos(0.5));
select acos(1);
select degrees(acos(1));
select acos(-1);
select degrees(acos(-1));

select cos(0);
select cos(pi());
select cos(pi() / 3);
select cos(pi() / 2);
select pi();

/* ASIN() 反正弦
   SIN() 正弦
   */
select asin(0.5);
select degrees(asin(0.5));

select asin(1);
select degrees(asin(1));

select asin(-1);
select degrees(asin(-1));

select sin(1);
select sin(0.5);
select sin(-1);
select sin(-0.5);
select sin(pi());
select sin(pi() / 2);
select sin(pi() / 3);
select sin(pi() / 6);

/* ATAN() 反正切
   TAN() 正切
   */
select atan(0.5);
select degrees(atan(0.5));

select tan(0);
select tan(1);
select tan(2);

/* COT() */
select cot(pi());
select cot(pi() / 2);
select cot(pi() / 4);
select cot(pi() / 6);

/* MOD() */
select mod(5, 3);
select mod(100, 17);
select round(100 / 17 - 0.5) as 整数, mod(100, 17) as 余数;
select 100 % 17;

select case e.employee_id % 2
           when 0 then '偶数员工'
           when 1 then '奇数员工'
           end                                as type,
       concat(e.first_name, ' ', e.last_name) as empName
from employees e
group by e.employee_id
order by type;

select case mod(e.employee_id, 2)
           when 0 then '偶数员工'
           when 1 then '奇数员工'
           end              as type,
       count(e.employee_id) as empCount
from employees e
group by type;

/* ceil() */
select ceil(1.001);
select ceil(1.401);
select ceil(1.501);
select ceil(-100.49);
select ceil(100.51);
select ceil(100.49);

select d.department_name as deptName, ceil(avg(e.salary)) as deptAvgSalary
from employees e
         inner join departments d on e.department_id = d.department_id
group by d.department_name
order by deptAvgSalary desc;

/* floor() */
select floor(1.005);
select floor(-1.005);
select floor(10.68);
select floor(-10.68);

select d.department_name    as deptName,
       floor(avg(e.salary)) as deptAvgSalary
from employees e
         inner join departments d on e.department_id = d.department_id
group by d.department_name
order by deptAvgSalary desc;

/* exp() */
select exp(1);
select exp(10);
select exp(ln(100));
select ln(exp(100));

/* sqrt() */
select sqrt(100);
select sqrt(81);
select sqrt(81 * 81);

/* power() */
select pow(2, 3);
select pow(3, 2);
select pow(10, 2);
select pow(10, 3);
select pow(100, 0.5);
select pow(1000, 1 / 3);
select pow(1000, -1);

/* abs() */
select abs(-1);
select abs(-100);
select abs(50 - 100);

/* truncate() */
select truncate(1.12345, 4);
select truncate(1.23456, 2);
select truncate(123.4567, 2);
select truncate(12345.6789, -2);

select d.department_name          as deptName,
       truncate(avg(e.salary), 0) as deptAvgSalary
from employees e
         inner join departments d on e.department_id = d.department_id
group by d.department_name
order by deptAvgSalary desc;