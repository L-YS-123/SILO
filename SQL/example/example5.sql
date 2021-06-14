--43. 사원 번호가 7788인 사원과 담당 업무가 같은 사원을 표시(사원 이름과 담당업무)하시오.
select e2.ename, e2.job, e2.deptno
from emp e inner join emp e2
on e.empno = 7788
where e.deptno = e2.deptno
;

--44. 사원번호가 7499인 사원보다 급여가 많은 사원을 표시하시오. 사원이름과 감당 업무
select e2.ename, e2.job, e2.sal
from emp e inner join emp e2
on e.empno=7499
where e2.sal > e.sal
order by e2.sal desc
;

--45. 최소급여를 받는 사원의 이름, 담당업무 및 급여를 표시하시오. (그룹함수 사용)
select e.ename, e.job, min(e.sal)
from emp e 
where e.sal <= all (select sal from emp)
group by e.ename, e.job
;

--46. 평균급여가 가장 적은 직급의 직급 이름과 직급의 평균을 구하시오.
select job, avg(sal)
from emp
group by job
having avg(sal) = (select min(avg(sal)) from emp group by job)
;
-- having 절에서 group by job을 왜 해주어야 하는지 모르겠음

--47. 각 부서의 최소 급여를 받는 사원의 이름, 급여, 부서번호를 표시하시오.
select ename, sal, deptno
from emp
where sal in ( select min(sal) from emp group by deptno)
;

--48. 담당업무가 ANALYST 인 사원보다 급여가 적으면서 
--업무가 ANALYST가 아닌 사원들을 표시(사원번호, 이름, 담당 업무, 급여)하시오.
select empno, ename, job, sal
from emp
where sal < all ( select sal from emp where job = 'ANALYST') and job != 'ANALYST'
;

--49. 부하직원이 없는 사원의 이름을 표시하시오. = 상사가 아니다 = mgr에 번호가 없다
-- 전체 인원 - mgr에 번호가 있는 인원 = 부하가 없는 직원
select distinct e1.ename
from emp e1, emp e2
where e1.empno not in ( select e1.empno from emp e1, emp e2 where e1.empno = e2.mgr)
;

--50. 부하직원이 있는 사원의 이름을 표시하시오.
select distinct e2.mgr, (select e1.ename from emp e1 where e2.mgr = e1.empno)
from emp e1, emp e2
;

--51. BLAKE와 동일한 부서에 속한 사원의 이름과 입사일을 표시하는 질의를 작성하시오. 
--( 단 BLAKE는 제외 )
select ename, hiredate
from emp
where deptno = ( select deptno from emp where ename='BLAKE' )
        and ename not in 'BLAKE'
               
;

--52. 급여가 평균 급여보다 많은 사원들의 
--사원 번호와 이름을 표시하되 
--결과를 급여에 대해서 오름차순으로 정렬하시오.
select e1.ename, e1.empno, e1.sal
from emp e1
where e1.sal > (select avg(sal) from emp)
order by sal
;

--53.이름에 K가 포함된 사원과 같은 부서에서 일하는 사원의 사원 번호와 이름을 표시하시오.
select empno, ename
from emp
where deptno in (select deptno from emp where ename like '%K%')
;

--54.부서 위치가 DALLAS인 사원의 이름과 부서번호 및 담당업무를 표시하시오.
select distinct e.ename, e.deptno, e.job    -- distinct 써야하는 이유가 짐작가지 않음.
from emp e, dept d
where e.deptno = (select d.deptno from dept d where d.loc = 'DALLAS')
;

--55.KING에게 보고하는 사원의 이름과 급여를 표시하시오.
select ename,sal
from emp
where mgr = (select empno from emp where mgr is null)
;

--56. RESEARCH 부서의 사원에 대한 부서번호, 사원이름 및 담당 업무를 표시하시오.
select d.deptno, e.ename, e.job
from dept d inner join emp e
on d.deptno = e.deptno
where d.deptno = '20';


--57.평균 월급보다 많은 급여를 받고 
--이름에 M이 포함된 사원과 같은 부서에서 근무하는 사원의 
--사원 번호, 이름, 급여를 표시하시오.
select empno, ename, sal
from emp
where sal > (select avg(sal) from emp) 
                    and deptno in (select deptno from emp where ename like '%M%')
;

--58.평균급여가 가장 적은 업무를 찾으시오.
select job, avg(sal)
from emp
group by job
having avg(sal) <= all (select avg(sal) from emp group by job)
;

--59.담당업무가 MANAGER 인 사원이 소속된 부서와 동일한 부서의 사원을 표시하시오.
select *
from emp
where deptno in (select deptno from emp where job='MANAGER')
;