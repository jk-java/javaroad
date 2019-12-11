package com.jk.urm.api;

import com.alibaba.fastjson.JSONObject;
import com.jk.urm.annotation.UserLoginToken;
import com.jk.urm.entity.User;
import com.jk.urm.service.UserService;
import com.jk.urm.service.impl.TokenService;
import com.jk.urm.token.TokenUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserApi {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @ApiOperation(value = "登陆", notes = "登陆")
    @RequestMapping(value = "/login")
    public Object login(@RequestBody Map map) {
        Map<String , Object> jsonObject = new HashMap();
        Map<String , String> data = new HashMap();
        jsonObject.put("data", data);
        User userForBase = new User();
        String userName = (String) map.get("userName");
        String userPassword = (String) map.get("userPassword");
        if(!StringUtils.isEmpty(userName) && !StringUtils.isEmpty(userPassword)) {
            User user = new User();
            user.setUserName(userName);
            user.setUserPassword(userPassword);
            User userResult = userService.login(user);
            if(userResult==null){
                jsonObject.put("msg", "登录失败,密码错误");
                return jsonObject;
            }
            userForBase.setId(userResult.getId());
            userForBase.setUserName(userResult.getUserName());
            userForBase.setUserPassword(userResult.getUserPassword());
            if (!userForBase.getUserPassword().equals(user.getUserPassword())) {
                jsonObject.put("msg", "登录失败,密码错误");
            } else {
                String token = tokenService.getToken(userForBase);
                data.put("token", token);
            }
        }else {
            jsonObject.put("msg", "登录失败,用户名或密码错误");
        }

        return jsonObject;
    }

//    @UserLoginToken
    @ApiOperation(value = "获取信息", notes = "获取信息")
    @RequestMapping(value = "/getMessage" ,method = RequestMethod.GET)
    public String getMessage() {

        // 取出token中带的用户id 进行操作
//        System.out.println(TokenUtil.getTokenUserId());

        return "您已通过验证";
    }
}
