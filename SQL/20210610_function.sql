-- 2021.06.10
-- function: 1.단일행 함수, 2.집합(다수행)함수
-- 단일행 함수: '1개'의 '행'이 포함하는 특정 컬럼의 값 하나를 연산하고 반환
-- 다수행 함수: '여러 행'의 특정 컬럼값들을 대상으로 연산하고 반환

--***** 변환함수 아주 중요 꼭 기억


-- 숫자 함수
select abs(10), abs(-7) -- 절댓값
from dual;

select floor(15.7) -- 소수점 이하 절삭
from dual;

select ROUND(15.193, -1), ROUND(15.193, 2) -- 오른쪽 숫자는 해당 소수점 자리수를 기준으로 반올림 함을 의미
from dual;

select TRUNC(15.79, 1) -- 기준점에서 절삭
from dual;

select MOD(11, 4) -- 왼쪽을 오른쪽숫자로 나눈 '나머지 값'
from dual;

-- 직원번호가 홀수인 사원
select empno, ename
from emp
where mod(empno, 2) = 1;

-- 문자 함수
-- concat(문자, 문자) == '문자'||'문자'
select concat('abc', 'efg'), 'abc' || 'efg'
from dual;

-- substr: 문자열 추출
-- substr(문자열, 시작 위치, 길이)
select substr('apple', 2, 3) --자바와 달리 sql은 시작 위치가 1
from dual;

select substr('apple', -3)
from dual;

-- replace: 특정 문자열(패턴)을 다른 문자열(패턴)으로 변경
select REPLACE('JACK and JUE','J','BL')
from dual;

select sysdate -- 현재 날짜
from dual;






------------------------------------------------------------------
-- 20210611
------------------------------------------------------------------

--형변환 함수

--날짜 -> 문자
-- to_char(날짜데이터, 패턴(출력형식)), to_char(숫자, 패턴(출력형식))
select sysdate, to_char(sysdate,' yyyy.mm.dd.day , hh24:mi')
from dual;

select ename, hiredate, to_char(hiredate, ' yyyy / mon / dd / day , hh:mm:ss')
from emp;

select*
from orders;

select orderid, orderdate, to_char(orderdate, 'yyyy.mm.dd') from orders;


-- 숫자 -> 문자
select to_char(123456, '0,000,000,000'), to_char (123456, 'L9,999,999,999')
from dual;

select empno, ename,  to_char(sal*1100, 'L999,999,999')
from emp
order by sal asc;


-- '1,000,000'(문자열) + 100000(숫자)
--문자->숫자
--to_number('문자열', 패턴)
select to_number('1,000,000', '9,999,999'),
        to_number('1,000,000', '9,999,999') + 100000
from dual;


--문자->날짜
--to_date('문자열', 패턴)
select to_date('2012-05-17', 'yyyy.mm.dd'), trunc((sysdate-to_date('2012-05-17', 'yyyy.mm.dd'))/365)
from dual;

--decode 함수: 분기(?)를 위해 사용 - 자바의 switch-case와 유사하다
--decode(컬럼이름, = 조건1 값, 조건1이 참일때 사용할 값
--              , =조건2 값, 조건2가 참일때 사용할 값
--                  ...                      )

-- emp 테이블에서 부서번호에 맞는 부서이름을 출력하자
select * from dept;

--10, accounting
--20, research
--30, sales
--40, operation

select  ename, deptno, 
decode(deptno, 10, 'accounting', 20, 'research', 30, 'sales', 40, 'operation') as danme
from emp;

--*****직급에 따라 급여를 인상하자
-- decode 이용
-- 직급이 analyst 인 사원은 5%, salesman인 사람은 10%, MANAGER인 사람은 15%, clerk인 사람은 20% 인상한다
select ename, sal, decode(job, 'ANALYST', sal+sal*0.05, 'SALESMAN', sal+sal*0.10, 'MANAGER', sal+sal*0.15, 'CLERK', sal+sal*0.20 ) as upSal
from emp;


-- case 함수도 분기할 때 사용한다
-- case when 조건1 then 참일때 값
-- decode와 달리 = 뿐만 아니라 >,< 연산자도 사용 가능하다
select ename, deptno, case when deptno=10 then 'ACCOUNTING' when deptno=20 then 'research'
                          when deptno=30 then 'sales' when deptno=40 then 'operation' end as deptname
from emp;