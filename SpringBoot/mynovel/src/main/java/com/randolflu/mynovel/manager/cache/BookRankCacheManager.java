package com.randolflu.mynovel.manager.cache;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.randolflu.mynovel.core.constant.CacheConsts;
import com.randolflu.mynovel.core.constant.DatabaseConsts;
import com.randolflu.mynovel.dao.entity.BookInfo;
import com.randolflu.mynovel.dao.mapper.BookInfoMapper;
import com.randolflu.mynovel.dto.resp.BookRankRespDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * 小说排行榜 缓存管理类
 *
 * @author xiongxiaoyang
 * @date 2022/5/12
 */
@Component
@RequiredArgsConstructor
public class BookRankCacheManager {

    private final BookInfoMapper bookInfoMapper;

    /**
     * 查询小说点击榜列表，并放入缓存中
     */
    @Cacheable(cacheManager = CacheConsts.REDIS_CACHE_MANAGER,
        value = CacheConsts.BOOK_VISIT_RANK_CACHE_NAME)
    public List<BookRankRespDto> listVisitRankBooks() {
        QueryWrapper<BookInfo> bookInfoQueryWrapper = new QueryWrapper<>();
        bookInfoQueryWrapper.orderByDesc(DatabaseConsts.BookTable.COLUMN_VISIT_COUNT);
        return listRankBooks(bookInfoQueryWrapper);
    }

    /**
     * 查询小说新书榜列表，并放入缓存中
     */
    @Cacheable(cacheManager = CacheConsts.CAFFEINE_CACHE_MANAGER,
        value = CacheConsts.BOOK_NEWEST_RANK_CACHE_NAME)
    public List<BookRankRespDto> listNewestRankBooks() {
        QueryWrapper<BookInfo> bookInfoQueryWrapper = new QueryWrapper<>();
        bookInfoQueryWrapper
            .gt(DatabaseConsts.BookTable.COLUMN_WORD_COUNT, 0)
            .orderByDesc(DatabaseConsts.CommonColumnEnum.CREATE_TIME.getName());
        return listRankBooks(bookInfoQueryWrapper);
    }

    /**
     * 查询小说更新榜列表，并放入缓存中
     */
    @Cacheable(cacheManager = CacheConsts.CAFFEINE_CACHE_MANAGER,
        value = CacheConsts.BOOK_UPDATE_RANK_CACHE_NAME)
    public List<BookRankRespDto> listUpdateRankBooks() {
        QueryWrapper<BookInfo> bookInfoQueryWrapper = new QueryWrapper<>();
        bookInfoQueryWrapper
            .gt(DatabaseConsts.BookTable.COLUMN_WORD_COUNT, 0)
            .orderByDesc(DatabaseConsts.CommonColumnEnum.UPDATE_TIME.getName());
        return listRankBooks(bookInfoQueryWrapper);
    }

    private List<BookRankRespDto> listRankBooks(QueryWrapper<BookInfo> bookInfoQueryWrapper) {
        bookInfoQueryWrapper
            .gt(DatabaseConsts.BookTable.COLUMN_WORD_COUNT, 0)
            .last(DatabaseConsts.SqlEnum.LIMIT_30.getSql());
        return bookInfoMapper.selectList(bookInfoQueryWrapper).stream().map(v -> {
            BookRankRespDto respDto = new BookRankRespDto();
            respDto.setId(v.getId());
            respDto.setCategoryId(v.getCategoryId());
            respDto.setCategoryName(v.getCategoryName());
            respDto.setBookName(v.getBookName());
            respDto.setAuthorName(v.getAuthorName());
            respDto.setPicUrl(v.getPicUrl());
            respDto.setBookDesc(v.getBookDesc());
            respDto.setLastChapterName(v.getLastChapterName());
            respDto.setLastChapterUpdateTime(v.getLastChapterUpdateTime());
            respDto.setWordCount(v.getWordCount());
            return respDto;
        }).toList();
    }

}
