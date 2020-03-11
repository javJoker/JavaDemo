package com.self.demo.event;

import org.springframework.context.ApplicationEvent;


/**
 * spring异步事件
 */
public class MyApplicationEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */



    private String id = "1111" ;
    private String mesg = "jhahahh";

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public MyApplicationEvent(Object source, String id, String mesg) {
        super(source);
        getMessage();
        this.id = id;
        this .mesg = mesg;
    }

    public MyApplicationEvent(Object source) {
        super(source);
    }

    public String getMesg() {
        return mesg;
    }

    public void setMesg(String mesg) {
        this.mesg = mesg;
    }



    private void getMessage(){
        System.out.println("发布自己的事件");
    }
}
