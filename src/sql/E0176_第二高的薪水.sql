-- 第二高的薪水 ps: 第二高则，数据不能重复。  关键语法 iFNULL()
SELECT IFNULL((SELECT DISTINCT salary  FROM Employee  ORDER BY salary DESC LIMIT 1,1),NULL)  SecondHighestSalary
