--계정 HR이 보유한 테이블의 리스트들
select*from tab;

--
desc tab;

-- 데이터 조회를 위한 명령 : Select
-- Select {컬럼명,..., *} from 테이블이름 ;
select * from emp; -- 전체출력

-- 사원의 사원 번호와 사원 이름을 출력, 번호와 이름의 순서를 임의로 바꿔 출력가능
select empno, ename, sal from emp; -- 부분출력

-- select 컬럼의 산술연산이 가능: (컬럼과 숫자) 연산, (컬럼과 컬럼) 연산
select empno+sal from emp;
select empno-sal from emp;
select empno, ename, sal, sal*12 from emp;

select sal*comm from emp;

-- 사원의 이름, 직급, 급여, 커미션, 연봉(급여*12), 연봉(급여*12+커미션)
select ename, job, sal, comm, sal*12, sal*12+comm from emp;

-- (중요!)개선: null 값을 0으로 치환해서 연산 { nvl(null인 컬럼,치환값), as ~~~: 별명 }
select ename, job, sal, nvl(comm,0), sal*12, sal*12+nvl(comm,0) as bonusIncluded from emp;

-- 컬럼과 문자열을 붙이는 연산 || 이용
-- sql에서 문자열 표현은 -> ' 작은 따옴표 이용해서 처리
-- , 쉼표는 사용하지 않는다.
select ename || ' is a ' || job from emp;

-- 결과 리스트에서 중복된 값을 하나씩만 출력: distinct
select distinct deptno from emp;

-- 여러 항목에서 distinct를 이용하여 중복된 값 거르고 출력
-- order by (컬럼) -> 행의 정렬
-- order by (컬럼)에 따라 결과 값이 달라진다
select distinct deptno, job from emp order by job;
select distinct deptno, job from emp order by deptno;

-- 특정 데이터 검색 방법 = where 조건절
-- 3000 이상 급여를 받는 사원의 이름, 직업, 급여
select ename, job, sal from emp where sal >= 3000;

commit;