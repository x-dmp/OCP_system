package cn.edu.cuit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");  // 允许跨域的路径
        corsConfiguration.setAllowCredentials(true);  // 允许请求携带cookie(允许的情况下,跨域路径必须为一个url)
        corsConfiguration.addAllowedMethod("*");  // 允许所有的请求方法 GET POST...
        corsConfiguration.addAllowedHeader("*");  // 允许携带所有头信息

        // CorsFilter构造器参数是CorsConfigurationSource
        // 我们使用它的实现类UrlBasedCorsConfigurationSource
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        // 拦截所有请求路径
        configSource.registerCorsConfiguration("/**", corsConfiguration);

        return new CorsFilter(configSource);
    }

}
