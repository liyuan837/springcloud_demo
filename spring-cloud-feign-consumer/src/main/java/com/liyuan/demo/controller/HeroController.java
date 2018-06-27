package com.liyuan.demo.controller;

import com.liyuan.demo.domain.exception.DemoException;
import com.liyuan.demo.domain.response.PageListResponse;
import com.liyuan.demo.domain.response.ResponseEntity;
import com.liyuan.demo.form.hero.HeroCreateForm;
import com.liyuan.demo.form.hero.HeroDeleteForm;
import com.liyuan.demo.form.hero.HeroQueryForm;
import com.liyuan.demo.form.hero.HeroUpdateForm;
import com.liyuan.demo.service.HeroService;
import com.liyuan.demo.vo.hero.HeroVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/hero")
@Api(value = "/hero", description = "")
public class HeroController extends BaseController {

	@Autowired
	private HeroService heroService;

	@ApiOperation(value = "查询",notes = "根据ID查询",httpMethod = "GET")
	@GetMapping(value = "/query")
	public ResponseEntity<HeroVo> query(@ApiParam(value = "", required = true)@RequestParam Integer id) throws DemoException {
		return heroService.query(id);
	}

	@ApiOperation(value = "查询数量",notes = "查询数量",httpMethod = "POST")
	@PostMapping(value = "/queryCount")
	public ResponseEntity<Integer> queryCount(@RequestBody@Valid HeroQueryForm form) throws DemoException {
		return heroService.queryCount(form);
	}

	@ApiOperation(value = "查询列表",notes = "查询列表",httpMethod = "POST")
	@PostMapping(value = "/queryList")
	public ResponseEntity<PageListResponse<HeroVo>> queryList(@RequestBody@Valid HeroQueryForm form) throws DemoException {
		return heroService.queryList(form);
	}

	@ApiOperation(value = "查询列表(带分页)",notes = "查询列表(带分页)",httpMethod = "POST")
	@PostMapping(value = "/queryPageList")
	public ResponseEntity<PageListResponse<HeroVo>> queryPageList(@RequestBody@Valid HeroQueryForm form) throws DemoException {
		return heroService.queryPageList(form);
	}

	@ApiOperation(value = "新增",notes = "新增",httpMethod = "POST")
	@PostMapping(value = "/add")
	public ResponseEntity<HeroVo> add(@RequestBody@Valid HeroCreateForm form) throws DemoException {
		return heroService.add(form);
	}

	@ApiOperation(value = "修改",notes = "修改",httpMethod = "POST")
	@PostMapping(value = "/update")
	public ResponseEntity update(@RequestBody@Valid HeroUpdateForm form) throws DemoException {
		return heroService.update(form);
	}

	@ApiOperation(value = "删除",notes = "删除",httpMethod = "POST")
	@PostMapping(value = "/delete")
	public ResponseEntity delete(@RequestBody@Valid HeroDeleteForm form) throws DemoException {
		return heroService.delete(form);
	}

}