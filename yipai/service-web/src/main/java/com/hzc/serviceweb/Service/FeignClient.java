package com.hzc.serviceweb.Service;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.cloud.openfeign.FeignClient(value = "service-user")
public interface FeignClient {
    @RequestMapping("/home/tt")
    String get();

    @RequestMapping("/home/ts")
    String ts(@RequestParam("name") String name);

}
