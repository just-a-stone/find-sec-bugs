package com.h3xstream.findsecbugs.mybatis;

import com.h3xstream.findbugs.test.BaseDetectorTest;
import com.h3xstream.findbugs.test.EasyBugReporter;
import org.testng.annotations.Test;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class MybatisPlusTypeConversionDetectorTest extends BaseDetectorTest {


    @Test
    public void detectPermissiveCORS() throws Exception {
        //Locate test code
        String[] files = {
                getClassFilePath("testcode/mybatis/service/UserService")
        };

        //Run the analysis
        EasyBugReporter reporter = spy(new SecurityReporter());
        analyze(files, reporter);

    }
}
