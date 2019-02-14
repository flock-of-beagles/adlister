
create table categories
(
  id int unsigned not null auto_increment,
  ad_id int unsigned not null,
  category varchar(25),
  primary key (id),
  foreign key (ad_id) references ads (id)
)