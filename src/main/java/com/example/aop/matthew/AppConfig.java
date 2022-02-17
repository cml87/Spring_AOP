package com.example.aop.matthew;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.example.aop.matthew")
@EnableAspectJAutoProxy // takes @Aspect annotated Spring beans and use them to create proxies.     <aop:aspectj-autoproxy/>
//in xml
public class AppConfig {


}
