package com.gy.mapapitest;

import com.gy.mapapitest.entity.ExtractContent;
import com.gy.mapapitest.entity.NvidiaApiService;
import okhttp3.Response;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LlvmTest {
    @Test
    public void testGetLocation() {
        List<String> querys = new ArrayList<>();
        querys.add("介绍一下爱因斯坦");
        querys.add("比较一下朱自清的荷塘月色和朱自清的春");
        querys.add("今天天气真不错。今天是个大晴天。比较这两句话的相似度");
        querys.add("将今天是个大晴天翻译成英文");
        querys.stream().forEach(query->{
            try {
                Response ans = NvidiaApiService.query(query);
                String string = ans.body().string();
                System.out.println(ExtractContent.extract(string));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }


}
