CREATE TABLE IF NOT EXISTS `stores` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `products` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) DEFAULT NULL,
    `price` int(11) DEFAULT NULL,
    `quantity` int(11) DEFAULT NULL,
    `store_id` int(11) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`store_id`) REFERENCES `stores`(`id`)
);
