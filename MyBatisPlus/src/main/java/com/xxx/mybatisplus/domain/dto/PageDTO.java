package com.xxx.mybatisplus.domain.dto;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxx.mybatisplus.domain.po.User;
import com.xxx.mybatisplus.domain.vo.UserVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
@Schema(description = "分页查询返回对象")
public class PageDTO<T> {
    @Schema(description = "总记录数")
    private Long total;
    @Schema(description = "总页数")
    private Long pages;
    @Schema(description = "对象列表")
    private List<T> list;

    public static <PO, VO> PageDTO<VO> of(Page<PO> p, Class<VO> clazz) {
        PageDTO<VO> dto = new PageDTO<>();

        dto.setTotal(p.getTotal());

        dto.setPages(p.getPages());

        // PO
        List<PO> records = p.getRecords();
        if (CollUtil.isEmpty(records)) {
            dto.setList(Collections.emptyList());
            return dto;
        }

        // PO -> VO
        List<VO> vos = BeanUtil.copyToList(records, clazz);
        // VO -> DTO
        dto.setList(vos);
        return dto;
    }

    public static <PO, VO> PageDTO<VO> of(Page<PO> p, Function<PO, VO> convertor) {
        PageDTO<VO> dto = new PageDTO<>();

        dto.setTotal(p.getTotal());

        dto.setPages(p.getPages());

        // PO
        List<PO> records = p.getRecords();
        if (CollUtil.isEmpty(records)) {
            dto.setList(Collections.emptyList());
            return dto;
        }

        // PO -> VO
//        List<VO> vos = BeanUtil.copyToList(records, clazz);
        // VO -> DTO
//        dto.setList(vos);
        List<VO> vos = records.stream().map(convertor).collect(Collectors.toList());
//        dto.setList(records.stream().map(convertor).collect(Collectors.toList()));
        dto.setList(vos);

        return dto;
    }

}
