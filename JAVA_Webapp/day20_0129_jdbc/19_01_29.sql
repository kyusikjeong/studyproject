--��¥����
/*
        ��¥ +,- ���� : ��¥�κ��� �� �Ⱓ��ŭ ���� ��¥�� ���
        ��¥ - ��¥ : �� ��¥ ���̿� �Ⱓ�� ������ش�.
*/
select sysdate -1 ����, sysdate ���� ,sysdate+1 ���� from dual;
/* ��ȯ�Լ�
   to_char(��¥| ����,'����') : ��¥ �Ǵ� ���ڸ� ������ ������ ���ڿ��� ��ȯ
   to_date(��¥������ ���ڿ�,'����') : ��¥ ������ ���ڿ��� ������ ������ ��¥�� ��ȯ
   to_number('100') >= 10
   */
   select * from gogek;
   select to_number(godam) + 10 as ���� from gogek where goname = '����';
   ---------------------------------------------------------------------------------------------------------------
   select to_char(sysdate , 'yy'), to_char(sysdate,'CC') from dual;
   select to_char(sysdate,'year') from dual; -- ���� ǥ��
   select to_char(sysdate,'yy'),to_char(sysdate,'rr') from dual; --������ ���� 2�ڸ��� ǥ��
   select to_char(sysdate, 'month'),to_char(sysdate,'mon') from dual;  --��
   select to_char(sysdate, 'q') from dual; -- �б�
   select to_char(sysdate, 'd') from dual; -- ����(1~7 �� 1-> �Ͽ���)
   select to_char(sysdate, 'dy') from dual; -- ������ �ѱ۷�
   select to_char(sysdate, 'day') from dual;-- ���� Ǯ����
   select to_char(sysdate, 'day','NLS_DATE_LANGUAGE=ENGLISH') from dual; --������ ����� ǥ��
   select to_char(sysdate, 'dd') from dual; --��
   select to_char(sysdate, 'ddd') from dual; ---365��
   select to_char(sysdate, 'hh'),to_char(sysdate,'hh24') from dual;   --�ð�
---------------------------------------------------------------------------------------------------------------
   select saname,sahire, trunc(months_between(sysdate, sahire))*30 as �ٹ��ϼ�,
   trunc(trunc(months_between(sysdate, sahire))/12) as �ٹ�����
   from sawon
   where saname = '������';
   
   select to_number('100') from dual;
   
    select to_char(sysdate,'CC "����" yyyy"��" day"�Դϴ�."') ��¥���  from dual;
    --�⺻������ �ִ� ���˿� �ؽ�Ʈ�� �߰�. 
    
   select to_char(add_months(sysdate,11)+2, 'ddd')- to_char(sysdate,'ddd') from dual; ---365��
   
   select saname,sahire,to_char((months_between(sysdate, sahire), 'ddd') from sawon;
   
   --2019 01�� 29�Ϸ� ����غ���
   select to_char(sysdate,'yyyy"��" mm"��" dd"��" day') as ���ó�¥ from dual;
   
   select to_char(sysdate,'yyyy"��" q"�б�" ddd"����" ') from dual;
   
   select to_char(sysdate,'yyyy"��" mm"��" dd"��"  day "�̸�"  q"�б� ,������ 1���߿� "')|| 
   (to_char(add_months(sysdate,11)+2, 'ddd')- to_char(sysdate,'ddd'))||'�� ���ҽ��ϴ�'  from dual;
   --12������ �� �ϼ��� ���Ѵ��� ���� ��¥�� ���� ���� ������ ����
   
   
   select (to_char(add_months(sysdate,11)+2, 'ddd')- to_char(sysdate,'ddd')) from dual;
   select saname,to_char(sapay,'fm$9,000') from sawon;   --���� ���� ���� ( 9- ���� ���ٸ� ����� ����, 0- ���� ��� ���)
   
   --next,last 
   --������ �������� ���� ����� ���� ȭ������ ���������� ��ȯ��.
   select next_day(sysdate,to_char(sysdate,'dy')) from dual;
   
   --������ ��/���� ������ ��¥(�̴��� ������ ��¥��)
   select last_day(sysdate) from dual;
   --add_months : Ư�� ���� ���� ���� ��¥�� �����ִ� �Լ�
   select saname,sahire, add_months(sahire,5) from sawon;
   
 select add_months(sysdate,11)+2 from dual;
   
   --��¥�� ����Ǵ� round / trunc �Լ�
   --�������� ������ �ݿø�
   select saname, sahire, round(sahire,'yyyy') from sawon;
   
   --�����Լ�['��-����']
   select sysdate + to_yminterval('00-10') from dual;
   
   --['�� ��: ��:��'] 
   select sysdate + to_dsinterval('0 00:00:00') from dual;
   
   
   select to_char(sysdate + to_dsinterval('0 01:30:00'),'RRRR-MM-DD:HH24:MI:SS' )from dual;  --�ú��� ǥ���ϰ� ����....
   
   --months_between ��¥�� ��¥ ������ �������� ���ϴ� �Լ�
   select saname,sahire, trunc(months_between(sysdate, sahire,2)) from sawon;
    select saname,sahire, trunc(months_between(sysdate, sahire)) % 12 from sawon;
   
   select * from sawon;
   
   --����3) �����, �Ի���, �ٹ��Ⱓ([xx�� xx����]) �� ����Ͻÿ�.
    select saname as �����,sahire as �Ի���, trunc(trunc(months_between(sysdate, sahire))/12)
    ||'��'|| TRUNC(MOD(months_between(sysdate, sahire),12)) ||'����' as �ٹ��Ⱓ
    from sawon;  --�⵵�� �� ���������� 12������ ������ ���Ͽ��� ������ 12�� ���� �������� ���Ͽ���. 
    
--����4) �Ի��� ���� �ٹ��� ���� ����Ͽ� �μ���ȣ,�̸�,�ٹ��ϼ��� ����Ͻÿ�.
select deptno, saname,floor(mod(months_between(sysdate,sahire),1)*30.5) from sawon;
     
select saname, sahire, trunc(months_between(sysdate, sahire)*30)||'��' as �ٹ��ϼ� from sawon; 
--���� ���� �� ��� ��¥ 30�� ���Ͽ���


  --next,last 
   --������ �������� ���� ����� ���� ȭ������ ���������� ��ȯ��.
   select next_day(sysdate, '��') from dual;


select deptno,saname, sahire,sysdate, trunc(months_between(sysdate, sahire)*30) as �ٹ��ϼ� ,
    TRUNC(months_between(sysdate, sahire)/12) ||'��' ||
    TRUNC(MOD(months_between(sysdate, sahire),12))||'����'|| 
    FLOOR(MOD(months_between(sysdate, sahire),1)*30.5)||'��'
from sawon; 


select deptno,saname, sahire,sysdate, trunc(months_between(sysdate, sahire)*30) as �ٹ��ϼ� ,
    TRUNC(months_between(sysdate, sahire)/12) ||'��' ||
    TRUNC(MOD(months_between(sysdate, sahire),12))||'����'|| 
    TRUNC(MOD(months_between(sysdate, sahire),1)*30)||'��' as �ٹ������
from sawon;
 ---�⵵ �켱 ���ϰ�,12�� ���� �������� ������ ���Ѵ�. �׸��� ������ ���̱� ���� ���� �Ҽ��� ���ڸ�����(1.1���� �̷��Ŀ�)  
 --30�� ���ؼ� ���� ���Ѵ�.
select deptno,saname, sahire,sysdate,
    TRUNC(months_between(sysdate, sahire))*30
from sawon;
--60�� ���ϰ�, ������ ���ϱ�...
--�Ի�⵵�� �޿��հ�� �ִ� �޿��� ���
select deptno,saname, sahire
 from sawon;

SELECT
  TRUNC(months_between(sysdate, sahire)/12) "��" ,
  TRUNC(MOD(months_between(sysdate, sahire),12)) 
FROM sawon;
   
   --����Ʈ�� �ۼ��� ������ �� :
   --ex) ���� ���� trunc(months_between(sysdate, sahire)) : �ش� ������ ��� ����. �ּ�--
   --�������� 1�� ) ��� ���̺��� ����� �ٹ� �ϼ�, ����, �ٹ� �� ������ 
   --                ex) ������ 10/05/11 | 3081 | 8�� 5���� 5��  
   --�������� 2�� ) ��� ���̺��� �Ի��� ���� �ٹ��� ���� ����Ͽ� �μ���ȣ, �̸�, �ٹ��ϼ��� ����Ͻÿ�.
   --�������� 3�� ) ��� ���̺��� ��� ����� 60�� ���� ���� �������� �� �� , �� ��, �� �� �ΰ��� ���� ��
   -- �̸� �Ի���, ��,���Ϸ� ����Ͻÿ�.
   
   
/*
    �����Լ�
    ����:rank() over([partition by by �÷���] order by �÷��� [desc])"����
    over:������ �ο��ϱ� ���� ��� ������ ���� ���ذ� ���� ��������
    partition by: �÷����� �������� ����, �����ÿ��� ��ü ������ ������� ���� �ο�
    order by �÷���: �÷��� �������� ����

RANK �Լ��� 1���� 2���� ��쿡�� ���� ������ 3������ �ο��Ѵ�.
--���� ����� �������� ��ü ������ ����ϱ� ���� ���

DENSE_RANK �Լ��� ���� ������ 2������ �ο��Ѵ�.
--���� ������ ������ ���� ������ ����ϱ� ���� ���ȴ�.

*/
select gobun,godam,goname, rank() over(order by godam desc) "����"
from gogek where godam is not null;

select gobun,godam, goname, dense_rank() over(order by godam desc) "����"
from gogek where godam is not null;

select * from gogek;


--update gogek set godam = 

--���� ) �μ����� �޿��� ���� ������ ������ ����Ͻÿ�. �� �ΰ��� ����)
--�μ� ��ȣ, ����̸� , �޿� , ����

select deptno,saname,sapay,
case 
    when deptno= 50 then '���ߺ�' 
    when deptno= 20 then '������'
    when deptno =30 then '�����'
    else '�Ѱ�����'
    end "�ӽúμ���"
,sapay, rank() over(partition by deptno order by sapay desc) as ���� from sawon where sapay is not null;


--����Լ� , �����Լ�, �׷��Լ�
--sum, avg, count, max, min �Լ�
-- �׷��Լ��� �Ϲ������÷� �Բ� ����ϱ� ���ؼ� group by �Ϲ������÷� ..... --�����۾� ����

select sum(sapay)/21, avg(nvl(sapay,0)),count(*),max(sapay),min(sapay) from sawon;

--nvl : �÷� �ϳ� �ܵ����� �Լ�. NVL(VAL1,VAL2) VAL1�� null�϶� VAL2�� ġȯ�ϴ� �Լ�
--avg : count ���� ������ �� �־����
-- count (sapay) : ���� �������� ���� COUNT()�� ������� 0�� ��ȯ => count(nvl(sapay,0)) �� ���� ���...


--�μ��� �޿� �հ踦 ���
--�� , 10�� , 20�� �μ��� ���
--��, �޿� �հ谡 15000 �̻��� �׷츸 ��� ***

select deptno, sum(sapay) from sawon
where deptno = 10 or deptno=30 -- where ������ group �Լ��� ����� �� ����.
group by deptno
--���ĵ� -- group by *** ; : ***�� �ִ� ������ �̸� .. �׷�ȭ
--(�Ϲ� �÷��� ����Լ��� ���� ������ ��ȯ���� Ʋ���� �׷�ȭ�� ������� �Ѵ�.)
having sum(sapay)>= 15000; -- group by �� ���� ������

--where ������ group �Լ��� ����� �� ����.

/*
select : ������ �÷�
from : ������, ����Լ� ��� �Ұ���.(from ���� ���� ���� �м��ϱ� ����)
group by - �����÷�
having : ����Լ� ��밡��
order by

*/

--����)����, ��å�� �ο����� �޿��հ踦 ���
-- ��, ���ڸ� �׷�ȭ �ϰ� �ο��� �θ������� ����� ���
-- �ο����� ���� ������ �����Ͻÿ�.

select * from sawon;

select sum(sapay)as s from sawon 
group by sapay
having sgender = '����';


select sajob,count(nvl(sajob,0)) from sawon 
group by sajob
having count(nvl(sajob,0))>=3;
--�������� �׷��� ������. nvl �Լ��� ���� ���ڰ� null �̸� ���� ���ڷ� ġȯ�ϴ� �Լ�



select sgender,sajob,count(sajob), sum(sapay) from sawon
where sgender = '����' and sapay is not null
group by sgender,sajob
--���ĵ� -- group by *** ; : ***�� �ִ� ������ �̸� .. �׷�ȭ
--(�Ϲ� �÷��� ����Լ��� ���� ������ ��ȯ���� Ʋ���� �׷�ȭ�� ������� �Ѵ�.)
having count(sajob)<= 2 
order by sajob;


----------------------------------------------------------------------------------------------------------------------------------------------------------
 select to_char(sysdate , 'yy'), to_char(sysdate,'CC') from dual;
--�Ի�⵵�� �޿��հ�� �ִ� �޿��� ���
select *
 from sawon;

select to_char(sahire , 'yy') , sum(sapay),max(sapay)
from sawon
group by to_char(sahire , 'yy');
--�⵵�� �������� �׷�ȭ


select sahire from sawon group by sahire;



select deptno, max(sapay) from sawon group by deptno order by 2 desc;
--rownum : ���� �÷�, �ӽ÷� �÷��� �ο��Ǵ� �Ϸù�ȣ. 
--where ������ ���� ������ �����Ҷ� ���, ��������(�ټ����� �ֽ� �����͸�..)
--�޿��� ���� ������ ����� ���, ��ȣ �Բ� ���
--����Ŭ�� ���� ������ ����� �˾ƾ� rownum�� ����� ����� �� �ִ�. 
select rownum, saname, sapay 
from sawon  -- ���α׷� ���� ���� 1 -> �� ���¿��� �̹� rownum ���� �������� ���̱� ������ �Ʒ����� ���Ǹ� �ص� �ǹ̰� ��������.
where rownum <= 3 -- ���� ���� 2
order by sapay desc ,saname; --���� ���� 3

--From -> Where -> Select -> Order by
-- from ���� ���� ���� ������ �ǰ� sawon ���̺� rownum �� �ο��ȴ�.
-- �� ���Ŀ� where ���� ���Ǳ� ������ ������ �̷������ ���� rownum <=2 �� row�� ���õȴ�.

--�ζ��� ��. ��������. from ���� ���̺� ��� ���ߵ�.

--���� ���� from �� �ڿ� ���� �������� ������ �����̴�. () �ȿ� ����...���� ����� �䰡 ���� �����. 
--��� �ϴ� ������ ���� ���� ������ �ڹٲٱ� ���� ����ϴ°�. 
--ex)

select rownum, saname,sapay from
(select rownum,saname,sapay from sawon order by sapay desc)  --ex) order by sapay �κп� �÷��� ������ �÷� ��ȣ�� �־ ������ �ȴ�. Order by 1 �̷�������
where rownum <=3;

--�÷� ������ �׷�ȭ
select sum(decode (sajob,'���', sapay,0)) "���",
sum(decode(sajob,'�븮',sapay,0)) "�븮",
sum(decode(sajob,'����',sapay,0)) "����",
sum(decode(sajob,'ȸ��',sapay,0)) "ȸ��",
sum(sapay) "�հ�" from sawon;
--���� �հ� ���ϱ�
--���� | ���� | �հ�

select sajob,decode (sajob,'���', sapay,0) 
from sawon
;

select count -- �־ �غ���.
sum(decode (sgender,'����',0) "����",
sum(decode (sgender,'����',0) "����",
count(*)  "�հ�"
from sawon;
select count(),count(),count(*) "�հ�" from sawon;
select count(sum(decode(sgender , '����',0))) "�հ�" from sawon;

---***Join (����) ***--
--����ϴ� �÷��� �ΰ� �̻��� ���̺� �����ϴ� ��� ���Ǵ� ��� ���� ���
--32������ ����
--����

1.eque(inner) join: ���εǴ� ���̺� ���� ���ǿ� �����ϴ� �ุ�� ����
2.outer join(left & right) : ���εǴ� ���̺� ���� ���ǿ� �����ϴ� ��� ������ ���̺��� ��� �����Ͱ� ����
3.cross join: ���εǴ� ���̺� ���� � ���赵 ���� ��� (table'table)->īƼ�� ��'
-------------------------------------------------------------------------
4.self join : �ڱ� �ڽ��� ���̺�� ���εǴ� ���
--����
1.T-SQL ����: where ������, ���̺���� �����Ͽ� ǥ��
-select~- : ���ϴ� �÷� ����
-from~: ����� �÷��� ���� ���̺� ����
-where~: ���� ���̺� ���� ���� �Ǵ� ������ ǥ��

2.Ansi ����: on������, ���������� ǥ��

--���εǴ� ���̺��� ���� �÷����� ������� ! - ansi
select saname, deptno, dname from sawon natural join dept;
select saname, deptno, dname from sawon join dept using(deptno);





select saname, deptno, dname from sawon natural join dept;


select * from dept;
select * from gogek;

select * from sawon;

--�÷����� ���ƾ� �ϴ°��� ����
select saname,samgr from sawon natural join gogek;
select saname,samgr from sawon join gogek using(sabun);
--�����, �μ���ȣ, �μ����� ���
select s.saname,s.deptno,d.dname from sawon s, dept d --���������� ���� �ʾƵ� �ڵ����� ������ �ϳ�, ���� Ŀ������ �����ս��� �������� ����� �����´�
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

--���� 9) �� �μ��� ��� �޿�, ��ü �޿�, �ְ� ����, ���� ������ ���Ͽ���� ������ ���� ������ ����Ͻÿ�.
--���� 10) 1980 ~ 1983�� ���̿� �Ի�� �� �μ��� ������� �μ���ȣ,�μ���, �Ի�⵵(1980,1981,1982)�� ����Ͻÿ�.

select d.deptno,d.dname,to_char(sahire,'yy') as �Ի�⵵
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
--ansi ������ �ɾ �����͸� ó����

select g.goname,g.gotel, s.saname from gogek g 
where g.godam = s.sabun(+); -- left outer join

select g.goname,g.gotel, s.saname from gogek g 
left outer join sawon s on (g.godam = s.sabun);

--�����, ��å, ����ڸ�, ��å�� ���

select s.saname, s.sajob, m.saname, m.sajob 
from sawon s, sawon m 
where s.samgr = m.sabun(+);

--����, ����ڸ�, ��å, �μ����� ���(����ڰ� ���� ���� ���)

select g.goname, s.saname, s.sajob, d.dname
from gogek g,sawon s,dept d
where g.godam = s.sabun(+) and s.deptno = d.deptno;

--�μ��� , �����, ��å, ����ڸ�, ��å�� ���(��, ����ڰ� ���� ����� ���)
select d.dname, s.saname, s.sajob, m.saname, m.sajob from sawon s, sawon m, dept d
where d.deptno(+) = s.deptno
and s.samgr = m.sabun(+);


--���� 10) 1980 ~ 1983�� ���̿� �Ի�� �� �μ��� ������� �μ���ȣ,�μ���, �Ի�⵵(1980,1981,1982)�� ����Ͻÿ�.
select sahire ,count(decode(to_char(sahire,'yy'),80,0)) as test,
count(decode(to_char(sahire,'yy'),81,0)) as test2,
count(decode(to_char(sahire,'yy'),82,0)) as test3,
count(decode(to_char(sahire,'yy'),83,0)) as test4
from sawon
group by sahire 
;



select  d.deptno as �μ���ȣ , d.dname as �μ���,
count(decode(to_char(sahire,'yy'),80,0)) as test,
count(decode(to_char(sahire,'yy'),81,0)) as test2,
count(decode(to_char(sahire,'yy'),82,0)) as test3,
count(decode(to_char(sahire,'yy'),83,0)) as test4
from sawon s , dept d

where d.deptno = s.deptno
group by d.deptno,d.dname;


having count(decode(to_char(sahire,'yy'),IN(80,81,82,83),0)) > 0;


order by to_char(s.sahire,'yy');




-- between �� ����ؼ� �⵵ ������ ������� ���Ͽ���.
decode(sajob,'�븮',sapay,0)

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


--�μ�(��)�� �޿� �հ踦 ���
select d.dname, sum(s.sapay)

from sawon s, dept d
where d.deptno = s.deptno
group by d.dname;


select count(*) from gogek;

select * from dept;
select * from sawon;
select * from gogek;

select s.saname saname,s.deptno deptno,d.dname dname,s.sapay sapay from sawon s, dept d 
       where s.deptno = d.deptno and dname = '�ѹ���' order by 3 desc;

select * from sawon;

select * from gogek;
