package com.liyuan.demo.controller;

import com.liyuan.demo.domain.condition.hero.HeroCondition;
import com.liyuan.demo.domain.exception.DemoException;
import com.liyuan.demo.domain.response.PageListResponse;
import com.liyuan.demo.domain.response.ResponseEntity;
import com.liyuan.demo.form.hero.HeroCreateForm;
import com.liyuan.demo.form.hero.HeroDeleteForm;
import com.liyuan.demo.form.hero.HeroQueryForm;
import com.liyuan.demo.form.hero.HeroUpdateForm;
import com.liyuan.demo.util.CopyUtil;
import com.liyuan.demo.vo.hero.HeroVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

/**
 * RestTemplate + spring-cloud-ribbon实现服务消费者
 */
@RestController
@RequestMapping("/demo/hero")
@Api(value = "/demo/hero", description = "")
public class HeroController extends BaseController {

	private String serverPath = "http://SPRING-CLOUD-PROVIDER/hero/";

	@Autowired
	private RestTemplate restTemplate;

	@ApiOperation(value = "查询",notes = "根据ID查询",httpMethod = "GET")
	@GetMapping(value = "/query")
	public ResponseEntity<HeroVo> query(@ApiParam(value = "", required = true)@RequestParam Integer id) throws DemoException {
		ResponseEntity<HeroVo> response = restTemplate.getForEntity(serverPath + "query?id={id}",ResponseEntity.class,id).getBody();
		return response;
	}

	@ApiOperation(value = "查询数量",notes = "查询数量",httpMethod = "POST")
	@PostMapping(value = "/queryCount")
	public ResponseEntity<Integer> queryCount(@RequestBody@Valid HeroQueryForm form) throws DemoException {
		ResponseEntity<Integer> response = restTemplate.postForEntity(serverPath + "queryCount",form,ResponseEntity.class).getBody();
		return response;
	}

	@ApiOperation(value = "查询列表",notes = "查询列表",httpMethod = "POST")
	@PostMapping(value = "/queryList")
	public ResponseEntity<PageListResponse<HeroVo>> queryList(@RequestBody@Valid HeroQueryForm form) throws DemoException {
		ResponseEntity<PageListResponse<HeroVo>> response = restTemplate.postForEntity(serverPath + "queryList",form,ResponseEntity.class).getBody();
		return response;
	}

	@ApiOperation(value = "查询列表(带分页)",notes = "查询列表(带分页)",httpMethod = "POST")
	@PostMapping(value = "/queryPageList")
	public ResponseEntity<PageListResponse<HeroVo>> queryPageList(@RequestBody@Valid HeroQueryForm form) throws DemoException {
		ResponseEntity<PageListResponse<HeroVo>> response = restTemplate.postForEntity(serverPath + "queryPageList",form,ResponseEntity.class).getBody();
		return response;
	}

	@ApiOperation(value = "新增",notes = "新增",httpMethod = "POST")
	@PostMapping(value = "/add")
	public ResponseEntity<HeroVo> add(@RequestBody@Valid HeroCreateForm form) throws DemoException {
		ResponseEntity<HeroVo> response = restTemplate.postForEntity(serverPath + "add",form,ResponseEntity.class).getBody();
		return response;
	}

	@ApiOperation(value = "修改",notes = "修改",httpMethod = "POST")
	@PostMapping(value = "/update")
	public ResponseEntity update(@RequestBody@Valid HeroUpdateForm form) throws DemoException {
		ResponseEntity<HeroVo> response = restTemplate.postForEntity(serverPath + "update",form,ResponseEntity.class).getBody();
		return response;
	}

	@ApiOperation(value = "删除",notes = "删除",httpMethod = "POST")
	@PostMapping(value = "/delete")
	public ResponseEntity delete(@RequestBody@Valid HeroDeleteForm form) throws DemoException {
		ResponseEntity response = restTemplate.postForEntity(serverPath + "delete",form,ResponseEntity.class).getBody();
		return response;
	}

}