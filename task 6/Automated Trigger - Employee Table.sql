CREATE TABLE Employees (
    emp_id INT PRIMARY KEY,
    name VARCHAR(100),
    department VARCHAR(100),
    salary DECIMAL(10,2),
    last_modified TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
CREATE TABLE Employee_Audit_Log (
    log_id INT AUTO_INCREMENT PRIMARY KEY,
    emp_id INT,
    action_type VARCHAR(10),   -- INSERT or UPDATE
    old_salary DECIMAL(10,2),
    new_salary DECIMAL(10,2),
    changed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
DELIMITER //

CREATE TRIGGER after_employee_insert
AFTER INSERT ON Employees
FOR EACH ROW
BEGIN
    INSERT INTO Employee_Audit_Log(emp_id, action_type, old_salary, new_salary)
    VALUES (NEW.emp_id, 'INSERT', NULL, NEW.salary);
END;
//

DELIMITER ;
DELIMITER //

CREATE TRIGGER after_employee_update
AFTER UPDATE ON Employees
FOR EACH ROW
BEGIN
    INSERT INTO Employee_Audit_Log(emp_id, action_type, old_salary, new_salary)
    VALUES (NEW.emp_id, 'UPDATE', OLD.salary, NEW.salary);
END;
//

DELIMITER ;
CREATE VIEW Daily_Activity_Report AS
SELECT 
    DATE(changed_at) AS activity_date,
    action_type,
    COUNT(*) AS total_actions
FROM Employee_Audit_Log
GROUP BY DATE(changed_at), action_type
ORDER BY activity_date DESC;
INSERT INTO Employees VALUES (1, 'Rahul', 'IT', 50000, NOW());
UPDATE Employees SET salary = 55000 WHERE emp_id = 1;

SELECT * FROM Daily_Activity_Report;
