package com.xxx.springboot02jsonresult.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class FastjsonConfig extends WebMvcConfigurationSupport {


    //    使用阿里 FastJson 作为JSON MessageConverter
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(
                SerializerFeature.WriteMapNullValue,// 保留map空的字段
                SerializerFeature.WriteNullStringAsEmpty,// 将String类型的null转成""
                SerializerFeature.WriteNullNumberAsZero,// 将Number类型的null转成0
                SerializerFeature.WriteNullListAsEmpty,// 将List类型的null转成[]
                SerializerFeature.WriteNullBooleanAsFalse,// 将Boolean类型的null转成false
                SerializerFeature.DisableCircularReferenceDetect// 避免循环引用
        );
        converter.setFastJsonConfig(config);
        converter.setDefaultCharset(StandardCharsets.UTF_8);

        List<MediaType> mediaTypeList = new ArrayList<>();
        // 解决中文乱码问题，相当于在Controller上的@RequestMapping中加了个属性produces = "application/json"
        mediaTypeList.add(MediaType.APPLICATION_JSON);
        converter.setSupportedMediaTypes(mediaTypeList);
        converters.add(converter);
    }
}
