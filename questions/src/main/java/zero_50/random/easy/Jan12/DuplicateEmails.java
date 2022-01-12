package zero_50.random.easy.Jan12;

/**
 * @author jesse.hu
 * @date 2022/1/12 17:15
 * @LeetCodeNo 182
 */
public class DuplicateEmails {
    /**
     * +-------------+---------+
     * | Column Name | Type    |
     * +-------------+---------+
     * | id          | int     |
     * | email       | varchar |
     * +-------------+---------+
     * id is the primary key column for this table.
     * Each row of this table contains an email. The emails will not contain uppercase letters.
     * accept criticize ： Write an SQL query to report all the duplicate emails
     * Input:
     * Person table:
     * +----+---------+
     * | id | email   |
     * +----+---------+
     * | 1  | a@b.com |
     * | 2  | c@d.com |
     * | 3  | a@b.com |
     * +----+---------+
     * Output:
     * +---------+
     * | Email   |
     * +---------+
     * | a@b.com |
     * +---------+
     * Explanation: a@b.com is repeated two times.
     *
     */

    /*
-- 解法1
select email from person group by email having count(email)>1

--解法2
select email from (select count(1) as t,email from person group by email)r  where r.t>1;   看不懂...

--解法3
select distinct(p1.Email) from Person p1
join Person  p2 on p1.Email = p2.Email AND p1.Id!=p2.Id
     */
}
