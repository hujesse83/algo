package zero_50.random.easy.Jan12;

/**
 * @author jesse.hu
 * @date 2022/1/12 16:47
 * @LeetCodeNo 175
 * SQL
 */
public class CombineTwoTablesSQL {

    /**
     * 题目：Write an SQL query to report the first name, last name, city, and state of each person in the Person table.
     * If the address of a personId is not present in the Address table, report null instead.
     *
     */


    /*
数据库在通过连接两张或多张表来返回记录时，都会生成一张中间的临时表，然后再将这张临时表返回给用户。 在使用left join时，on和where条件的区别如下：

1、on条件是在生成临时表时使用的条件，它不管on中的条件是否为真，都会返回左边表中的记录。

2、where条件是在临时表生成好后，再对临时表进行过滤的条件。这时已经没有left join的含义（必须返回左边表的记录）了，条件不为真的就全部过滤掉。

            select FirstName, LastName, City, State
            from Person left join Address
            on Person.PersonId = Address.PersonId
            ;
     */
}
