/*
 comparison function
 COALESCE() 返回参数列表中的第一个非空参数。
 DECODE() 向 SQL 查询添加过程化的 if-then-else 逻辑。
 NULLIF() 相等则返回 null，否则返回第一个表达式。
 */

select decode(1, 2, 'Equal');

SELECT DECODE(1, 1, 'Equal');

SELECT employee_id,
       first_name,
       last_name,
       salary
FROM employees
ORDER BY DECODE('S', 'F', first_name, 'L', last_name, 'S', salary);

select nullif(1, 2);
select nullif(2, 2);
select coalesce(null, null, 3);

