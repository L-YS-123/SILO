--2021-06-15

--DDL(Data Definition Language)

--table 생성 : create table

--table 수정 : alter table

--table 삭제 : drop table


-- create table (
--        컬럼이름 타입(사이즈),
--         ...... ,
--          제약조건 정의
--        )


--지금까지 실습에 사용했던 사원 테이블과 유사한 구조의 사원번호, 사원이름, 급여 3개의 칼럼으로 구성된 EMP01 테이블을 생성해 봅시다.
create table emp01 (
empno number(4),
ename varchar2(10),
sal number(6,2)
);


--서브 쿼리를 이용해서 기존 테이블의 구조를 복사하고 해당 튜플도 복사
--데이터 내용은 가져오나 '제약조건'은 가져오지 '않는다'
--데이터 백업 목적으로 주로 사용
create table emp02
as
select * from emp
;

select * from emp02
;

-- 컬럼의 일부만 복사 가능
create table emp03
as
select empno, ename, sal from emp
;

--조건 처리도 가능
create table emp04
as
select * from emp where deptno=30
;

--테이블만 가져오기
create table emp05
as
select * from emp where 1=2 --false값 -> 모든행에 대해서 false값을 가지게 됨
--테이블 구조만 가져오게 됨
;






-- 테이블의 변경은 alter table
-- alter table (테이블 이름) add()
-- alter table (테이블 이름) modify() -- 수정
-- alter table (테이블 이름) drop()

--emp01 테이블에 job 컬럼을 추가해보자
alter table emp01 
add( job varchar2(9) )
;
desc emp01;

-- emp01 테이블의 job 칼럼의 사이즈를 수정 0->30
alter table emp01
modify (job varchar2(30)) --job을 바꾸고 싶다
;

-- emp01 테이블의 job 컬럼을 삭제
alter table emp01
drop column job
;

-- 테이블 삭제
drop table emp06;
drop table emp02;


--emp02 생성
create table emp02
as
select * from emp
;

--모든 행을 삭제하는 truncate
--데이터만 지워진다
--*롤백이 안 된다(커밋이 자동으로 실행)*
--조심해서 사용해야 함
truncate table emp02;

--테이블의 이름 변경 -> rename 현재이름 to 새로운이름
rename emp01 to test
;
desc emp01;
desc test;