-- 2023-09-22 프로시져
/*
프로시져(procedure)
:프로시져는 특정 작업을 수행하는 일종의 서브 프로그램으로
데이타베이스에 저장되는 객체이다
반복되는 코드같은 경우 프로시져에 저장해두었다가 호출해서
실행만 하면 되므로 재사용성이 높다
 
형식
CREATE : 새로 생성, 기존 프로시저가 있을 경우 오류 발생
CREATE OR REPLACE : 새로 생성, 기존 프로지서가 있으면 덮어 쓴다.
create [or replace] procedure 프로시져명
   [파라미터 모드 데이타타입,....]
is
       	변수 선언
begin
            	코드;
end;
/
 
호출:   exec 프로시져명
        exec 프로시져명(값..)
*/

-- 예제 1
-- 프로시저 생성해보기
CREATE OR REPLACE PROCEDURE mytest
IS

BEGIN
    DBMS_OUTPUT.PUT_LINE('프로시저 생성');
END;
/


EXEC mytest;

-- 예제 2: 숫자를 인자롭 보내면 구구단 출력

CREATE OR REPLACE PROCEDURE gugu(dan NUMBER)
IS
BEGIN
    if dan < 2 or dan > 9 THEN
        DBMS_OUTPUT.PUT_LINE('잘못된 숫자입니다.');
    else
        DBMS_OUTPUT.PUT_LINE(' **' || dan || ' 단 **');
        for a in 1..9 LOOP
            DBMS_OUTPUT.PUT_LINE(dan || 'x' || a || '=' || dan*a);
        END LOOP;
    end if;
END;
/


EXEC gugu(9);

INSERT INTO shop
VALUES (seq_shop.nextval, '레이스블라우스', 23000, 'white');
INSERT INTO shop
VALUES (seq_shop.nextval, '레이스조끼', 19000, 'red');
INSERT INTO shop
VALUES (seq_shop.nextval, '체크조끼', 39000, 'rainbow');
INSERT INTO shop
VALUES (seq_shop.nextval, '칠부청바지', 56000, 'blue');
commit;
-- sang_color의 타입 길이 변경
ALTER TABLE shop 
MODIFY sang_color VARCHAR2(30);

-- 예제3 : 상품명을 인자로 보내면 그 단어가 포함된 모든 상품 출력
CREATE OR REPLACE 
PROCEDURE sangpum(sang VARCHAR2)
IS
    CURSOR s1
    IS
    SELECT * FROM shop 
    WHERE sang_name LIKE '%'||sang||'%';
-- 검색된 상품 갯수를 구할 변수
    v_cnt NUMBER(2);
BEGIN
    SELECT COUNT(*)
    INTO v_cnt
    FROM shop 
    WHERE sang_name LIKE '%'||sang||'%';
    if v_cnt = 0
    THEN DBMS_OUTPUT.PUT_LINE(sang||' 상품은 목록에 없습니다.');
    else
        DBMS_OUTPUT.PUT_LINE(sang||' 상품 조회 ');
        DBMS_OUTPUT.PUT_LINE('총 ' || v_cnt|| '개 조회');
        DBMS_OUTPUT.PUT_LINE('상품번호 상품명 가격 색상');
        DBMS_OUTPUT.PUT_LINE('----------------------');
        FOR s IN s1 LOOP
            DBMS_OUTPUT.PUT_LINE(s.sang_no||'  '||s.sang_name||'  '||
            s.sang_price||'  '||s.sang_color);
            EXIT WHEN s1%NOTFOUND;
        END LOOP;
    end if;
END;
/

EXEC sangpum('한복');

-- 예제 4
/*  exec addupdate('레이스조끼', 'black'); : 
    '레이스조끼' 상품이 없으면 추가 있으면 색상 수정
*/
CREATE OR REPLACE 
PROCEDURE addupdate(sang VARCHAR2, price NUMBER, color varchar2)
IS
    -- 상품 수량
    v_cnt number(2);
BEGIN
    SELECT COUNT(*)
    INTO v_cnt FROM shop
    WHERE sang_name = sang;
    if v_cnt = 0
    THEN
        INSERT INTO shop VALUES(seq_shop.nextval, sang, price, color);
        DBMS_OUTPUT.PUT_LINE(sang|| '을 추가했습니다.');
    else
        UPDATE shop
        SET sang_price = price, sang_color = color 
        WHERE sang_name = sang;
        DBMS_OUTPUT.PUT_LINE(sang|| '을 수정했습니다.');

    end if;
end;
/
exec addupdate('청바지', 20000, 'blue');
select * from shop;