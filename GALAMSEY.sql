DROP DATABASE GALAMSEY;	
CREATE DATABASE GALAMSEY;
USE GALAMSEY;

CREATE TABLE OBSERVATORIES (
	ObservatoryID int auto_increment primary key,
    ObsName varchar(45),
    yearStarted smallint not null,
    areaCovered double not null,
    countryLocation varchar(45)
    );

CREATE TABLE GALAMSEY_RECORDS (
	GalamseyId int auto_increment primary key,
    galamseyValue tinyint not null,
	galamseyColour enum('Yellow','Green','Brown') not null,
    yearStarted smallint not null,
    longitude smallint not null,
    latitude smallint not null,
    ObservatoryRecordedIn varchar(45)
    );
    
    
INSERT INTO OBSERVATORIES(ObsName, yearStarted, areaCovered, countryLocation)
VALUES ('Japan Observatory', 2003, 324.56, 'Japan');    
INSERT INTO OBSERVATORIES(ObsName, yearStarted, areaCovered, countryLocation)
VALUES ('Madina Observatory', 2005, 192.6, 'Ghana');
INSERT INTO OBSERVATORIES(ObsName, yearStarted, areaCovered, countryLocation)
VALUES ('Accra Observatory', 2001, 29.65, 'Ghana');
INSERT INTO OBSERVATORIES(ObsName, yearStarted, areaCovered, countryLocation)
VALUES ('Wuhan Observatory', 2007, 34.56, 'China');
INSERT INTO OBSERVATORIES(ObsName, yearStarted, areaCovered, countryLocation)
VALUES ('Lagos Observatory', 2013, 34.56, 'Nigeria');



INSERT INTO GALAMSEY_RECORDS(galamseyValue, galamseyColour, yearStarted, longitude, latitude, ObservatoryRecordedIn) 
VALUES (1, 'Green', 2004, 43, 56,  'Japan Observatory');
INSERT INTO GALAMSEY_RECORDS(galamseyValue, galamseyColour, yearStarted, longitude, latitude, ObservatoryRecordedIn) 
VALUES (3, 'Brown', 1998, 56, 78, 'Wuhan Observatory');
INSERT INTO GALAMSEY_RECORDS(galamseyValue, galamseyColour, yearStarted, longitude, latitude, ObservatoryRecordedIn) 
VALUES (2, 'Yellow', 2009, 49, 97, 'Madina Observatory');
INSERT INTO GALAMSEY_RECORDS(galamseyValue, galamseyColour, yearStarted, longitude, latitude, ObservatoryRecordedIn) 
VALUES (3, 'Brown', 1999, 56, 32, 'Accra Observatory');
INSERT INTO GALAMSEY_RECORDS(galamseyValue, galamseyColour, yearStarted, longitude, latitude, ObservatoryRecordedIn) 
VALUES (1, 'Green', 2002, 34, 83, 'Madina  Observatory');
INSERT INTO GALAMSEY_RECORDS(galamseyValue, galamseyColour, yearStarted, longitude, latitude, ObservatoryRecordedIn) 
VALUES (3, 'Brown', 2002, 38, 43, 'Madina  Observatory');
INSERT INTO GALAMSEY_RECORDS(galamseyValue, galamseyColour, yearStarted, longitude, latitude, ObservatoryRecordedIn) 
VALUES (2, 'Yellow', 2002, 90, 32, 'Wuhan  Observatory');
INSERT INTO GALAMSEY_RECORDS(galamseyValue, galamseyColour, yearStarted, longitude, latitude, ObservatoryRecordedIn) 
VALUES (3, 'Brown', 1999, 73, 45, 'Madina Observatory');
INSERT INTO GALAMSEY_RECORDS(galamseyValue, galamseyColour, yearStarted, longitude, latitude, ObservatoryRecordedIn) 
VALUES (3, 'Brown', 1999, 23, 12, 'Japan Observatory');
INSERT INTO GALAMSEY_RECORDS(galamseyValue, galamseyColour, yearStarted, longitude, latitude, ObservatoryRecordedIn) 
VALUES (2, 'Yellow', 2002, 121, 82, 'Japan  Observatory');

SELECT * FROM GALAMSEY_RECORDS;
SELECT * FROM OBSERVATORIES;

#DELETE FROM OBSERVATORIES WHERE ObservatoryID = 6;