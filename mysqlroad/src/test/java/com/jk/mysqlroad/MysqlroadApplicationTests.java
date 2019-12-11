package com.jk.mysqlroad;

import com.jk.mysqlroad.entity.User;
import com.jk.mysqlroad.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
//@MapperScan("com.jk.mysqlroad.mapper")
class MysqlroadApplicationTests {

    @Autowired
    UserService iUserService;

    @Test
    void contextLoads() {
    }

    @Test
    void insertTest_User(){

        for(int i =0;i<10000;i++){
            User user = new User();
            user.setId(i+15001);
            user.setUserName("园园"+ (i+1));
            user.setUserPassword("123yy");
            iUserService.insertUser(user);
            System.out.println("第" + (i+1) + "插入完成");
        }

    }

    @Test
    void insertTest_UserList(){
        int batchNum = 10;

        for(int i =24001;i<=1000000;){
            List<User> userList = new ArrayList<>();
            for (int j =1 ; j<=1000 ; j++) {
                User user = new User();
                user.setId(i);
                user.setUserName("testData" + i + "_batch" + batchNum);
                user.setUserPassword("123PassWord");
                userList.add(user);
                i++;
            }
            iUserService.insertUserList(userList);
            batchNum++;
            System.out.println("第" + batchNum + "批插入完成---------至"+ i+ "条");
        }

    }

    @Test
    void queryTest1_User(){
//        List<User> userList = iUserService.queryAllUser();
//        System.out.println(userList);
//
//
        User user = new User();
        user.setId(6);
        user.setUserName("蒋康6");
        user.setUserPassword("123jk");
        long startTime = System.currentTimeMillis();    //获取开始时间
        User userResult = iUserService.queryUser(user);
        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println(userResult);
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
    }

    @Test
    void queryTest2_All(){

        long startTime = System.currentTimeMillis();    //获取开始时间
        List<User> userList = iUserService.queryAllUser();
        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println(userList);
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
    }

    @Test
    void queryTest2_Condition(){
        Map map = new HashMap<String,String>();
        map.put("userName" , "康");
        long startTime = System.currentTimeMillis();   //获取开始时间
        List<User> userList = iUserService.queryUserCondition(map);
        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println(userList);
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
    }

}
