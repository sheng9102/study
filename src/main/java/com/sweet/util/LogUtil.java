package com.sweet.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LogUtil {
    /**
     * 我们在xml中已经使⽤了通⽤切⼊点表达式，供多个切⾯使⽤，那么在注解中如何使⽤呢？
     * 第⼀步：编写⼀个⽅法
     * 第⼆步：在⽅法使⽤@Pointcut注解
     * 第三步：给注解的value属性提供切⼊点表达式
     * 细节：
     * 1.在引⽤切⼊点表达式时，必须是⽅法名+()，例如"pointcut()"。
     * 2.在当前切⾯中使⽤，可以直接写⽅法名。在其他切⾯中使⽤必须是全限定⽅法名。
     *
     *
     * 全限定⽅法名 访问修饰符 返回值 包名.包名.包名.类名.⽅法名(参数列表)
     *  全匹配⽅式：
     *  public void
     * com.lagou.service.impl.TransferServiceImpl.updateAccountByCardNo(c
     * om.lagou.pojo.Account)
     *  访问修饰符可以省略
     *  void
     * com.lagou.service.impl.TransferServiceImpl.updateAccountByCardNo(c
     * om.lagou.pojo.Account)
     *  返回值可以使⽤*，表示任意返回值
     *  *
     * com.lagou.service.impl.TransferServiceImpl.updateAccountByCardNo(c
     * om.lagou.pojo.Account)
     *  包名可以使⽤.表示任意包，但是有⼏级包，必须写⼏个
     *  *
     * ....TransferServiceImpl.updateAccountByCardNo(com.lagou.pojo.Accou
     * nt)
     *  包名可以使⽤..表示当前包及其⼦包
     *  *
     * ..TransferServiceImpl.updateAccountByCardNo(com.lagou.pojo.Account
     * )
     *  类名和⽅法名，都可以使⽤.表示任意类，任意⽅法
     *  * ...(com.lagou.pojo.Account)
     *  参数列表，可以使⽤具体类型
     *  基本类型直接写类型名称 ： int
     *  引⽤类型必须写全限定类名：java.lang.String
     *  参数列表可以使⽤*，表示任意参数类型，但是必须有参数
     *  * *..*.*(*)
     *  参数列表可以使⽤..，表示有⽆参数均可。有参数可以是任意类型
     *  * *..*.*(..)
     *  全通配⽅式：
     *  * *..*.*(..)
     */
    @Pointcut("execution(* com.sweet.service.school.impl.*.*(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void beforePrintLog(JoinPoint jp) {
        Object[] args = jp.getArgs();
        System.out.println("前置通知：beforePrintLog，参数是：" +
                Arrays.toString(args));
    }

    @AfterReturning(value = "pointcut()", returning = "rtValue")
    public void afterReturningPrintLog(Object rtValue) {
        System.out.println("后置通知：afterReturningPrintLog，返回值是：" + rtValue);
    }

    @AfterThrowing(value = "pointcut()", throwing = "e")
    public void afterThrowingPrintLog(Throwable e) {
        System.out.println("异常通知：afterThrowingPrintLog，异常是：" + e);
    }

    @After("pointcut()")
    public void afterPrintLog() {
        System.out.println("最终通知：afterPrintLog");
    }

    /**
     * 环绕通知
     *
     * @param pjp
     * @return
     */
    @Around("pointcut()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp) {
        //定义返回值
        Object rtValue = null;
        try {
            //前置通知
            System.out.println("环绕前置通知");
            //1.获取参数
            Object[] args = pjp.getArgs();

            //2.执⾏切⼊点⽅法
            rtValue = pjp.proceed(args);
            //后置通知
            System.out.println("环绕后置通知");
        } catch (Throwable t) {
            //异常通知
            System.out.println("环绕异常通知");
            t.printStackTrace();
        } finally {
            //最终通知
            System.out.println("环绕最终通知");
        }
        return rtValue;
    }
}
