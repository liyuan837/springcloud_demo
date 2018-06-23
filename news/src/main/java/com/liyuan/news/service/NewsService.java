package com.liyuan.news.service;

import com.liyuan.news.dao.NewsRepository;
import com.liyuan.news.domain.News;
import com.liyuan.news.domain.PageGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author:LiYuan
 * @description:
 * @Date:Create in 9:22 2018/2/7
 * @Modified By:
 */
@Service
@Transactional
public class NewsService {
    @Autowired
    private NewsRepository newsRepository;

    public Page<News> findAll(PageGet pageGet) {
        Sort sort = new Sort(Sort.Direction.DESC, "publishtime");
        Pageable pageable = new PageRequest(pageGet.getPage(), pageGet.getCount(), sort);
        return newsRepository.findAll(pageable);
    }

    public News save(News news) {
        return newsRepository.save(news);
    }

    public News find(Integer id) {
        return newsRepository.findOne(id);
    }
}
