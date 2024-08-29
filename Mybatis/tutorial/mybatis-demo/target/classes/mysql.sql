create
database mybatis;
use
mybatis;

drop table if exists tb_user;

create table tb_user
(
    id       int primary key auto_increment,
    username varchar(20),
    password varchar(20),
    gender   char(1),
    addr     varchar(50)
);

insert into tb_user values (1, "zhangsan", "123456", "男", "北京");
insert into tb_user values (2, "lisi", "123456", "男", "上海");
insert into tb_user values (4, "wangwu", "123456", "男", "广州");