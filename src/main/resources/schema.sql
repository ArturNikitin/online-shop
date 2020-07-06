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
    product_type VARCHAR(50),
    constraint product_id_fkey FOREIGN KEY (product_id) references Products(id)
);

CREATE TABLE IF NOT EXISTS Uneatable_products
(
    product_id INTEGER PRIMARY KEY,
    constraint product_id_fkey FOREIGN KEY (product_id) references Products(id)
);

CREATE TABLE IF NOT EXISTS "users"
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS cart
(
    user_id INTEGER UNIQUE NOT NULL,
    constraint user_id_fkey FOREIGN KEY (user_id) references users(id)
);

CREATE TABLE IF NOT EXISTS cart
(
    cart_id INTEGER NOT NULL,
    product_id INTEGER NOT NULL,
    product_amount INTEGER,
    constraint products_carts_pkey PRIMARY KEY (cart_id, product_id),
    constraint cart_id_fkey FOREIGN KEY (cart_id) references users(id),
    constraint product_id_fkey FOREIGN KEY (product_id) references products(id)
);
