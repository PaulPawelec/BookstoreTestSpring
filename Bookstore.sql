DROP TABLE IF EXISTS `authors`;
CREATE TABLE `authors` (
 `id` int NOT NULL AUTO_INCREMENT,
 `name` varchar(64) DEFAULT NULL,
 `surname` varchar(64) DEFAULT NULL,
 PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories` (
 `id` int NOT NULL AUTO_INCREMENT,
 `name` varchar(40) DEFAULT NULL,
 PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
 `id` int NOT NULL AUTO_INCREMENT,
 `name` varchar(100) DEFAULT NULL,
 `publisher` varchar(50) DEFAULT NULL,
 `price` float DEFAULT NULL,
 `category_id` int DEFAULT NULL,
 PRIMARY KEY (`id`),
 FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`)
);

DROP TABLE IF EXISTS `authors_to_books`;
CREATE TABLE `authors_to_books` (
 `book_id` int NOT NULL,
 `author_id` int NOT NULL,
 PRIMARY KEY (`book_id`, `author_id`),
 FOREIGN KEY (`book_id`) REFERENCES `books` (`id`),
 FOREIGN KEY (`author_id`) REFERENCES `authors` (`id`)
);

drop table if exists `users`;
CREATE TABLE users (
 username VARCHAR(35) NOT NULL,
 password VARCHAR(60) NOT NULL,
 enabled boolean NOT NULL DEFAULT TRUE,
 PRIMARY KEY (username)
);
DROP TABLE IF EXISTS `authorities`;

CREATE TABLE authorities (
 username varchar(35) NOT NULL,
 authority varchar(50) NOT NULL,

 UNIQUE KEY `authorieties_idx_1` (`username`, `authority`),
 FOREIGN KEY (`username`) REFERENCES `users` (`username`)
);

CREATE TABLE `orders` (
 `id` int(10) NOT NULL AUTO_INCREMENT,
 `price` float DEFAULT NULL,
 `status` VARCHAR(25) DEFAULT NULL,
 `date_time` timestamp DEFAULT CURRENT_TIMESTAMP,
 `username` VARCHAR(25) DEFAULT NULL,
 PRIMARY KEY (`id`),
FOREIGN KEY (`username`) REFERENCES `users` (`username`)
)

CREATE TABLE `orders_to_books` (
 `book_id` int(11) NOT NULL,
 `order_id` int(10) NOT NULL,
 PRIMARY KEY (`book_id`,`order_id`),
 CONSTRAINT `FK_ORDER` FOREIGN KEY (`order_id`)
 REFERENCES `orders` (`id`),
 CONSTRAINT `FK_BOOK` FOREIGN KEY (`book_id`)
 REFERENCES `books` (`id`)
);

INSERT INTO `categories` VALUES (1, 'Literatura polska');
INSERT INTO `categories` VALUES (2, 'Literatura zagraniczna');
INSERT INTO `categories` VALUES (3, 'Fantasy');
INSERT INTO `books` VALUES (1, 'Hamlet', 'AAA', 6.5, 2);
INSERT INTO `books` VALUES (2, 'Makbet', 'AAA', 6.8, 2);
INSERT INTO `books` VALUES (3, 'Potop', 'BBB', 18.4, 1);
INSERT INTO `books` VALUES (4, 'Quo vadis', 'BBB', 17.99, 1);
INSERT INTO `books` VALUES (5, 'Pan Tadeusz', 'CCC', 13.78, 1);
INSERT INTO `books` VALUES (6, 'Nad Niemnem', 'CCC', 15.45, 1);
INSERT INTO `books` VALUES (7, 'Eragon', 'MAG', 21.45, 3);
INSERT INTO `authors` (`name` , `surname`) VALUES
('William', 'Shakespeare'),
('Henryk', 'Sienkiewicz'),
('Adam', 'Mickiewicz'),
('Eliza', 'Orzeszkowa'),
('Jaroslaw', 'Grzedowicz'),
('Christopher', 'Paolini');
INSERT INTO `authors_to_books` VALUES (1, 1);
INSERT INTO `authors_to_books` VALUES (1, 5);
INSERT INTO `authors_to_books` VALUES (2, 1);
INSERT INTO `authors_to_books` VALUES (2, 5);
INSERT INTO `authors_to_books` VALUES (3, 2);
INSERT INTO `authors_to_books` VALUES (4, 2);
INSERT INTO `authors_to_books` VALUES (5, 3);
INSERT INTO `authors_to_books` VALUES (6, 4);
INSERT INTO `authors_to_books` VALUES (7, 6);