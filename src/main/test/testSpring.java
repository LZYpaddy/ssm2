import com.zyg.service.IAccountService;
import com.zyg.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LZY
 * @version 1.0
 * @date 2020/3/25 17:31
 */

public class testSpring {
   @Test
    public void run1(){
       ApplicationContext applicationContext =new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
       IAccountService accountService= (IAccountService) applicationContext.getBean("accountService");
       accountService.findAll();

   }

}
