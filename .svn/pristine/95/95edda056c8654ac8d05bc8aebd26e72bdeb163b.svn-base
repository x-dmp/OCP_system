package cn.edu.cuit;

import cn.edu.cuit.dao.OperAccountDAO;
import cn.edu.cuit.model.entity.OperAccount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@EnableAutoConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OcpApplication.class)
public class OperAccountDAOTest {

    @Resource
    private OperAccountDAO operAccountDAO;

    @Test
    public void findAccountByAccountNameTest(){
        List<OperAccount> res = operAccountDAO.findAccountByAccountName("wwwww");
        System.out.println("num is " + res.size());
        for(OperAccount i : res){
            System.out.println(i);
        }
    }
}
