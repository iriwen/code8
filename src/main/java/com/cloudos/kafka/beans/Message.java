package com.cloudos.kafka.beans;

import java.util.Date;

/**
 * Created by iriwen on 2018/7/4.
 */

public class Message {


    private Long id;    //id

    private String msg; //消息

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    private Date sendTime;  //时间戳


}
