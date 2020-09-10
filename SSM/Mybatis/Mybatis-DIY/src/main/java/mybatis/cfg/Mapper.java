package mybatis.cfg;

/**
 * 封装dao映射文件中的  执行的sql语句 和 返回的结果类型全名
 *<select id="listUser" resultType="domain.User">
 *         select * from user
 *     </select>
 */

public class Mapper {
    private String queryString;
    private String resultType;

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
