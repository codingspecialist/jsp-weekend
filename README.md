## 블로그 프로젝트

### 데이터베이스 테이블 스키마

```sql
CREATE TABLE user(
	id int primary key auto_increment,
    username varchar(100) not null unique,
    password varchar(100) not null,
    email varchar(100) not null,
    address varchar(100) not null,
    createDate timestamp
) engine=InnoDB default charset=utf8;

CREATE TABLE post(
	id int primary key auto_increment,
    userId int,
    title varchar(100) not null,
    content longtext,
    readCount int,
    createDate timestamp,
    foreign key (userId) references user (id)
) engine=InnoDB default charset=utf8;

CREATE TABLE comment(
	id int primary key auto_increment,
    userId int,
    postId int,
    content varchar(300) not null,
    createDate timestamp,
    foreign key (userId) references user (id) on delete set null,
    foreign key (postId) references post (id) on delete cascade
) engine=InnoDB default charset=utf8;

```