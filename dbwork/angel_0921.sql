-- DB ����ȭ
-- DB������ �޸𸮸� �������� �ʱ� ���ؼ� � ���̺��� �ĺ��ڸ� ������ ���� ���� ���̺�� ������
-- ������ ����ȭ����Ѵ�. ����ȭ�� �����ͺ��̽��� �ߺ��� �ּ�ȭ�ǵ��� ����� �����ͺ��̽��̴�.
-- ��: �޸� ����, ����ȭ�� �ý������� ���ؼ� ������ ���ϴ�.
-- ��: ��ȸ������ �ſ� ���� �ý����� ��쿡�� ���̺��� JOIN ������ �ݺ������� �̷������ ������ ���� ���� �ӵ��� �ʾ����� �ִ�.

-- student�� num�� �ܺ�Ű�� ���� ���ο� ���̺� stuinfo�� ����
-- �ܺ�Ű�� ���̺� �����ÿ� �����ص� �ǰ� ���߿� �����ص��ȴ�.

CREATE TABLE stuinfo(
    idx number(5) CONSTRAINT stuinfo_pk_idx PRIMARY KEY,
    num number(5),
    addr varchar2(20),
    hp varchar2(20));
    
-- student�� num�� �ܺ�Ű�� ����( ���� : PRIMARY KEY�� ���� ���� )
alter table stuinfo 
ADD CONSTRAINT stuinfo_fk_num 
FOREIGN KEY(num) 
REFERENCES student(num);

-- stuinfo ������ �߰�
INSERT INTO stuinfo
VALUES (seq_stu.nextval, 16, '����� ������', '010-2323-2323');
INSERT INTO stuinfo
VALUES (seq_stu.nextval, 14, '���ֵ� ���ֽ�', '010-5656-5656');
INSERT INTO stuinfo
VALUES (seq_stu.nextval, 17, '�λ�', '010-1212-1212');

SELECT * FROM stuinfo;

-- student�� ��ȸ
SELECT * FROM student;

-- ���������� ��ϵ� �л��� ���ؼ� ��� ������ ���(inner join, equi join)
SELECT
    stu.name, stu.java, stu.spring, stu.ban, info.addr, info.hp
FROM student stu, stuinfo info
WHERE stu.num = info.num;

-- ���� �÷��� ���ٸ� ���� ����
SELECT
    name, java, spring, ban, addr, hp
FROM student stu, stuinfo info
WHERE stu.num = info.num;

-- ���������� ��ϵǾ����� ���� �л����� ��� (OUTER JOIN)
-- SUB TABALE DP(+) : ����� �ȵ� �÷��� NULL ������ ���

SELECT
    stu.name, stu.java, stu.spring, stu.ban, info.addr, info.hp
FROM student stu, stuinfo info
WHERE stu.num = info.num(+);

-- �� ����� NULL�� �л��� ���
SELECT
   stu.num, stu.name, stu.java, stu.spring, stu.ban, info.addr, info.hp
FROM student stu, stuinfo info
WHERE stu.num = info.num(+) AND info.addr IS NULL;

-- SUB ���̺� ����� �����Ͱ� �ִµ� �θ����̺�(student)�� �ش� �����͸� ������ ���
-- student�� 3�� ������ ���� : �ڽ� ���̺�(stuinfo)�� num�� 3�� �����͸� ������ student ����
DELETE 
FROM student
WHERE num=14;

DELETE 
FROM stuinfo
WHERE num = 14;

-- �θ� ���̺� DROP
DROP TABLE student; -- ���� �߻�

-- �ڽ� ���̺� DROP
DROP TABLE stuinfo; -- DROP ����

-------------------------------------------------------------

-- ��ǰ ������ ���� shop ���̺�
-- ��ٱ��Ͽ� ���� cart ���̺� ��ǰ���� ������ ���ؼ� shop�� num�� �ܺ�Ű�� ����
-- ��ǰ�� �����Գ� ��ٱ����� �ش� �����Ͱ� �ڵ����� �����ǵ��� ON DLETE CASCADE�� ����
-- ������ ����
CREATE SEQUENCE seq_shop 
START WITH 10
INCREMENT BY 10
NOCACHE;

-- shop table ����
CREATE TABLE shop(
    sang_no NUMBER(5) CONSTRAINT shop_pk_no PRIMARY KEY,
    sang_name VARCHAR2(100),
    sang_price NUMBER(7),
    sang_color VARCHAR(20)
);

-- �ܺ�Ű�� ����� cart ���̺��� ���� - shop�� ��ǰ�� ����� ��ٱ��� ����� �ڵ����� ����������
-- CASCADE ����
CREATE TABLE cart (
    cart_no NUMBER(5) CONSTRAINT cart_pk_no PRIMARY KEY,
    sang_no NUMBER(5),
    cnt NUMBER(5),
    cartday DATE
    );
    
ALTER TABLE cart 
ADD CONSTRAINT cart_fk_shopno
FOREIGN KEY (sang_no)
REFERENCES shop(sang_no) ON DELETE CASCADE;

-- ��ǰ ���
INSERT INTO shop
VALUES (
    seq_shop.nextval, '���콺' , 23000, 'yellow');
INSERT INTO shop
VALUES (
    seq_shop.nextval, 'û����' , 43000, 'blue');
INSERT INTO shop
VALUES (
    seq_shop.nextval, '����' , 33000, 'green');
INSERT INTO shop
VALUES (
    seq_shop.nextval, '����' , 13000, 'white');
INSERT INTO shop
VALUES (
    seq_shop.nextval, '�ݹ���' , 35000, 'gray');
    
commit;

-- cart�� 3�� �߰� - ���糯¥
INSERT INTO cart
VALUES(seq_shop.nextval, 10, 5, SYSDATE);

INSERT INTO cart
VALUES(seq_shop.nextval, 30, 2, SYSDATE);

INSERT INTO cart
VALUES(seq_shop.nextval, 50, 3, SYSDATE);

SELECT * FROM CART;
-- ��ȸ (INNER JOIN)
-- ��ǰ��, ����, ����, ����, ������(YYYY-MM-DD HH24:MI)
SELECT sang_name, sang_price, sang_color, cnt, TO_CHAR(cartday, 'yyyy-mm-dd hh24:mi') cartday
FROM shop s, cart c
WHERE s.sang_no = c.sang_no;

-- �ƹ��� ���� ���� ��ǰ�� ��ȸ
-- ��ǰ��, ����, ���� ���
SELECT sang_name, sang_price, sang_color
FROM shop s, cart c
WHERE s.sang_no = c.sang_no(+) AND c.cnt IS NULL;

-- CASCADE�� ���� �����Ƿ� cart�� ��� ��ǰ�� ���� ����( cart�� �ڵ����� ������)
DELETE 
FROM shop 
WHERE sang_no = 10;

-- �θ� ���̺� DROP
DROP TABLE shop; -- ����

-- ���̺� ���� �� sub ���̺� ���� ���� �� �θ� ���̺� ����

DROP TABLE CART;
DROP TABLE SHOP;
DROP SEQUENCE SEQ_SHOP;

-- ����
-- ������ : seq_food
-- ������� �޴� ���̺� ( ���̺�� : food)
-- �÷���
CREATE SEQUENCE seq_food;

CREATE TABLE food(
    food_num NUMBER(5),
    fname VARCHAR2(20),
    fprice NUMBER(7));
    
CREATE TABLE person (
    person_num NUMBER(5),
    food_num NUMBER(5),
    person_name VARCHAR2(10),
    bookingday DATE);
    
ALTER TABLE food ADD CONSTRAINT pk_food_num PRIMARY KEY(food_num);
ALTER TABLE person 
ADD CONSTRAINT pk_person_num 
PRIMARY KEY(person_num);

ALTER TABLE person 
ADD CONSTRAINT fk_food_num 
FOREIGN KEY(food_num)
REFERENCES food(food_num)
ON DELETE CASCADE;

INSERT INTO food
VALUES (seq_food.nextval, '��', 5000);
INSERT INTO food
VALUES (seq_food.nextval, '��', 2000);
INSERT INTO food
VALUES (seq_food.nextval, '����', 3000);
INSERT INTO food
VALUES (seq_food.nextval, '��', 1000);
INSERT INTO food
VALUES (seq_food.nextval, '�����', 2000);
    
SELECT * FROM FOOD;
SELECT * FROM person;

INSERT INTO person
VALUES (seq_food.nextval, 5, '�达' , SYSDATE);
INSERT INTO person
VALUES (seq_food.nextval, 5, '�ھ�' , SYSDATE);
INSERT INTO person
VALUES (seq_food.nextval, 4, '�̾�' , SYSDATE);

DELETE FROM FOOD
WHERE food_num = 5;

SELECT 
f.food_num ������, person_name �ֹ��ڸ�, 
fname ���ĸ�, fprice ����, TO_CHAR(bookingday , 'YYYY-MM-DD')������ 
FROM food f, person p
WHERE f.food_num = p.food_num;
COMMIT;