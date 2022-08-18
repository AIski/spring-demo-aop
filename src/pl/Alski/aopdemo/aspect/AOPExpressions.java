package pl.Alski.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AOPExpressions {

    // this is where we add all of our related advices for logging
    @Pointcut("execution(* pl.Alski.aopdemo.dao.*.*(..))")
    private void forDaoPackage() {
    }

    //create pointcut for getter methods
    @Pointcut("execution(* pl.Alski.aopdemo.dao.*.get*(..))")
    private void getters() {
    }

    //create pointcut for setter methods
    @Pointcut("execution(* pl.Alski.aopdemo.dao.*.set*(..))")
    private void setters() {
    }

    //create pointcut to include package and exclude getter/setter
    @Pointcut("forDaoPackage() && !(getters() || setters())")
    protected void forDaoPackageNoGettersSetters() {
    }

}
