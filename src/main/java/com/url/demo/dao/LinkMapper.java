package com.url.demo.dao;


import com.url.demo.domain.Link;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkMapper {

        Link selectByPrimaryKey(Integer id);

        int insert(Link link);

        Link findByLongUrl(String longUrl);

        String findByShortUrl(String shortUrl);

    }
