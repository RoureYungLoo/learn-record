package config;

import com.xxx.pojo.Country;
import com.xxx.pojo.Province;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.web.servlet.DispatcherServlet;

/* 自定义配置类，用于注册Bean */
@Configuration
public class CommonConfig {

    /**/
    /* 注入 Country 对象 */
    // @Bean
    // public Country country(){
    //    return new Country();
    // }

    /* 对象默认的名字是方法名 */
//    @Bean
//    public Country country() {
//        return new Country("wqe", "4324");
//    }

    /* 对象默认的名字是方法名 */
//    @Bean("yindu") // 修改注入的Bean名
//    public Country country2() {
//        return new Country("印度", "社会主义"); // 硬编码
//    }

//    @Bean("henan") // 修改注入的Bean名
//    public Province province(Country country){
//        return new Province("河南","省长");
//    }


//    @Bean
//    /* Bean的条件注册 */ // 如果配置文件中配置了指定信息则注入，否则不注入
//    @ConditionalOnProperty(prefix = "country",name = {"name","system"}) // name是配置文件中的键名
//    public Country country(
//            @Value("${country.name}") String name, // @Value("${key.key...}")
//            @Value("${country.system}")  String system){
//        return new Country(name,system);
//    }

    @Bean
    /* Bean条件注册：不存在Country时则注入，否则不注入 */
    // @ConditionalOnMissingBean(Country.class)

    // 如果没有引入web起步依赖，环境中没有DispatcherServlet，则注入，否则不主图注入
    @ConditionalOnMissingClass("org.springframework.web.servlet.DispatcherServlet")
    public Province province(){
        return new Province();
    }
}
