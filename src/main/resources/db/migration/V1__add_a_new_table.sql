DROP TABLE IF EXISTS Prices;

CREATE TABLE Prices (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    brand_id VARCHAR (255),
    start_date VARCHAR (255),
    end_date VARCHAR (255),
    price_list INTEGER,
    product_id FLOAT,
    priority INTEGER,
    price DOUBLE,
    curr VARCHAR(255)
);

INSERT INTO Prices (brand_id, start_date, end_date, price_list, product_id, priority, price, curr)VALUES(1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 1, 35455, 0, 35.50, 'EUR');
INSERT INTO Prices (brand_id, start_date, end_date, price_list, product_id, priority, price, curr)VALUES(1, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 2, 35455, 1, 25.45, 'EUR');
INSERT INTO Prices (brand_id, start_date, end_date, price_list, product_id, priority, price, curr)VALUES(1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 3, 35455, 1, 30.50, 'EUR');
INSERT INTO Prices (brand_id, start_date, end_date, price_list, product_id, priority, price, curr)VALUES(1, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 4, 35455, 1, 38.95, 'EUR');