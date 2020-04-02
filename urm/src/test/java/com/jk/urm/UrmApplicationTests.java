package com.jk.urm;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UrmApplicationTests {

    @Test
    void contextLoads() {
    }

    /*@Test
    void tokenTest(){
        User user = new User();
        user.setId(1);
        user.setUserName("蒋康1");
        user.setUserPassword("123jk");
        String token = tokenService.getToken(user);
        System.out.println(token);
        Map map = tokenService.validateToken("s"+token);
        Boolean result = (Boolean) map.get("RESULT");
        System.out.println(result);
        String msg = (String) map.get("ERR_MSG");
        System.out.println(msg);
    }

    @Test
    void tokenValidateTest(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJBUFAiLCJ1c2VyX2lkIjoiMSIsImlzcyI6IjEiLCJleHAiOjE1NzUzNTUwMTYsImlhdCI6MTU3NTM1NDQxNn0.z2W27DMscyF77MwPgEynmJ1fv9R9-K1R-D1whMkVHyc";
        Map map = tokenService.validateToken(token);
        Boolean result = (Boolean) map.get("RESULT");
        System.out.println(result);
        String msg = (String) map.get("ERR_MSG");
        System.out.println(msg);
    }
*/
}
