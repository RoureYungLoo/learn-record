package com.xxx.mybatisplus.domain.query;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxx.mybatisplus.domain.po.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.logging.log4j.message.ReusableMessage;

@Data
@Schema(description = "通用分页参数")
public class PageQuery {
    @Schema(description = "页数", requiredMode = Schema.RequiredMode.REQUIRED, defaultValue = "1")
    private Integer pageNo;
    @Schema(description = "页大小", requiredMode = Schema.RequiredMode.REQUIRED, defaultValue = "1")
    private Integer pageSize;
    @Schema(description = "排序关键字", requiredMode = Schema.RequiredMode.REQUIRED, defaultValue = "balance")
    private String sortBy;
    @Schema(description = "顺序/逆序", requiredMode = Schema.RequiredMode.REQUIRED, defaultValue = "true")
    private Boolean isAsc;

    public <T> Page<T> toMpPage(OrderItem... orderItems) {
        Page<T> page = Page.of(pageNo, pageSize);

        if (StrUtil.isNotBlank(sortBy)) {
            page = page.addOrder(new OrderItem().setColumn(sortBy).setAsc(isAsc));
        } else if (orderItems != null) { // 默认根据create_time排序
            page = page.addOrder(orderItems);
        }

        return page;
    }

    public <T> Page<T> toMpPage(String defaultSortBy, Boolean defaultAsc) {
        return toMpPage(new OrderItem().setColumn(defaultSortBy).setAsc(defaultAsc));
    }

    public <T> Page<T> toMpPageDefaultSortByCreateTime() {
        return toMpPage(new OrderItem().setColumn("create_time").setAsc(false));
    }

    public <T> Page<T> toMpPageDefaultSortByUpdateTime() {
        return toMpPage(new OrderItem().setColumn("update_time").setAsc(false));

    }
}
