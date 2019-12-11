package com.jk.mysqlroad.api;

import com.alibaba.fastjson.JSONObject;
import com.jk.mysqlroad.entity.User;
import com.jk.mysqlroad.service.UserService;
import com.jk.mysqlroad.service.impl.TokenService;
import com.jk.mysqlroad.token.TokenUtil;
import com.jk.mysqlroad.token.annotation.UserLoginToken;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
public class UserApi {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @ApiOperation(value = "登陆", notes = "登陆")
    @RequestMapping(value = "/login" ,method = RequestMethod.GET)
    public Object login(User user, HttpServletResponse response) {
        JSONObject jsonObject = new JSONObject();
        User userForBase = new User();
        User userResult = userService.login(user);
        if(userResult==null) return null;
        userForBase.setId(userResult.getId());
        userForBase.setUserName(userResult.getUserName());
        userForBase.setUserPassword(userResult.getUserPassword());
        if (!userForBase.getUserPassword().equals(user.getUserPassword())) {
            jsonObject.put("message", "登录失败,密码错误");
            return jsonObject;
        } else {
            String token = tokenService.getToken(userForBase);
            jsonObject.put("token", token);

            Cookie cookie = new Cookie("token", token);
            cookie.setPath("/");
            response.addCookie(cookie);

            return jsonObject;

        }
    }

    @UserLoginToken
    @ApiOperation(value = "获取信息", notes = "获取信息")
    @RequestMapping(value = "/getMessage" ,method = RequestMethod.GET)
    public String getMessage() {

        // 取出token中带的用户id 进行操作
        System.out.println(TokenUtil.getTokenUserId());

        return "您已通过验证";
    }
}
