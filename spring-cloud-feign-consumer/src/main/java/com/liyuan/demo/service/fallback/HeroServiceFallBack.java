package com.liyuan.demo.service.fallback;

import com.liyuan.demo.domain.response.PageListResponse;
import com.liyuan.demo.domain.response.ResponseEntity;
import com.liyuan.demo.form.hero.HeroCreateForm;
import com.liyuan.demo.form.hero.HeroDeleteForm;
import com.liyuan.demo.form.hero.HeroQueryForm;
import com.liyuan.demo.form.hero.HeroUpdateForm;
import com.liyuan.demo.service.HeroService;
import com.liyuan.demo.vo.hero.HeroVo;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * HeroService的熔断器类
 * 注意：一定要实现HeroService服务接口
 */
@Component
public class HeroServiceFallBack implements HeroService{

    @Override
    public ResponseEntity<HeroVo> query(@RequestParam("id") Integer id){
        return new ResponseEntity<>();
    }

    @Override
    public ResponseEntity<Integer> queryCount(@RequestBody @Valid HeroQueryForm form){
        return new ResponseEntity<>();
    }

    @Override
    public ResponseEntity<PageListResponse<HeroVo>> queryList(@RequestBody@Valid HeroQueryForm form){
        return new ResponseEntity<>();
    }

    public ResponseEntity<PageListResponse<HeroVo>> queryPageList(@RequestBody@Valid HeroQueryForm form){
        return new ResponseEntity<>();
    }

    @Override
    public ResponseEntity<HeroVo> add(@RequestBody@Valid HeroCreateForm form){
        return new ResponseEntity<>();
    }

    @Override
    public ResponseEntity update(@RequestBody @Valid HeroUpdateForm form){
        return new ResponseEntity<>();
    }

    @Override
    public ResponseEntity delete(@RequestBody@Valid HeroDeleteForm form){
        return new ResponseEntity<>();
    }
}