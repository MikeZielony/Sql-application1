DROP DATABASE  mentors_applicants;

CREATE DATABASE mentors_applicants
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Polish_Poland.1250'
    LC_CTYPE = 'Polish_Poland.1250'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

DROP TABLE mentors;

CREATE TABLE mentors (
	id SERIAL PRIMARY KEY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	nick_name VARCHAR(50),
	phone_number VARCHAR(50),
	email VARCHAR(50),
	city VARCHAR(50),
	favourite_number INT
);

INSERT INTO mentors(first_name,last_name,nick_name,phone_number,email,city,favourite_number)
VALUES('Pál','Monoczki','Pali','003630/327-2663','pal.monoczki@codecool.com','Miskolc',NULL),
      ('Sándor','Szodoray','Szodi','003620/519-9152','sandor.szodoray@codecool.com','Miskolc',7),
      ('Dániel','Salamon','Dani','003620/508-0706','daniel.salamon@codecool.com','Budapest',4),
      ('Miklós','Beöthy','Miki','003630/256-8118','miklos.beothy@codecool.com','Budapest',42),
      ('Tamás','Tompa','Tomi','003630/370-0748','tamas.tompa@codecool.com','Budapest',42),
      ('Mateusz','Ostafil','Mateusz','003648/518-664-923','mateusz.ostafil@codecool.com','Krakow',13),
      ('Anikó','Fenyvesi','Anikó','003670/111-2222','aniko.fenyvesi@codecool.com','Budapest',11),
      ('Immánuel','Fodor','Immi','003620/123-6234','immanuel.fodor@codecool.com','Budapest',3),
      ('László','Molnár','Laci','003620/222-5566','laszlo.molnar@codecool.com','Budapest',5),
      ('Mátyás','Forián Szabó','Matyi','003630/111-5532','matyas.forian.szabo@codecool.com','Budapest',90),
      ('Zoltán','Sallay','Zozi','003670/898-3122','zoltan.sallay@codecool.com','Budapest',5),
      ('Szilveszter','Erdős','Sly','003620/444-5555','szilveszter.erdos@codecool.com','Budapest',13),
      ('László','Terray','Laci','003670/402-2435','laszlo.terray@codecool.com','Budapest',8),
      ('Árpád','Törzsök','Árpád','003630/222-1221','arpad.torzsok@codecool.com','Budapest',9),
      ('Imre','Lindi','Imi','003670/222-1233','imre.lindi@codecool.com','Miskolc',3),
      ('Róbert','Kohányi','Robi','003630/123-5553','robert.kohanyi@codecool.com','Miskolc',NULL),
      ('Przemysław','Ciąćka','Przemek','003670/222-4554','przemyslaw.ciacka@codecool.com','Krakow',55),
      ('Marcin','Izworski','Marcin','003670/999-2323','marcin.izworski@codecool.com','Krakow',55),
      ('Rafał','Stępień','Rafal','003630/323-5343','rafal.stepien@codecool.com','Krakow',3),
      ('Agnieszka','Koszany','Agi','003630/111-5343','agnieszka.koszany@codecool.com','Krakow',77),
      ('Mateusz','Steliga','Mateusz','003630/123-5343','mateusz.steliga@codecool.com','Krakow',5),
      ('Attila','Molnár','Atesz','003670/630-0539','attila.molnar@codecool.com','Budapest',23);

DROP TABLE applicants;

CREATE TABLE applicants (
	id SERIAL PRIMARY KEY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	phone_number VARCHAR(50),
	email VARCHAR(50),
	application_code INT
);

INSERT INTO applicants(first_name,last_name,phone_number,email,application_code)
VALUES('Dominique','Williams','003630/734-4926','dolor@laoreet.co.uk',61823),
      ('Jemima','Foreman','003620/834-6898','magna@etultrices.net',58324),
      ('Zeph','Massey','003630/216-5351','a.feugiat.tellus@montesnasceturridiculus.co.uk',61349),
      ('Joseph','Crawford','003670/923-2669','lacinia.mattis@arcu.co.uk',12916),
      ('Ifeoma','Bird','003630/465-8994','diam.duis.mi@orcitinciduntadipiscing.com',65603),
      ('Arsenio','Matthews','003620/804-1652','semper.pretium.neque@mauriseu.net',39220),
      ('Jemima','Cantu','003620/423-4261','et.risus.quisque@mollis.co.uk',10384),
      ('Carol','Arnold','003630/179-1827','dapibus.rutrum@litoratorquent.com',70730),
      ('Jane','Forbes','003670/653-5392','janiebaby@adipiscingenimmi.edu',56882),
      ('Ursa','William','003620/496-7064','malesuada@mauriseu.net',91220);