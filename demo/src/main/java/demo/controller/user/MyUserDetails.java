package demo.controller.user;

import demo.entity.UserControl;
import demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetails implements UserDetailsService {
    @Autowired
    UserService userService;
    @Override

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserControl userByUser = userService.selectByName(username);
        return new User(userByUser.getUserName(), userByUser.getUserPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
