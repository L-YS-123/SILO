--2021-06-16

--1. phoneInfo_basic 테이블의 SELECT, UPDATE, DELETE, INSERT 하는 SQL
desc phoneinfo_basic;

insert into phoneinfo_basic (idx, fr_name, fr_phonenumber, fr_address, fr_email, fr_regdate)
values (1,'손흥민','111-1111-1111','서울', 'bbb@bbb.com' ,sysdate)
;

select * from phoneinfo_basic;

insert into phoneinfo_basic
values (2,'차범근','222-2222-2222', 'aaa@aaa.com', '인천' ,'21/06/15')
;

insert into phoneinfo_basic
(idx, fr_name, fr_phonenumber)
values
(3, '박지성', '333-3333-3333')
;


select * from phoneinfo_basic;

update phoneinfo_basic
set fr_address = '수원', fr_email = 'aaa@aaa.com'
where idx=2
;

commit;

delete 
from phoneinfo_basic
;


--2. phoneinfo_univ 테이블의 SELECT, UPDATE, DELETE, INSERT 하는 SQL
insert into phoneinfo_univ
(idx, fr_u_major, fr_u_year, fr_ref)
values
(1, '컴퓨터과학', 1, 1)
;

update phoneinfo_univ
set fr_u_major = '재료공학'
where idx = 1
;

select * from phoneinfo_univ;

delete from phoneinfo_univ
where fr_u_year = 1
;

commit;



--3. phoneinfo_com 테이블의 SELECT, UPDATE, DELETE, INSERT 하는 SQL
insert into phoneinfo_com
values
(1, '비트캠프', 2)
;

commit;

select * from phoneinfo_com;

update phoneinfo_com
set fr_c_company = '현대자동차'
where idx=1
;

delete from phoneinfo_com
where fr_ref = 2
;
