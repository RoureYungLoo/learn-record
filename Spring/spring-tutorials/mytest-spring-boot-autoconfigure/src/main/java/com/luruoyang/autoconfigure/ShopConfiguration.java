package com.luruoyang.autoconfigure;

import com.luruoyang.properties.ShopProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ShopProperties.class)
@ConditionalOnProperty(name = "my.shop.ready", havingValue = "true")
public class ShopConfiguration {
}
