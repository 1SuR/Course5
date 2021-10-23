package com.example.course5.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Hello")
public class HelloApi {
    @RequestMapping(value = "/say1/{name}",method =RequestMethod.GET)
    public String sayName1(@PathVariable String name) {

        return "你的名字是"+name;
    }
    @GetMapping("/say2/{name}")
    public String sayName2(@PathVariable String name) {

        return "你的名字"+name;
    }


}