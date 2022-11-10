package com.jhson.api.home.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class ClientLog {

    private String ip;
    private int port;
    private Date time;

    public ClientLog() {
        ip = null;
        port = -1;
        time = null;
    }

    @Override
    public String toString() {
        return String.format(
                "[Client Info] : IP(%s:%d) accessTime(%s)"
                , this.ip
                , this.port
                , new SimpleDateFormat("yyyy-MM-dd : hh:mm:ss").format(this.time)
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientLog that = (ClientLog) o;
        return Objects.equals(ip, that.ip) && Objects.equals(time, that.time) && port==that.port;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip);
    }

    public ClientLog setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public ClientLog setPort(int port) {
        this.port = port;
        return this;
    }

    public ClientLog setTime(Date time) {
        this.time = time;
        return this;
    }

    public int getPort() {
        return port;
    }

    public String getIp() {
        return ip;
    }

    public Date getTime() {
        return time;
    }




}
