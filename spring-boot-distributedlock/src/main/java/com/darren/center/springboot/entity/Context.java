package com.darren.center.springboot.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Context implements Serializable{

    private String msgSeq;

    private String clientIp;

    private Map<String, Object> attrs;


    public <T> void setAttrs(String key, T value) {
        if (attrs == null){
            attrs = new HashMap<>();
        }
        this.attrs.put(key, value);
    }

    public <T> T getAttrs(String key) {
        if (attrs != null){
            return (T) this.attrs.get(key);
        }
        return null;
    }

    public Context() {
    }

    public Context(String msgSeq) {
        this.msgSeq = msgSeq;
    }

    public Map<String, Object> getAttrs() {
        return attrs;
    }

    public void setAttrs(Map<String, Object> attrs) {
        this.attrs = attrs;
    }

    public String getMsgSeq() {
        return msgSeq;
    }

    public void setMsgSeq(String msgSeq) {
        this.msgSeq = msgSeq;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

}
