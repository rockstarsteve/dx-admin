//package com.dx.common.log;
//
//import lombok.Data;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.ibatis.executor.statement.BaseStatementHandler;
//import org.apache.ibatis.executor.statement.RoutingStatementHandler;
//import org.apache.ibatis.executor.statement.StatementHandler;
//import org.apache.ibatis.mapping.BoundSql;
//import org.apache.ibatis.mapping.ParameterMapping;
//import org.apache.ibatis.plugin.*;
//import org.apache.ibatis.reflection.MetaObject;
//import org.apache.ibatis.session.Configuration;
//
//import java.lang.reflect.Field;
//import java.sql.Connection;
//import java.sql.Statement;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Properties;
//
//@Intercepts({
//        @Signature(
//            type = StatementHandler.class,
//            method = "prepare",
//            args = {Connection.class, Integer.class}
//        ),
//
//        @Signature(
//                type = StatementHandler.class,
//                method = "batch",
//                args = {Statement.class}
//        ),
//
//})
//@Slf4j
//public class ShowSqlInterceptor implements Interceptor {
//
//    @Override
//    public Object intercept(Invocation invocation) throws Throwable {
//
//        // 方法过滤,其实没必要
//        String[] methods = {"prepare","batch"};
//        if(!Arrays.asList(methods).contains(invocation.getMethod().getName())){
//            log.info("未知的方法:{}",invocation.getMethod().getName());
//            return invocation.proceed();
//        }
//
//
//        StatementHandler statementHandler = (StatementHandler)invocation.getTarget();
//
//        BaseStatementHandler baseStatementHandler = null;
//
//        if(statementHandler instanceof RoutingStatementHandler){
//
//            Field field = statementHandler.getClass().getDeclaredField("delegate");
//
//            field.setAccessible(true);
//
//            baseStatementHandler = (BaseStatementHandler) field.get(statementHandler);
//
//        }else if(statementHandler instanceof BaseStatementHandler){
//            baseStatementHandler = (BaseStatementHandler)statementHandler;
//        }
//
//        if(baseStatementHandler == null){
//            return invocation.proceed();
//        }
//
//        // baseStatementHandler 抽象类
//        Field field = baseStatementHandler.getClass().getSuperclass().getDeclaredField("configuration");
//
//        field.setAccessible(true);
//        Configuration configuration = (Configuration) field.get(baseStatementHandler);
//
//        Object[] args = invocation.getArgs();
//
//
//        BoundSql boundSql = statementHandler.getBoundSql();
//
//        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
//
//        String sql = boundSql.getSql();
//
//        sql = sql.replace("\n","");
//
//        for (ParameterMapping parameterMapping : parameterMappings) {
//            Object value = "";
//            String propertyName = parameterMapping.getProperty();
//            if(boundSql.hasAdditionalParameter(propertyName)){
//                value = boundSql.getAdditionalParameter(propertyName);
//
//            }else{
//                MetaObject metaObject = configuration.newMetaObject(boundSql.getParameterObject());
//                value = metaObject.getValue(propertyName);
//            }
//
//            if(value != null){
//                if(value instanceof Data){
//
//                }else if (value instanceof LocalDateTime){
//
//                }else if(value instanceof LocalDate){
//
//                }else if(value instanceof Number){
//
//                }else {
//                    value = "'" + value.toString() + "'";
//                }
//                sql = sql.replaceFirst("[?]",value.toString());
//            }
//
//
//        }
//
//        System.out.println("最终执行的sql："+ sql);
//        return invocation.proceed();
//    }
//
//    @Override
//    public Object plugin(Object target) {
//        return Plugin.wrap(target,this);
//    }
//
//    @Override
//    public void setProperties(Properties properties) {
//
//    }
//
//
//
//
//
//}
