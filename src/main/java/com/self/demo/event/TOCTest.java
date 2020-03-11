package com.self.demo.event;


import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TOCTest {

    @Test
    public void testEvent(){
        AnnotationConfigApplicationContext applicationContexts = new AnnotationConfigApplicationContext(SpringConfig.class);
        applicationContexts.publishEvent(new MyApplicationEvent("我发布的事件"));
        String[] beanDefinitionNames = applicationContexts.getBeanDefinitionNames();
        for (String bname:beanDefinitionNames){
            System.out.println(bname);
        }

        applicationContexts.close();

    }
}
