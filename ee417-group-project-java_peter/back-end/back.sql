--- create database
CREATE DATABASE groupProjectDatabase;

--- create User table
CREATE TABLE Users(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    firstName VARCHAR(255) NOT NULL,
    lastName VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    role ENUM('Admin', 'Lecturer', 'Student', 'Guest'),
    UNIQUE (id)
);

--- create AirSensor table
CREATE TABLE AirSensors (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    time_date DATETIME NOT NULL DEFAULT NOW(),
    location VARCHAR(255) NOT NULL,
    aqi DOUBLE NOT NULL,
    UNIQUE (id)
);

--- create Room table
CREATE TABLE Rooms (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    capacity INT NOT NULL,
    UNIQUE (id)
);

--- create NOiseSensor table
CREATE TABLE NoiseSensors (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    time_date DATETIME NOT NULL DEFAULT NOW(),
    room_id BIGINT FOREIGN KEY,
    noiseLevelDB DOUBLE,
    FOREIGN KEY (room_id) REFERENCES (Room.id),
    UNIQUE (id)
);

--- create RoomOccupancy table
CREATE TABLE RoomOccupancys (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    time_date DATETIME NOT NULL DEFAULT NOW(),
    room_id BIGINT FOREIGN KEY,
    current_occupancy INT NOT NULL,
    percentage_occupancy DOUBLE NOT NULL
    UNIQUE (id),
    FOREIGN KEY (room_id) REFERENCES (Room.id)
);

--- create TrafficType table
CREATE TABLE TrafficTypes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    UNIQUE (id)
);

--- create CampusOccupancy table
CREATE TABLE CampusOccupancies (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    time_date DATETIME NOT NULL DEFAULT NOW(),
    traffic_type_id ENUM('pedestrians', 'cyclist', 'cars'),
    num_in INT NOT NULL,
    num_out INT NOT NULL,
    UNIQUE (id)
);
