package com.byf.test;


import com.byf.dao.IUserDao;
import com.byf.dao.impl.UserDaoImpl;
import com.byf.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {

    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;


    @Before
    public void init() throws IOException {
        /**
         * 1.读取配置文件
         *      1）绝对路径：d:/xxx/xxx.xml  不可用
         *      2）相对路径：src/java/main/xxx.xml  不可用
         *      3）使用类加载器，他只能兑取类路径的配置文件
         *      4）使用ServletContext对象的getRealPath()
         */
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        /**
         * 2.创建SqlSessionFactory工厂
         *      1）创建工厂mybatis使用了构建者模式
         *          优势：把对象创建的细节。因此，使用者直接调用对象
         */
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        /**
         * 3.使用工厂创建Dao接口的代理对象
         *      1）创建Dao接口实现类使用了代理模式
         *          优势：不修改源码的基础上，增强方法
         */
        userDao = new UserDaoImpl(factory);
    }
    @Test
    public void testConfig() throws IOException {
        // sqlSession.getMapper(IUserDao.class);
        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user:users){
            System.out.println(user);
        }
    }


    /**
     * 测试查询一个用户
     */
    @Test
    public void testFindById(){
        //5.使用代理对象执行方法
        User user = userDao.findById(48);
        System.out.println(user);
    }

    /**
     * 测试模糊查询
     */
    @Test
    public void testFindByName(){
        //5.使用代理对象执行方法
        List<User> users = userDao.findByName("J");
        for (User user:users){
            System.out.println(user);
        }
    }

    /**
     * 测试总记录条数
     */
    @Test
    public void testFindTotal(){
        //5.使用代理对象执行方法
        int couont = userDao.findTotal();
        System.out.println(couont);
    }

    /**
     * 测试保存操作
     */
    @Test
    public void testSave(){
        User user = new User();
        user.setUserName("auto commit User property");
        user.setUserAddress("北京市顺义区");
        user.setUserSex("男");
        user.setUserBirthday(new Date());
        System.out.println("保存操作之前："+user);
        //5.执行保存方法
        userDao.saveUser(user);

        System.out.println("保存操作之后："+user);
    }

    /**
     * 测试更新操作
     */
    @Test
    public void testUpdate(){
        User user = new User();
        user.setUserId(56);
        user.setUserName("mybastis update user");
        user.setUserAddress("北京市顺义区");
        user.setUserSex("女");
        user.setUserBirthday(new Date());

        //5.执行保存方法
        userDao.updateUser(user);
    }

    /**
     * 测试删除操作
     */
    @Test
    public void testDelete(){
        //5.执行删除方法
        userDao.deleteUser(56);
    }

    @After
    public void destroy() throws IOException {
        in.close();
    }

}
