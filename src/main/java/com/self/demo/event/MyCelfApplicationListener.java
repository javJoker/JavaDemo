package com.self.demo.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyCelfApplicationListener implements ApplicationListener<MyApplicationEvent> {


    @Override
    public void onApplicationEvent(MyApplicationEvent event) {
        String mesg = event.getMesg();
        System.out.println(mesg);
        System.out.println("自己的监听事件" + event);
    }

}
