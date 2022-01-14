package zero_50.random.easy.Jan13;

/**
 * @author jesse.hu
 * @date 2022/1/13 18:33
 * @LeetCodeNo 197
 * Write an SQL query to find all dates' Id with higher temperatures compared to its previous dates (yesterday).
 *找出昨天比今天气温高的Id。 需要用到日期函数
 */
public class RisingTemperature {
    /**
     * Weather table:
     * +----+------------+-------------+
     * | id | recordDate | temperature |
     * +----+------------+-------------+
     * | 1  | 2015-01-01 | 10          |
     * | 2  | 2015-01-02 | 25          |
     * | 3  | 2015-01-03 | 20          |
     * | 4  | 2015-01-04 | 30          |
     * +----+------------+-------------+
     * Output:
     * +----+
     * | id |
     * +----+
     * | 2  |
     * | 4  |
     * +----+
     * Explanation:
     * In 2015-01-02, the temperature was higher than the previous day (10 -> 25).
     * In 2015-01-04, the temperature was higher than the previous day (20 -> 30).
     *
     */
    /*
        select w1.id
        from Weather w1
        inner join Weather w2
        on  DATE_SUB(w1.recordDate,INTERVAL 1 DAY) = w2.recordDate
        and w1.temperature > w2.temperature;
     */
}
