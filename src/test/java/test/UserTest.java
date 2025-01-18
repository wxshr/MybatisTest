package test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class UserTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    }

    @Test
    public void findUserById() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            User user = session.selectOne("pojo.UserMapper.findUserById", 100);
            if (user != null) {
                System.out.println(user.toString());
            } else {
                System.out.println("ID：100的用户不存在.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @Test
//    public void findUsersByTags() {
//        try (SqlSession session = sqlSessionFactory.openSession()) {
//            Map<String, Object> params = new HashMap<>();
//            params.put("username", "User1");
//            params.put("email", "user1@example.com");
//            List<User> userList = session.selectList("pojo.UserMapper.findUsersByTags", params);
//            for (User u : userList) {
//                System.out.println(u.toString());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    public void insertUser() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            User user = new User();
            user.setUsername("王五");
            user.setEmail("123456789@example.com");
            user.setPhone("1112223333");
            session.insert("pojo.UserMapper.insertUser", user);
            session.commit();
            System.out.println("用户完成插入.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateUser() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            User user = new User();
            user.setId(1);
            user.setUsername("孙七");
            user.setEmail("123456789@example.com");
            user.setPhone("9876543210");
            session.update("pojo.UserMapper.updateUser", user);
            session.commit();
            System.out.println("用户完成更新.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteUser() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.delete("pojo.UserMapper.deleteUser", 103);
            session.commit();
            System.out.println("用户已经删除.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @Test
//    public void searchUsers() {
//        try (SqlSession session = sqlSessionFactory.openSession()) {
//            Map<String, Object> params = new HashMap<>();
//            params.put("email", "user1@example.com");
//            List<User> userList = session.selectList("pojo.UserMapper.searchUsers", params);
//            for (User u : userList) {
//                System.out.println(u.toString());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//    @Test
//    public void insertUsers() {
//        try (SqlSession session = sqlSessionFactory.openSession()) {
//            List<User> users = new ArrayList<>();
//            User user1 = new User();
//            user1.setUsername("User1");
//            user1.setEmail("user1@example.com");
//            user1.setPhone("1234567890");
//            users.add(user1);
//
//            User user2 = new User();
//            user2.setUsername("User2");
//            user2.setEmail("user2@example.com");
//            user2.setPhone("0987654321");
//            users.add(user2);
//
//            session.insert("pojo.UserMapper.insertUsers", users);
//            session.commit();
//            System.out.println("Users inserted.");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//    @Test
//    public void findUsersWithPagination() {
//        try (SqlSession session = sqlSessionFactory.openSession()) {
//            Map<String, Object> params = new HashMap<>();
//            params.put("offset", 0);
//            params.put("limit", 10);
//            List<User> userList = session.selectList("pojo.UserMapper.findUsersWithPagination", params);
//            for (User u : userList) {
//                System.out.println(u.toString());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


//    @Test
//    public void findUsersByIds() {
//        try (SqlSession session = sqlSessionFactory.openSession()) {
//            List<Integer> ids = new ArrayList<>();
//            ids.add(100);
//            ids.add(101);
//            ids.add(102);
//            List<User> userList = session.selectList("pojo.UserMapper.findUsersByIds", ids);
//            for (User u : userList) {
//                System.out.println(u.toString());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


//    @Test
//    public void findUsersByComplexConditions() {
//        try (SqlSession session = sqlSessionFactory.openSession()) {
//            Map<String, Object> params = new HashMap<>();
//            params.put("username", "User1");
//            params.put("email", "user1@example.com");
//            params.put("minId", 1);
//            params.put("maxId", 10);
//            List<User> userList = session.selectList("pojo.UserMapper.findUsersByComplexConditions", params);
//            for (User u : userList) {
//                System.out.println(u.toString());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
@Test
public void findUsersByIdAndQqEmail() {
    try (SqlSession session = sqlSessionFactory.openSession()) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", "100"); // 这里可以根据需要替换为其他值
        List<User> userList = session.selectList("pojo.UserMapper.findUsersByIdAndQqEmail", params);
        for (User u : userList) {
            System.out.println(u.toString());
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}




        @Test
        public void findUserByMap() {
            try (SqlSession session = sqlSessionFactory.openSession()) {
                Map<String, Object> params = new HashMap<>();

                // 使用数组
                Integer[] idArray = {100, 101, 102}; // 可以根据需要替换为其他值
                params.put("ids", Arrays.asList(idArray));

                // 或者使用链表
                // List<Integer> idList = Arrays.asList(1, 2, 3); // 可以根据需要替换为其他值
                // params.put("ids", idList);

                List<User> users = session.selectList("pojo.UserMapper.findUserByMap", params);
                if (!users.isEmpty()) {
                    for (User user : users) {
                        System.out.println(user.toString());
                    }
                } else {
                    System.out.println("未找到符合条件的用户.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



}