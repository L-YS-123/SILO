--2021-06-15
--1 마당서점의고객이요구하는다음질문에대해SQL 문을작성하시오.
--(5) 박지성이구매한도서의출판사수
select count(distinct publisher)
from customer c, orders o, book b
where c.custid=o.custid and o.bookid=b.bookid
and c.name='박지성'
;

--(6) 박지성이구매한도서의이름, 가격, 정가와판매가격의차이
select b.bookname, b.price, b.price - o.saleprice
from book b inner join orders o
on b.bookid = o.bookid
where custid = 1;

--(7) 박지성이구매하지않은도서의이름
select b.bookname
from book b inner join orders o
on b.bookid = o.bookid
where custid != 1
;

--2 마당서점의운영자와경영자가요구하는다음질문에대해SQL 문을작성하시오.
--(8) 주문하지않은고객의이름(부속질의사용)
select distinct c.name
from customer c, orders o
where c.custid not in (select o.custid from orders o)
;

select *
from orders o, customer c
where o.custid(+)=c.custid and o.orderid is null
;

--(9) 주문금액의총액과주문의평균금액
select  sum(saleprice),round(avg(saleprice))
from orders
;

--(10) 고객의이름과고객별구매액
select c.name, sum(o.saleprice)
from customer c, orders o
where c.custid = o.custid
group by c.name
;

--(11) 고객의이름과고객이구매한도서목록
select c.name, b.bookname
from customer c, book b, orders o
where c.custid = o.custid and b.bookid = o.bookid
order by c.name 
;

--(12) 도서의가격(Book 테이블)과판매가격(Orders 테이블)의차이가가장많은주문
select max(b.price - o.saleprice) as "가장 차이가 많은 주문"
from book b inner join orders o
on b.bookid = o.bookid
where b.price - o.saleprice in ( select b.price - o.saleprice from book b, orders o)
;


--(13) 도서의판매액평균보다자신의구매액평균이더높은고객의이름
select c.name, round(avg(o1.saleprice))
from customer c, orders o1, orders o2
where c.custid = o1.custid
group by c.name
having round(avg(o1.saleprice)) > round(avg(o2.saleprice))
;

--3. 마당서점에서 다음의 심화된 질문에 대해 SQL 문을 작성하시오.
--(1) 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름
select distinct b.publisher
from orders o, customer c, book b
where o.custid=c.custid and o.bookid=b.bookid and c.name='박지성'
;


select distinct *
from orders o, customer c, book b
where o.custid=c.custid and o.bookid=b.bookid 

and b.publisher in (select distinct b.publisher
from orders o, customer c, book b
where o.custid=c.custid and o.bookid=b.bookid and c.name='박지성')

and c.name != '박지성';


--(2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름
select c.name
from customer c, book b, orders o
where c.custid = o.custid and b.bookid = o.bookid
group by c.name
having count(distinct b.publisher) >= 2
;






