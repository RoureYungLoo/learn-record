package com.xxx.mybatisplus.service.impl;

import com.xxx.mybatisplus.domain.po.Address;
import com.xxx.mybatisplus.mapper.AddressMapper;
import com.xxx.mybatisplus.service.IAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author luruoyang
 * @since 2024-09-06
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements IAddressService {

}
