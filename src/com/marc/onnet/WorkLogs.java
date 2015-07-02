package com.marc.onnet;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class WorkLogs {
    private List<WorkLog> workLogs;


    public WorkLogs(List<WorkLog> employees) {
        workLogs = employees;
    }


    public WorkLogs from(File file) {
        return this;
    }


    public List<WorkLog> getWorkLogs() {
        return workLogs;
    }


    void calculTotal() {
        System.out.println("----------------------------------------------");
        Stream<WorkLog> tradeStream = getWorkLogs().stream();

        Double total = tradeStream
              .filter(t -> isTimeOff(t))
              .mapToDouble(t -> t.getHours())
              .sum();
        tradeStream = getWorkLogs().stream();
        Double grandTotal = tradeStream
              .mapToDouble(t -> t.getHours())
              .sum();

        System.out.println("Grand total=" + grandTotal / 8 + " days");
        System.out.println("total Time OFF=" + total / 8 + " days");
    }


    private boolean isTimeOff(WorkLog t) {
        return t.getActivity_name().matches("Time Off");
    }


    void spool() {
        Stream<WorkLog> tradeStream = getWorkLogs().stream();
        tradeStream.forEach(System.out::print);
    }


    void spoolDays() {
        Map<Date, DayReportLog> calendar = new HashMap<>();

        Stream<WorkLog> tradeStream = getWorkLogs().stream();
        tradeStream.forEachOrdered(worklog -> {
            Date work_date = worklog.getWork_date();
            DayReportLog orDefault = calendar.getOrDefault(work_date, new DayReportLog());
            if (orDefault.getWorkDate() == null) {
                orDefault.setWorkDate(work_date);
            }
            if (isTimeOff(worklog)) {
                orDefault.setTimeOffHours(orDefault.getTimeOffHours() + worklog.getHours());
            }
            else {
                orDefault.setTimeOfWork(orDefault.getTimeOfWork() + worklog.getHours());
            }
            calendar.put(work_date,orDefault);
        });

        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.DAY_OF_MONTH, 1);
        instance.set(Calendar.YEAR, 2015);
        instance.set(Calendar.MONTH, Calendar.JUNE);
        instance.set(Calendar.HOUR, 12);
        instance.set(Calendar.MINUTE, 0);
        instance.set(Calendar.SECOND, 0);
        instance.set(Calendar.MILLISECOND, 0);

        int actualMaximum = instance.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println("----------------------------------------------");

        StringBuilder lineOne= new StringBuilder();
        StringBuilder lineTwo= new StringBuilder();
        StringBuilder lineThre= new StringBuilder();
        for (int i = 1; i < actualMaximum; i++) {
            Date date = instance.getTime();
            DayReportLog orDefault = calendar.getOrDefault(date, new DayReportLog());
            lineOne.append(new SimpleDateFormat("dd/MM/yyyy").format(date)).append("\t");
            lineTwo.append(orDefault.getTimeOfWork()).append("\t");
            lineThre.append(orDefault.getTimeOffHours()).append("\t");
            instance.add(Calendar.DAY_OF_MONTH, 1);
        }
        System.out.println( lineOne.toString());
        System.out.println( lineTwo.toString());
        System.out.println(lineThre.toString());
    }
}
