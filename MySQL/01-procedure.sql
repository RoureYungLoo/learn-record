-- 存储过程 stored procedure
show databases;

use randolflu;


delimiter //
-- 创建存储过程
create procedure proName(in param_in int)
begin
    declare i int;
    set i = 0;
    repeat
        insert into items(id) values (default);
        set i = i + 1;
    until i >= param_in end repeat;
end;
//

delimiter ;
call proName(10);

SELECT * FROM items;