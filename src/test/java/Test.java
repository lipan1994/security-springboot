import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: lipan
 * @date: 2021/2/27 17:44
 */

@RunWith(SpringRunner.class)
public class Test {

    @org.junit.Test
    public void test() throws Exception{

        //$2a$10$Ic/KJtm7UoiRmbNS1DEJ9uvmRQLR1xHzJzp.eG5yaJdhXa5BKCmjy
        BCryptPasswordEncoder bpe=new BCryptPasswordEncoder();
        bpe.encode("secret");
    }
}
