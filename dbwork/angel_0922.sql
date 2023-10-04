-- 2023-09-22 ���ν���
/*
���ν���(procedure)
:���ν����� Ư�� �۾��� �����ϴ� ������ ���� ���α׷�����
����Ÿ���̽��� ����Ǵ� ��ü�̴�
�ݺ��Ǵ� �ڵ尰�� ��� ���ν����� �����صξ��ٰ� ȣ���ؼ�
���ุ �ϸ� �ǹǷ� ���뼺�� ����
 
����
CREATE : ���� ����, ���� ���ν����� ���� ��� ���� �߻�
CREATE OR REPLACE : ���� ����, ���� ���������� ������ ���� ����.
create [or replace] procedure ���ν�����
   [�Ķ���� ��� ����ŸŸ��,....]
is
       	���� ����
begin
            	�ڵ�;
end;
/
 
ȣ��:   exec ���ν�����
        exec ���ν�����(��..)
*/

-- ���� 1
-- ���ν��� �����غ���
CREATE OR REPLACE PROCEDURE mytest
IS

BEGIN
    DBMS_OUTPUT.PUT_LINE('���ν��� ����');
END;
/


EXEC mytest;

-- ���� 2: ���ڸ� ���ڷ� ������ ������ ���

CREATE OR REPLACE PROCEDURE gugu(dan NUMBER)
IS
BEGIN
    if dan < 2 or dan > 9 THEN
        DBMS_OUTPUT.PUT_LINE('�߸��� �����Դϴ�.');
    else
        DBMS_OUTPUT.PUT_LINE(' **' || dan || ' �� **');
        for a in 1..9 LOOP
            DBMS_OUTPUT.PUT_LINE(dan || 'x' || a || '=' || dan*a);
        END LOOP;
    end if;
END;
/


EXEC gugu(9);

INSERT INTO shop
VALUES (seq_shop.nextval, '���̽����콺', 23000, 'white');
INSERT INTO shop
VALUES (seq_shop.nextval, '���̽�����', 19000, 'red');
INSERT INTO shop
VALUES (seq_shop.nextval, 'üũ����', 39000, 'rainbow');
INSERT INTO shop
VALUES (seq_shop.nextval, 'ĥ��û����', 56000, 'blue');
commit;
-- sang_color�� Ÿ�� ���� ����
ALTER TABLE shop 
MODIFY sang_color VARCHAR2(30);

-- ����3 : ��ǰ���� ���ڷ� ������ �� �ܾ ���Ե� ��� ��ǰ ���
CREATE OR REPLACE 
PROCEDURE sangpum(sang VARCHAR2)
IS
    CURSOR s1
    IS
    SELECT * FROM shop 
    WHERE sang_name LIKE '%'||sang||'%';
-- �˻��� ��ǰ ������ ���� ����
    v_cnt NUMBER(2);
BEGIN
    SELECT COUNT(*)
    INTO v_cnt
    FROM shop 
    WHERE sang_name LIKE '%'||sang||'%';
    if v_cnt = 0
    THEN DBMS_OUTPUT.PUT_LINE(sang||' ��ǰ�� ��Ͽ� �����ϴ�.');
    else
        DBMS_OUTPUT.PUT_LINE(sang||' ��ǰ ��ȸ ');
        DBMS_OUTPUT.PUT_LINE('�� ' || v_cnt|| '�� ��ȸ');
        DBMS_OUTPUT.PUT_LINE('��ǰ��ȣ ��ǰ�� ���� ����');
        DBMS_OUTPUT.PUT_LINE('----------------------');
        FOR s IN s1 LOOP
            DBMS_OUTPUT.PUT_LINE(s.sang_no||'  '||s.sang_name||'  '||
            s.sang_price||'  '||s.sang_color);
            EXIT WHEN s1%NOTFOUND;
        END LOOP;
    end if;
END;
/

EXEC sangpum('�Ѻ�');

-- ���� 4
/*  exec addupdate('���̽�����', 'black'); : 
    '���̽�����' ��ǰ�� ������ �߰� ������ ���� ����
*/
CREATE OR REPLACE 
PROCEDURE addupdate(sang VARCHAR2, price NUMBER, color varchar2)
IS
    -- ��ǰ ����
    v_cnt number(2);
BEGIN
    SELECT COUNT(*)
    INTO v_cnt FROM shop
    WHERE sang_name = sang;
    if v_cnt = 0
    THEN
        INSERT INTO shop VALUES(seq_shop.nextval, sang, price, color);
        DBMS_OUTPUT.PUT_LINE(sang|| '�� �߰��߽��ϴ�.');
    else
        UPDATE shop
        SET sang_price = price, sang_color = color 
        WHERE sang_name = sang;
        DBMS_OUTPUT.PUT_LINE(sang|| '�� �����߽��ϴ�.');

    end if;
end;
/
exec addupdate('û����', 20000, 'blue');
select * from shop;