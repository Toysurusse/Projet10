package com.library.config;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(namespace = Authentication.AUTH_NS)
public class Authentication {

    public static final String AUTH_NS = "http://library";

    @XmlElement(namespace = AUTH_NS)
    private String username;
    @XmlElement(namespace = AUTH_NS)
    private String password;

    public Authentication() {
        this.username = username;
        this.password = password;
    }

    public Authentication(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isTrue(){
        boolean control = false;
        if("password".equals(password)&&"username".equals(username)){
            control=true;
        }
        return control;
    }

    public Authentication authentic(){
        return new Authentication("username","password");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
