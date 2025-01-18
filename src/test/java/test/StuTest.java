package test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pojo.Achievement;
import pojo.Stu;

//import org.apache.ibatis.session.KeyHandler;
//import org.apache.ibatis.session.RowBounds;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StuTest {

    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;

    @Before
    public void setUp() throws Exception {
        // 加载 MyBatis 配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    @After
    public void tearDown() throws Exception {
        // 关闭 SqlSession
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    @Test
    public void testInsertStuAndGetAchievements() {
        Stu stu = new Stu();
        stu.setName("王五");
        stu.setGrade("计算机1225");
        // 插入学生记录，同时获取自增的id
        sqlSession.insert("mapper.StuMapper.insertStu", stu);
        sqlSession.commit();
        int newStuId = stu.getId(); // 获取自增的id

        // 插入一些成绩
        List<Achievement> achievements = new ArrayList<>();
        Achievement ach1 = new Achievement();
        ach1.setId("ATX7896543");
        ach1.setCourseName("离散数学");
        ach1.setScore(100);
        ach1.setStuid(newStuId);
        achievements.add(ach1);

        for (Achievement ach : achievements) {
            sqlSession.insert("mapper.AchievementMapper.insertAchievement", ach);
        }
        sqlSession.commit();

        // 查询学生及其成绩
        Stu stuWithAchievements = sqlSession.selectOne("mapper.StuMapper.findStuWithAchievementsById", newStuId);
        assertNotNull(stuWithAchievements);
        assertEquals("王五", stuWithAchievements.getName());
        assertNotNull(stuWithAchievements.getAchievementList());
        assertFalse(stuWithAchievements.getAchievementList().isEmpty());
        System.out.println("学生及其成绩查询成功：" + stuWithAchievements);
    }

    @Test
    public void testUpdateStu() {
        Stu stu = sqlSession.selectOne("mapper.StuMapper.findStuById", 1);
        if (stu != null) {
            stu.setGrade("计算机1227");
            int updateResult = sqlSession.update("mapper.StuMapper.updateStu", stu);
            sqlSession.commit();
            assertEquals("更新失败，受影响的行数应该为1", 1, updateResult);
            System.out.println("学生信息更新成功，受影响的行数：" + updateResult);
        } else {
            fail("更新操作失败，未找到ID为1的学生");
        }
    }
    @Test
    public void testInsertStu() {
        Stu stu = new Stu();
        stu.setName("舒浩然");
        stu.setGrade("计算机1226");
        int insertResult = sqlSession.insert("mapper.StuMapper.insertStu", stu);
        sqlSession.commit();
        assertTrue("插入失败，受影响的行数应该大于0", insertResult > 0);
        System.out.println("学生 '张三' 插入成功，受影响的行数：" + insertResult);
    }

    @Test
    public void testDeleteStuById() {
        Stu stu = sqlSession.selectOne("mapper.StuMapper.findStuById", 5);
        if (stu != null) {
            int deleteResult = sqlSession.delete("mapper.StuMapper.deleteStuById", 5);
            sqlSession.commit();
            assertEquals("删除失败，受影响的行数应该为1", 1, deleteResult);
            System.out.println("学生信息删除成功，受影响的行数：" + deleteResult);
        } else {
            System.out.println("删除操作失败，未找到ID为5的学生");
        }
    }

    @Test
    public void testFindStuById() {
        Stu stu = sqlSession.selectOne("mapper.StuMapper.findStuById", 1);
        assertNotNull(stu);
        assertEquals("王颖", stu.getName());
        assertEquals("计算机1227", stu.getGrade());
        System.out.println("学生信息查询成功：" + stu);
    }

//    @Test
//    public void testDeleteStuById() {
//        int deleteResult = sqlSession.delete("mapper.StuMapper.deleteStuById", 3);
//        sqlSession.commit();
//        assertEquals("删除失败，受影响的行数应该为1", 1, deleteResult);
//        System.out.println("学生信息删除成功，受影响的行数：" + deleteResult);
//    }

    @Test
    public void testFindStuWithAchievementsById() {
        Stu stuWithAchievements = sqlSession.selectOne("mapper.StuMapper.findStuWithAchievementsById", 2);
        assertNotNull(stuWithAchievements);
        assertEquals("Bob", stuWithAchievements.getName());
        assertNotNull(stuWithAchievements.getAchievementList());
        assertFalse(stuWithAchievements.getAchievementList().isEmpty());
        System.out.println("学生及其成绩查询成功：" + stuWithAchievements);
    }
}