package com.liyuan.consumerfeign.domain;

import java.util.List;

/**
 * @Author:LiYuan
 * @description:
 * @Date:Create in 9:55 2018/2/7
 * @Modified By:
 */
public class PageResult<T> {
    private List<T> content;
    private Integer totalPages;

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }
}
