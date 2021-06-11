--2021.06.11

--그룹함수
--'여러행'을 묶어 처리하는 함수
-- sum, avg, count, max, min

-- 사원 테이블에서 
--1. 사원의 수
--2. 급여의 총합
--3. 급여 평균
--4. 최대 급여
--5. 최소 급여

select 
    count(*) as "사원의 수", -- 사원의 수를 셀 때 특정컬럼으로 하지 말고 전체를 출력(수 오류 없게)
    sum(sal) as "급여의 총합",
    round(avg(sal), 2) as "급여 평균",
    max(sal) as "최대 급여",
    min(sal) as "최소 급여",
    sum(comm) as "커미션의 총합", --그룹함수는 null값을 제외하고 연산
    avg(comm) as "커미션의 평균",
    count(comm) as "커미션 받는 사원의 수"
from emp;

--distinct 이용해서 중복된 개수 제거
select count(job)
from emp;

select distinct job
from emp;

select count(distinct job)
from emp;

-- 마당서적 book 테이블에 책을 납품하는 출판사
select count(distinct publisher)
from book
order by publisher;


-- group by
-- 특정 컬럼을 이용해서 그룹핑하기

-- select 칼럼명, 그룹함수 
-- from 테이블
-- where 조건
-- group by 그룹핑할 기준컬럼;

-- 부서별 급여 평균을 구해보자
select avg(sal) from emp where deptno=10;
select avg(sal) from emp where deptno=20;
select avg(sal) from emp where deptno=30;

select 
    deptno, 
    count(*), 
    sum(sal) as "부서별 급여총합", 
    round(avg(sal),2) as "부서별 급여평균", 
    max(sal) as "부서별 최대급여", 
    min(sal) as "부서별 최소급여"
from emp
group by deptno;

-- 직급별
select distinct job, count(*)
from emp
group by job;

--다음은 부서별로 사원 수와 커미션을 받는 사원들의 수를 계산하는 예제입니다.
select deptno, count(*), count(comm)
from emp
group by deptno;

-- group by의 그룹함수 결과를 비교시에는 having절을 사용한다
-- select
-- from
-- where
-- group by 
-- having 그룹함수 연산자값 (=, !=, >, <, >=, <=)

-- 부서별 평균 급여가 2000이상인(having)
-- 부서번호와 부서별 평균 급여를 출력
select deptno, round(avg(sal), 1)
from emp
group by deptno
having avg(sal) >= 2000;

-- 부서급여의 최대값과 최소값을 구하되 
-- 최대 급여가 2900이상인 부서만 출력합니다.