package com.baizhi.action;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/User")
public class UserAction {
    @Autowired
    private UserService userService;
    //我在线上测试我的git项目
    @RequestMapping("/login")
    public String login(User user,HttpServletRequest request){
        try{
            User login = userService.login(user);
            request.getSession().setAttribute("flog","Y");
            System.out.println("登录方法已调用");
            return "showAll";
        }catch(Exception e){
            e.printStackTrace();
            String message = e.getMessage();
            System.out.println("登录方法调用失败返回错误信息");
            return "login";
        }
    }

    @RequestMapping("/edit")
    public String edit(User user, String oper) {
        if ("add".equals(oper))
            userService.add(user);
        if ("del".equals(oper))
            userService.del(user);
        if ("edit".equals(oper)) {
            userService.edit(user);
        }
        System.out.println("jqGrid中的修改方法已调用");
        return "showAll";
    }
    @RequestMapping("/regist")
    public String regist(User user) {
        userService.add(user);
        System.out.println("注册方法已调用");
        return "login";
    }

    @RequestMapping("/editStatus")
    public String editStatus(User user, HttpServletRequest request){
        User use = (User)request.getAttribute("user");
        if(use!=null)
        userService.editStatus(use);
        System.out.println("用户状态修改方法已调用");
        return "showAll";
    }

    @RequestMapping("/queryAll")
    @ResponseBody
    public HashMap<String, Object> queryAll(Integer page, Integer rows) {
        HashMap<String, Object> map = new HashMap<>();
        Integer dataNums = userService.dataNums();//总数据条数
        int pageNum = 0;//总页数
        if (dataNums % rows == 0)
            pageNum = dataNums / rows;
        else
            pageNum = dataNums / rows + 1;
        List<User> users = userService.queryAll(page, rows);
        map.put("page", page);  //当前页
        map.put("total", pageNum); //总页数
        map.put("rows", users);      //数据
        map.put("records", dataNums);    //总条数
        System.out.println("查询分页已调用");
        System.out.println(map);
        return map;
    }
}
