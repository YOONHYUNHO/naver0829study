-- DB 정규화
-- DB서버의 메모리를 낭비하지 않기 위해서 어떤 테이블을 식별자를 가지는 여러 개의 테이블로 나누는
-- 과정을 정규화라고한다. 정규화된 데이터베이스는 중복이 최소화되도록 설계된 데이터베이스이다.
-- 장: 메모리 절약, 구조화된 시스템으로 인해서 관리가 편하다.
-- 단: 조회비율이 매우 높은 시스템의 경우에는 테이블간의 JOIN 연산이 반복적으로 이루어지기 때문에 질의 응답 속도가 늦어질수 있다.

-- student의 num을 외부키로 갖는 새로운 테이블 stuinfo를 생성
-- 외부키는 테이블 생성시에 설정해도 되고 나중에 설정해도된다.

CREATE TABLE stuinfo(
    idx number(5) CONSTRAINT stuinfo_pk_idx PRIMARY KEY,
    num number(5),
    addr varchar2(20),
    hp varchar2(20));
    
-- student의 num을 외부키로 설정( 주의 : PRIMARY KEY만 연결 가능 )
alter table stuinfo 
ADD CONSTRAINT stuinfo_fk_num 
FOREIGN KEY(num) 
REFERENCES student(num);

-- stuinfo 데이터 추가
INSERT INTO stuinfo
VALUES (seq_stu.nextval, 16, '서울시 강남구', '010-2323-2323');
INSERT INTO stuinfo
VALUES (seq_stu.nextval, 14, '제주도 제주시', '010-5656-5656');
INSERT INTO stuinfo
VALUES (seq_stu.nextval, 17, '부산', '010-1212-1212');

SELECT * FROM stuinfo;

-- student만 조회
SELECT * FROM student;

-- 개인정보가 등록된 학생에 한해서 모든 정보를 출력(inner join, equi join)
SELECT
    stu.name, stu.java, stu.spring, stu.ban, info.addr, info.hp
FROM student stu, stuinfo info
WHERE stu.num = info.num;

-- 같은 컬럼이 없다면 생략 가능
SELECT
    name, java, spring, ban, addr, hp
FROM student stu, stuinfo info
WHERE stu.num = info.num;

-- 개인정보가 등록되어있지 않은 학생들을 출력 (OUTER JOIN)
-- SUB TABALE DP(+) : 등록이 안된 컬럼은 NULL 값으로 출력

SELECT
    stu.name, stu.java, stu.spring, stu.ban, info.addr, info.hp
FROM student stu, stuinfo info
WHERE stu.num = info.num(+);

-- 위 결과에 NULL인 학생만 출력
SELECT
   stu.num, stu.name, stu.java, stu.spring, stu.ban, info.addr, info.hp
FROM student stu, stuinfo info
WHERE stu.num = info.num(+) AND info.addr IS NULL;

-- SUB 테이블에 연결된 데이터가 있는데 부모테이블(student)의 해당 데이터를 삭제할 경우
-- student의 3번 데이터 삭제 : 자식 테이블(stuinfo)의 num이 3인 데이터를 삭제후 student 삭제
DELETE 
FROM student
WHERE num=14;

DELETE 
FROM stuinfo
WHERE num = 14;

-- 부모 테이블 DROP
DROP TABLE student; -- 오류 발생

-- 자식 테이블 DROP
DROP TABLE stuinfo; -- DROP 가능

-------------------------------------------------------------

-- 상품 정보를 담을 shop 테이블
-- 장바구니에 담을 cart 테이블 상품정보 저장을 위해서 shop의 num을 외부키로 설정
-- 상품을 삭제함녀 장바구니의 해당 데이터가 자동으로 삭제되도록 ON DLETE CASCADE를 설정
-- 시퀀스 생성
CREATE SEQUENCE seq_shop 
START WITH 10
INCREMENT BY 10
NOCACHE;

-- shop table 생성
CREATE TABLE shop(
    sang_no NUMBER(5) CONSTRAINT shop_pk_no PRIMARY KEY,
    sang_name VARCHAR2(100),
    sang_price NUMBER(7),
    sang_color VARCHAR(20)
);

-- 외부키로 연결된 cart 테이블을 생성 - shop의 상품을 지우면 장바구니 목록은 자동으로 지워지도록
-- CASCADE 생성
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

-- 상품 등록
INSERT INTO shop
VALUES (
    seq_shop.nextval, '블라우스' , 23000, 'yellow');
INSERT INTO shop
VALUES (
    seq_shop.nextval, '청바지' , 43000, 'blue');
INSERT INTO shop
VALUES (
    seq_shop.nextval, '긴팔' , 33000, 'green');
INSERT INTO shop
VALUES (
    seq_shop.nextval, '반팔' , 13000, 'white');
INSERT INTO shop
VALUES (
    seq_shop.nextval, '반바지' , 35000, 'gray');
    
commit;

-- cart에 3개 추가 - 현재날짜
INSERT INTO cart
VALUES(seq_shop.nextval, 10, 5, SYSDATE);

INSERT INTO cart
VALUES(seq_shop.nextval, 30, 2, SYSDATE);

INSERT INTO cart
VALUES(seq_shop.nextval, 50, 3, SYSDATE);

SELECT * FROM CART;
-- 조회 (INNER JOIN)
-- 상품명, 가격, 색상, 갯수, 구입일(YYYY-MM-DD HH24:MI)
SELECT sang_name, sang_price, sang_color, cnt, TO_CHAR(cartday, 'yyyy-mm-dd hh24:mi') cartday
FROM shop s, cart c
WHERE s.sang_no = c.sang_no;

-- 아무도 담지 않은 상품명 조회
-- 상품명, 가격, 색상 출력
SELECT sang_name, sang_price, sang_color
FROM shop s, cart c
WHERE s.sang_no = c.sang_no(+) AND c.cnt IS NULL;

-- CASCADE를 지정 했으므로 cart에 담긴 상품도 삭제 가능( cart도 자동으로 지워짐)
DELETE 
FROM shop 
WHERE sang_no = 10;

-- 부모 테이블 DROP
DROP TABLE shop; -- 에러

-- 테이블 삭제 시 sub 테이블 먼저 제거 후 부모 테이블 제거

DROP TABLE CART;
DROP TABLE SHOP;
DROP SEQUENCE SEQ_SHOP;

-- 문제
-- 시퀀스 : seq_food
-- 레스토랑 메뉴 테이블 ( 테이블명 : food)
-- 컬럼명
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
VALUES (seq_food.nextval, '밥', 5000);
INSERT INTO food
VALUES (seq_food.nextval, '국', 2000);
INSERT INTO food
VALUES (seq_food.nextval, '반찬', 3000);
INSERT INTO food
VALUES (seq_food.nextval, '물', 1000);
INSERT INTO food
VALUES (seq_food.nextval, '음료수', 2000);
    
SELECT * FROM FOOD;
SELECT * FROM person;

INSERT INTO person
VALUES (seq_food.nextval, 5, '김씨' , SYSDATE);
INSERT INTO person
VALUES (seq_food.nextval, 5, '박씨' , SYSDATE);
INSERT INTO person
VALUES (seq_food.nextval, 4, '이씨' , SYSDATE);

DELETE FROM FOOD
WHERE food_num = 5;

SELECT 
f.food_num 시퀀스, person_name 주문자명, 
fname 음식명, fprice 가격, TO_CHAR(bookingday , 'YYYY-MM-DD')예약일 
FROM food f, person p
WHERE f.food_num = p.food_num;
COMMIT;