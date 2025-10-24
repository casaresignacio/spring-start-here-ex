
CREATE TABLE IF NOT EXISTS account (
    id INT PRIMARY KEY AUTO_INCREMENT,  -- O IDENTITY para compatibilidad amplia
    name VARCHAR(50) NOT NULL,
    amount DECIMAL(10, 2) NOT NULL
);

