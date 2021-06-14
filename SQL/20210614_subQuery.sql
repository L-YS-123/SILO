--2021.06.14

--sub query

-- 스칼라 부속질의
-- : select 절 이후에 사용
-- 반드시 단일 행, 단일 열 값이 사용된다.
select o.custid, (select name from customer c where o.custid=c.custid )
from orders o
;
-- emp 테이블만 사용해서 사원이름과 부서이름을 출력하자
select e.ename, (select d.dname from dept d where e.deptno=d.deptno)
from emp e
order by ename
;
select ename, dname -- 같은 결과값
from emp, dept
where emp.deptno=dept.deptno
order by ename
;
-- 마당서점의 고객별 판매액을 보이시오(결과는 고객이름과 고객별 판매액을 출력)
select c.custid, c.name, sum(o.saleprice)
from orders o, customer c
where o.custid=c.custid
group by c.custid, c.name
;
select o.custid, (select name from customer c where o.custid = c.custid),
        sum(o.saleprice)
from orders o
group by custid
;



-- 인라인 뷰 : from절 뒤에 사용되는 부속질의. 가상테이블처럼 사용한다
-- 고객번호가 2이하인 고객의 판매액을 보이시오(결과는 고객이름과 고객별 판매액 출력)
select o.custid, c.name, sum(saleprice)
from (select custid, name from customer where custid<=2) c, orders o
where c.custid = o.custid
group by o.custid, c.name
;

-- 중첩질의: where절 뒤에 사용하는 부속질의
-- 비교연산자를 이용할 때는 단일행 단일열의 결과를 갖는 부속질의를 사용해야한다.
-- >,<,=,!=,<=,>=
-- 평균 급여보다 더 많은 급여를 받는 사원을 검색
select *
from emp
where sal > 1000
;
select *
from emp
where sal > (select avg(sal) from emp)
;

--평균 주문금액 이하의 주문에 대해서 주문번호와 금액을 보이시오.
select *
from orders
where saleprice <= (select avg(saleprice) from orders)
order by saleprice
;

--각 고객의 평균 주문금액보다 큰 금액의 주문 내역에 대해서 주문번호, 고객번호, 금액을 보이시오.
select *
from orders
where saleprice > (select avg(saleprice) from orders)
;

-- 다중행 연산자 in
-- 3000이상 받는 사원이 소속된 부서와 동일한 부서에서 근무하는 사원 리스트 출력
select distinct deptno
from emp
where sal >= 3000
;
select *
from emp
where deptno in (select distinct deptno from emp where sal >=3000)
;

-- 대한민국에 거주하는 고객에게
-- 판매한 도서의 총 판매액을 구하시오
select sum(saleprice)
from orders
where custid in (select custid from customer where address like '%대한민국%')
;
--select custid from customer where address like '%대한민국%';


--3번 고객이 주문한 도서의 최고 금액보다 더 비싼 도서를 구입한 주문의 주문번호와 금액을 보이시오.
-- 다중행 연산 all, any
select orderid, saleprice
from orders
where saleprice > all(select saleprice from orders where custid=3)
--  > (select max(saleprice) from orders where custid =3)
;


--exists 연산자로 대한민국에 거주하는 고객에게
--판매한 도서의 총 판매액을 구하시오
select sum(saleprice)
from orders o
where exists (select * from customer c where o.custid = c.custid and c.address like '%대한민국%') 
; 
--select * from customer c where 3 = c.custid and c.address like '%대한민국%';