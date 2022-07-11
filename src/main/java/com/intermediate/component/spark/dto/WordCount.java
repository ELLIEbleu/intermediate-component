package com.intermediate.component.spark.dto;

import java.io.Serializable;

public class WordCount implements Serializable {
    private String word;
    private Integer count;

    public WordCount(String word, Integer count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public Integer getCount() {
        return count;
    }
}
