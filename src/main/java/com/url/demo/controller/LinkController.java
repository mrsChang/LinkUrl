package com.url.demo.controller;

import com.url.demo.domain.Link;
import com.url.demo.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LinkController {

    @Autowired
    private LinkService linkService;

    /**
     * 生成短链接
     * @param url
     * @return Caron
     */
    @RequestMapping("/api")
    @ResponseBody
    public Object save(String url){

        if (url == null || "".equals(url)){
            return null;
        }
        if(url.startsWith("http://") || url.startsWith("https://")){
            Link link = new Link();
            link.setLongUrl(url);
            return  linkService.save(link);
        }else{
            return "网址必须以http或https开头";
        }
    }

    /**
     * 301跳转
     * @param url
     * @return
     */
    @RequestMapping("/{url}")
    public String restoreUrl(@PathVariable("url") String url){

        String restoreUrl = linkService.restoreUrl("http://cni.tips/"+url);

        if(restoreUrl != null && !"".equals(restoreUrl)){
            return "redirect:"+restoreUrl;
        }else{
            return "redirect:http://www.cnilink.com";
//            return  "forward:/404.html";    //如果要访问本地html，@RequestMapping("/{url}")前面必须加一层路径/aa/{url}
        }
     }



}
