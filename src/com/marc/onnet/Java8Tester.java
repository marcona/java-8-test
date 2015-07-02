package com.marc.onnet;
import com.marc.onnet.xml.MarcoParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import javax.xml.stream.XMLStreamException;
/**
 * Created by marcona on 06/06/15.
 */
public class Java8Tester {

    public WorkLogs loadFile(){
        WorkLogs workLogs = null;
        try {
            workLogs
                  = MarcoParser.parse().from(new File("/home/marcona/dev/java/perso/java-8-test/src/jira.bi-sam.com_AMA_JUIN.xml"));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (XMLStreamException e) {
            e.printStackTrace();
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return workLogs;
    }
}
