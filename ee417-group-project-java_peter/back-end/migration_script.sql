-- ----------------------------------------------------------------------------
-- MySQL Workbench Migration
-- Migrated Schemata: ee417_groupA
-- Source Schemata: ee417group
-- Created: Tue Apr  9 14:52:25 2024
-- Workbench Version: 8.0.36
-- ----------------------------------------------------------------------------

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------------------------------------------------------
-- Schema ee417_groupA
-- ----------------------------------------------------------------------------
DROP SCHEMA IF EXISTS `ee417_groupA` ;
CREATE SCHEMA IF NOT EXISTS `ee417_groupA` ;

-- ----------------------------------------------------------------------------
-- Table ee417_groupA.airsensor
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `ee417_groupA`.`airsensor` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `air_quality` DOUBLE NOT NULL,
  `timeDate` DATETIME(6) NULL DEFAULT NULL,
  `room_id` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKfcrbi3k0yy05kqllv81ofgkha` (`room_id` ASC) VISIBLE,
  CONSTRAINT `FKfcrbi3k0yy05kqllv81ofgkha`
    FOREIGN KEY (`room_id`)
    REFERENCES `ee417_groupA`.`room` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------------------------------------------------------
-- Table ee417_groupA.campusoccupancy
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `ee417_groupA`.`campusoccupancy` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `time_date` DATETIME NOT NULL,
  `traffic_type_id` BIGINT NULL DEFAULT NULL,
  `num_in` INT NOT NULL,
  `num_out` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `traffic_type_id` (`traffic_type_id` ASC) VISIBLE,
  CONSTRAINT `campusoccupancy_ibfk_1`
    FOREIGN KEY (`traffic_type_id`)
    REFERENCES `ee417_groupA`.`traffictype` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------------------------------------------------------
-- Table ee417_groupA.energysage
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `ee417_groupA`.`energysage` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `energyUsage` INT NOT NULL,
  `timeDate` DATETIME(6) NULL DEFAULT NULL,
  `room_id` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKsxq2wgusokglp4n9fqqnl66xj` (`room_id` ASC) VISIBLE,
  CONSTRAINT `FKsxq2wgusokglp4n9fqqnl66xj`
    FOREIGN KEY (`room_id`)
    REFERENCES `ee417_groupA`.`room` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------------------------------------------------------
-- Table ee417_groupA.energyusage
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `ee417_groupA`.`energyusage` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `energyUsage` INT NOT NULL,
  `room_id` BIGINT NULL DEFAULT NULL,
  `timeDate` DATETIME(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKqosrvkymqof93smglmb10cvmv` (`room_id` ASC) VISIBLE,
  CONSTRAINT `FKqosrvkymqof93smglmb10cvmv`
    FOREIGN KEY (`room_id`)
    REFERENCES `ee417_groupA`.`room` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------------------------------------------------------
-- Table ee417_groupA.humiditysensor
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `ee417_groupA`.`humiditysensor` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `humidity` DOUBLE NOT NULL,
  `timeDate` DATETIME(6) NULL DEFAULT NULL,
  `room_id` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKau06kauec4dfkd8bhk03xu16e` (`room_id` ASC) VISIBLE,
  CONSTRAINT `FKau06kauec4dfkd8bhk03xu16e`
    FOREIGN KEY (`room_id`)
    REFERENCES `ee417_groupA`.`room` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------------------------------------------------------
-- Table ee417_groupA.noisesensor
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `ee417_groupA`.`noisesensor` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `room_id` BIGINT NULL DEFAULT NULL,
  `noiseLevelDB` DOUBLE NULL DEFAULT NULL,
  `timeDate` DATETIME(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `room_id` (`room_id` ASC) VISIBLE,
  CONSTRAINT `noisesensor_ibfk_1`
    FOREIGN KEY (`room_id`)
    REFERENCES `ee417_groupA`.`room` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------------------------------------------------------
-- Table ee417_groupA.role
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `ee417_groupA`.`role` (
  `id` BIGINT NOT NULL,
  `name` ENUM('ADMIN', 'STAFF', 'STUDENT', 'GUEST') NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------------------------------------------------------
-- Table ee417_groupA.role_seq
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `ee417_groupA`.`role_seq` (
  `next_val` BIGINT NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------------------------------------------------------
-- Table ee417_groupA.room
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `ee417_groupA`.`room` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `capacity` INT NOT NULL,
  `building` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------------------------------------------------------
-- Table ee417_groupA.room_seq
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `ee417_groupA`.`room_seq` (
  `next_val` BIGINT NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------------------------------------------------------
-- Table ee417_groupA.roomoccupancy
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `ee417_groupA`.`roomoccupancy` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `room_id` BIGINT NULL DEFAULT NULL,
  `currentOccupancy` INT NOT NULL,
  `percentOccupancy` DOUBLE NOT NULL,
  `timeDate` DATETIME(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `room_id` (`room_id` ASC) VISIBLE,
  CONSTRAINT `roomoccupancy_ibfk_1`
    FOREIGN KEY (`room_id`)
    REFERENCES `ee417_groupA`.`room` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------------------------------------------------------
-- Table ee417_groupA.temperaturesensor
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `ee417_groupA`.`temperaturesensor` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `temperature` DOUBLE NOT NULL,
  `room_id` BIGINT NULL DEFAULT NULL,
  `timeDate` DATETIME(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKk845yusq7dv4pvk0uh4learuf` (`room_id` ASC) VISIBLE,
  CONSTRAINT `FKk845yusq7dv4pvk0uh4learuf`
    FOREIGN KEY (`room_id`)
    REFERENCES `ee417_groupA`.`room` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------------------------------------------------------
-- Table ee417_groupA.traffictype
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `ee417_groupA`.`traffictype` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------------------------------------------------------
-- Table ee417_groupA.user
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `ee417_groupA`.`user` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(255) NOT NULL,
  `lastName` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `address` VARCHAR(255) NOT NULL,
  `role` ENUM('Admin', 'Lecturer', 'Student', 'Guest') NULL DEFAULT NULL,
  `eircode` VARCHAR(255) NULL DEFAULT NULL,
  `username` VARCHAR(255) NULL DEFAULT NULL,
  `role_id` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email` (`email` ASC) VISIBLE,
  INDEX `FKn82ha3ccdebhokx3a8fgdqeyy` (`role_id` ASC) VISIBLE,
  CONSTRAINT `FKn82ha3ccdebhokx3a8fgdqeyy`
    FOREIGN KEY (`role_id`)
    REFERENCES `ee417_groupA`.`role` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------------------------------------------------------
-- Table ee417_groupA.user_role
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `ee417_groupA`.`user_role` (
  `user_id` BIGINT NOT NULL,
  `role_id` BIGINT NOT NULL,
  INDEX `FKa68196081fvovjhkek5m97n3y` (`role_id` ASC) VISIBLE,
  INDEX `FK859n2jvi8ivhui0rl0esws6o` (`user_id` ASC) VISIBLE,
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o`
    FOREIGN KEY (`user_id`)
    REFERENCES `ee417_groupA`.`user` (`id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y`
    FOREIGN KEY (`role_id`)
    REFERENCES `ee417_groupA`.`role` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
SET FOREIGN_KEY_CHECKS = 1;
