-- DB
DROP DATABASE IF EXISTS final_project;
CREATE DATABASE final_project CHARACTER SET=utf8mb4;
USE final_project;

DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `video`;
DROP TABLE IF EXISTS `comment`;
DROP TABLE IF EXISTS `subcomment`;
DROP TABLE IF EXISTS `like`;
DROP TABLE IF EXISTS `follow`;


-- USER
CREATE TABLE `user` (
  `id` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `name` varchar(20) NOT NULL,
  `age` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- VIDEO
CREATE TABLE `video` (
  `youtube_id` varchar(200) NOT NULL,
  `channel_name` varchar(200) NOT NULL,
  `fit_part_name` varchar(10) NOT NULL,
  `title` varchar(200) NOT NULL,
  `view_cnt` int DEFAULT '0',
  PRIMARY KEY (`youtube_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- comment
CREATE TABLE `comment` (
  `comment_no` int NOT NULL AUTO_INCREMENT,
  `youtube_id` varchar(200) NOT NULL,
  `nick_name` varchar(200) NOT NULL,
  `content` varchar(2000) NOT NULL,
  `user_id` varchar(50) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`comment_no`),
  CONSTRAINT `youtube_id_FK` FOREIGN KEY (`youtube_id`) REFERENCES `video` (`youtube_id`) ON DELETE CASCADE,
  CONSTRAINT `user_id_FK` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- subcomment
CREATE TABLE `subcomment` (
  `sub_no` int NOT NULL AUTO_INCREMENT,
  `comment_no` int NOT NULL,
  `nick_name` varchar(200) NOT NULL,
  `content` varchar(2000) NOT NULL,
  `user_id` varchar(50) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`sub_no`),
  CONSTRAINT `comment_no_FK` FOREIGN KEY (`comment_no`) REFERENCES `comment` (`comment_no`) ON DELETE CASCADE,
  CONSTRAINT `subcommnet_user_id_FK` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- LIKE (비디오에 대한 찜)
CREATE TABLE `like` (
	`no` int NOT NULL AUTO_INCREMENT,
	`youtube_id` varchar(200) NOT NULL,
    `user_id` varchar(50) NOT NULL,
	PRIMARY KEY (`no`),
	CONSTRAINT `like_user_id_FK` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE,
	CONSTRAINT `like_youtube_id_FK` FOREIGN KEY (`youtube_id`) REFERENCES `video` (`youtube_id`) ON DELETE CASCADE
)  ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- FOLLOW 
CREATE TABLE `follow`  (
   `no` int NOT NULL AUTO_INCREMENT,
   `user_id` varchar(50) NOT NULL,
   `follow_id` varchar(50) NOT NULL,
   	PRIMARY KEY (`no`),
	CONSTRAINT `follow_follow_id_FK` FOREIGN KEY (`follow_id`) REFERENCES `user` (`id`) ON DELETE CASCADE,
    CONSTRAINT `follow_user_id_FK` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


