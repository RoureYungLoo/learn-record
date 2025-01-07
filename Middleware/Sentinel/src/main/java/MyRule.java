import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityRule;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityRuleManager;
import com.alibaba.csp.sentinel.slots.system.SystemRule;
import com.alibaba.csp.sentinel.slots.system.SystemRuleManager;

import java.util.ArrayList;
import java.util.List;

public class MyRule {
    /* 定义系统访问规则 */
    public static void initSystemRule() {
        List<SystemRule> rules = new ArrayList<>();

        SystemRule rule = new SystemRule();
        rule.setHighestSystemLoad(10);

        rules.add(rule);

        SystemRuleManager.loadRules(rules);
    }

    /* 定义访问控制规则 */
    public static void initAuthorityRule(String resource, String app) {
        List<AuthorityRule> rules = new ArrayList<>();

        AuthorityRule rule = new AuthorityRule();
        rule.setResource(resource);
        rule.setLimitApp(app);
        rule.setStrategy(RuleConstant.AUTHORITY_WHITE);

        rules.add(rule);
        AuthorityRuleManager.loadRules(rules);
    }
}
