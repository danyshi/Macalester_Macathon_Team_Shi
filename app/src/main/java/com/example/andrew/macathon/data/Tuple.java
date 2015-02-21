package com.example.andrew.macathon.data;

/**
 * Created by Asra Nizami on 2/20/2015.
 */
public class Tuple {

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    private int startTime;

    public int getEndTime() {
        return endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    private int endTime;

    public Tuple(int startTime, int endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }

}
