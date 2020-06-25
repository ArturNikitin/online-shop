CREATE TABLE IF NOT EXISTS Products
(
    id  SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE,
    price DECIMAL NOT NULL
);

CREATE TABLE IF NOT EXISTS Warehouse
(
    product_id INTEGER PRIMARY KEY,
    stock_value INTEGER,
    constraint product_id_fkey FOREIGN KEY (product_id) references Products(id)
);

CREATE TABLE IF NOT EXISTS Eatable_products
(
    product_id INTEGER PRIMARY KEY,
    weight DECIMAL,
    constraint product_id_fkey FOREIGN KEY (product_id) references Products(id)
);

CREATE TABLE IF NOT EXISTS Uneatable_products
(
    product_id INTEGER PRIMARY KEY,
    constraint product_id_fkey FOREIGN KEY (product_id) references Products(id)
);

