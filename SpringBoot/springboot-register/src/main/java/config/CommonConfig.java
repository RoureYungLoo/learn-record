package config;

import com.xxx.pojo.Country;
import com.xxx.pojo.Province;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
    @Bean("yindu")
    public Country country2() {
        return new Country("印度", "432114");
    }

    @Bean("henan")
    public Province province(Country country){
        return new Province("河南","direct");
    }
}
