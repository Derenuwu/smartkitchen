DROP TABLE IF EXISTS dish;
CREATE TABLE dish (
   id INT PRIMARY KEY AUTO_INCREMENT,
   name varchar(255),
   price decimal(10,2)
);

INSERT INTO dish (name, price) VALUES
('Gong Bao Chicken', 34.5), ('Pepper Steak & Onion', 19.5);

DROP TABLE IF EXISTS t_table;
CREATE TABLE t_table (
   id INT PRIMARY KEY AUTO_INCREMENT,
   name varchar(255)
);

INSERT INTO t_table (name) VALUES ("table1"), ("table2"), ("table3");

DROP TABLE IF EXISTS t_order;
CREATE TABLE t_order (
   id INT PRIMARY KEY AUTO_INCREMENT,
   table_id INT NOT NULL,
   dish_id INT NOT NULL,
   quantity INT NOT NULL DEFAULT 1,
   FOREIGN KEY (table_id) REFERENCES t_table(id),
   FOREIGN KEY (dish_id) REFERENCES dish(id)
);

INSERT INTO t_order (table_id, dish_id, quantity) 
VALUES
   (1, 1, 2)
;