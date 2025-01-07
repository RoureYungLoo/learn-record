package com.randolflu.mynovel.service.impl;

import com.randolflu.mynovel.core.common.resp.RestResp;
import com.randolflu.mynovel.dto.resp.HomeBookRespDto;
import com.randolflu.mynovel.dto.resp.HomeFriendLinkRespDto;
import com.randolflu.mynovel.manager.cache.FriendLinkCacheManager;
import com.randolflu.mynovel.manager.cache.HomeBookCacheManager;
import com.randolflu.mynovel.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 首页模块 服务实现类
 *
 * @author xiongxiaoyang
 * @date 2022/5/13
 */
@Service
@RequiredArgsConstructor
public class HomeServiceImpl implements HomeService {

    private final HomeBookCacheManager homeBookCacheManager;

    private final FriendLinkCacheManager friendLinkCacheManager;

    @Override
    public RestResp<List<HomeBookRespDto>> listHomeBooks() {
        return RestResp.ok(homeBookCacheManager.listHomeBooks());
    }

    @Override
    public RestResp<List<HomeFriendLinkRespDto>> listHomeFriendLinks() {
        return RestResp.ok(friendLinkCacheManager.listFriendLinks());
    }
}
