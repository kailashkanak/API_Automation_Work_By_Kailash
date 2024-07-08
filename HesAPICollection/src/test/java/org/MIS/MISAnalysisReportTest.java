package org.MIS;

import org.Meterinfo.MISAnalysisReport;
import org.testng.annotations.Test;

public class MISAnalysisReportTest {
    @Test
    public void misAnalysisReportTest()
    {
        MISAnalysisReport misAnalysisReport = new MISAnalysisReport();

        misAnalysisReport.getMIS();
    }
}
