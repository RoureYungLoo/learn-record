package com.xxx.springbootregister.annotation;

import config.CommonConfig;
import config.CommonImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(CommonImportSelector.class)
/* 自定义组合注解， */
public @interface EnableCommonConfig {

}
