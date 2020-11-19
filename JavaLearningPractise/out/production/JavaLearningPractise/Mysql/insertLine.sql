select
count(case when score between 60 and 70 then 1 end) as 60-70,
count(case when score between 70 and 80 then 1 end) as 70-80,
count(case when score between 80 and 90 then 1 end) as 80-90,
count(case when score between 90 and 100 then 1 end) as 90-100
from student_info;

alter table 'tbname'
add column 'state' integer not null default '0' comment '0为添加1为编辑';

alter table 'tbname'
add column 'state' integer not null default '0' comment '0为添加1为编辑' after 'column_name';

alter table 'tbname'
add column 'state' integer not null default '0' comment '0为添加1为编辑' first;