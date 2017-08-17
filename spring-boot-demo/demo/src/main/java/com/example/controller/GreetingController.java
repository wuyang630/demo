package com.example.controller;

import com.example.dao.Greeting;
import com.example.dao.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Created by wuyang on 2017/7/5.
 */
@Controller
public class GreetingController {

    @MessageMapping("/helloWS")
    @SendTo("/out/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000);
        return new Greeting("Hello, " + message.getName() + "|");
    }
}
