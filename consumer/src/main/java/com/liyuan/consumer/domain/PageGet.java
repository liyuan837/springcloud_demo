package com.liyuan.consumer.domain;

/**
 * @Author:LiYuan
 * @description:
 * @Date:Create in 9:39 2018/2/7
 * @Modified By:
 */
public class PageGet {
    private Integer page;
    private Integer count;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
