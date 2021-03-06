package cn.edu.cuit.controller;

import cn.edu.cuit.model.entity.OperAccount;
import cn.edu.cuit.model.entity.Syslog;
import cn.edu.cuit.service.ISyslogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @auther yincaiTA
 * @date 2021/1/1 11:48
 * @description 日志切面类
 */
@Component
@Aspect
public class LogAop {
    private Date visitTime;  // 访问controller方法的时间
    private String username; // 登陆用户的用户名
    private String ip;       // 访问电脑的ip
    private String url;      // 访问的controller方法路径
    private Integer executionTime;  // 执行方法的时间
    private Method method;   // 执行的方法对象
    private Class clazz;     // 执行类的字节码对象

    private Syslog syslog;  // 保存的日志对象

    private static final Logger LOGGER = LoggerFactory.getLogger(LogAop.class);
    private final HttpServletRequest request;
    private final ISyslogService syslogService;

    @Autowired
    public LogAop(HttpServletRequest request, ISyslogService syslogService) {
        this.request = request;
        this.syslogService = syslogService;
    }

    // 前置通知
    @Before("execution(* cn.edu.cuit.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException {
        // 获取访问方法的时间
        this.visitTime = new Date();
        // 获取登陆用户的用户名
        Object o = this.request.getSession().getAttribute("user");
        if (o == null) {
            LOGGER.info("请求 {} 时, LogAop.doBefore 内用户不存在状态信息", this.removeContextPath(this.request.getRequestURI()));
            return ;
        }
        OperAccount account = (OperAccount) o;
        this.username = account.getOperUserName();
        // 获取电脑的ip(先获取request对象, web.xml/config配置RequestContextListener)
        this.ip = request.getRemoteAddr();
        // 获取controller方法路径(url)
        // ----start----
        // 具体要访问的类
        this.clazz = joinPoint.getTarget().getClass();
        // 具体执行的方法名
        String methodName = joinPoint.getSignature().getName();
        // 获取执行方法的对象
        Object[] args = joinPoint.getArgs();
        if (args==null || args.length==0){
            // 获取无参方法
            this.method = this.clazz.getMethod(methodName);
        }else{
            // 获取有参方法 需要参数class对象
            Class[] classArgs = new Class[args.length];
            for (int i=0; i<args.length; i++){
                classArgs[i] = args[i].getClass();
            }
            this.method = this.clazz.getMethod(methodName, classArgs);
        }

        // 封装syslog对象
        this.syslog = new Syslog();
        this.syslog.setIp(this.ip);
        this.syslog.setMethod("[类名] "+clazz.getName() + "[方法名] " + method.getName());
        this.syslog.setAccountName(this.username);
        this.syslog.setVisitTime(this.visitTime);
        // 去掉context-path的uri
        this.syslog.setUrl(this.removeContextPath(this.request.getRequestURI()) + "【" + this.getControllerRest(method) + "】");
        // ---- end -----
    }

    // 后置通知
    @After("execution(* cn.edu.cuit.controller.*.*(..))")
    public void doAfter(JoinPoint joinPoint){
        // 登录接口(去掉context-path)不包含在里面
        if ("/users/login".equals(removeContextPath(this.request.getRequestURI())) || null == this.request.getSession().getAttribute("user")) {
            LOGGER.info("请求 {} 时, LogAop.doAfter 内用户不存在状态信息", this.request.getRequestURI());
            return ;
        }

        // 获取方法执行结束时间(计算执行时间ms)
        this.executionTime = (int) (new Date().getTime() - this.visitTime.getTime());
        this.syslog.setExecuteTime(executionTime);
        // 日志接口的查询 除外
        if ("cn.edu.cuit.controller.SyslogController".equals(clazz.getName()) && "findAll".equals(method.getName())){
            this.syslog = null;
        }
        // 添加进数据库
        this.syslogService.save(this.syslog);
    }

    /**
     * @param method 具体访问的方法 针对不同注解进行不同解析
     * @return GET/POST/PATCH/DELETE/PUT
     */
    private String getControllerRest(Method method) {
        RequestMapping rm = method.getAnnotation(RequestMapping.class);
        if (rm != null) {
            return rm.method()[0].toString().split("\\.")[0];
        }
        GetMapping gm = method.getAnnotation(GetMapping.class);
        if (gm != null) {
            return "GET";
        }
        PostMapping pom = method.getAnnotation(PostMapping.class);
        if (pom != null) {
            return "POST";
        }
        DeleteMapping dm = method.getAnnotation(DeleteMapping.class);
        if (dm != null) {
            return "DELETE";
        }
        PatchMapping pam = method.getAnnotation(PatchMapping.class);
        if (pam != null) {
            return "PATCH";
        }
        return "";
    }

    /**
     * 给uri去除context-path
     * @param uri 访问的uri
     * @return 去除context-path的uri
     */
    private String removeContextPath(String uri) {
        return uri.split(request.getContextPath())[1];
    }
}
