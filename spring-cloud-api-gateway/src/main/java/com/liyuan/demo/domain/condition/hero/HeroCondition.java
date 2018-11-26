package com.liyuan.demo.domain.condition.hero;

import java.io.Serializable;
import java.util.List;
import com.liyuan.demo.domain.condition.BaseCondition;
import lombok.Data;

@Data
public class HeroCondition extends BaseCondition implements Serializable {

	/**
	 * 
	*/
	private Integer id;
	/**
	 * 列表
	*/
	private List<Integer> idList;
	/**
	 * 
	*/
	private Integer type;
	/**
	 * 
	*/
	private String name;
	/**
	 * 
	*/
	private String describe;
	/**
	 * 
	*/
	private String skill;
}