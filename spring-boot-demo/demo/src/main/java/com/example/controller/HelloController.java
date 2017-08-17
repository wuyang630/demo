package com.example.controller;

import com.example.component.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wuyang on 2017/4/7.
 */

@Controller
public class HelloController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @Autowired
    private RestClient client ;
    @RequestMapping("/tbs={keyword}")
    @ResponseBody
    public String tbsearch(@PathVariable String keyword) {
        return client.tbsearch(keyword);
    }

    @RequestMapping("/bds={keyword}")
    @ResponseBody
    public String bdsearch(@PathVariable String keyword) {
        return client.bdsearch(keyword);
    }

    @RequestMapping("/jds={keyword}")
    @ResponseBody
    public String jdsearch(@PathVariable String keyword) {
        return client.jdsearch(keyword);
    }

    @RequestMapping("/any={url:.+}")
    @ResponseBody
    public String open(@PathVariable String url) {
        System.out.println(url);
        return client.open(url);
    }
}
