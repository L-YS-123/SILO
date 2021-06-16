--2021-06-16

--DML

-- 테스트 테이블 생성
create table dept01
as
select * from dept where 1=0; -- 조건=에러 -> 틀만 생성


-- 데이터 입력: 행단위 입력
-- insert into 테이블명(컬럼명, 컬럼명2,....) values (데이터값, 데이터값2,....)
--컬럼갯수 = 데이터 갯수
--컬럼의 도메인과 입력데이터의 타입이 일치
--기본키와 같이 not null인 경우 컬럼을 생략하면 안 됨


desc dept01;
drop table dept01;
select * from dept01;

-- 1번부서 개발팀 서울 위치
insert into dept01 
(deptno, dname, loc)
values
(10, '개발팀', '서울')
;

-- 데이터 저장할 컬럼기술을 생략 가능
-- 모든 컬럼의 데이터를 입력할 때
-- values 절의 데이터 순서 -> 테이블이 생성될 때 정의된, 컬럼의 순서
desc dept01;

insert into dept01 values (20, '마켓팅', '부산');




desc emp;

insert into emp (empno, deptno) values (7777,60); -- 오입력
select * from emp;
rollback;

desc orders;

insert into orders (orderid, custid, bookid) values (11, 6, 11); -- 오류


-- 서브쿼리를 이용해서 데이터 입력
drop table dept02;
create table dept02
as select * from dept where 1=0;
select * from dept02;

insert into dept02
select * from dept;



-- 데이터를 변경: 
--update 테이블명 set 컬럼이름 = 새로운데이터, 컬럼이름=... where 행을 선택하는 조건
create table dept03
as select * from dept
;

select * from dept03;

update dept03
set loc = 'SEOUL'
;
-- 모든 값을 변경하므로 where절이 필요 없음

--10번 부서의 위치를 BUSAN으로 이동, 부서이름도 DEV로 변경
update dept03
set loc='BUSAN', dname='DEV'
where deptno = 10
;


--emp01 새롭게 생성하고 update
drop table emp01;
create table emp01
as select * from emp;

select * from emp01;

--모든 사원의 부서번호를 30번으로 수정합시다.
update emp01
set deptno = 30;

-- 이번엔 모든 사원의 급여를 10% 인상시키는 update문
update emp01
set sal = sal*1.1;

-- 모든 사원의 입사일을 오늘로 수정
update emp01
set hiredate = sysdate
;

rollback;
--부서번호가 10번인 사원의 부서번호를 30번으로 수정합시다.
update emp01
set deptno = 30
where deptno = 10
;

--급여가 3000이상인 사원만 급여를 10% 인상하자
update emp01
set sal=sal*1.1
where sal>=3000
;

--1981년에 입사한 사원의 입사일을 오늘로 수정합시다.
update emp01
set hiredate = sysdate
where substr(hiredate, 1, 2) = '81'
;

-- SCOTT 사원의 부서번호는 20번으로, 직급은 MANAGER로 한번에 바꾸자
update emp01
set deptno=30, job='MANAGER'
where ename = 'SCOTT'
;

select * from emp01;

-- SCOTT 사원의 입사일자는 오늘로, 급여를 50으로, 커미션을 4000으로 수정
update emp01
set hiredate=sysdate, sal=50, comm=4000
where ename='SCOTT'
;


--20번 부서의 지역명을
--40번 부서의 지역명으로 변경하기 위해서 서브 쿼리문을 사용해 봅시다
insert into dept01 
select * from dept
;
select * from dept01 ;
select * from dept;

update dept01
set loc = (select from where)
where deptno=40
;


-- 서브쿼리를 이용하여
-- 부서번호가 20인 부서의 부서명과 지역명을
-- 부서번호가 10번인 부서와 동일하게 변경하자
select * from dept01 where deptno=10;
select * from dept01 where deptno=20;

update dept01
set (dname, loc) = (select dname,loc from dept01 where deptno=10)
where deptno=20
;

rollback;


-- 데이터의 삭제: 행단위 삭제
-- delete from 테이블이름 where 조건 

-- dept01 테이블의 모든 데이터를 삭제하자
delete from dept01;
select * from dept01;

-- 이름이 SCOTT인 사원을 삭제하자
delete from emp01 where ename='SCOTT';
select * from emp01;

-- 사원테이블에서 부서명이 sales인 사원을 모두 삭제해봅시다
select deptno from dept where dname='sales';
delete from emp01
where deptno=(deptno from dept where dname='sales')
;