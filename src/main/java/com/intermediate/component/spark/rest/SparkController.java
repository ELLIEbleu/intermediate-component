package com.intermediate.component.spark.rest;

import com.alibaba.fastjson.JSONObject;
import com.intermediate.component.spark.dto.WordCount;
import com.intermediate.component.spark.service.SparkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SparkController {

    @Autowired
    private SparkService sparkService;

    @GetMapping("/wordCount")
    public String wordCount() {
        List<WordCount> list = sparkService.doWordCount();
        return JSONObject.toJSONString(list);
    }
}
