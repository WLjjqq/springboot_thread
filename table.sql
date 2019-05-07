create table alarm
(
  alarm_id      int auto_increment
    primary key,
  created       datetime     not null
  comment '报警时间',
  principal     varchar(20)  not null
  comment '报警负责人',
  supplier_name varchar(100) not null
  comment '报警关联供应商',
  order_no      varchar(30)  not null
  comment '报警关联订单-订单号',
  order_row_no  varchar(30)  not null
  comment '报警关联订单-订单行项目号',
  technics      varchar(30)  not null
  comment '报警详细信息-工艺大类',
  min           double       not null
  comment '报警详细信息-参数上限',
  max           double       not null
  comment '报警详细信息-参数下限',
  value         double       not null
  comment '报警详细信息-报警实测值',
  duration      int          null
  comment '报警详细信息-报警持续时间(s)'
)
  comment '报警信息
';



create table dailyreport
(
  daily_id      int auto_increment
    primary key,
  title         varchar(50)  not null
  comment '日报标题',
  summary       varchar(200) not null
  comment '日报概述信息',
  supplier_name varchar(100) not null
  comment '供应商名称'
)
  comment '日报信息';