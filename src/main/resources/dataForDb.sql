
CREATE DATABASE IF NOT EXISTS `spring_mvc`
USE `spring_mvc`;

CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DELETE FROM `hibernate_sequence`;
INSERT INTO `hibernate_sequence` (`next_val`) VALUES
	(1);
CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DELETE FROM `role`;
INSERT INTO `role` (`id`, `role`) VALUES
	(1, 'ADMIN'),
	(2, 'USER');
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint NOT NULL,
  `active` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DELETE FROM `user`;
INSERT INTO `user` (`id`, `active`, `password`, `username`) VALUES
	(1, b'1', '$2a$08$WWA08BjCH9Tfdag0KIy3ouLRrOiICSl3DPXT0iEafDH/BRHzjNEJe', 'admin'),
	(2, b'1', '$2a$08$WWA08BjCH9Tfdag0KIy3ouLRrOiICSl3DPXT0iEafDH/BRHzjNEJe', 'user');



CREATE TABLE IF NOT EXISTS `user_roles` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  KEY `FKrhfovtciq1l558cw6udg0h0d3` (`role_id`),
  KEY `FK55itppkw3i07do3h7qoclqd4k` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DELETE FROM `user_roles`;

INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES
	(1, 1),
	(2, 2);