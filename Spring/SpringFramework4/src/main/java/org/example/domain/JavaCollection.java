package org.example.domain;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class JavaCollection {
    String[] nicknames;
    List langs;
    Set hobbies;
    Map addrMap;
    Properties cateProps;
    String username;

    public String getUsername() {
        System.out.println("String: " + username);
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String[] getNicknames() {
        System.out.println("Array: " + nicknames);
        return nicknames;
    }

    public void setNicknames(String[] nicknames) {
        this.nicknames = nicknames;
    }

    public List getLangs() {
        System.out.println("List : " + langs);
        return langs;
    }

    public void setLangs(List langs) {
        this.langs = langs;
    }

    public Set getHobbies() {
        System.out.println("Set : " + hobbies);
        return hobbies;
    }

    public void setHobbies(Set hobbies) {
        this.hobbies = hobbies;
    }

    public Map getAddrMap() {
        System.out.println("Map : " + addrMap);
        return addrMap;
    }

    public void setAddrMap(Map addrMap) {
        this.addrMap = addrMap;
    }

    public Properties getCateProps() {
        System.out.println("Props : " + cateProps);
        return cateProps;
    }

    public void setCateProps(Properties cateProps) {
        this.cateProps = cateProps;
    }
}
