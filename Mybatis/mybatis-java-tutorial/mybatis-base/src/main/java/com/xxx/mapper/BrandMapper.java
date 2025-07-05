package com.xxx.mapper;

import com.xxx.entity.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    /* 查询所有 */
    List<Brand> selectAll();

    /* 查询一个 */
    Brand selectById(int id);

    /* 条件查询 */
    /* 参数接收：
    *   1. 散装参数：如果方法中有多个参数，需要使用@Param("SQL参数占位符名称")注解
    *   2. 对象参数：对象属性名和参数占位符名保持一致
    *   3. Map参数：map的key的名称和SQL参数占位符保持一致
    *  */
//    List<Brand> selectByCondition(
//            /* @Param("sql参数占位符名称")注解 用于sql参数接收 占位符*/
//            @Param("status") int status,
//            @Param("companyName") String companyName,
//            @Param("brandName") String brandName);

    // List<Brand> selectByCondition(Brand brand);

    List<Brand> selectByCondition(Map map);


    List<Brand> selectByConditionSingle(Brand brand);

    /* 添加数据 */
    void add(Brand brand);

    /* 修改数据 */
    int update(Brand brand);

    void deleteById(int id);

    void deleteByIds(@Param("ids") int[] ids);
}
