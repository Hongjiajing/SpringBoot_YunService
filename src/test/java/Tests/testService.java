package Tests;

import com.baizhi.application;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = application.class)
public class testService {
    @Autowired
    private UserService userService;
    @Test
    public void Testlogin(){
        User user = new User();
        user.setUsername("5");
        user.setAge(7);
        User login = userService.login(user);
        System.out.println(login);

    }
    @Test
    public void Testrejist(){
/*      User user = new User();
        user.setUsername("哇哈哈");
        user.setAge(13);
        user.setSex("男");
        Integer add = userService.add(user);
        System.out.println(add);*/
/*        List<User> users = userService.queryAll(2, 3);
        for (User user : users) {
            System.out.println(user);

        }*/
        User user = new User();
        user.setId("6");
        user.setUsername("小白");
        user.setSex("女");
        user.setAge(28);
        user.setStatus("正常");
        Integer del = userService.editStatus(user);
        System.out.println(del);

    }
}
