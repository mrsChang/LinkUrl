package com.url.demo.service;

import com.url.demo.domain.Link;

public interface LinkService {

    String save(Link link);

    String restoreUrl(String url);
}
