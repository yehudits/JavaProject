- מסמך readme המסביר בקצרה כיצד להתקין ולהפעיל את המערכת.
BuyCardsProject
  
Instruction to project installation.

1.Cloning the project.
There are two options in order to get the project locally: 
- cloning from git https://github.com/yehudits/JavaProject.git
- unzipping the project folder.

2. run mvn clean and install in order to get all mvn dependencies for the project.

3. create database
- The project uses JavaDB
- create a dataBase using NetBeans GUI. 
        DataBase Name: BuyCardsProject.
        user Name: root
        Password: root
 
run commands on the db in order to create tables:
- user
  CREATE TABLE "user" (
  id INT NOT NULL GENERATED ALWAYS AS IDENTITY,‏
  "name" VARCHAR(30) NOT NULL,
  email VARCHAR(40) NOT NULL,
  password VARCHAR(30) NOT NULL,
  userType BOOLEAN,
  PRIMARY KEY(id)
  )

- seat
  CREATE TABLE "SEAT" (
  "SEAT_ID" INTEGER not null primary key generated always as identity,
  "SHOW_ID" INTEGER,
  "USER_ID" INTEGER,
  "ROW_NUM" INTEGER,
  "COLUMNS" INTEGER,
  "ORDER_TOKEN" VARCHAR(30)
  );   

- show
  CREATE TABLE "SHOW" (
  "ID" INTEGER not null primary key generated always as identity,
  "OWNER" INTEGER,
  "DESCRIPTION" VARCHAR(200),
  "ADDRESS" VARCHAR(70),
  "ROWS_NUM" INTEGER,
  "COLUMNS" INTEGER,
  "PRICE" INTEGER,
  "DATE" DATE,
  "SHOW_NAME" VARCHAR(70)
  );

In order to launch the project, you must at least one user in the DB (admin user, because new shows requires administartors to create them).
So before running the project you should add a primary user with the command:‏
- insert an administrator:
insert into app."user" ("name","email","password","userType")
values ('admin','admin@gmail.com','pass',true);