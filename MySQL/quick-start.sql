-- Create Employee table
CREATE TABLE Employee
(
    EmployeeId   INT PRIMARY KEY,
    EmployeeName VARCHAR(100) NOT NULL,
    Salary       DECIMAL(10, 2)
);

-- Insert some sample data
INSERT INTO Employee (EmployeeId, EmployeeName, Salary)
VALUES (1, 'John Smith', 50000.00),
       (2, 'Jane Doe', 60000.00),
       (3, 'Mike Johnson', 55000.00),
       (4, 'Sarah Williams', 62000.00),
       (5, 'David Brown', 58000.00);

-- Query to verify the table structure and data
SELECT *
FROM Employee;

-- Create Product table
CREATE TABLE Product
(
    ProductId   CHAR(12) PRIMARY KEY,
    ProductName VARCHAR(100) NOT NULL,
    Category    VARCHAR(20) CHECK (Category IN ('手机', '电脑'))
);

-- Insert some sample data
INSERT INTO Product (ProductId, ProductName, Category)
VALUES ('P001', 'iPhone 15 Pro', '手机'),
       ('P002', 'Samsung Galaxy S24', '手机'),
       ('P003', 'MacBook Air M2', '电脑'),
       ('P004', 'Dell XPS 13', '电脑'),
       ('P005', 'Huawei MateBook X', '电脑');

-- Query to verify the table structure and data
SELECT *
FROM Product;