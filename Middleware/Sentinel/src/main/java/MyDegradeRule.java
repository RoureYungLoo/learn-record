import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.degrade.circuitbreaker.CircuitBreakerStrategy;

import java.util.ArrayList;
import java.util.List;


public class MyDegradeRule {
    /* 熔断降级规则 */
    public static void initDegradeRule(String resource) {
        List<DegradeRule> rules = new ArrayList<>();

        DegradeRule rule = new DegradeRule(resource);
        rule.setGrade(CircuitBreakerStrategy.ERROR_RATIO.getType())
                .setCount(0.7)
                .setMinRequestAmount(100)
                .setStatIntervalMs(30000)
                .setTimeWindow(10);
        rules.add(rule);

        DegradeRuleManager.loadRules(rules);
    }
}
