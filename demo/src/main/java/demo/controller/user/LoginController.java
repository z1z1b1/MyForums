package demo.controller.user;

import demo.entity.CommentMess;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.entity.UserControl;
import demo.service.UserService;
//import com.example.demo.util.TokenUtil;

/**
 * @ClassName: LoginCONTROLLER
 * @Description:
 * @Author
 * @Date 2022/1/20
 * @Version 1.0
 */
@RestController
public class LoginController {
    @Autowired
    UserService userService;

    @PostMapping("login")
    @CrossOrigin(origins = "*")
    public String login(UserControl user) throws JSONException {

       return "111";

    }

    @PostMapping("register")
    @CrossOrigin(origins = "*")
    public UserControl insertComment(UserControl user) {
        return userService.insert(user);
    }
}
