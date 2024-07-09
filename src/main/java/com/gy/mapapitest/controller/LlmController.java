package com.gy.mapapitest.controller;

import com.gy.mapapitest.entity.ExtractContent;
import com.gy.mapapitest.entity.NvidiaApiService;
import okhttp3.Response;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Service
@RestController
@RequestMapping("/llvm")
public class LlmController {

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/query")
    public String query(@RequestParam("query") String query) throws IOException {
        Response response = NvidiaApiService.query(query);
        return ExtractContent.extract(response.body().string());
    }
}
