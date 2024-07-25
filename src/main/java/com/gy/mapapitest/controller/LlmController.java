package com.gy.mapapitest.controller;

import com.gy.mapapitest.entity.User;
import com.gy.mapapitest.service.ExtractContent;
import com.gy.mapapitest.service.NvidiaApiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import okhttp3.Response;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Api(tags = "llvm 的 API")
@RestController
@RequestMapping("/llvm")
public class LlmController {

    @ApiOperation("发送请求")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/query")
    public String query(@RequestParam("query") String query) throws IOException {
        Response response = NvidiaApiService.query(query);
        return ExtractContent.extract(response.body().string());
    }

    @ApiOperation("用户登录")
    @PostMapping("/user")
    public String user(@RequestBody User user) {
        System.out.println(user.toString());
        return "hello";
    }
}
