# Write your MySQL query statement below
-- SELECT name AS Customers FROM Customers where id NOT IN (SELECT customerId FROM Orders WHERE customerId IS NOT NULL);


SELECT c.name AS Customers FROM Customers c LEFT JOIN Orders o ON c.id=o.customerId WHERE o.id IS NULL;