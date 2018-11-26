package com.liyuan.demo.vo.hero;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class HeroVo implements Serializable {

	@ApiModelProperty(value = "", required = true)
	private Integer id;

	@ApiModelProperty(value = "")
	private Integer type;

	@ApiModelProperty(value = "")
	private String name;

	@ApiModelProperty(value = "")
	private Date createtime;

	@ApiModelProperty(value = "")
	private String describe;

	@ApiModelProperty(value = "")
	private String skill;

}