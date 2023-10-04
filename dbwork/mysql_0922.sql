-- 테이블 조회
show tables; -- 전체
SELECT * FROM test01;
desc test01;

-- INSERT
INSERT INTO test01
(name, age) 
VALUES('KIM', 40); 

INSERT INTO test01
VALUES(NULL, 'SON', 26, 184.5, NOW(), '2023-01-01');

-- 테이믈 구조 변경( 1.ADD, 2.DROP COLUMN, 3.MODIFY, 4.RENAME COLUMN)
ALTER TABLE test01
ADD hp VARCHAR(20) DEFAULT '010-1111-1111'; -- 컬럼 추가

ALTER TABLE test01
DROP COLUMN age; -- 컬럼 제거

ALTER TABLE test01
RENAME column birthday TO birth; -- 컬럼명 수정

-- 테이블명 변경
ALTER TABLE test01 
RENAME member;

-- 테이블 생성, 제약조건 추가
CREATE TABLE sawon (
    num SMALLINT AUTO_INCREMENT,
    name VARCHAR(20),
    score SMALLINT,
    gender VARCHAR(10),
    buseo VARCHAR(10),
    CONSTRAINT pk_sawon_num PRIMARY KEY (num),
    CONSTRAINT ck_sawon_score CHECK (score BETWEEN 0 AND 100),
    CONSTRAINT ck_sawon_gender CHECK (gender IN ('여자' , '남자'))
);
desc sawon;

-- 제약 조건 확인
select * from information_schema.table_constraints where table_name='sawon';

-- 데이터 추가
INSERT INTO sawon
VALUES (NULL, '손흥민', 89, '여자', '홍보부');

INSERT INTO sawon
VALUES (NULL, '이강인', 99, '남자', '인사부');

INSERT INTO sawon
VALUES (NULL, '홀란드', 55, '여자', '홍보부');

INSERT INTO sawon
VALUES (NULL, '권은비', 99, '여자', '교육부');

INSERT INTO sawon
VALUES (NULL, '음바페', 79, '남자', '인사부');

INSERT INTO sawon
VALUES (NULL, '김민재', 98, '여자', '홍보부');

INSERT INTO sawon
VALUES (NULL, '이재성', 66, '남자', '교보부');

INSERT INTO sawon
VALUES (NULL, '손웅정', 97, '남자', '교육부');

-- 제약조건 오류 확인
INSERT INTO sawon
VALUES (NULL, '손흥민', 120, '여자', '홍보부');

INSERT INTO sawon
VALUES (NULL, '손흥민', 120, '여', '홍보부');

sawon

