

--  schema.sql


-- DROP TABLE MEAL IF EXISTS ;
-- CREATE TABLE MEAL (
--   MEAL_ID               BIGINT AUTO_INCREMENT,
--   START                 TIMESTAMP NOT NULL,
--   DISH                    VARCHAR(100) NOT NULL,
--   USER_ID BIGINT NOT NULL,
--   PRIMARY KEY (MEAL_ID),
--   foreign key (USER_ID) references USER(USER_ID)
-- );

-- DROP TABLE INCIDENT IF EXISTS;
-- CREATE TABLE INCIDENT (
--   INCIDENT_ID               BIGINT AUTO_INCREMENT,
--   START                 TIMESTAMP NOT NULL,
--   REACTION                    VARCHAR(100) NOT NULL,
--   USER_ID BIGINT NOT NULL,
--   PRIMARY KEY (INCIDENT_ID),
--   foreign key (USER_ID) references USER(USER_ID)
-- );



-- TOBIASZOWE

-- DROP TABLE SECURITY IF EXISTS;
-- CREATE TABLE SECURITY (
--   SECURITY_ID               BIGINT AUTO_INCREMENT,
--   LOGIN                 VARCHAR (100) NOT NULL,
--   PASSWORD                 VARCHAR(100) NOT NULL,
--   SALT                    VARCHAR(100) NOT NULL,
--   PRIMARY KEY (SECURITY_ID)
-- );
--
-- DROP TABLE USER IF EXISTS;
-- CREATE TABLE USER (
--   USER_ID               BIGINT AUTO_INCREMENT,
--   NAME                    VARCHAR(100),
--   AGE                    INT,
--   WEIGHT                    DOUBLE(2),
--   HEIGHT                    DOUBLE(2),
--   GENDER                    VARCHAR(100),
--   BMI                    DOUBLE(2),
--   BMR                    DOUBLE(2),
--   SECURITY_ID     BIGINT NOT NULL,
--   PRIMARY KEY (USER_ID),
--   foreign key (SECURITY_ID) references SECURITY(SECURITY_ID)
-- );
--
-- DROP TABLE TRAINING IF EXISTS;
-- CREATE TABLE TRAINING (
--   TRAINING_ID           BIGINT AUTO_INCREMENT,
--   TRAINING_NAME         VARCHAR(100),
--   LEGS                  DOUBLE(2) NOT NULL,
--   CHEST                 DOUBLE(2) NOT NULL,
--   SHOULDERS             DOUBLE(2) NOT NULL,
--   BICEPS                DOUBLE(2) NOT NULL,
--   ABBS                  DOUBLE(2) NOT NULL,
--   DEADLIFT              DOUBLE(2) NOT NULL,
--
--   PRIMARY KEY (TRAINING_ID)
-- );
--
-- DROP TABLE DIET IF EXISTS;
-- CREATE TABLE DIET (
--   DIET_ID           BIGINT AUTO_INCREMENT,
--   BMI_MIN               DOUBLE(2) NOT NULL,
--   BMI_MAX               DOUBLE(2) NOT NULL,
--   PROTEIN               DOUBLE(2) NOT NULL,
--   CARBO                 DOUBLE(2) NOT NULL,
--   FAT                   DOUBLE(2) NOT NULL,
--
--   PRIMARY KEY (DIET_ID)
-- );
--

---------------------------------


-- CREATE TABLE IF NOT EXISTS POLLEN
-- (
--   POLLEN_ID     BIGINT AUTO_INCREMENT,
--   NAME          VARCHAR(100) NOT NULL,
--   START         TIMESTAMP NOT NULL,
--   STOP          TIMESTAMP NOT NULL,
--   PRIMARY KEY (POLLEN_ID)
-- )

-- DROP TABLE ALLERGEN IF EXISTS;
-- CREATE TABLE ALLERGEN (
--   ALLERGEN_ID               BIGINT AUTO_INCREMENT,
--   NAME                 VARCHAR (100) NOT NULL,
--   PRIMARY KEY (ALLERGEN_ID)
-- );
--
-- DROP TABLE DISH IF EXISTS;
-- CREATE TABLE DISH (
--   DISH_ID               BIGINT AUTO_INCREMENT,
--   NAME                 VARCHAR (100) NOT NULL,
--   PRIMARY KEY (DISH_ID)
-- );
--
-- DROP TABLE DISH_ALLERGEN IF EXISTS;
-- CREATE TABLE DISH_ALLERGEN (
--   DISH_ID int REFERENCES DISH (DISH_ID) ON UPDATE CASCADE,
--   ALLERGEN_ID int REFERENCES ALLERGEN(ALLERGEN_ID)  ON UPDATE CASCADE ON DELETE CASCADE,
--    CONSTRAINT DISH_ID_PKEY PRIMARY KEY (DISH_ID, ALLERGEN_ID)  -- explicit pk
-- );