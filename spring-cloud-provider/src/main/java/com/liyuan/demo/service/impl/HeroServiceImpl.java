package com.liyuan.demo.service.impl;

import com.liyuan.demo.domain.po.hero.HeroPo;
import com.liyuan.demo.domain.condition.hero.HeroCondition;
import com.liyuan.demo.mapper.HeroMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import com.liyuan.demo.domain.exception.DemoException;
import com.liyuan.demo.service.impl.BaseServiceImpl;
import com.liyuan.demo.service.HeroService;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "com.liyuan.demo.domain.po.hero")
public class HeroServiceImpl extends BaseServiceImpl<HeroPo, HeroCondition, HeroMapper> implements HeroService {

@Override
    @Cacheable(key = "#id")
    public HeroPo queryWithValid(Object id) throws DemoException {
        return super.queryWithValid(id);
    }}