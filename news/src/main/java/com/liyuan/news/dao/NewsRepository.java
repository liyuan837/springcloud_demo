package com.liyuan.news.dao;

import com.liyuan.news.domain.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:LiYuan
 * @description:
 * @Date:Create in 9:16 2018/2/7
 * @Modified By:
 */
@Repository
public interface NewsRepository extends JpaRepository<News,Integer>{

    Page<News> findAll(Pageable pageable);
}
