--20210616

--view

--자주 사용되는
--30번 부서에 소속된 사원들의
--사번과 이름, 부서번호를 출력하기위한
--select문을 하나의 뷰로 정의해봅시다

create or replace view emp_view30
as
select empno, ename, deptno
from emp
where deptno=30
;

select *  from emp_view30
--where ename='JAMES'
;

--view 삭제
drop view emp_view30;


-- 인라인 뷰를 이용한 top3 구하기
select rownum, ename, hiredate
from emp
--order by hiredate
;

--입사일이 빠른 사람 5명만(TOP-N)을 얻어오기
select rownum, ename, hiredate
from (select * from emp order by hiredate)
where rownum < 6
;


create or replace view view_HIR
as
select * from emp order by hiredate;

select rownum, ename, hiredate 
from view_HIR
order by hiredate;



--sequence: 번호 재생기
create sequence pi_idx_pk;

select pi_idx_pk.nextval
from dual; -- 실행시마다 증가


select pi_idx_pk.currval
from dual; -- 시퀀스가 현재 가지고 있는 값을 확인