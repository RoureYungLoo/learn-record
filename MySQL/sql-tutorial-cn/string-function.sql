/*
LENGTH()
POSITION()
SUBSTRING()

CONCAT()
REPLACE()

TRIM()
LTRIM()
RTRIM()

UPPER()
LOWER()

LEFT()
RIGHT()
INSTR()
LOCATE()
CHARINDEX()

STRING_AGG()

ASCII()
CHR()

REGEXP_MATCH()
REGEXP_REPLACE()
REGEXP_SUBSTR()

LPAD()
RPAD()

QUOTE()
UNQUOTE()
SOUNDEX()
DIFFERENCE()
*/

/* length(), char_length() */
/* 字节数 */
select length('SQL') string_length;
/* 字符数 */
select char_length('SQL') string_length;

select length(concat(e.first_name, ' ', e.last_name)) as length,
       concat(e.first_name, ' ', e.last_name)         as name
from employees e
order by length(concat(e.first_name, ' ', e.last_name)) desc
limit 5;

/* position() */
select position('SQL' in 'SQL will, SQL will rock you!');
select position('We' in 'SQL will, SQL will rock you!');
select position('will' in 'SQL will, SQL will rock you!');

select concat(e.first_name, '', e.last_name), position('A' in e.first_name) as pos
from employees e
where position('A' in e.first_name) > 0;

select concat(e.first_name, ' ', e.last_name) as empName, e.email as email
from employees e
where position('J' in e.email) = 1;

select concat(e.first_name, ' ', e.last_name) as empName,
       case position('515' in e.phone_number)
           when 1 then '以515开头'
           else '不以515开头'
           end                                as res
from employees e;

/* ASCII() 返回字符串中第一个字符的 ASCII 码值。 */
select ascii('a'); -- 97
select ascii('A'); -- 65
select ascii('ASCII');

/* CHR() 1-255 */
select char(97);
select char(65);

/* concat() */
select concat('a', 'b', 'c');

select concat(e.first_name, ' ', e.last_name) as full_name
from employees e;

select concat(e.first_name, ' · ', e.last_name) as full_name
from employees e;

select concat_ws(' ', e.first_name, e.last_name)
from employees e;

/* lower() */
select lower(e.first_name)
from employees e;
update employees e
set e.email = lower(e.email)
where e.employee_id > 0;
select e.email
from employees e;

select *
from employees e
where lower(e.first_name) = 'sarah';

/* upper() */
select upper(e.last_name)
from employees e;

select *
from employees e
where upper(e.first_name) = 'BRUCE';

/* replace() */
select replace('We will, We will rock you!', 'We', 'SQL');
select replace('We will, we will rock you!', 'We', 'SQL');
select replace('We will, We will rock you!', 'WE', 'SQL');

select concat_ws(' ', e.first_name, e.last_name) as empName,
       replace(e.phone_number, '.', '-')         as phone
from employees e;

update employees e
set e.phone_number = replace(e.phone_number, '.', '-')
where e.employee_id > 0;

select e.phone_number
from employees e;

/* substring() */
select substring('SQLTutorial.org', 1, 3) as res;
select substring('SQLTutorial.org', 13, 3) as res;
select substring('SQLTutorial.org', 4, 8) as res;
select substring('SQLTutorial.org', position('.' in 'SQLTutorial.or'), 4) as ext;

select e.first_name, substring(e.first_name, 1, 1) as res
from employees e;

select substring(e.first_name, 1, 1) as initial, count(e.employee_id) as empCount
from employees e
group by initial;

/* trim() */
select trim('*' from '***SQL***');
select trim(leading '*' from '***SQL***');
select trim(trailing '*' from '***SQL***');
select trim('     ***SQL***     ') as res;
select trim(leading '0' from '00001900') as res;

update employees e
set e.first_name   = trim(e.first_name),
    e.last_name    = trim(e.last_name),
    e.phone_number = trim(e.phone_number),
    e.email        = trim(e.email)
where e.employee_id > 0;

/* LTRIM() */
insert into employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                      department_id)
    value (
           306, ' John', ' Doe', ' JohnDoe@qq.com', '# 515.123.8191', '1994-06-07', 1, 8500, 205, 11
    );
select *
from employees e
where e.first_name like concat(' ', '%');

update employees e
set e.first_name = ltrim(e.first_name)
where e.first_name like concat(' ', '%');

select *
from employees e
where e.last_name like concat(' ', '%');

select e.first_name          as firstName,
       ltrim(e.last_name)    as lastName,
       ltrim(e.phone_number) as phoneNumber
from employees e
where e.employee_id = 306;

select *
from employees e
where e.employee_id = 306;

select e.employee_id,
       case
           when e.last_name != ltrim(e.last_name) then '包含前导空格'
           else '不包含前导空格'
           end as res
from employees e;

/* rtrim() */
insert into employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                      department_id)
    value (
           406, 'John ', 'Doe ', 'JohnDoe@qq.com ', '515.123.8191#', '1994-06-07', 1, 8500, 205, 11
    );
select e.first_name, rtrim(e.first_name)
from employees e
where e.first_name like concat('%', ' ');

update employees e
set e.first_name = rtrim(e.first_name)
where e.first_name like concat('%', ' ');

select e.first_name,
       rtrim(e.last_name),
       rtrim(e.phone_number)
from employees e
where e.employee_id = 406;

select e.last_name,
       case
           when e.last_name != rtrim(e.last_name) then '姓氏包含尾部空格'
           else '姓氏不包含尾部空格' end as res
from employees e;

/* left() */
select left('1234567', 2);
select left('1234567', 3);
select left('SQL tutorial', 3);

select left(e.last_name, 1)
from employees e;

select concat(e.first_name, ' ', e.last_name)
from employees e
where left(e.last_name, 1) = 'K';

select left(e.last_name, 1) as 姓氏首字母, count(e.employee_id) as empCount
from employees e
group by left(e.last_name, 1);

/* right() */
select right('123456', 2);
select right('resume.pdf', 4);

drop table if exists performance_evaluation;
create table if not exists performance_evaluation
(
    employee_id     bigint primary key,
    rating          int          not null,
    evaluation_form varchar(255) not null
);

insert into performance_evaluation
values (101, 4, 'neena.pdf'),
       (102, 3, 'lex.pdf'),
       (103, 5, 'alexander.doc'),
       (104, 3, 'bruce.xls'),
       (105, 3, 'david.xls');

select *
from performance_evaluation;

select concat(e.first_name, ' ', e.last_name) as empName,
       pe.rating                              as rating,
       pe.evaluation_form                     as evaForm,
       right(pe.evaluation_form, 3)           as suffix
from employees e
         inner join performance_evaluation pe on e.employee_id = pe.employee_id;

select concat(e.first_name, ' ', e.last_name) as empName,
       pe.rating,
       pe.evaluation_form,
       right(pe.evaluation_form, 3)           as suffix
from performance_evaluation pe
         inner join employees e on pe.employee_id = e.employee_id
where right(pe.evaluation_form, 3) in ('pdf', 'xls');

select right(pe.evaluation_form, 3) as suffix, count(*) as count
from performance_evaluation pe
group by right(pe.evaluation_form, 3);

/* LPAD() */
select lpad('1900', 8, '#');
select lpad('123', 6, '0');
select lpad('123456', 7, '0');

select e.employee_id               as empId,
       lpad(e.employee_id, 5, '0') as fullEmpId
from employees e;

/* RPAD() */
select rpad('123', 5, '#');
select rpad('ABC', 10, '.');
select rpad('ABC', 4, '.');

select concat(rpad(e.first_name, 20, '.'), e.employee_id) as res
from employees e;
