package com.langchain;

import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zhishi
 * @version 1.0
 * @date 2024/5/10 13:15
 */

@SpringBootApplication
//@ComponentScan(basePackages={"com.langchain"})
public class LangChain {

    public static void main(String[] args) {



        String apiKey = "demo";
        OpenAiChatModel model = OpenAiChatModel.withApiKey(apiKey);
        String answer = model.generate("使用韩语叫 '你好'");
        System.out.println(answer); // Hello World

        SpringApplication.run(LangChain.class, args); // 3



//        String apiKey = System.getenv("OPENAI_API_KEY");

//        String apiKey = "demo";
//
//        OpenAiChatModel model = OpenAiChatModel.withApiKey(apiKey);
//
//

//        String answer = model.generate("Say 'Hello World'");
//        System.out.println(answer); // Hello World



    }
}
