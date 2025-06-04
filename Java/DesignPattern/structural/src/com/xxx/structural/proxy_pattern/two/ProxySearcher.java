package com.xxx.structural.proxy_pattern.two;

/* 代理类 */
public class ProxySearcher implements Searcher {

    /* 持有真实对象的引用 */
    private final RealSearcher searcher;
    private final AccessValidator validator;
    private final Logger logger;

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

    public ProxySearcher() {
        searcher = new RealSearcher();
        validator = new AccessValidator();
        logger = new Logger();
    }

    public ProxySearcher(RealSearcher searcher, AccessValidator validator, Logger logger) {
        this.searcher = searcher;
        this.validator = validator;
        this.logger = logger;
    }
}
