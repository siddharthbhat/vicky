--- ---------------------------------------------------------
--- This file contains dummy data to be sent to the server to simulate data to retrieve
--- ---------------------------------------------------------
-- Dummy data for table `ee417group.room`
INSERT INTO `ee417group`.`room` (`name`, `capacity`, `building`) VALUES
('Room A', 20, 'Building 1'),
('Room B', 30, 'Building 2'),
('Room C', 25, 'Building 3');

-- Dummy data for table `ee417group.roomoccupancy`
INSERT INTO `ee417group`.`roomoccupancy` (`room_id`, `currentOccupancy`, `percentOccupancy`, `timeDate`) VALUES
(1, 15, 75.0, '2024-04-11 12:00:00'),
(2, 20, 66.67, '2024-04-11 12:00:00'),
(3, 10, 40.0, '2024-04-11 12:00:00');

-- Dummy data for table `ee417group.role`
INSERT INTO `ee417group`.`role` (`id`, `name`) VALUES
(1, 'ADMIN'),
(2, 'STAFF'),
(3, 'STUDENT'),
(4, 'GUEST');

-- Dummy data for table `ee417group.user`
INSERT INTO `ee417group`.`user` (`firstName`, `lastName`, `email`, `password`, `address`, `role_id`, `username`) VALUES
('John', 'Doe', 'john.doe@example.com', 'password123', '123 Main St', 3, 'johndoe'),
('Jane', 'Smith', 'jane.smith@example.com', 'password456', '456 Elm St', 3, 'janesmith'),
('Staff', 'Staff', 'admin@example.com', 'admin123', '789 Oak St', 2, 'staff');

-- Dummy data for table `ee417group.temperaturesensor`
INSERT INTO `ee417group`.`temperaturesensor` (`temperature`, `room_id`, `timeDate`) VALUES
(22.5, 1, '2024-04-11 12:00:00'),
(23.0, 2, '2024-04-11 12:00:00'),
(21.8, 3, '2024-04-11 12:00:00');

-- Dummy data for table `ee417group.noisesensor`
INSERT INTO `ee417group`.`noisesensor` (`noiseLevelDB`, `room_id`, `timeDate`) VALUES
(40.0, 1, '2024-04-11 12:00:00'),
(45.0, 2, '2024-04-11 12:00:00'),
(42.5, 3, '2024-04-11 12:00:00');

-- Dummy data for table `ee417group.humiditysensor`
INSERT INTO `ee417group`.`humiditysensor` (`humidity`, `room_id`, `timeDate`) VALUES
(50.0, 1, '2024-04-11 12:00:00'),
(55.0, 2, '2024-04-11 12:00:00'),
(52.0, 3, '2024-04-11 12:00:00');
