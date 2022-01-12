package zero_50.random.easy.Jan12;

/**
 * @author jesse.hu
 * @date 2022/1/12 17:27
 * @LeetCodeNo 183
 */
public class CustomersWhoNeverOrder {
    /**
     *Customers table:
     * +----+-------+
     * | id | name  |
     * +----+-------+
     * | 1  | Joe   |
     * | 2  | Henry |
     * | 3  | Sam   |
     * | 4  | Max   |
     * +----+-------+
     * Orders table:
     * +----+------------+
     * | id | customerId |
     * +----+------------+
     * | 1  | 3          |
     * | 2  | 1          |
     * +----+------------+
     * Output:
     * +-----------+
     * | Customers |
     * +-----------+
     * | Henry     |
     * | Max       |
     * +-----------+
     *
     */

    /*
# 498ms
select c.Name as Customers from Customers c left join Orders o on o.CustomerId = c.Id where o.Id is null;

# 532ms
select c.Name as Customers from Customers c where not exists (select 1 from Orders o where o.CustomerId = c.Id);

# 455ms
select c.Name as Customers from Customers c where c.Id not in (select distinct o.CustomerId from Orders o);
     */
}
