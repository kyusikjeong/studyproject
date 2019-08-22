--날짜연산
/*
        날짜 +,- 숫자 : 날짜로부터 그 기간만큼 지난 날짜를 계산
        날짜 - 날짜 : 두 날짜 사이에 기간을 계산해준다.
*/
select sysdate -1 어제, sysdate 오늘 ,sysdate+1 내일 from dual;
/* 변환함수
   to_char(날짜| 숫자,'형식') : 날짜 또는 숫자를 지정한 형식의 문자열로 변환
   to_date(날짜형식의 문자열,'형식') : 날짜 형식의 문자열을 지정한 형식의 날짜로 변환
   to_number('100') >= 10
   */
   select * from gogek;
   select to_number(godam) + 10 as 연산 from gogek where goname = '류민';
   ---------------------------------------------------------------------------------------------------------------
   select to_char(sysdate , 'yy'), to_char(sysdate,'CC') from dual;
   select to_char(sysdate,'year') from dual; -- 영문 표기
   select to_char(sysdate,'yy'),to_char(sysdate,'rr') from dual; --연도의 끝의 2자리만 표기
   select to_char(sysdate, 'month'),to_char(sysdate,'mon') from dual;  --월
   select to_char(sysdate, 'q') from dual; -- 분기
   select to_char(sysdate, 'd') from dual; -- 요일(1~7 ㅣ 1-> 일요일)
   select to_char(sysdate, 'dy') from dual; -- 요일을 한글로
   select to_char(sysdate, 'day') from dual;-- 요일 풀네임
   select to_char(sysdate, 'day','NLS_DATE_LANGUAGE=ENGLISH') from dual; --요일을 영어로 표기
   select to_char(sysdate, 'dd') from dual; --일
   select to_char(sysdate, 'ddd') from dual; ---365일
   select to_char(sysdate, 'hh'),to_char(sysdate,'hh24') from dual;   --시간
---------------------------------------------------------------------------------------------------------------
   select saname,sahire, trunc(months_between(sysdate, sahire))*30 as 근무일수,
   trunc(trunc(months_between(sysdate, sahire))/12) as 근무연월
   from sawon
   where saname = '감수정';
   
   select to_number('100') from dual;
   
    select to_char(sysdate,'CC "세기" yyyy"년" day"입니다."') 날짜출력  from dual;
    --기본적으로 있는 포맷에 텍스트만 추가. 
    
   select to_char(add_months(sysdate,11)+2, 'ddd')- to_char(sysdate,'ddd') from dual; ---365일
   
   select saname,sahire,to_char((months_between(sysdate, sahire), 'ddd') from sawon;
   
   --2019 01월 29일로 출력해보기
   select to_char(sysdate,'yyyy"년" mm"월" dd"일" day') as 오늘날짜 from dual;
   
   select to_char(sysdate,'yyyy"년" q"분기" ddd"일차" ') from dual;
   
   select to_char(sysdate,'yyyy"년" mm"월" dd"일"  day "이며"  q"분기 ,앞으로 1년중에 "')|| 
   (to_char(add_months(sysdate,11)+2, 'ddd')- to_char(sysdate,'ddd'))||'일 남았습니다'  from dual;
   --12월까지 총 일수를 구한다음 현재 날짜를 빼서 몇일 남은지 구함
   
   
   select (to_char(add_months(sysdate,11)+2, 'ddd')- to_char(sysdate,'ddd')) from dual;
   select saname,to_char(sapay,'fm$9,000') from sawon;   --숫자 관련 형식 ( 9- 값이 없다면 출력을 안함, 0- 값이 없어도 출력)
   
   --next,last 
   --오늘을 기준으로 가장 가까운 다음 화요일은 언제인지를 반환함.
   select next_day(sysdate,to_char(sysdate,'dy')) from dual;
   
   --지정한 년/월의 마지막 날짜(이달의 마지막 날짜는)
   select last_day(sysdate) from dual;
   --add_months : 특정 개월 수를 더한 날짜를 구해주는 함수
   select saname,sahire, add_months(sahire,5) from sawon;
   
 select add_months(sysdate,11)+2 from dual;
   
   --날짜에 연산되는 round / trunc 함수
   --기준으로 월에서 반올림
   select saname, sahire, round(sahire,'yyyy') from sawon;
   
   --연산함수['년-개월']
   select sysdate + to_yminterval('00-10') from dual;
   
   --['일 시: 분:초'] 
   select sysdate + to_dsinterval('0 00:00:00') from dual;
   
   
   select to_char(sysdate + to_dsinterval('0 01:30:00'),'RRRR-MM-DD:HH24:MI:SS' )from dual;  --시분초 표시하고 변경....
   
   --months_between 날짜와 날짜 사이의 개월수를 구하는 함수
   select saname,sahire, trunc(months_between(sysdate, sahire,2)) from sawon;
    select saname,sahire, trunc(months_between(sysdate, sahire)) % 12 from sawon;
   
   select * from sawon;
   
   --문제3) 사원명, 입사일, 근무기간([xx년 xx개월]) 로 출력하시오.
    select saname as 사원명,sahire as 입사일, trunc(trunc(months_between(sysdate, sahire))/12)
    ||'년'|| TRUNC(MOD(months_between(sysdate, sahire),12)) ||'개월' as 근무기간
    from sawon;  --년도는 총 개월수에서 12개월로 나누어 구하였고 개월은 12로 나눈 나머지를 구하였다. 
    
--문제4) 입사한 달의 근무일 수를 계산하여 부서번호,이름,근무일수를 출력하시오.
select deptno, saname,floor(mod(months_between(sysdate,sahire),1)*30.5) from sawon;
     
select saname, sahire, trunc(months_between(sysdate, sahire)*30)||'일' as 근무일수 from sawon; 
--개월 수에 달 평균 날짜 30을 곱하였다


  --next,last 
   --오늘을 기준으로 가장 가까운 다음 화요일은 언제인지를 반환함.
   select next_day(sysdate, '월') from dual;


select deptno,saname, sahire,sysdate, trunc(months_between(sysdate, sahire)*30) as 근무일수 ,
    TRUNC(months_between(sysdate, sahire)/12) ||'년' ||
    TRUNC(MOD(months_between(sysdate, sahire),12))||'개월'|| 
    FLOOR(MOD(months_between(sysdate, sahire),1)*30.5)||'일'
from sawon; 


select deptno,saname, sahire,sysdate, trunc(months_between(sysdate, sahire)*30) as 근무일수 ,
    TRUNC(months_between(sysdate, sahire)/12) ||'년' ||
    TRUNC(MOD(months_between(sysdate, sahire),12))||'개월'|| 
    TRUNC(MOD(months_between(sysdate, sahire),1)*30)||'일' as 근무년월일
from sawon;
 ---년도 우선 구하고,12를 나눈 나머지를 개월로 구한다. 그리고 편차를 줄이기 위해 월의 소수점 한자리수에(1.1개월 이런식에)  
 --30을 곱해서 일을 구한다.
select deptno,saname, sahire,sysdate,
    TRUNC(months_between(sysdate, sahire))*30
from sawon;
--60일 더하고, 월요일 구하기...
--입사년도별 급여합계와 최대 급여를 출력
select deptno,saname, sahire
 from sawon;

SELECT
  TRUNC(months_between(sysdate, sahire)/12) "년" ,
  TRUNC(MOD(months_between(sysdate, sahire),12)) 
FROM sawon;
   
   --레포트에 작성후 제출할 것 :
   --ex) 연산 설명 trunc(months_between(sysdate, sahire)) : 해당 쿼리의 기능 설명. 주석--
   --연습문제 1번 ) 사원 테이블에서 사원의 근무 일수, 개월, 근무 년 월일을 
   --                ex) 감수정 10/05/11 | 3081 | 8년 5개월 5일  
   --연습문제 2번 ) 사원 테이블에서 입사한 달의 근무일 수를 계산하여 부서번호, 이름, 근무일수를 출력하시오.
   --연습문제 3번 ) 사원 테이블에서 모든 사원의 60일 지난 후의 월요일은 몇 년 , 몇 월, 몇 일 인가를 구한 후
   -- 이름 입사일, 월,요일로 출력하시오.
   
   
/*
    석차함수
    형식:rank() over([partition by by 컬럼명] order by 컬럼명 [desc])"석차
    over:순위를 부여하기 위한 대상 집합의 정렬 기준과 분할 기준정의
    partition by: 컬럼명을 기준으로 분할, 생략시에는 전체 집합을 대상으로 순위 부여
    order by 컬럼명: 컬럼을 기준으로 정렬

RANK 함수는 1등이 2건인 경우에는 다음 순위를 3등으로 부여한다.
--정렬 결과를 기준으로 전체 순위를 출력하기 위해 사용

DENSE_RANK 함수는 다음 순위를 2등으로 부여한다.
--동일 순위를 무시한 연속 순위를 출력하기 위해 사용된다.

*/
select gobun,godam,goname, rank() over(order by godam desc) "순위"
from gogek where godam is not null;

select gobun,godam, goname, dense_rank() over(order by godam desc) "순위"
from gogek where godam is not null;

select * from gogek;


--update gogek set godam = 

--문제 ) 부서별로 급여가 높은 순으로 석차를 출력하시오. 단 널값은 제외)
--부서 번호, 사원이름 , 급여 , 석차

select deptno,saname,sapay,
case 
    when deptno= 50 then '개발부' 
    when deptno= 20 then '영업부'
    when deptno =30 then '전산부'
    else '총관리부'
    end "임시부서명"
,sapay, rank() over(partition by deptno order by sapay desc) as 석차 from sawon where sapay is not null;


--계산함수 , 집계함수, 그룹함수
--sum, avg, count, max, min 함수
-- 그룹함수와 일반집계컬럼 함께 사용하기 위해서 group by 일반집계컬럼 ..... --정렬작업 포함

select sum(sapay)/21, avg(nvl(sapay,0)),count(*),max(sapay),min(sapay) from sawon;

--nvl : 컬럼 하나 단독적용 함수. NVL(VAL1,VAL2) VAL1이 null일때 VAL2로 치환하는 함수
--avg : count 영향 널포함 꼭 넣어야함
-- count (sapay) : 널을 포함하지 않음 COUNT()는 없을경우 0을 반환 => count(nvl(sapay,0)) 와 같은 기능...


--부서별 급여 합계를 출력
--단 , 10번 , 20번 부서만 출력
--단, 급여 합계가 15000 이상인 그룹만 출력 ***

select deptno, sum(sapay) from sawon
where deptno = 10 or deptno=30 -- where 절에는 group 함수를 사용할 수 없다.
group by deptno
--정렬됨 -- group by *** ; : ***에 있는 값들을 미리 .. 그룹화
--(일반 컬럼을 계산함수랑 같이 쓸때는 반환수가 틀려서 그룹화를 시켜줘야 한다.)
having sum(sapay)>= 15000; -- group by 에 대한 조건절

--where 절에는 group 함수를 사용할 수 없다.

/*
select : 추출할 컬럼
from : 조건절, 계산함수 사용 불가능.(from 다음 가장 먼저 분석하기 때문)
group by - 집계컬럼
having : 계산함수 사용가능
order by

*/

--문제)성별, 직책별 인원수와 급여합계를 출력
-- 단, 여자만 그룹화 하고 인원이 두명이하인 사원만 출력
-- 인원수가 많은 순으로 정렬하시오.

select * from sawon;

select sum(sapay)as s from sawon 
group by sapay
having sgender = '여자';


select sajob,count(nvl(sajob,0)) from sawon 
group by sajob
having count(nvl(sajob,0))>=3;
--직업별로 그룹을 지었다. nvl 함수는 앞의 인자가 null 이면 뒤의 인자로 치환하는 함수



select sgender,sajob,count(sajob), sum(sapay) from sawon
where sgender = '여자' and sapay is not null
group by sgender,sajob
--정렬됨 -- group by *** ; : ***에 있는 값들을 미리 .. 그룹화
--(일반 컬럼을 계산함수랑 같이 쓸때는 반환수가 틀려서 그룹화를 시켜줘야 한다.)
having count(sajob)<= 2 
order by sajob;


----------------------------------------------------------------------------------------------------------------------------------------------------------
 select to_char(sysdate , 'yy'), to_char(sysdate,'CC') from dual;
--입사년도별 급여합계와 최대 급여를 출력
select *
 from sawon;

select to_char(sahire , 'yy') , sum(sapay),max(sapay)
from sawon
group by to_char(sahire , 'yy');
--년도만 뽑은다음 그룹화


select sahire from sawon group by sahire;



select deptno, max(sapay) from sawon group by deptno order by 2 desc;
--rownum : 가상 컬럼, 임시로 컬럼에 부여되는 일련번호. 
--where 절에서 행의 갯수를 제한할때 사용, 공지사항(다섯개의 최신 데이터만..)
--급여가 많은 세명의 사원을 출력, 번호 함께 출력
--오라클의 연산 순서를 제대로 알아야 rownum을 제대로 사용할 수 있다. 
select rownum, saname, sapay 
from sawon  -- 프로그램 실행 순서 1 -> 이 상태에서 이미 rownum 값이 정해지는 것이기 때문에 아래에서 정의를 해도 의미가 없어진다.
where rownum <= 3 -- 실행 순서 2
order by sapay desc ,saname; --실행 순서 3

--From -> Where -> Select -> Order by
-- from 절이 가장 먼저 실행이 되고 sawon 테이블에 rownum 가 부여된다.
-- 그 이후에 where 절이 사용되기 때문에 정렬이 이루어지기 전에 rownum <=2 인 row가 선택된다.

--인라인 뷰. 서브쿼리. from 절에 테이블 대신 들어가야됨.

--뷰라는 것은 from 절 뒤에 오는 서브쿼리 형태의 쿼리이다. () 안에 존재...쿼리 실행시 뷰가 먼저 실행됨. 
--사용 하는 이유는 앞의 실행 순서를 뒤바꾸기 위해 사용하는것. 
--ex)

select rownum, saname,sapay from
(select rownum,saname,sapay from sawon order by sapay desc)  --ex) order by sapay 부분에 컬럼명에 정렬할 컬럼 번호를 넣어도 정렬이 된다. Order by 1 이런식으로
where rownum <=3;

--컬럼 단위의 그룹화
select sum(decode (sajob,'사원', sapay,0)) "사원",
sum(decode(sajob,'대리',sapay,0)) "대리",
sum(decode(sajob,'부장',sapay,0)) "부장",
sum(decode(sajob,'회장',sapay,0)) "회장",
sum(sapay) "합계" from sawon;
--성별 합계 구하기
--남자 | 여자 | 합계

select sajob,decode (sajob,'사원', sapay,0) 
from sawon
;

select count -- 넣어서 해보자.
sum(decode (sgender,'남자',0) "남자",
sum(decode (sgender,'여자',0) "여자",
count(*)  "합계"
from sawon;
select count(),count(),count(*) "합계" from sawon;
select count(sum(decode(sgender , '남자',0))) "합계" from sawon;

---***Join (조인) ***--
--사용하는 컬럼이 두개 이상의 테이블에 존재하는 경우 사용되는 고급 쿼리 명령
--32개까지 가능
--종료

1.eque(inner) join: 조인되는 테이블 간의 조건에 만족하는 행만을 추출
2.outer join(left & right) : 조인되는 테이블 간의 조건에 만족하는 행과 마스터 테이블의 모든 데이터가 추출
3.cross join: 조인되는 테이블 간의 어떤 관계도 없는 경우 (table'table)->카티션 곱'
-------------------------------------------------------------------------
4.self join : 자기 자신의 테이블과 조인되는 경우
--문법
1.T-SQL 문법: where 조건절, 테이블명을 나열하여 표현
-select~- : 원하는 컬럼 나열
-from~: 사용한 컬럼을 가진 테이블 나열
-where~: 사용된 테이블 간의 관계 또는 조건을 표현

2.Ansi 문법: on조건절, 서술형태의 표현

--조인되는 테이블간의 관계 컬럼명이 같은경우 ! - ansi
select saname, deptno, dname from sawon natural join dept;
select saname, deptno, dname from sawon join dept using(deptno);





select saname, deptno, dname from sawon natural join dept;


select * from dept;
select * from gogek;

select * from sawon;

--컬럼명이 같아야 하는것을 증명
select saname,samgr from sawon natural join gogek;
select saname,samgr from sawon join gogek using(sabun);
--사원명, 부서번호, 부서명을 출력
select s.saname,s.deptno,d.dname from sawon s, dept d --참조변수를 걸지 않아도 자동으로 참조를 하나, 수가 커질수록 퍼포먼스가 떨어지는 결과를 가져온다
where s.deptno = d.deptno;

select s.saname, s.sabun, g.godam 
from gogek g, sawon s
where s.sabun(+) = g.godam;     -- outer  join

select s.saname, s.deptno, d.dname 
from sawon s join dept d on (s.deptno=d.deptno); -- ansi

select sahire ,count(decode(to_char(sahire,'yy'),80,0)) as test,
count(decode(to_char(sahire,'yy'),81,0)) as test2,
count(decode(to_char(sahire,'yy'),82,0)) as test3,
count(decode(to_char(sahire,'yy'),83,0)) as test4
from sawon
group by sahire;

--문제 9) 각 부서별 평균 급여, 전체 급여, 최고 월급, 최저 월급을 구하여평균 월급이 많은 순으로 출력하시오.
--문제 10) 1980 ~ 1983년 사이에 입사된 각 부서별 사원수를 부서번호,부서명, 입사년도(1980,1981,1982)로 출력하시오.

select d.deptno,d.dname,to_char(sahire,'yy') as 입사년도
from sawon s , dept d
group by to_char(sahire,'yy'),d.deptno,d.dname
having to_char(sahire,'yy') between 80 and 83
order by to_char(sahire,'yy')
;

select d.deptno,trunc(avg(s.sapay),1),max(s.sapay),min(s.sapay)
from dept d
join sawon s on (s.deptno=d.deptno)
group by d.deptno
order by trunc(avg(s.sapay),1) desc;
--ansi 조인을 걸어서 데이터를 처리함

select g.goname,g.gotel, s.saname from gogek g 
where g.godam = s.sabun(+); -- left outer join

select g.goname,g.gotel, s.saname from gogek g 
left outer join sawon s on (g.godam = s.sabun);

--사원명, 직책, 담당자명, 직책을 출력

select s.saname, s.sajob, m.saname, m.sajob 
from sawon s, sawon m 
where s.samgr = m.sabun(+);

--고객명, 담당자명, 직책, 부서명을 출력(담당자가 없는 고객도 출력)

select g.goname, s.saname, s.sajob, d.dname
from gogek g,sawon s,dept d
where g.godam = s.sabun(+) and s.deptno = d.deptno;

--부서명 , 사원명, 직책, 담당자명, 직책을 출력(단, 담당자가 없는 사원도 출력)
select d.dname, s.saname, s.sajob, m.saname, m.sajob from sawon s, sawon m, dept d
where d.deptno(+) = s.deptno
and s.samgr = m.sabun(+);


--문제 10) 1980 ~ 1983년 사이에 입사된 각 부서별 사원수를 부서번호,부서명, 입사년도(1980,1981,1982)로 출력하시오.
select sahire ,count(decode(to_char(sahire,'yy'),80,0)) as test,
count(decode(to_char(sahire,'yy'),81,0)) as test2,
count(decode(to_char(sahire,'yy'),82,0)) as test3,
count(decode(to_char(sahire,'yy'),83,0)) as test4
from sawon
group by sahire 
;



select  d.deptno as 부서번호 , d.dname as 부서명,
count(decode(to_char(sahire,'yy'),80,0)) as test,
count(decode(to_char(sahire,'yy'),81,0)) as test2,
count(decode(to_char(sahire,'yy'),82,0)) as test3,
count(decode(to_char(sahire,'yy'),83,0)) as test4
from sawon s , dept d

where d.deptno = s.deptno
group by d.deptno,d.dname;


having count(decode(to_char(sahire,'yy'),IN(80,81,82,83),0)) > 0;


order by to_char(s.sahire,'yy');




-- between 을 사용해서 년도 사이의 사원들을 구하였다.
decode(sajob,'대리',sapay,0)

select sahire ,count(decode(to_char(sahire,'yy'),80,0)) as test,
count(decode(to_char(sahire,'yy'),81,0)) as test2,
count(decode(to_char(sahire,'yy'),82,0)) as test3,
count(decode(to_char(sahire,'yy'),83,0)) as test4
from sawon
group by sahire;


select decode(to_char(sahire,'yy'), 80) 
decode(to_char(sahire,'yy'), 81),
decode(to_char(sahire,'yy'), 82),
decode(to_char(sahire,'yy'), 83)


from sawon;

select to_char(sahire,'yy') from sawon order by to_char(sahire,'yy');


--부서(명)별 급여 합계를 출력
select d.dname, sum(s.sapay)

from sawon s, dept d
where d.deptno = s.deptno
group by d.dname;


select count(*) from gogek;

select * from dept;
select * from sawon;
select * from gogek;

select s.saname saname,s.deptno deptno,d.dname dname,s.sapay sapay from sawon s, dept d 
       where s.deptno = d.deptno and dname = '총무부' order by 3 desc;

select * from sawon;

select * from gogek;
