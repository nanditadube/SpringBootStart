# SpringBootStart
Starter project for Spring Boot

This project conatins a simple implementation of fetching data from an Oracle 11g database using SpringBoot and displaying using Thymeleaf.

Following is the schema for the table fetched:
CREATE TABLE "TEST"."SERVERCONFIG" 
   (	"ID" NUMBER(11,0), 
	"CONFIGURATION" VARCHAR2(45 BYTE), 
	"CONFKEY" VARCHAR2(128 BYTE), 
	"CONFVALUE" VARCHAR2(4000 BYTE)
   );
