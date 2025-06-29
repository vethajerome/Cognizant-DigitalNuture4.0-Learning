-- Create Accounts table
CREATE TABLE Accounts (
    AccountID INT PRIMARY KEY,
    AccountType VARCHAR(20),
    Balance DECIMAL(10,2)
);

-- Insert sample accounts
INSERT INTO Accounts VALUES
(101, 'Savings', 5000.00),
(102, 'Savings', 10000.00),
(103, 'Checking', 3000.00);

-- Create Employees table
CREATE TABLE Employees (
    EmployeeID INT PRIMARY KEY,
    DepartmentID INT,
    Salary DECIMAL(10,2)
);

-- Insert sample employees
INSERT INTO Employees VALUES
(1, 10, 40000.00),
(2, 10, 45000.00),
(3, 20, 50000.00);












DELIMITER //

CREATE PROCEDURE ProcessMonthlyInterest()
BEGIN
    -- Add 1% interest to all savings accounts
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';

    SELECT 'Monthly interest processed successfully.' AS Message;
END;
//

DELIMITER ;


DELIMITER //

CREATE PROCEDURE UpdateEmployeeBonus(
    IN dept_id INT,
    IN bonus_percent DECIMAL(5,2)
)
BEGIN
    -- Add bonus to all employees in the given department
    UPDATE Employees
    SET Salary = Salary + (Salary * bonus_percent / 100)
    WHERE DepartmentID = dept_id;

    SELECT CONCAT('Bonus applied to department ', dept_id) AS Message;
END;
//

DELIMITER //

CREATE PROCEDURE TransferFunds(
    IN from_account INT,
    IN to_account INT,
    IN amount DECIMAL(10,2)
)
BEGIN
    DECLARE from_balance DECIMAL(10,2);

    -- Get balance of source account
    SELECT Balance INTO from_balance
    FROM Accounts
    WHERE AccountID = from_account;

    -- Check balance and perform transfer
    IF from_balance < amount THEN
        SELECT 'Transfer failed: Insufficient balance.' AS Message;
    ELSE
        -- Deduct from source
        UPDATE Accounts
        SET Balance = Balance - amount
        WHERE AccountID = from_account;

        -- Add to destination
        UPDATE Accounts
        SET Balance = Balance + amount
        WHERE AccountID = to_account;

        SELECT 'Transfer successful!' AS Message;
    END IF;
END;
//

DELIMITER ;


DELIMITER ;


CALL ProcessMonthlyInterest();
SELECT * FROM Accounts;


CALL UpdateEmployeeBonus(10, 10);
SELECT * FROM Employees;

CALL TransferFunds(102, 103, 2000);

SELECT * FROM Accounts;





SELECT * FROM employees;




