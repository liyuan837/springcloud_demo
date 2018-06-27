package com.liyuan.demo.form.hero;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class HeroDeleteForm implements Serializable {

	@ApiModelProperty(value = "", required = true)
	@NotNull(message = "不能为空")
	private Integer id;

}