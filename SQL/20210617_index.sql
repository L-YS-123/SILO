--2021-06-17

--인덱스: 검색을 빠르게 하기 위한 객체
--물리적인 저장 공간이 필요
--생성 시간이 필요
--많은 인덱스는 dml 작업이 많은 경우 성능저하가 온다


--emp01 테이블을 복사 -> 로우들을 계속 복사
drop table emp01;

create table emp01
as 
select * from emp;

select * from emp01;


insert into emp01
select * from emp01;


insert into emp01
(empno, ename)
values
(7777, 'KING')
;

insert into emp01
(empno, ename)
values
(7777, 'SON')
;


select * from emp01 where ename='SON' ; --인덱스 설정 이전에 검색이 오래걸림: 4초 정도
                                        --인덱스 설정 이후에 0.006초 정도로 검색이 매우 빨라짐


--emp01 테이블의 ename컬럼을 index로 설정
create index index_emp01_ename
on emp01(ename)
;