package cn.edu.cuit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @auther yincaiTA
 * @date 2020/12/17 22:23
 * @description springboot启动类
 */
@SpringBootApplication
@MapperScan("cn.edu.cuit.dao")
public class OcpApplication {
    public static void main(String[] args) {
        SpringApplication.run(OcpApplication.class, args);
    }
}
