package com.schmij03.sw8.playground.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;
import com.schmij03.sw8.playground.model.SentimentAnalyzer;

@RestController
public class ServiceController {

    private SentimentAnalyzer analysis = new SentimentAnalyzer();

    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index.html");
    }

    @GetMapping("/ping")
    public String ping() {
        return "Sentiment app is up and running!";
    }

    @GetMapping("/sentiment")
    public String predict(@RequestParam(name = "text", required = true) String text) throws Exception {
        var result = analysis.predict(text);
        return result.toJson();
    }

}
