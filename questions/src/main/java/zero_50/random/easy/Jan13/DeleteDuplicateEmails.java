package zero_50.random.easy.Jan13;

/**
 * @author jesse.hu
 * @date 2022/1/13 18:29
 * @LeetCodeNo 196 :star
 *  要先将查询出的ID缓存起来，再根据此ID删除，因为mysql 不能先将select出表中的某些值，再这更新个表!
 */
public class DeleteDuplicateEmails {
    /*
    delete p1 from Person p1,Person p2
    where p1.email = p2.email and p1.Id >p2.id;

     */
}
