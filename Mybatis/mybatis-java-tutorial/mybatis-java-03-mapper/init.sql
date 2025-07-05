CREATE TABLE Person
(
    id            INT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    name          VARCHAR(50) NOT NULL COMMENT '姓名',
    alias         VARCHAR(100) COMMENT '别名/化名/代号',
    gender        ENUM ('男', '女') COMMENT '性别',
    nationality   VARCHAR(50) COMMENT '民族',
    birth_date    DATE COMMENT '出生日期',
    death_date    DATE COMMENT '去世日期',
    death_place   VARCHAR(100) COMMENT '去世地点',
    burial_place  VARCHAR(100) COMMENT '安葬地点',
    hometown      VARCHAR(100) COMMENT '籍贯',
    occupation    VARCHAR(100) COMMENT '职业/身份',
    `rank`        VARCHAR(100) COMMENT '军衔/职务',
    education     VARCHAR(100) COMMENT '学历/教育经历',
    join_date     DATE COMMENT '参加抗日活动时间',
    achievement   TEXT COMMENT '主要事迹/成就',
    awards        TEXT COMMENT '荣誉/勋章',
    famous_battle VARCHAR(255) COMMENT '著名战役',
    organization  VARCHAR(100) COMMENT '所属组织',
    family        TEXT COMMENT '家庭成员',
    biography     TEXT COMMENT '生平介绍',
    martyr        BOOLEAN COMMENT '是否为烈士',
    photo_url     VARCHAR(255) COMMENT '照片链接',
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
    updated_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='抗日英雄信息表';

INSERT INTO person (name, alias, gender, nationality, birth_date, death_date, death_place, burial_place, hometown,
                    occupation, `rank`, education, join_date, achievement, awards, famous_battle, organization, family,
                    biography, martyr, photo_url)
VALUES ('李大钊', NULL, '男', '汉族', '1889-10-29', '1927-04-28', '北京', '北京西山碧云寺', '河北乐亭', '革命家',
        '中共创始人', '北京大学', '1921-07-01', '中国共产党创始人之一', '无', '五四运动', '中国共产党', '妻子、子女',
        '中国近代革命先驱', TRUE, NULL),
       ('董存瑞', NULL, '男', '汉族', '1929-10-15', '1948-05-25', '河北隆化', '隆化烈士陵园', '河北怀来', '战士',
        '工兵', '小学', '1945-08-01', '舍身炸碉堡', '一级英雄模范', '隆化战役', '中国人民解放军', '父母、兄弟',
        '著名战斗英雄', TRUE, NULL),
       ('佟麟阁', NULL, '男', '汉族', '1892-05-13', '1937-07-28', '北平', '八宝山革命公墓', '河北高阳', '将领', '军长',
        '保定军校', '1931-09-18', '七七事变中英勇牺牲', '抗日英烈', '卢沟桥事变', '国民革命军', '妻子、子女', '抗日名将',
        TRUE, NULL),
       ('赵登禹', NULL, '男', '汉族', '1898-10-06', '1937-07-28', '北平', '八宝山革命公墓', '山东菏泽', '将领', '师长',
        '保定军校', '1931-09-18', '守卫北平英勇牺牲', '抗日英烈', '卢沟桥事变', '国民革命军', '妻子、子女', '抗日名将',
        TRUE, NULL),
       ('马本斋', NULL, '男', '回族', '1901-01-01', '1944-02-07', '延安', '延安烈士陵园', '河北献县', '八路军旅长',
        '旅长', '私塾', '1937-07-07', '回民支队领导人', '民族团结奖', '百团大战', '八路军', '母亲、妻子',
        '著名回族抗日英雄', TRUE, NULL),
       ('谢晋元', NULL, '男', '汉族', '1905-04-26', '1941-04-24', '上海', '上海四行仓库', '广东蕉岭', '军官', '团长',
        '黄埔军校', '1932-01-28', '四行仓库保卫战', '抗战英雄', '四行仓库保卫战', '国民革命军', '妻子、子女',
        '八百壮士领袖', TRUE, NULL),
       ('杨根思', NULL, '男', '汉族', '1922-11-26', '1950-12-29', '朝鲜', '江苏泰兴', '江苏泰兴', '连长', '连长',
        '小学', '1944-01-01', '三不怕精神', '一级英雄', '长津湖战役', '中国人民志愿军', '父母、兄弟', '著名战斗英雄',
        TRUE, NULL),
       ('王二小', NULL, '男', '汉族', '1932-01-01', '1942-10-25', '河北涞源', '涞源烈士陵园', '河北涞源', '儿童团员',
        NULL, '小学', '1940-01-01', '带敌入伏英勇牺牲', '少年英雄', '涞源伏击战', '八路军', '父母', '少年抗日英雄',
        TRUE, NULL),
       ('彭雪枫', NULL, '男', '汉族', '1907-09-09', '1944-09-11', '河南商丘', '商丘烈士陵园', '河南镇平', '新四军将领',
        '师长', '黄埔军校', '1937-07-07', '新四军名将', '抗战英烈', '豫东战役', '新四军', '妻子、子女', '新四军著名将领',
        TRUE, NULL),
       ('赵一曼', '李一超', '女', '汉族', '1905-10-25', '1936-08-02', '哈尔滨', '哈尔滨烈士陵园', '四川宜宾',
        '抗日女英雄', '政委', '北京女子师范大学', '1932-01-01', '英勇抗日', '三八红旗手', '哈尔滨保卫战', '东北抗联',
        '父母、儿子', '著名抗日女英雄', TRUE, NULL),
       ('杨靖宇', NULL, '男', '汉族', '1905-02-26', '1940-02-23', '濛江县', '靖宇县烈士陵园', '河南确山', '抗日将领',
        '总司令', '黄埔军校', '1931-09-18', '领导东北抗联', '八一勋章', '松花江战役', '东北抗联', '妻子、子女',
        '著名抗日民族英雄', TRUE, NULL),
       ('左权', NULL, '男', '汉族', '1905-03-15', '1942-05-25', '山西辽县', '左权县烈士陵园', '湖南醴陵',
        '八路军副参谋长', '副参谋长', '黄埔军校', '1937-07-07', '指挥百团大战', '独立自由勋章', '百团大战', '八路军',
        '妻子、女儿', '八路军高级将领', TRUE, NULL),
       ('赵尚志', NULL, '男', '汉族', '1908-04-22', '1942-02-12', '黑龙江', '哈尔滨烈士陵园', '辽宁朝阳', '抗联将领',
        '司令员', '东北讲武堂', '1932-01-01', '东北抗联领导人', '抗战英烈', '黑龙江抗战', '东北抗联', '妻子、子女',
        '东北抗日英雄', TRUE, NULL),
       ('吉鸿昌', NULL, '男', '汉族', '1895-10-18', '1934-11-24', '开封', '开封烈士陵园', '河南扶沟', '将领', '师长',
        '保定军校', '1927-08-01', '誓死抗日', '抗战英烈', '豫东战役', '国民革命军', '妻子、子女', '著名抗日将领', TRUE,
        NULL),
       ('杨虎城', NULL, '男', '汉族', '1893-11-26', '1949-09-06', '南京', '西安烈士陵园', '陕西西安', '将领',
        '十七路军总指挥', '保定军校', '1926-03-12', '西安事变主角', '抗战英烈', '西安事变', '国民革命军', '妻子、子女',
        '著名抗日将领', TRUE, NULL),
       ('马占山', NULL, '男', '汉族', '1885-11-30', '1950-11-29', '北京', '八宝山革命公墓', '黑龙江通河县', '将领',
        '省主席', '奉天讲武堂', '1931-09-19', '江桥抗战', '抗战英烈', '江桥抗战', '东北军', '妻子、子女', '著名抗日将领',
        TRUE, NULL),
       ('佟麟阁', NULL, '男', '汉族', '1892-05-13', '1937-07-28', '北平', '八宝山革命公墓', '河北高阳', '将领', '军长',
        '保定军校', '1931-09-18', '七七事变中英勇牺牲', '抗日英烈', '卢沟桥事变', '国民革命军', '妻子、子女', '抗日名将',
        TRUE, NULL),
       ('赵登禹', NULL, '男', '汉族', '1898-10-06', '1937-07-28', '北平', '八宝山革命公墓', '山东菏泽', '将领', '师长',
        '保定军校', '1931-09-18', '守卫北平英勇牺牲', '抗日英烈', '卢沟桥事变', '国民革命军', '妻子、子女', '抗日名将',
        TRUE, NULL),
       ('马本斋', NULL, '男', '回族', '1901-01-01', '1944-02-07', '延安', '延安烈士陵园', '河北献县', '八路军旅长',
        '旅长', '私塾', '1937-07-07', '回民支队领导人', '民族团结奖', '百团大战', '八路军', '母亲、妻子',
        '著名回族抗日英雄', TRUE, NULL),
       ('谢晋元', NULL, '男', '汉族', '1905-04-26', '1941-04-24', '上海', '上海四行仓库', '广东蕉岭', '军官', '团长',
        '黄埔军校', '1932-01-28', '四行仓库保卫战', '抗战英雄', '四行仓库保卫战', '国民革命军', '妻子、子女',
        '八百壮士领袖', TRUE, NULL);

create table author
(
    `id`       int unsigned primary key auto_increment,
    `username` varchar(255),
    `password` varchar(255),
    `email`    varchar(255),
    `bio`      varchar(255)
);

alter table author
    add name varchar(256);

alter table author
    add favourite_section varchar(512);

select *
from author;
create table tb_user
(
    `id`             int unsigned primary key auto_increment,
    `user_id`        int unsigned not null,
    `user_name`      varchar(50)  not null,
    `user_avatar`    varchar(512) not null,
    `user_pass_word` varchar(32)  not null,
    `create_time`    datetime     not null default CURRENT_TIMESTAMP,
    `update_time`    datetime     not null default CURRENT_TIMESTAMP
);


-- 插入30条用户测试数据
INSERT INTO tb_user (user_id, user_name, user_avatar, user_pass_word)
VALUES (1001, '张三', 'https://example.com/avatars/zhangsan.jpg', 'e10adc3949ba59abbe56e057f20f883e'),
       (1002, '李四', 'https://example.com/avatars/lisi.png', 'e10adc3949ba59abbe56e057f20f883e'),
       (1003, '王五', 'https://example.com/avatars/wangwu.gif', 'e10adc3949ba59abbe56e057f20f883e'),
       (1004, '赵六', 'https://example.com/avatars/zhaoliu.jpg', 'e10adc3949ba59abbe56e057f20f883e'),
       (1005, '钱七', 'https://example.com/avatars/qianqi.png', 'e10adc3949ba59abbe56e057f20f883e'),
       (1006, '孙八', 'https://example.com/avatars/sunba.jpg', 'e10adc3949ba59abbe56e057f20f883e'),
       (1007, '周九', 'https://example.com/avatars/zhoujiu.gif', 'e10adc3949ba59abbe56e057f20f883e'),
       (1008, '吴十', 'https://example.com/avatars/wushi.png', 'e10adc3949ba59abbe56e057f20f883e'),
       (1009, '郑十一', 'https://example.com/avatars/zhengshiyi.jpg', 'e10adc3949ba59abbe56e057f20f883e'),
       (1010, '王十二', 'https://example.com/avatars/wangshier.gif', 'e10adc3949ba59abbe56e057f20f883e'),
       (1011, '冯十三', 'https://example.com/avatars/fengshisan.png', 'e10adc3949ba59abbe56e057f20f883e'),
       (1012, '陈十四', 'https://example.com/avatars/chenshisi.jpg', 'e10adc3949ba59abbe56e057f20f883e'),
       (1013, '褚十五', 'https://example.com/avatars/chushiwu.gif', 'e10adc3949ba59abbe56e057f20f883e'),
       (1014, '卫十六', 'https://example.com/avatars/weishiliu.png', 'e10adc3949ba59abbe56e057f20f883e'),
       (1015, '蒋十七', 'https://example.com/avatars/jiangshiqi.jpg', 'e10adc3949ba59abbe56e057f20f883e'),
       (1016, '沈十八', 'https://example.com/avatars/shenshiba.gif', 'e10adc3949ba59abbe56e057f20f883e'),
       (1017, '韩十九', 'https://example.com/avatars/hanshijiu.png', 'e10adc3949ba59abbe56e057f20f883e'),
       (1018, '杨二十', 'https://example.com/avatars/yangershi.jpg', 'e10adc3949ba59abbe56e057f20f883e'),
       (1019, '朱二一', 'https://example.com/avatars/zhueryi.gif', 'e10adc3949ba59abbe56e057f20f883e'),
       (1020, '秦二二', 'https://example.com/avatars/qinerer.png', 'e10adc3949ba59abbe56e057f20f883e'),
       (1021, '尤二三', 'https://example.com/avatars/youersan.jpg', 'e10adc3949ba59abbe56e057f20f883e'),
       (1022, '许二四', 'https://example.com/avatars/xuersi.gif', 'e10adc3949ba59abbe56e057f20f883e'),
       (1023, '何二五', 'https://example.com/avatars/heerwu.png', 'e10adc3949ba59abbe56e057f20f883e'),
       (1024, '吕二六', 'https://example.com/avatars/lverliu.jpg', 'e10adc3949ba59abbe56e057f20f883e'),
       (1025, '施二七', 'https://example.com/avatars/shierqi.gif', 'e10adc3949ba59abbe56e057f20f883e'),
       (1026, '张二八', 'https://example.com/avatars/zhangerba.png', 'e10adc3949ba59abbe56e057f20f883e'),
       (1027, '孔二九', 'https://example.com/avatars/kongerjiu.jpg', 'e10adc3949ba59abbe56e057f20f883e'),
       (1028, '曹三十', 'https://example.com/avatars/caosanshi.gif', 'e10adc3949ba59abbe56e057f20f883e'),
       (1029, '严三一', 'https://example.com/avatars/yansanyi.png', 'e10adc3949ba59abbe56e057f20f883e'),
       (1030, '华三二', 'https://example.com/avatars/huasaneer.jpg', 'e10adc3949ba59abbe56e057f20f883e');

-- 作者表
create table tb_author
(
    `id`                int unsigned primary key auto_increment,
    `username`          varchar(255),
    `password`          varchar(255),
    `email`             varchar(255),
    `bio`               varchar(255),
    `favourite_section` varchar(512)
);

-- 发布表
create table tb_post
(
    `id`           int unsigned primary key auto_increment,
    `tb_blog_id `  int unsigned,
    `tb_author_id` int unsigned,
    `created_on`   datetime,
    `section`      varchar(500),
    `subject`      varchar(500),
    `draft`        varchar(500),
    `body`         varchar(2000)
);

-- 插入30条帖子测试数据
INSERT INTO tb_post (`tb_blog_id`, tb_author_id, created_on, section, subject, draft, body)
VALUES (1, 1001, '2023-01-01 10:00:00', '技术', 'MyBatis入门教程', '否',
        'MyBatis是一个优秀的持久层框架，它支持自定义SQL、存储过程以及高级映射。本文将详细介绍MyBatis的基本使用方法。'),
       (2, 1002, '2023-01-02 11:00:00', '生活', '春天的美好时光', '否',
        '春天来了，万物复苏。今天去公园散步，看到了很多美丽的花朵，心情特别好。春天真是一个让人心情愉悦的季节。'),
       (3, 1003, '2023-01-03 12:00:00', '美食', '家常菜制作技巧', '否',
        '今天分享几道家常菜的制作方法，包括红烧肉、糖醋里脊和麻婆豆腐。这些菜都很容易上手，味道也很不错。'),
       (4, 1004, '2023-01-04 13:00:00', '科技', '人工智能发展趋势', '否',
        '人工智能技术正在快速发展，从机器学习到深度学习，再到现在的生成式AI，技术更新迭代非常快。'),
       (5, 1005, '2023-01-05 14:00:00', '旅游', '云南大理游记', '否',
        '大理是一个美丽的地方，有苍山洱海，有古城文化。这次旅行让我深深感受到了云南的魅力。'),
       (6, 1006, '2023-01-06 15:00:00', '教育', '学习方法分享', '否',
        '好的学习方法能事半功倍，本文分享一些实用的学习技巧，希望能帮助大家提高学习效率。'),
       (7, 1007, '2023-01-07 16:00:00', '健康', '健康生活方式', '否',
        '健康是人生最重要的财富，本文介绍一些健康的生活方式，包括饮食、运动和作息等方面。'),
       (8, 1008, '2023-01-08 17:00:00', '音乐', '古典音乐欣赏', '否',
        '古典音乐有着深厚的文化底蕴，本文推荐几首经典的古典音乐作品，希望大家能够喜欢。'),
       (9, 1009, '2023-01-09 18:00:00', '电影', '2023年值得看的电影', '否',
        '2023年有很多优秀的电影作品，本文推荐几部我个人认为很值得一看的电影。'),
       (10, 1010, '2023-01-10 19:00:00', '读书', '好书推荐', '否',
        '读书能开阔视野，增长知识。本文推荐几本我认为很有价值的书籍，涵盖不同领域。'),
       (11, 1011, '2023-01-11 20:00:00', '运动', '健身计划制定', '否',
        '制定合理的健身计划对于保持身体健康很重要，本文分享如何制定适合自己的健身计划。'),
       (12, 1012, '2023-01-12 21:00:00', '摄影', '摄影技巧分享', '否',
        '摄影是一门艺术，需要技巧和创意。本文分享一些实用的摄影技巧，希望能帮助摄影爱好者。'),
       (13, 1013, '2023-01-13 22:00:00', '编程', 'Java开发技巧', '否',
        'Java是一门非常流行的编程语言，本文分享一些Java开发中的实用技巧和最佳实践。'),
       (14, 1014, '2023-01-14 23:00:00', '园艺', '家庭园艺指南', '否',
        '在家里种植一些植物不仅能美化环境，还能净化空气。本文介绍一些适合家庭种植的植物。'),
       (15, 1015, '2023-01-15 00:00:00', '手工', 'DIY手工制作', '否',
        '手工制作不仅能锻炼动手能力，还能制作出独特的作品。本文分享几个简单的手工制作项目。'),
       (16, 1016, '2023-01-16 01:00:00', '理财', '个人理财规划', '否',
        '合理的理财规划对于个人财务健康很重要，本文介绍一些基本的理财知识和规划方法。'),
       (17, 1017, '2023-01-17 02:00:00', '宠物', '宠物护理指南', '否',
        '养宠物需要很多耐心和爱心，本文介绍一些宠物护理的基本知识和注意事项。'),
       (18, 1018, '2023-01-18 03:00:00', '时尚', '穿搭技巧分享', '否',
        '合适的穿搭能提升个人形象，本文分享一些实用的穿搭技巧和搭配建议。'),
       (19, 1019, '2023-01-19 04:00:00', '游戏', '游戏攻略分享', '否',
        '游戏不仅能娱乐，还能锻炼思维。本文分享一些热门游戏的攻略和技巧。'),
       (20, 1020, '2023-01-20 05:00:00', '历史', '历史人物故事', '否',
        '历史是一面镜子，能让我们了解过去，思考现在。本文分享一些历史人物的故事。'),
       (21, 1021, '2023-01-21 06:00:00', '科学', '科学知识普及', '否',
        '科学知识能帮助我们更好地理解世界，本文分享一些有趣的科学知识。'),
       (22, 1022, '2023-01-22 07:00:00', '心理', '心理健康维护', '否',
        '心理健康和身体健康同样重要，本文介绍一些维护心理健康的方法。'),
       (23, 1023, '2023-01-23 08:00:00', '环保', '环保生活实践', '否',
        '环保是每个人的责任，本文分享一些在日常生活中实践环保的方法。'),
       (24, 1024, '2023-01-24 09:00:00', '创业', '创业经验分享', '否',
        '创业是一条充满挑战的道路，本文分享一些创业过程中的经验和教训。'),
       (25, 1025, '2023-01-25 10:00:00', '职场', '职场技能提升', '否',
        '在职场中，技能提升很重要，本文分享一些提升职场技能的方法和技巧。'),
       (26, 1026, '2023-01-26 11:00:00', '语言', '英语学习心得', '否',
        '英语是一门重要的国际语言，本文分享一些英语学习的心得和方法。'),
       (27, 1027, '2023-01-27 12:00:00', '艺术', '艺术欣赏指南', '否',
        '艺术能陶冶情操，提升审美，本文介绍一些艺术欣赏的方法和技巧。'),
       (28, 1028, '2023-01-28 13:00:00', '哲学', '哲学思考随笔', '否',
        '哲学能帮助我们思考人生的意义，本文分享一些哲学思考的心得。'),
       (29, 1029, '2023-01-29 14:00:00', '社会', '社会现象观察', '否',
        '观察社会现象能帮助我们更好地理解社会，本文分享一些对社会现象的观察和思考。'),
       (30, 1030, '2023-01-30 15:00:00', '未来', '未来科技展望', '否',
        '科技发展日新月异，本文展望一下未来科技的发展趋势和可能的影响。');

-- comment 表
create table tb_comment
(
    `id`         int unsigned primary key auto_increment,
    `tb_post_id` int unsigned,
    `name`       varchar(50),
    `comment`    varchar(500)
);

-- 插入30条评论测试数据
INSERT INTO tb_comment (tb_post_id, name, comment)
VALUES (1, '张三', '这篇文章写得很详细，很有帮助。'),
       (2, '李四', '春天真的很美，我也去公园散步了。'),
       (3, '王五', '红烧肉真的很好吃，我下次也要试试。'),
       (4, '赵六', '人工智能的发展真是太快了，我需要学习更多知识。'),
       (5, '钱七', '云南大理真的很美，我下次也要去。'),
       (6, '孙八', '学习方法很重要，我需要改进一下。'),
       (7, '周九', '健康的生活方式很重要，我需要多运动。'),
       (8, '吴十', '古典音乐真的很美，我需要多欣赏。'),
       (9, '郑十一', '2023年有很多优秀的电影，我需要多看一些。');


-- tag 表
create table tb_tag
(
    `id`   int unsigned primary key auto_increment,
    `name` varchar(50)
);

-- blog tag 中间表
create table tb_post_tag
(
    `tb_post_id` int unsigned not null,
    `tb_tag_id`  int unsigned not null,
    constraint primary key (tb_post_id, tb_tag_id)
);

drop table tb_blog;
-- 博客表
create table tb_blog
(
    `id`           int unsigned primary key auto_increment,
    `title`        varchar(50)  not null,
    `tb_author_id` int,
    `content`      varchar(255) not null default '',
    `state`        varchar(20)  not null default '草稿'
);

-- 往表中插入数据50条, 要求使用有意义的数据
INSERT INTO tb_blog (title, tb_author_id, content, state)
VALUES ('Java编程入门指南', '张三', '学习Java的基础语法和面向对象编程思想。', '发布'),
       ('深入理解MyBatis框架', '李四', '解析MyBatis的工作原理与配置方式。', '发布'),
       ('Spring Boot实战教程', '王五', '掌握如何使用Spring Boot构建现代化的Web应用。', '发布'),
       ('前端开发基础概述', '赵六', '了解HTML、CSS和JavaScript的基本用法。', '草稿'),
       ('数据库优化技巧分享', '陈七', '讲解SQL优化与索引使用的最佳实践。', '草稿'),
       ('微服务架构设计模式', '张三', '探讨基于Spring Cloud的微服务架构实现。', '发布'),
       ('Git版本控制详解', '李四', '介绍Git常用命令与团队协作的最佳实践。', '发布'),
       ('Docker容器化部署指南', '王五', '学习如何使用Docker进行应用打包和部署。', '发布'),
       ('RESTful API设计规范', '赵六', '掌握RESTful风格API的设计原则与示例。', '草稿'),
       ('高并发系统设计思路', '陈七', '分析高并发场景下的系统架构与性能优化策略。', '草稿'),
       ('深入理解JVM内存模型', '张三', '解析JVM的堆栈结构与垃圾回收机制。', '发布'),
       ('Java并发编程实战', '李四', '学习多线程编程与线程池的应用技巧。', '发布'),
       ('Redis缓存技术详解', '王五', '掌握Redis的基本命令与应用场景。', '发布'),
       ('消息队列Kafka入门', '赵六', '了解Kafka的基本概念与简单使用方法。', '草稿'),
       ('Elasticsearch搜索引擎实战', '陈七', '学习如何使用Elasticsearch进行全文检索。', '草稿'),
       ('Spring Security权限控制详解', '张三', '掌握Spring Security在Web项目中的安全控制。', '发布'),
       ('Vue.js前端框架快速上手', '李四', '学习Vue.js的基础语法与组件化开发。', '发布'),
       ('TypeScript编程语言介绍', '王五', '了解TypeScript的类型系统与高级特性。', '发布'),
       ('HTTP协议详解与优化', '赵六', '掌握HTTP协议的工作原理与性能优化技巧。', '草稿'),
       ('持续集成与持续交付(CI/CD)', '陈七', '学习Jenkins等工具在自动化部署中的应用。', '草稿'),

       ('Spring Boot整合MyBatis实战', '张三', '演示如何将Spring Boot与MyBatis结合使用。', '发布'),
       ('Spring AOP面向切面编程', '李四', '掌握AOP的概念与实际应用。', '发布'),
       ('Java设计模式详解', '王五', '学习常见的设计模式及其使用场景。', '发布'),
       ('分布式事务解决方案', '赵六', '分析分布式系统中的事务一致性问题。', '草稿'),
       ('Kubernetes容器编排平台介绍', '陈七', '了解Kubernetes的核心概念与架构。', '草稿'),
       ('Maven依赖管理详解', '张三', '掌握Maven在Java项目中的依赖管理和构建流程。', '发布'),
       ('前端工程化实践指南', '李四', '学习前端项目的模块化开发与构建工具使用。', '发布'),
       ('Python数据分析入门', '王五', '掌握Python中Pandas库的基本用法。', '发布'),
       ('Node.js后端开发实战', '赵六', '学习如何使用Node.js搭建后端服务。', '草稿'),
       ('大数据处理框架Hadoop介绍', '陈七', '了解Hadoop生态系统及其核心组件。', '草稿'),

       ('React前端框架深入理解', '张三', '掌握React的状态管理和组件通信方式。', '发布'),
       ('Go语言编程入门', '李四', '学习Go语言的基本语法与并发模型。', '发布'),
       ('MySQL性能调优实战', '王五', '掌握MySQL查询优化与索引调整技巧。', '发布'),
       ('网络编程与Socket通信', '赵六', '学习TCP/IP协议及Socket编程实现。', '草稿'),
       ('敏捷开发与Scrum实践', '陈七', '了解敏捷开发的基本流程与Scrum框架的应用。', '草稿'),
       ('DevOps理念与实践', '张三', '掌握DevOps文化与相关工具链的使用。', '发布'),
       ('代码质量保障与单元测试', '李四', '学习JUnit等工具在Java项目中的测试实践。', '发布'),
       ('软件架构设计原则与模式', '王五', '了解常见的软件架构设计模式与适用场景。', '发布'),
       ('前后端分离开发模式探讨', '赵六', '分析前后端分离的优势与实现方案。', '草稿'),
       ('日志收集与监控体系构建', '陈七', '学习ELK等日志收集与分析工具的使用。', '草稿'),

       ('Java虚拟机性能调优', '张三', '深入了解JVM调优技巧与GC策略优化。', '发布'),
       ('微服务注册中心与配置中心实践', '李四', '学习Nacos或Consul在微服务中的应用。', '发布'),
       ('区块链技术入门与应用', '王五', '了解区块链的基本原理与典型应用场景。', '发布'),
       ('AI与机器学习简介', '赵六', '学习机器学习的基本概念与算法分类。', '草稿'),
       ('低代码平台发展趋势', '陈七', '分析低代码开发平台对传统开发的影响。', '草稿'),
       ('云原生架构设计理念', '张三', '掌握云原生应用程序的设计原则。', '发布'),
       ('服务网格(Service Mesh)详解', '李四', '学习Istio等Service Mesh工具的核心功能。', '发布'),
       ('前端性能优化技巧', '王五', '掌握前端页面加载速度优化的方法。', '发布'),
       ('网络安全基础与防护策略', '赵六', '了解常见攻击手段与防御措施。', '草稿'),
       ('数据可视化工具Tableau入门', '陈七', '学习Tableau的基本操作与图表制作方法。', '草稿');

-- 博客表
select *
from tb_blog;

-- 发布表
select *
from tb_post;

-- 评论表
select *
from tb_comment;

-- 发布表-标签表 连接表
select *
from tb_post_tag;

-- 标签表
select *
from tb_tag;

select B.id                as blog_id,
       B.title             as blog_title,
       B.tb_author_id         as blog_author_id,
       A.id                as author_id,
       A.username          as author_username,
       A.password          as author_password,
       A.email             as author_email,
       A.bio               as author_bio,
       A.favourite_section as author_favourite_section,
       P.id                as post_id,
       P.tb_blog_id           as post_blog_id,
       P.tb_author_id         as post_author_id,
       P.created_on        as post_created_on,
       P.section           as post_section,
       P.subject           as post_subject,
       P.draft             as draft,
       P.body              as post_body,
       C.id                as comment_id,
       C.tb_post_id           as comment_post_id,
       C.name              as comment_name,
       C.comment           as comment_text,
       T.id                as tag_id,
       T.name              as tag_name
from tb_blog B
         left outer join tb_author A on B.tb_author_id = A.id
         left outer join tb_post P on B.id = P.tb_blog_id
         left outer join tb_comment C on P.id = C.tb_post_id
         left outer join tb_post_tag PT on PT.tb_post_id = P.id
         left outer join tb_tag T on PT.tb_tag_id = T.id
where B.id = 1;