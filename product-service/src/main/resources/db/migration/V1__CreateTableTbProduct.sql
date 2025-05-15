CREATE TABLE tb_product (
    id serial NOT NULL,
    description_product varchar(100) NOT NULL,
    brand_product varchar(255) NOT NULL,
    model_product varchar(255) NOT NULL,
    currency_product varchar(3) NOT NULL,
    price_product float(53) NOT NULL,
    stock_product integer NOT NULL,
    PRIMARY KEY (id)
);