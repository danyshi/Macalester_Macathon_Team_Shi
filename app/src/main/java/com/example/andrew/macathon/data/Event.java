package com.example.andrew.macathon.data;

/**
 * Created by Asra Nizami on 2/20/2015.
 */
public class Event {

    public Event(Integer startTime,Integer endTime, String title){
        this.startTime = startTime;
        this.endTime = endTime;
        this.title = title;
    }

    private Integer startTime, endTime;
    private String title;


    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }
}
