drop table if exists tb_brand;

create table tb_brand
(
    id           int primary key auto_increment,
    brand_name   varchar(50),
    company_name varchar(50),
    ordered      int,
    description  varchar(255),
    status       int

);

insert into tb_brand (brand_name, compan y_name, ordered, description, status)
values ("三只松鼠","三只松鼠有限公司",5,"好吃不上火",0),
       ("华为","华为技术有限公司",100,"华为致力于把数字世界带入每个人、每个家庭、每个组织，构建万物互联的智能世界：让无处不在的联接，成为人人平等的权利，成为智能世界的前提和基础；为世界提供多样性算力，让云无处不在，让智能无所不及；所有的行业和组织，因强大的数字平台而变得敏捷、高效、生机勃勃；通过AI重新定义体验，让消费者在家居、出行、办公、影音娱乐、运动健康等全场景获得极致的个性化智慧体验。",1),
       ("小米","小米技术有限公司",50,"小米是全球领先的智能手机品牌之一，智能手机出货量稳居全球前三。截至2023年6月，全球MIUI月活跃用户6.06亿。同时，小米已经建立起全球领先的消费级AIoT（人工智能和物联网）平台，截至2023年6月30日，小米AIoT平台已连接的IoT设备（不包括智能手机、笔记本电脑及平板）数达到6.55亿。",1),
       ("OPPO","OPPO技术有限公司",65,"OPPO 始终坚持以本分为核心的价值观，致力于打造令人怦然心动的伟大产品。我们坚信，面对外部环境的压力与诱惑，唯有保持平常心态，回归事物的本源，才能做出正确的判断和抉择，实现企业的健康长久。",1);

select * from tb_brand;
