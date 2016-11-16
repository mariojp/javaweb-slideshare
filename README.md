# javaweb-slideshare
Código fonte referente ao curso Java WEB 1 Hands on (http://www.slideshare.net/mariojp/java-web-29911434)


Usando:
- Tomcat 9 (http://tomcat.apache.org)
- Eclipse Neon (https://www.eclipse.org)
- Java 8 (http://www.oracle.com/technetwork/java/javase/downloads/index.html)

Na pasta lib:
- HSQLDB 2.3.4 (http://hsqldb.org)
- JSTL 1.2.5 (https://tomcat.apache.org/download-taglibs.cgi)

SQL DO BANCO:

SET AUTOCOMMIT FALSE;
DROP TABLE USUARIOS;
COMMIT;

CREATE TABLE USUARIOS (
  ID INTEGER IDENTITY PRIMARY KEY,
  LOGIN VARCHAR(30) NOT NULL UNIQUE,
  SENHA  VARCHAR(50) NOT NULL
);
COMMIT;

INSERT INTO USUARIOS ("LOGIN","SENHA") VALUES ('usuario1', '1234');
COMMIT;
INSERT INTO USUARIOS ("LOGIN","SENHA") VALUES ('usuario2', '1234');
COMMIT;

SELECT * FROM USUARIOS;
