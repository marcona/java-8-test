package com.marc.onnet;
import java.util.Date;
/**
 * Created by marcona on 02/07/15.
 */
public class DayReportLog {
    private Date workDate;
    private Double timeOffHours=0.;
    private Double timeOfWork=0.;


    public Double getTimeOffHours() {
        return timeOffHours;
    }


    public void setTimeOffHours(Double timeOffHours) {
        this.timeOffHours = timeOffHours;
    }


    public Date getWorkDate() {
        return workDate;
    }


    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }


    public Double getTimeOfWork() {
        return timeOfWork;
    }


    public void setTimeOfWork(Double timeOfWork) {
        this.timeOfWork = timeOfWork;
    }
}
