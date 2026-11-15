# Write your MySQL query statement below
SELECT name AS Customers FROM Customers where id NOT IN (SELECT customerId FROM Orders);