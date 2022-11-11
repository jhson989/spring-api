package com.jhson.api.home.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class ClientInfoDTO {

    private String ip;
    private int port;
    private Date accessTime;

    public ClientInfoDTO() {
    }

    @Override
    public String toString() {
        return String.format(
                "[Client Info] : IP(%s:%d) accessTime(%s)"
                , this.ip
                , this.port
                , new SimpleDateFormat("yyyy-MM-dd : kk:mm:ss").format(this.accessTime)
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientInfoDTO that = (ClientInfoDTO) o;
        return Objects.equals(ip, that.ip) && Objects.equals(accessTime, that.accessTime) && port==that.port;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip);
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setAccessTime(Date accessTime) {
        this.accessTime = accessTime;
    }

    public int getPort() {
        return port;
    }

    public String getIp() {
        return ip;
    }

    public Date getAccessTime() {
        return accessTime;
    }




}
