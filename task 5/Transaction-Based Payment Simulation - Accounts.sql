CREATE DATABASE PaymentDB;
USE PaymentDB;
CREATE TABLE Accounts (
    account_id INT PRIMARY KEY,
    account_name VARCHAR(100),
    balance DECIMAL(10,2)
);
INSERT INTO Accounts VALUES (1, 'User_Account', 10000.00);
INSERT INTO Accounts VALUES (2, 'Merchant_Account', 5000.00);
SELECT * FROM Accounts;
DELIMITER //

CREATE PROCEDURE MakePayment(
    IN sender_id INT,
    IN receiver_id INT,
    IN amount DECIMAL(10,2)
)
BEGIN
    DECLARE sender_balance DECIMAL(10,2);

    START TRANSACTION;

    -- Lock and get sender balance
    SELECT balance INTO sender_balance
    FROM Accounts
    WHERE account_id = sender_id
    FOR UPDATE;

    -- Check balance
    IF sender_balance >= amount THEN

        -- Deduct from sender
        UPDATE Accounts
        SET balance = balance - amount
        WHERE account_id = sender_id;

        -- Add to receiver
        UPDATE Accounts
        SET balance = balance + amount
        WHERE account_id = receiver_id;

        COMMIT;

    ELSE
        ROLLBACK;
    END IF;

END //

DELIMITER ;
CALL MakePayment(1, 2, 2000);
SELECT * FROM Accounts;
CALL MakePayment(1, 2, 20000);
SELECT * FROM Accounts;
