package test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pojo.Stu;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    @Test
    public void findStuById() {
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession session = sqlSessionFactory.openSession();
            Stu stu = session.selectOne("pojo.Stu.findStuById", 1);
            System.out.println("name:" + stu.getName() + " grade:" + stu.getGrade());
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findStuByPojoStu() {
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession session = sqlSessionFactory.openSession();
            Stu stu = new Stu();
            stu.setId(1);
            stu.setName("王颖");
            stu.setGrade("计算机1226");
            List<Stu> stuList = session.selectList("pojo.Stu.findStuByPojoStu", stu);
            for (Stu stu1 : stuList) {
                System.out.println(stu1.toString());
            }
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}