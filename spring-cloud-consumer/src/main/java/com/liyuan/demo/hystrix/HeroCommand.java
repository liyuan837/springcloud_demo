package com.liyuan.demo.hystrix;

import com.liyuan.demo.domain.po.hero.HeroPo;
import com.liyuan.demo.domain.response.ResponseEntity;
import com.liyuan.demo.vo.hero.HeroVo;
import com.netflix.hystrix.HystrixCommand;
import org.springframework.web.client.RestTemplate;

/**
 * @Author:LiYuan
 * @description:自定义熔断器
 * @Date:Create in 9:47 2018/3/2
 * @Modified By:
 */
public class HeroCommand extends HystrixCommand<ResponseEntity<HeroVo>> {
    private RestTemplate restTemplate;

    private HeroPo heroPo;

    private String serverPath = "http://SPRING-CLOUD-PROVIDER/hero/";

    /**
     * 构造方法的第一个参数是保存一些分组信息，后面参数不限，主要用来传递请求参数等信息
     */
    public HeroCommand(Setter setter, RestTemplate restTemplate, HeroPo heroPo) {
        super(setter);
        this.restTemplate = restTemplate;
        this.heroPo = heroPo;
    }

    /**
     * 系统在运行时会根据getCacheKey方法的返回值来判断这个请求是否和之前执行过的请求一样
     * @return
     */
    @Override
    protected String getCacheKey() {
        return String.valueOf(heroPo.getId());
    }

    /**
     * run方法实质性请求时调用
     * @return
     * @throws Exception
     */
    @Override
    protected ResponseEntity<HeroVo> run() throws Exception {
        return restTemplate.getForEntity(serverPath + "query?id={id}",ResponseEntity.class,heroPo.getId()).getBody();
    }

    /**
     * getFallback方法将在服务调用失败是回调
     * @return
     */
    @Override
    protected ResponseEntity<HeroVo> getFallback(){
        return new ResponseEntity<HeroVo>();
    }
}
