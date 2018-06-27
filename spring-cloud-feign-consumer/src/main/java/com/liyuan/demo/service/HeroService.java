package com.liyuan.demo.service;

import com.liyuan.demo.domain.response.PageListResponse;
import com.liyuan.demo.domain.response.ResponseEntity;
import com.liyuan.demo.form.hero.HeroCreateForm;
import com.liyuan.demo.form.hero.HeroDeleteForm;
import com.liyuan.demo.form.hero.HeroQueryForm;
import com.liyuan.demo.form.hero.HeroUpdateForm;
import com.liyuan.demo.service.fallback.HeroServiceFallBack;
import com.liyuan.demo.vo.hero.HeroVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 通过@FeignClient注解来指定服务名（不区分大小写）进而绑定服务
 * fallback：指定熔断器类
 */
@FeignClient(name="spring-cloud-provider", fallback=HeroServiceFallBack.class)
public interface HeroService {

    //通过SpringMVC中提供的注解来绑定服务提供者提供的接口
    @GetMapping(value="/hero/query")
    ResponseEntity<HeroVo> query(@RequestParam("id") Integer id);

    //post请求支持@RequestBody注解
    @PostMapping(value="/hero/queryCount")
    ResponseEntity<Integer> queryCount(@RequestBody@Valid HeroQueryForm form);

    @PostMapping(value="/hero/queryList")
    ResponseEntity<PageListResponse<HeroVo>> queryList(@RequestBody@Valid HeroQueryForm form);

    @PostMapping(value="/hero/queryPageList")
    ResponseEntity<PageListResponse<HeroVo>> queryPageList(@RequestBody@Valid HeroQueryForm form);

    @PostMapping(value="/hero/add")
    ResponseEntity<HeroVo> add(@RequestBody@Valid HeroCreateForm form);

    @PostMapping(value="/hero/update")
    ResponseEntity update(@RequestBody @Valid HeroUpdateForm form);

    @PostMapping(value="/hero/delete")
    ResponseEntity delete(@RequestBody@Valid HeroDeleteForm form);
}