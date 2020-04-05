import org.apache.ibatis.io.Resources;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author LZY
 * @version 1.0
 * @date 2020/3/25 21:39
 */
public class testMybatis {
    @Test
    void test() throws Exception {
        Resources.getResourceAsStream("SqlMapConfig.xml");
    }
}
