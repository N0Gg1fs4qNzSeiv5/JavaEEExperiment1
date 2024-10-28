DROP DATABASE IF EXISTS `javaee_experiment1`;

CREATE DATABASE `javaee_experiment1`;

USE `javaee_experiment1`;

CREATE TABLE `user` (
    `id` int NOT NULL AUTO_INCREMENT,
    `username` varchar(255) NOT NULL,
    `password` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `message` (
    `id` int NOT NULL AUTO_INCREMENT,
    `title` varchar(255) NOT NULL,
    `content` text NOT NULL,
    `datetime` DATETIME NOT NULL,
    `user_id` int NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (user_id) REFERENCES `user`(id)
);


CREATE TABLE `reply` (
    `id` int NOT NULL AUTO_INCREMENT,
    `content` text NOT NULL,
    `datetime` DATETIME NOT NULL,
    `user_id` int NOT NULL,
    `message_id` int NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (user_id) REFERENCES `user`(id),
    FOREIGN KEY (message_id) REFERENCES `message`(id)
);