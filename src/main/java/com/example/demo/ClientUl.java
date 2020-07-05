package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="client_id")
public class ClientUl extends Client{
    Integer inn;
    String orgName;

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Integer getInn() {
        return inn;
    }

    public void setInn(Integer inn) {
        this.inn = inn;
    }

    @Override
    public String getStatus(){
        return super.getStatus() + getInn();
    }

    @Override
    public String toString() {
        return "ClientUl{" +
                "id='" + getId() + '\'' +
                "inn=" + inn +
                ", orgName='" + orgName + '\'' +
                ", status='" + getStatus() + '\'' +
                '}';
    }
}
