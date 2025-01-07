package com.xxx.structural.proxy_pattern.two;

/* 真实主题角色 */
public class RealSearcher implements Searcher {
    @Override
    public String DoSearch(String userId, String keyword) {
        System.out.println("RealSubject 业务方法"+userId+"查询了关键字："+keyword);
        return "模拟返回的内容";
    }
}
