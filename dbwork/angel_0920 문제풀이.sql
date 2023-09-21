--���̺� ���� (student) : num ����(5),name ���ڿ�(10),height ����(5,1),
--  java ����(3) �⺻�� 10,spring ����(3) �⺻�� 10, ban ���ڿ�(20)

CREATE TABLE student1 (
num NUMBER(5), name VARCHAR2(10),
height number(5,1),
java number(3) default 10,
spring number(3) default 10,
ban varchar2(20));




--������ ����  seq_stu  �⺻(1���� 1������), nocache �߰�
create sequence seq_stu1 nocache;



--�������ǵ� �߰�
--num  �� primary key �߰�(student_pk_nu)
ALTER TABLE STUDENT1 ADD CONSTRAINT student_pk_num primary key(num);



--java,spring �� 1~100 �� �����ϵ��� check �������� �߰�
alter table student1 add CONSTRAINT student_ck_java1 check( java > = 1 and java <=100);
alter table student1 add CONSTRAINT student_ck_spring1 check( spring > = 1 and spring <=100);





--ban �� '�޴Թ�','�޴Թ�','���Թ�' �� �߰��Ҽ� �ֵ��� check �߰�
alter table student1 add CONSTRAINT student_ck_ban1 check(ban in('�޴Թ�', '�޴Թ�', '���Թ�'));



--5�� ������ ����Ÿ�� �߰��غ���
insert into student1(num, name, java, height, ban) values(seq_stu1.nextval, '������', 89, 167.5, '�޴Թ�');
insert into student1 values(seq_stu1.nextval, '��', 178.5, 99, 99, '�޴Թ�');
insert into student1 values(seq_stu1.nextval, '��', 168.5, 69, 59, '�޴Թ�');
insert into student1 values(seq_stu1.nextval, '��', 158.5, 79, 49, '�޴Թ�');
insert into student1 values(seq_stu1.nextval, '��', 188.5, 89, 39, '���Թ�');


select * from student1;
--Ŀ���ϱ�

commit;


--num>=4 �̻� ��� ����
delete from student1 where num >= 4;



-- num �� 3�� ����� java������ 99�� ,ban�� '�޴Թ�' ���� ����

update student1 
set java = 99, ban = '�޴Թ�' 
where num = 3;


--num=2 �λ���� Ű�� 188.9 �� ����

update student1 
set height = 188.9 
where num = 2;

--num=2 �� ����Ÿ ����
delete from student1 where num = 2;

--����Ÿ 3������ �� �߰�
insert into student1 values(seq_stu1.nextval, '����', 118.5, 59, 39, '�޴Թ�');
insert into student1 values(seq_stu1.nextval, '����', 168.5, 69, 50, '���Թ�');
insert into student1 values(seq_stu1.nextval, '����', 128.5, 79, 86, '�޴Թ�');
commit;

--��ȸ : �̸�  �� �ڹ�  ������  ����  ��� -������ ���� ������� ���

SELECT name, ban, java, spring, java+spring total, (java+spring)/2 avg FROM student1 ORDER BY total desc;














