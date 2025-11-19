package com.luruoyang.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Data
@ConfigurationProperties(prefix = "my.shop")
public class ShopProperties {
  private String openHours;
  private boolean ready;


}
