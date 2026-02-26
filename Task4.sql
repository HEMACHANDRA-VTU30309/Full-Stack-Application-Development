create database market;
use market;
CREATE TABLE Customers (
    customer_id INT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    city VARCHAR(50)
);
CREATE TABLE Products (
    product_id INT PRIMARY KEY,
    product_name VARCHAR(100),
    price DECIMAL(10,2)
);
CREATE TABLE Orders (
    order_id INT PRIMARY KEY,
    customer_id INT,
    product_id INT,
    quantity INT,
    order_date DATE,
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id),
    FOREIGN KEY (product_id) REFERENCES Products(product_id)
);
INSERT INTO Customers VALUES
(1, 'Ravi', 'ravi@gmail.com', 'Hyderabad'),
(2, 'Anita', 'anita@gmail.com', 'Bangalore'),
(3, 'Suresh', 'suresh@gmail.com', 'Chennai');

INSERT INTO Products VALUES
(101, 'Laptop', 60000),
(102, 'Mobile', 20000),
(103, 'Headphones', 2000);

INSERT INTO Orders VALUES
(1001, 1, 101, 1, '2025-01-01'),
(1002, 1, 103, 2, '2025-01-05'),
(1003, 2, 102, 1, '2025-01-07'),
(1004, 2, 103, 3, '2025-01-10'),
(1005, 2, 101, 1, '2025-01-15');


SELECT 
    c.name AS customer_name,
    p.product_name,
    o.quantity,
    p.price,
    (o.quantity * p.price) AS total_amount,
    o.order_date
FROM Orders o
JOIN Customers c ON o.customer_id = c.customer_id
JOIN Products p ON o.product_id = p.product_id
ORDER BY o.order_date DESC;

SELECT *
FROM (
    SELECT 
        o.order_id,
        c.name,
        (o.quantity * p.price) AS order_value
    FROM Orders o
    JOIN Customers c ON o.customer_id = c.customer_id
    JOIN Products p ON o.product_id = p.product_id
) AS order_values
WHERE order_value = (
    SELECT MAX(o.quantity * p.price)
    FROM Orders o
    JOIN Products p ON o.product_id = p.product_id
);

SELECT name
FROM Customers
WHERE customer_id = (
    SELECT customer_id
    FROM Orders
    GROUP BY customer_id
    ORDER BY COUNT(order_id) DESC
    LIMIT 1
);

SELECT 
    c.name,
    SUM(o.quantity * p.price) AS total_spent
FROM Orders o
JOIN Customers c ON o.customer_id = c.customer_id
JOIN Products p ON o.product_id = p.product_id
GROUP BY c.name
ORDER BY total_spent DESC;

