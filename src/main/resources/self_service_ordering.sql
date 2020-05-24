create database if not exists self_service_ordering;

use self_service_ordering;

drop table if exists user;

create table if not exists user
(
    id       int          not null primary key auto_increment comment '主键自增id',
    name     varchar(255) null comment '用户名',
    phone    varchar(255) null comment '电话',
    password varchar(255) null comment '密码',
    score    int          null comment '积分' comment '积分',
    role_id  int          not null comment '角色，1、用户 2、商家'
) comment '用户';

drop table if exists desk;

create table if not exists desk
(
    id      int          not null primary key auto_increment comment '主键自增id',
    desk_no varchar(255) null comment '编号',
    status  int          not null comment '状态，0、未占用 1、已占用' default 0
) comment '餐桌';


drop table if exists category;

create table if not exists category
(
    id        int          not null primary key auto_increment comment '主键自增id',
    cate_name varchar(255) null comment '种类名称',
    img       varchar(255) null comment '图片'
) comment '菜的种类';

drop table if exists dish;

create table if not exists dish
(
    id       int          not null primary key auto_increment comment '主键自增id',
    cate_id  int          not null comment '种类id',
    size     int          not null comment '分量',
    price    varchar(255) not null comment '单价',
    quantity int          not null comment '数量' default 0
) comment '菜的数量';


drop table if exists activity;

create table if not exists activity
(
    id   int          not null primary key auto_increment comment '主键自增id',
    name varchar(255) null comment '活动名称'
) comment '活动';
drop table if exists score_rule;

create table if not exists score_rule
(
    id        int          not null primary key auto_increment comment '主键自增id',
    rule_name varchar(255) null comment '积分规则',
    use_score int          null comment '消耗积分'
) comment '积分规则';


drop table if exists `order`;
create table if not exists `order`
(
    id          int      not null primary key auto_increment comment '主键自增id',
    user_id     int      null comment '用户id',
    desk_id     int      null comment '餐桌id',
    cate_id     int      null comment '菜品分类id',
    size        int      null comment '分量',
    num         int      null comment '数量',
    price       varchar(255) comment '单价',
    pay_type    int      null comment '支付方式',
    status      int      null comment '支付状态 0、未支付 1、已支付',
    create_time datetime not null comment '下单时间' default current_timestamp
) comment '订单';





