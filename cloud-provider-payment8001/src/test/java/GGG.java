import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author Administrator
 * @date 2020/9/17
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest
@DisplayName("TaskRepositoryTest")
public class GGG {
    @Test
    @DisplayName("新junit测试1")
    void test() {
        System.out.println("Task:: " + System.currentTimeMillis());
    }
}
