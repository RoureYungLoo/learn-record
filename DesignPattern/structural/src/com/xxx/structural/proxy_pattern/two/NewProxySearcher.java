package com.xxx.structural.proxy_pattern.two;

/* 代理类,  */
public class NewProxySearcher implements Searcher {

    private final RealSearcher realSearcher;
    private final AccessValidator accessValidator;
    private final Logger logger;
    private final MsgSender msgSender;

    public NewProxySearcher() {
        realSearcher = new RealSearcher();
        accessValidator = new AccessValidator();
        logger = new Logger();
        msgSender = new MsgSender();
    }

    @Override
    public String DoSearch(String userId, String keyword) {

        /* 鉴权 */
        if (!accessValidator.Validate(userId)) {
            System.out.println("鉴权失败");
            return null;
        }

        /* 执行业务 */
        String result = realSearcher.DoSearch(userId, keyword);

        /* 记录日志 */
        logger.Log(userId);

        /* 发送消息 */
        msgSender.sendMsg(userId, keyword);

        return result;
    }
}
