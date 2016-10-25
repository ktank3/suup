SELECT * FROM NOTICES;

INSERT INTO NOTICES(CODE, TITLE, CONTENT, WRITER) VALUES('1082','�����ּ���','������ �ʿ��ؿ�','�ظ���');

SELECT ISNULL(MAX(CONVERT(INT,CODE)),0)+1 AS CODE FROM NOTICES
SELECT ISNULL(MAX(CAST(CODE AS INT)),0)+1 AS CODE FROM NOTICES


SELECT *  
	FROM(
	SELECT ROWNUM NUM, N.* 
		FROM( 
	SELECT *
	FROM NOTICES_VIEW
	WHERE TITLE LIKE '%%'
	ORDER BY REGDATE DESC
	) N	
)    
WHERE NUM BETWEEN 1 AND 10 

SELECT 
	ROW_NUMBER() OVER (ORDER BY REGDATE DESC) NUM, 
	NOTICES.*
FROM NOTICES
WHERE NUM BETWEEN 1 AND 10


---��� ���� ����ϱ� ���� ��
SELECT N.*, COUNT(C.CODE) AS CMTCNT
FROM 
	NOTICES N LEFT OUTER JOIN COMMENTS C ON N.CODE = C.NOTICECODE
GROUP BY N.CODE, N.TITLE, N.WRITER, N.CONTENT, N.REGDATE, N.HIT

SELECT * FROM NOTICES_VIEW

--getList query
SELECT * FROM (
	SELECT 
		ROW_NUMBER() OVER (ORDER BY REGDATE DESC) 'NUM', 
		NOTICES_VIEW.*
	FROM NOTICES_VIEW
	WHERE TITLE LIKE '%%'
	) N
WHERE NUM BETWEEN 1 AND 10


--getCount����
SELECT COUNT(CODE) COUNT FROM NOTICES_VIEW WHERE TITLE LIKE '%%'