--2021.06.11

-- join

-- cross join
-- 스키마(행)의 모든 경우의 수: 집합의 곱 연산과 같다
select * 
from emp,dept; -- 14행 x 4행 = 56행, 단순한 일대다 대응으로 붙였을때 의미가 없다

--* equi join -> 가장 많이 사용
--외래키 = (참조테이블의)기본키
select * 
from emp,dept 
where emp.deptno = dept.deptno; -- deptno_1 이 아님! / 의미가 있는 조인


-- 이름이 SCOTT인 사람의 이름과 부서명을 출력해봅시다 -> where

-- 출력해야하는 컬럼을 가지는 테이블을 확인해보자
-- 이름: emp, 부서명: dept
select *
from emp e, dept d 
where e.deptno = d.deptno --and e.ename='SCOTT';
order by d.dname , e.ename ;


select *
from emp e inner join dept d
on e.deptno = d.deptno
;

select *
from emp e inner join dept d
on e.deptno = d.deptno
where e.ename = 'SCOTT'
;


-- self join: 자기 자신을 조인(참조)
-- emp -> mgr 컬럼이 emp.empno 참조
select e.ename, e.mgr, m.ename
from emp e, emp m  
where e.mgr = m.empno(+); -- (+): 아우터 조인: null값이 포함된 스키마도 표현하겠다


-- non equi join
--동등 비교가 아닌 <,> 같은 비교로 조인의 조건을 작성

select emp.ename, emp.sal, salgrade.grade ,salgrade.losal, salgrade.hisal
from emp ,salgrade -- equi, non-equi 테이블은 새로운테이블이 만들어졌다고 생각하면 편하다
where emp.sal between salgrade.losal and salgrade.hisal
--emp.sal >= salgrade.losal and emp.sal <= salgrade.hisal
order by emp.ename;


select * from orders;
select * from customer;
select * from book;

select o.orderid, c.name, b.bookname
from orders o, customer c, book b
where o.custid = c.custid and o.bookid = b.bookid
order by o.orderid
;



-- '비교하는 컬럼의 이름이 같을때'
-- on 절을 생략하고 -> using을 이용하여 조건식을 생략할 수 있다

select *
from emp e inner join dept d
--on e.deptno = d.deptno
using (deptno)
where e.ename = 'SCOTT'
;


--natural join
select *
from emp NATURAL JOIN dept
;


-- [ left | right | full ]outer Join
select *
from emp e left outer join emp m
on e.mgr = m.empno
;



--*** 회원별 구매 내역출력
select c.name, count(o.orderid)as "구매횟수", avg(saleprice)
from orders o, customer c
where o.custid(+) = c.custid -- 아우터(+)로 구매고객 통계 가능
group by c.name -- 컬럼과 함수를 동시에 select 할 수 있는 이유. 그룹바이(기준점)
;
