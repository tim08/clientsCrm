package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="client_id")
public class ClientIp extends Client{
    String name;
    String surname;
    Float passportNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Float getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(Float passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Override
    public String getStatus(){
        return super.getStatus() + getPassportNumber();
    }

    @Override
    public String toString() {
        return "ClientIp{" +
                "id='" + getId() + '\'' +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", passportNumber=" + passportNumber +
                ", status='" + getStatus() + '\'' +
                '}';
    }
}
