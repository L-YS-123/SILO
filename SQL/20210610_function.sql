-- 2021.06.10
-- function: 1.단일행 함수, 2.집합(다수행)함수
-- 단일행 함수: '1개'의 '행'이 포함하는 특정 컬럼의 값 하나를 연산하고 반환
-- 다수행 함수: '여러 행'의 특정 컬럼값들을 대상으로 연산하고 반환


-- 숫자 함수
select abs(10), abs(-7) -- 절댓값
from dual;

select floor(15.7) -- 소수점 이하 절삭
from dual;

select ROUND(15.193,1), ROUND(15.193,-1) -- 마이너스는, 반올림 기준점을 숫자만큼 정수방향으로 이동
from dual;

select TRUNC(15.79,1) -- 소수점 둘째자리 절삭
from dual;

select MOD(11,4) -- 왼쪽을 오른쪽숫자로 나눈 '나머지 값'
from dual;

-- 직원번호가 홀수인 사원
select empno, ename
from emp
where mod(empno,2) = 1;

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