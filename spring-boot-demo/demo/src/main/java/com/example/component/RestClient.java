package com.example.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

/**
 * Created by wuyang on 2017/4/11.
 */
@Component
public class RestClient {
    private RestTemplate restTemplate;
    private final static String bdurl = "http://www.baidu.com/s?wd={kw}";
    private final static String tburl = "https://s.taobao.com/search?q={kw}";
    private final static String jdurl = "http://search.jd.com/Search?enc=utf-8&wq={kw}&keyword={kw}";
    private final static String httpprefix = "http://{url}";
    private final static String httpsprefix = "https://{url}";

    @Autowired
    public RestClient(RestTemplateBuilder restTemplateBuilder) {
//    public RestClient() {
        this.restTemplate = restTemplateBuilder
                .requestFactory(new SimpleClientHttpRequestFactory())
                .setConnectTimeout(1000)
                .setReadTimeout(1000)
                .build();
//        this.restTemplate = new RestTemplate(new SimpleClientHttpRequestFactory());
    }

    public String bdsearch(String kw) {
        return  restTemplate.getForObject(bdurl , String.class , kw);
    }

    public String tbsearch(String kw) {
        return  restTemplate.getForObject(tburl , String.class , kw);
    }

    public String jdsearch(String kw) {
        return  restTemplate.getForObject(jdurl , String.class , kw,kw);
    }

    private String wrapperOpen(String url) {

        ResponseEntity<String> entity = restTemplate.getForEntity(httpprefix, String.class, url);
        System.out.println(entity);
        if (entity.getStatusCode().equals(HttpStatus.OK)) {
            return entity.getBody();
        } else {
            HttpStatus statusCode = entity.getStatusCode();
            if (statusCode.equals(HttpStatus.PERMANENT_REDIRECT)
                    || statusCode.equals(HttpStatus.MOVED_PERMANENTLY)
                    || statusCode.equals(HttpStatus.FOUND)
                    || statusCode == HttpStatus.TEMPORARY_REDIRECT ) {
                Logger.getGlobal().info(entity.getHeaders().getLocation().getPath());
                return restTemplate.getForObject(entity.getHeaders().getLocation(),String.class);
            }
            return restTemplate.getForObject(httpsprefix,String.class,url);
        }
    }

    public String open(String url) {
        String string = wrapperOpen(url);
        return StringUtils.replace(StringUtils.replace(string,"淘宝","五羊")
                ,"猫","狗");
    }
}
