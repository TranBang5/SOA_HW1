USE ecommerce;
INSERT INTO products (product_id, price)ecommerce
SELECT CONCAT('P', id), ROUND(RAND() * 100 + 1, 2)
FROM (SELECT @row := @row + 1 AS id 
      FROM (SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4) AS a, 
           (SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4) AS b, 
           (SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4) AS c, 
           (SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4) AS d, 
           (SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4) AS e, 
           (SELECT @row := 0) AS f
     ) AS g;