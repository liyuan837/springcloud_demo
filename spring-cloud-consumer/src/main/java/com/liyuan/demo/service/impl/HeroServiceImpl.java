package com.liyuan.demo.service.impl;

import com.liyuan.demo.domain.exception.DemoException;
import com.liyuan.demo.domain.response.PageListResponse;
import com.liyuan.demo.domain.response.ResponseEntity;
import com.liyuan.demo.form.hero.HeroCreateForm;
import com.liyuan.demo.form.hero.HeroDeleteForm;
import com.liyuan.demo.form.hero.HeroQueryForm;
import com.liyuan.demo.form.hero.HeroUpdateForm;
import com.liyuan.demo.service.HeroService;
import com.liyuan.demo.vo.hero.HeroVo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HeroServiceImpl implements HeroService {

    @Autowired
    private RestTemplate restTemplate;

    private String serverPath = "http://SPRING-CLOUD-PROVIDER/hero/";

    @Override
    @HystrixCommand(fallbackMethod = "queryError")
    @CacheResult
    public ResponseEntity<HeroVo> query(Integer id) throws DemoException {
        ResponseEntity<HeroVo> response = restTemplate.getForEntity(serverPath + "query?id={id}",ResponseEntity.class,id).getBody();
        return response;
    }

    @Override
    public ResponseEntity<Integer> queryCount(HeroQueryForm form) throws DemoException {
        ResponseEntity<Integer> response = restTemplate.postForEntity(serverPath + "queryCount",form,ResponseEntity.class).getBody();
        return response;
    }

    @Override
    public ResponseEntity<PageListResponse<HeroVo>> queryList(HeroQueryForm form) throws DemoException {
        ResponseEntity<PageListResponse<HeroVo>> response = restTemplate.postForEntity(serverPath + "queryList",form,ResponseEntity.class).getBody();
        return response;
    }

    @Override
    public ResponseEntity<PageListResponse<HeroVo>> queryPageList(HeroQueryForm form) throws DemoException {
        ResponseEntity<PageListResponse<HeroVo>> response = restTemplate.postForEntity(serverPath + "queryPageList",form,ResponseEntity.class).getBody();
        return response;
    }

    @Override
    public ResponseEntity<HeroVo> add(HeroCreateForm form) throws DemoException {
        ResponseEntity<HeroVo> response = restTemplate.postForEntity(serverPath + "add",form,ResponseEntity.class).getBody();
        return response;
    }

    @Override
    public ResponseEntity update(HeroUpdateForm form) throws DemoException {
        ResponseEntity<HeroVo> response = restTemplate.postForEntity(serverPath + "update",form,ResponseEntity.class).getBody();
        return response;
    }

    @Override
    public ResponseEntity delete(HeroDeleteForm form) throws DemoException {
        ResponseEntity response = restTemplate.postForEntity(serverPath + "delete",form,ResponseEntity.class).getBody();
        return response;
    }

    public ResponseEntity<HeroVo> queryError(Integer id) throws DemoException {
        return new ResponseEntity<HeroVo>();
    }
}