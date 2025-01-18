package test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Customer;

import java.util.List;

public class CustomerTest {


    @Test
    public void findCustomerWithOrderById()
    {
        SqlSession session = MybatisUtil.getSession();
        List<Customer> customerList = session.selectList("pojo.Customer.findCstomerWithOrderById",1);
        for(Customer customer:customerList)
        {
            System.out.println(customer.toString());
        }
        session.close();
    }


}
