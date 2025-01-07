import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphO;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SentinelHelloWorld {

    public static void main(String[] args) {
        String resourceName = "HelloWorld";
        String app = "SentinelHelloWorld";

         // initFlowRules();
         MyFlowRule.FlowQpsRule(resourceName);
         //MyDegradeRule.initDegradeRule(resourceName);
         //MyRule.initSystemRule();
        //MyRule.initAuthorityRule(resourceName,app);


        while (true) {
            Entry entry = null;
            try {
                entry = SphU.entry(resourceName);
                System.out.println("hello world");
            } catch (BlockException e) {
                boolean b = BlockException.isBlockException(e);
                System.out.println(b);
                System.out.println("blocked!");
            } finally {
                if (entry != null) {
                    entry.exit();
                }
            }
        }

       /* while (true) {
            // 资源名可使用任意有业务语义的字符串
            if (SphO.entry(resourceName)) {
                // 务必保证finally会被执行
                try {
                    System.out.println("hello world");
                    //被保护的业务逻辑
                } finally {
                    SphO.exit();
                }
            } else {
                // 资源访问阻止，被限流或被降级
                // 进行相应的处理操作
                System.out.println("blocked!");
            }
        }*/


        // 配置规则.
//        initFlowRules();
/*        while (true) {
            // 1.5.0 版本开始可以直接利用 try-with-resources 特性
            try (Entry entry = SphU.entry("HelloWorld")) {
                // 被保护的逻辑
                Thread.sleep(49);
                System.out.println("hello world");
            } catch (BlockException ex) {
                // 处理被流控的逻辑
                System.out.println("blocked!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
    }

    private static void initFlowRules() {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("HelloWorld");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // Set limit QPS to 20.
        rule.setCount(20);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }


}
