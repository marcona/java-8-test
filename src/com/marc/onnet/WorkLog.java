package com.marc.onnet;

import java.util.Date;
public class WorkLog {
    private String work_description;
    private String username;
    private Date work_date;
    private double hours;
    private String activity_name;


    public String getActivity_name() {
        return activity_name;
    }


    public void setActivity_name(String activity_name) {
        this.activity_name = activity_name;
    }


    public double getHours() {
        return hours;
    }


    public void setHours(double hours) {
        this.hours = hours;
    }


    public Date getWork_date() {
        return work_date;
    }


    public void setWork_date(Date work_date) {
        this.work_date = work_date;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getWork_description() {
        return work_description;
    }


    public void setWork_description(String work_description) {
        this.work_description = work_description;
    }


    @Override
    public String toString() {
        return "WorkLog{" +
               "work_description='" + work_description + '\'' +
               ", username='" + username + '\'' +
               ", work_date=" + work_date +
               ", hours=" + hours +
               ", activity_name='" + activity_name + '\'' +
               '}';
    }
}

