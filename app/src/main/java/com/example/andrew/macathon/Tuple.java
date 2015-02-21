package com.example.andrew.macathon;

import java.sql.Time;

/**
 * Created by Asra Nizami on 2/20/2015.
 */
public class Tuple {
    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    private Time startTime;

    public Time getEndTime() {
        return endTime;
    }

    public Time getStartTime() {
        return startTime;
    }

    private Time endTime;

    public Tuple(Time startTime, Time endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }


}
