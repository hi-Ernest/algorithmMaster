package test.redis.distributed;

import java.util.List;

/**
 * mock数据
 */
public class Jedis {
    /**
     * <dependency>
     *     <groupId>redis.clients</groupId>
     *     <artifactId>jedis</artifactId>
     *     <version>2.9.0</version>
     * </dependency>
     */
    public static String set(String lockKey, String requestId, String nx, String px, int expireTime) {
        return "";
    }

    public Object eval(String script, List<String> singletonList, List<String> singletonList1) {
        Long res = 1L;
        return res;
    }
}
