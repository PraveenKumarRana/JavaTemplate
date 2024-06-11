CREATE TABLE deal
(
    id          int NOT NULL AUTO_INCREMENT,
    deal_name   varchar(255),
    price       double precision,
    item_count  int,
    expiry_time DATETIME,
    PRIMARY KEY (id)
);

CREATE TABLE orders
(
    id          int NOT NULL AUTO_INCREMENT,
    user_id     int,
    deal_id     int,
    item_bought int,
    PRIMARY KEY (id)
);

