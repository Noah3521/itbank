<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div id="main">
	<details open>
		<summary>SQL</summary>
		<fieldset>
			<pre>
DROP TABLE MEMBER4 PURGE;
DROP TABLE BOARD4 PURGE;

DROP SEQUENCE MEMBER4_SEQ;
DROP SEQUENCE BOARD4_SEQ;

CREATE SEQUENCE MEMBER4_SEQ 
    START WITH 1
    MAXVALUE 99999
    INCREMENT BY 1
    NOCYCLE
    NOCACHE;
    
CREATE SEQUENCE BOARD4_SEQ
    START WITH 1
    MAXVALUE 99999
    INCREMENT BY 1
    NOCYCLE
    NOCACHE;
    
CREATE TABLE MEMBER4 (
    IDX 		NUMBER DEFAULT MEMBER4_SEQ.NEXTVAL PRIMARY KEY	,
    USERID 		VARCHAR2(100) NOT NULL UNIQUE					,
    USERPW 		VARCHAR2(300) NOT NULL							,
    SALT 		VARCHAR2(500) NOT NULL							,
    USERNAME 	VARCHAR2(100) NOT NULL							,
    EMAIL 		VARCHAR2(100) NOT NULL
);

CREATE TABLE BOARD4 (
    IDX			  NUMBER DEFAULT BOARD4_SEQ.NEXTVAL PRIMARY KEY,
    TITLE      	  VARCHAR2(100) 	NOT NULL		,
    MEMBER4_IDX   NUMBER 			NOT NULL		,
    CONTENT       VARCHAR2(4000) 	NOT NULL		,
    FILENAME      VARCHAR2(255) 					,
    WDATE      	  DATE 				DEFAULT SYSDATE	,
    VIEWCOUNT 	  NUMBER 			DEFAULT 0		,
    
    CONSTRAINT 	BOARD4_MEMBER2_FK 
    FOREIGN KEY (MEMBER4_IDX)
    REFERENCES 	MEMBER4 (IDX)
);
			</pre>
		</fieldset>
	</details>
	<details open>
		<summary>ERD</summary>
		<img height="700" src="${cpath }/resources/20230920_member2_board4_ERD.png">
	</details>
</div>

</body>
</html>