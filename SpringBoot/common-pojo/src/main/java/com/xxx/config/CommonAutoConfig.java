package com.xxx.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Import;

@AutoConfiguration
@Import(CommonConfig.class)
public class CommonAutoConfig {
    public CommonAutoConfig() {
    }
}
