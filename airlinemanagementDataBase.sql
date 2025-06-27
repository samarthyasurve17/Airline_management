use airlinemanagementsystem;
select * from flightdetails;
select * from passenger;
select * from flightdetails;
create table reservation(PNR varchar(15),TICKET_NO varchar(15),AADHAR_NUMBER varchar(15),NAME varchar(15),NATIONALITY varchar(15),FLIGHT_CODE varchar(15),FLIGHT_NAME varchar(15),SOURCE varchar(15),DESTINATION varchar(15));
select * from reservation;

UPDATE flightdetails
SET FLIGHT_NAME = 'SAM AIRLINES'
WHERE FLIGHT_CODE BETWEEN 1001 AND 1014;
ALTER TABLE reservation MODIFY NAME VARCHAR(20);

create table cancel(PNR varchar(15),CANCELATION_NO varchar(15),NAME varchar(15),FLIGHT_CODE varchar(15),FLIGHT_NAME varchar(15),FLIGHT_DATE varchar(15));
select * from cancel;
ALTER TABLE cancel MODIFY PNR VARCHAR(20);
delete from cancel where PNR='SHWETA GHOSALKAR';





