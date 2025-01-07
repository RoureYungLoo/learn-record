package com.xxx.structural.proxy_pattern.two;

public class ProxySearch implements Searcher {

    private RealSearcher searcher = new RealSearcher();
    private AccessValidator validator = new AccessValidator();
    private Logger logger = new Logger();

    public void Log(String userId) {
        logger.Log(userId);
    }

    public boolean Validate(String userId) {
        return validator.Validate(userId);
    }


    @Override
    public String DoSearch(String userId, String keyword) {

        // 身份验证
        if (Validate(userId)) {
            // 业务方法
            String result = searcher.DoSearch(userId, keyword);
            Log(userId); // 记录日志
            return result;
        } else {
            return null;
        }
    }
}
