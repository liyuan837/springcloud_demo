package com.liyuan.demo.service;

import com.liyuan.demo.domain.exception.DemoException;
import com.liyuan.demo.domain.response.PageListResponse;
import com.liyuan.demo.domain.response.ResponseEntity;
import com.liyuan.demo.form.hero.HeroCreateForm;
import com.liyuan.demo.form.hero.HeroDeleteForm;
import com.liyuan.demo.form.hero.HeroQueryForm;
import com.liyuan.demo.form.hero.HeroUpdateForm;
import com.liyuan.demo.vo.hero.HeroVo;

public interface HeroService {
    ResponseEntity<HeroVo> query(Integer id) throws DemoException;
    ResponseEntity<Integer> queryCount(HeroQueryForm form) throws DemoException;

    ResponseEntity<PageListResponse<HeroVo>> queryList(HeroQueryForm form) throws DemoException;
    ResponseEntity<PageListResponse<HeroVo>> queryPageList(HeroQueryForm form) throws DemoException;
    ResponseEntity<HeroVo> add(HeroCreateForm form) throws DemoException;
    ResponseEntity update(HeroUpdateForm form) throws DemoException;
    ResponseEntity delete(HeroDeleteForm form) throws DemoException;
}