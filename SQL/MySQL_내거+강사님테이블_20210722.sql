create table project.member (
id varchar(20),
pw varchar(20),
name varchar(15),
regdate date
);

insert into member (id, pw, name) values ('aaa', 'bbb', 'ccc');

SELECT * FROM project.member;




drop table if exists project.member;

create table project.member (
	idx int auto_increment,
    memberid varchar(14) not null,
    password varchar(20) not null,
    membername varchar(20) not null,
    memberphoto varchar(50) default 'photo.png',
    regdate timestamp default current_timestamp,
    constraint member_idx_pk primary key (idx),
    constraint member_memberid_uq unique (memberid)        
);

-- Select
select * from project.member;
select * from project.member where idx=1;


-- insert
INSERT INTO project.member
(memberid, password, membername)
VALUES
('cool', '1111', 'COOL');

-- update
update project.member
set
password='0000', membername='tester'
where idx=1
;

-- Delete
delete from project.member where idx=1;

