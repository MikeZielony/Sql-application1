--exerice 1
SELECT (first_name),(last_name) FROM mentors;
--exercise 2
SELECT (nick_name) FROM mentors
WHERE city='Miskolc';
--exercise 3
SELECT CONCAT_WS(' ', (first_name),(last_name) )AS full_name,(phone_number) FROM applicants
WHERE first_name='Carol';
--exercise 4
SELECT CONCAT_WS(' ', (first_name),(last_name) )AS full_name,(phone_number) FROM applicants
WHERE RIGHT(email,21)='@adipiscingenimmi.edu';
--exercise 5
INSERT INTO applicants (first_name,last_name,phone_number,email,application_code)
VALUES ('Markus','Schaffarzyk','003620/725-2666','djnovus@groovecoverage.com',54823);
SELECT * FROM applicants
WHERE application_code=54823;
--exercise 6
UPDATE applicants 
SET phone_number='003670/223-7459'
WHERE first_name='Jemima' AND last_name='Foreman';
SELECT phone_number FROM applicants
WHERE first_name='Jemima' AND last_name='Foreman';
--exercise 7
DELETE FROM applicants
WHERE RIGHT(email,12)='mauriseu.net';
SELECT * FROM applicants









