package com.xxx.mybatisplus.controller;


import com.xxx.mybatisplus.domain.po.City;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author luruoyang
 * @since 2024-09-06
 */
@RestController
@RequestMapping("/address")
@Tag(name = "地址管理",description = "这里是地址管理模块")
public class AddressController {

    @Operation(summary = "新增地址",description = "新增地址描述")
    @Parameter(name = "province",description = "省份")
    @Parameter(name = "zone",description = "市")
    @PostMapping
    public String save(String province,String zone){
        return "保存成功";
    }

    @Operation(summary = "新增地址",description = "新增地址描述")
    @Parameter(name = "province",description = "省份",required = true)
    @Parameter(name = "zone",description = "市")
    @GetMapping("/v2")
    public String save(@ParameterObject City city){
        System.out.println(city);
        return "保存成功";
    }


}
