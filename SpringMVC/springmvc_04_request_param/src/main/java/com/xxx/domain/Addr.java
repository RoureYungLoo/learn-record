package com.xxx.domain;

public class Addr {
    private String province;
    private String city;

    @Override
    public String toString() {
        return "Addr{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Addr() {
    }

    public Addr(String province, String city) {
        this.province = province;
        this.city = city;
    }
}
