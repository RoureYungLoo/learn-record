package com.randolflu.mynovel.service;


import com.randolflu.mynovel.core.common.resp.PageRespDto;
import com.randolflu.mynovel.core.common.resp.RestResp;
import com.randolflu.mynovel.dto.req.BookSearchReqDto;
import com.randolflu.mynovel.dto.resp.BookInfoRespDto;

/**
 * 搜索 服务类
 *
 * @author xiongxiaoyang
 * @date 2022/5/23
 */
public interface SearchService {

    /**
     * 小说搜索
     *
     * @param condition 搜索条件
     * @return 搜索结果
     */
    RestResp<PageRespDto<BookInfoRespDto>> searchBooks(BookSearchReqDto condition);

}
