package test;

import org.apache.ibatis.session.SqlSession;
import pojo.Person;

public class PersonTest {
    public void findPersonWithIDCardById() {
        SqlSession session = MybatisUtil.getSession();
        Person person = session.selectOne("pojo.Person.findPersonWithIdCardById", 100);
        if (person != null) {
            System.out.println(person.toString());
        }
        session.close();
    }

    public void findPersonWithIdCardByName() {
        SqlSession session = MybatisUtil.getSession();
        Person person = session.selectOne("pojo.Person.findPersonWithIdCardByName", "张三");
        if (person != null) {
            System.out.println(person.toString());
        }
        session.close();
    }

    public void insertPerson() {
        SqlSession session = MybatisUtil.getSession();
        Person person = new Person();
        person.setId(103);
        person.setName("张三");
        person.setGrade("计算机1224");
        person.setSchoolCardId(1234567893);

        session.insert("pojo.Person.insertPerson", person);
        session.commit();
        session.close();
    }

    public void updatePerson() {
        SqlSession session = MybatisUtil.getSession();
        Person person = session.selectOne("pojo.Person.findPersonWithIdCardById", 100);
        if (person != null) {
            person.setName("舒浩然");
            person.setGrade("计算机1226");
            session.update("pojo.Person.updatePerson", person);
            session.commit();
        }
        session.close();
    }

    public void deletePerson() {
        SqlSession session = MybatisUtil.getSession();
        session.delete("pojo.Person.deletePerson", 103);
        session.commit();
        session.close();
    }

    public static void main(String[] args) {
        PersonTest test = new PersonTest();
        test.findPersonWithIDCardById();
        test.findPersonWithIdCardByName();
        test.insertPerson();
        test.updatePerson();
        test.deletePerson();
    }
}
