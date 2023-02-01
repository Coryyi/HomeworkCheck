package com.coryi.check.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Works {
    private String pic;
    private String content;
    private LocalDate publishTime;
    private List<String> pis = new ArrayList<>();

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(LocalDate publishTime) {
        this.publishTime = publishTime;
    }
}
