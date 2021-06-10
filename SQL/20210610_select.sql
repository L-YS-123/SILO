-- 컬럼 like '%'
-- ename like 'F%' -> F로 시작하는 문자열
-- ename like '%F' -> F로 끝나는 문자열
-- ename like '%F%' -> F를 포함하는 문자열
-- 'java' 단어를 포함하는지 -> title like '%java%'
-- 게시판 검색창 포함검색에서 많이 사용

select *
from emp
where ename like '%A%';

-- like '_F%' ->  _는 단 하나의 문자만 대응가능
-- 3번째 글자가 F인 사원을 찾고싶다 -> like '__F%'

-- 자리수 패턴: 컬럼의 값이 자리수가 정해져 있고 값에 패턴이 있는 경우
-- 이름의 두번째 문자에 A를 포함하는 사원의 리스트
select*
from emp
--where ename like '_A%';
--where ename like '__A%'; -- 3번째 문자가 A인 이름
where ename not like '__A%'; -- 3번째가 A가 아닌 이름


-- null값을 확인하는 연산자  -> is null, is not null
-- 커미션이 등록되어 있지 않은 사원의 리스트
-- 결과 행의 정렬 : order by 컬럼 asc(오름차순)/desc(내림차순)
select *
from emp
where comm is not null
order by sal desc, ename asc
;