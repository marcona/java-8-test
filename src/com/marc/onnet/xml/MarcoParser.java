package com.marc.onnet.xml;
import com.marc.onnet.WorkLog;
import com.marc.onnet.WorkLogs;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class MarcoParser {

    public MarcoParser() {

    }


    public static void main(String[] args) throws FileNotFoundException,
                                                  XMLStreamException {

        if (args.length != 1) {
            throw new RuntimeException("The name of the XML file is required!");
        }

    }


    public static MarcoParser parse() {
        return new MarcoParser();
    }


    public WorkLogs from(File file) throws FileNotFoundException, XMLStreamException, ParseException {
        List<WorkLog> employees = null;
        String text = null;
        WorkLog workLog = null;

        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(
              file));

        while (reader.hasNext()) {
            int event = reader.next();

            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                {
                    if ("worklog".equals(reader.getLocalName())) {
                        workLog = new WorkLog();
                        //workLog.setID(reader.getAttributeValue(0));
                    }
                    if ("worklogs".equals(reader.getLocalName())) {
                        employees = new ArrayList<>();
                    }

                    break;
                }
                case XMLStreamConstants.CHARACTERS: {
                    text = reader.getText().trim();
                    break;
                }
                case XMLStreamConstants.END_ELEMENT: {
                    switch (reader.getLocalName()) {
                        case "worklog": {
                            employees.add(workLog);
                            break;
                        }
                        case "hours": {
                            workLog.setHours(Double.parseDouble(text));
                            break;
                        }
                        case "username": {
                            workLog.setUsername(text);
                            break;
                        }
                        case "activity_name": {
                            workLog.setActivity_name(text);
                            break;
                        }
                        case "work_date": {
                            workLog.setWork_date(new SimpleDateFormat("yyyy-MM-dd").parse(text));
                            break;
                        }
                        case "work_description": {
                            workLog.setWork_description(text);
                            break;
                        }
                    }
                    break;
                }
            }
        }

        // Print all employees.
        if (employees != null) {
            for (WorkLog employee : employees) {
                System.out.println(employee.toString());
            }
        }
        WorkLogs workLogs = new WorkLogs(employees);
        return workLogs;
    }
}


