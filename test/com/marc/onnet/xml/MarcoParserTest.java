package com.marc.onnet.xml;
import com.marc.onnet.WorkLogs;
import java.io.File;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * Created by marcona on 06/06/15.
 */
public class MarcoParserTest {

    @Test
    public void test_parse() throws Exception {
        File file = new File("/home/marcona/dev/java/perso/java-8-test/src/jira.bi-sam.com_AMA_JUIN.xml");

        WorkLogs tradeData = MarcoParser.parse().from(file);
        assertThat(tradeData.getWorkLogs().size(), is(3));
    }
}
