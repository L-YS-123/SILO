--2021.06.11

-- join

-- cross join
-- 스키마(행)의 모든 경우의 수: 집합의 곱 연산과 같다
select * from emp,dept; -- 14행 x 4행 = 56행, 단순한 일대다 대응으로 붙였을때 의미가 없다

--* equi join -> 가장 많이 사용
--외래키 = (참조테이블의)기본키
select * from emp,dept where emp.deptno = dept.deptno; -- deptno_1 이 아님! / 의미가 있는 조인


-- 이름이 SCOTT인 사람의 이름과 부서명을 출력해봅시다 -> where

-- 출력해야하는 컬럼을 가지는 테이블을 확인해보자
-- 이름: emp, 부서명: dept
select e.ename, d.dname from emp e, dept d where e.deptno = d.deptno --and e.ename='SCOTT';
order by d.dname , e.ename ;


-- self join: 자기 자신을 조인(참조)
-- emp -> mgr 컬럼이 emp.empno 참조
select e.ename, e.mgr, m.ename from emp e, emp m  where e.mgr = m.empno(+); -- (+): 아우터 조인
