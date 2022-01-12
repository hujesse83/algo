package zero_50.random.easy.Jan12;

/**
 * @author jesse.hu
 * @date 2022/1/12 17:03
 * @LeetCodeNo 175
 */
public class EmployeesEarningMoreThanTheirManagers {
    /**
     * 题目要求
     * +-------------+---------+
     * | Column Name | Type    |
     * +-------------+---------+
     * | id          | int     |
     * | name        | varchar |
     * | salary      | int     |
     * | managerId   | int     |
     * +-------------+---------+
     * id is the primary key column for this table.
     * Each row of this table indicates the ID of an employee, their name, salary, and the ID of their manager.
     *
     *
     * Input:
     * Employee table:
     * +----+-------+--------+-----------+
     * | id | name  | salary | managerId |
     * +----+-------+--------+-----------+
     * | 1  | Joe   | 70000  | 3         |
     * | 2  | Henry | 80000  | 4         |
     * | 3  | Sam   | 60000  | Null      |
     * | 4  | Max   | 90000  | Null      |
     * +----+-------+--------+-----------+
     * Output:
     * +----------+
     * | Employee |
     * +----------+
     * | Joe      |
     * +----------+
     * Explanation: Joe is the only employee who earns more than his manager
     */

    /*
    Method 1、自连接。 从两个表里使用 Select 语句可能会导致产生 笛卡尔乘积
SELECT
    a.Name AS 'Employee'
FROM
    Employee AS a,
    Employee AS b
WHERE
    a.ManagerId = b.Id
        AND a.Salary > b.Salary
;

    Method 2、使用Join语句
    实际上， JOIN 是一个更常用也更有效的将表连起来的办法，我们使用 ON 来指明条件。

select
    a.Name as Employee
from Employee as a inner join Employee as b
on
    a.Managerid = b.Id
    and a.Salary > b.Salary
;

     */
}
