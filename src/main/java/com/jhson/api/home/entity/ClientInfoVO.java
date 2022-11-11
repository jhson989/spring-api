package com.jhson.api.home.entity;

import java.util.Date;
import java.util.Objects;

public class ClientInfoVO {

    private String ip;
    private int port;
    private Date lastAccessTime;
    private int numVisits;

    public static class ClientInfoVOBuilder {

        private String ip;
        private int port;
        private Date lastAccessTime;
        private int numVisits;

        public ClientInfoVO build() {
            ClientInfoVO clientInfoVO = new ClientInfoVO();
            clientInfoVO.ip = this.ip;
            clientInfoVO.port = this.port;
            clientInfoVO.lastAccessTime = this.lastAccessTime;
            clientInfoVO.numVisits = this.numVisits;
            return clientInfoVO;
        }

        public ClientInfoVOBuilder setIp(String ip) {
            this.ip = ip;
            return this;
        }

        public ClientInfoVOBuilder setPort(int port) {
            this.port = port;
            return this;
        }

        public ClientInfoVOBuilder setLastAccessTime(Date lastAccessTime) {
            this.lastAccessTime = lastAccessTime;
            return this;
        }

        public ClientInfoVOBuilder setNumVisits(int numVisits) {
            this.numVisits = numVisits;
            return this;
        }


    }

    public static ClientInfoVOBuilder clientInfoVOBuilder() {
        return new ClientInfoVOBuilder();
    }

    public static ClientInfoVO toVO(ClientInfoDTO clientInfoDTO) {
        return ClientInfoVO.clientInfoVOBuilder()
                .setIp(clientInfoDTO.getIp())
                .setPort(clientInfoDTO.getPort())
                .setLastAccessTime(clientInfoDTO.getAccessTime())
                .setNumVisits(1)
                .build();
    }

    public static ClientInfoVO toVO(ClientInfoDTO clientInfoDTO, int numVisits) {
        return ClientInfoVO.clientInfoVOBuilder()
                .setIp(clientInfoDTO.getIp())
                .setPort(clientInfoDTO.getPort())
                .setLastAccessTime(clientInfoDTO.getAccessTime())
                .setNumVisits(numVisits+1)
                .build();
    }

    @Override
    public String toString() {
        return "ClientVO{" +
                "ip='" + ip + '\'' +
                ", port=" + port +
                ", lastAccessTime=" + lastAccessTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientInfoVO clientInfoVO = (ClientInfoVO) o;
        return port == clientInfoVO.port && Objects.equals(ip, clientInfoVO.ip) && Objects.equals(lastAccessTime, clientInfoVO.lastAccessTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip, port, lastAccessTime);
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    public Date getLastAccessTime() {
        return lastAccessTime;
    }

    public int getNumVisits() {
        return numVisits;
    }
}
