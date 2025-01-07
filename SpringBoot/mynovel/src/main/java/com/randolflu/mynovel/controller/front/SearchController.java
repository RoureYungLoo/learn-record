package com.randolflu.mynovel.controller.front;

import com.randolflu.mynovel.core.common.resp.PageRespDto;
import com.randolflu.mynovel.core.common.resp.RestResp;
import com.randolflu.mynovel.core.constant.ApiRouterConsts;
import com.randolflu.mynovel.dto.req.BookSearchReqDto;
import com.randolflu.mynovel.dto.resp.BookInfoRespDto;
import com.randolflu.mynovel.service.SearchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 前台门户-搜索模块 API 控制器
 *
 * @author xiongxiaoyang
 * @date 2022/5/27
 */
@Tag(name = "SearchController", description = "前台门户-搜索模块")
@RestController
@RequestMapping(ApiRouterConsts.API_FRONT_SEARCH_URL_PREFIX)
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    /**
     * 小说搜索接口
     */
    @Operation(summary = "小说搜索接口")
    @GetMapping("books")
    public RestResp<PageRespDto<BookInfoRespDto>> searchBooks(
        @ParameterObject BookSearchReqDto condition) {
        return searchService.searchBooks(condition);
    }

}
