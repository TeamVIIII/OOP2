package oop2_project;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Result;

import static org.junit.Assert.*;

import java.util.List;

public class testOverallReport {

    private OverallReport overallReport;
    private Report passengerReport;
    private Report luggageSlipReport;
    private Report luggageManifestReport;
    private Report flightReport;

    @Before
    public void setUp() 
    {
        RunTest executer = new RunAllTests();
        Copier copier = new CopyAll();
        Compiler compiler = new Compiler();
        String failing = "testData/PerfectSubmission";

        copier.copyAll(failing);
        compiler.compileTest();
        List <Result> results = executer.runAll();
        overallReport = new OverallReport();

        passengerReport = new PassengerReport(results.get(0));
        luggageSlipReport = new LuggageSlipReport(results.get(1)); 
        luggageManifestReport = new LuggageManifestReport(results.get(2)); 
        flightReport = new FlightReport(results.get(3)); 
    }

    @Test
    public void testAddReport() {
        overallReport.addReport(passengerReport);
        overallReport.addReport(luggageSlipReport);
        overallReport.addReport(luggageManifestReport);
        overallReport.addReport(flightReport);

        assertEquals(4, overallReport.getNumReports());
    }

    @Test
    public void testRemoveReport() {
        overallReport.addReport(passengerReport);
        overallReport.addReport(luggageSlipReport);
        overallReport.removeReport(passengerReport);

        assertEquals(1, overallReport.getNumReports());
    }

    @Test
    public void testGetTotalMark() 
    {
        assertEquals(71, overallReport.getTotalMark());
    }

    @Test
    public void testGetTotalMarkbyReport()
    {
        overallReport.addReport(passengerReport);
        overallReport.addReport(luggageSlipReport);
        overallReport.addReport(luggageManifestReport);
        overallReport.addReport(flightReport);

        assertEquals(16, overallReport.getTotalMarkbyReport(0));
        assertEquals(14, overallReport.getTotalMarkbyReport(1));
        assertEquals(20, overallReport.getTotalMarkbyReport(2));
        assertEquals(16, overallReport.getTotalMarkbyReport(3));
    }

    @Test
    public void testGetAcquiredMarkbyReport()
    {
        overallReport.addReport(passengerReport);
        overallReport.addReport(luggageSlipReport);
        overallReport.addReport(luggageManifestReport);
        overallReport.addReport(flightReport);

        assertEquals(16, overallReport.getAcquiredMarkbyReport(0));
        assertEquals(14, overallReport.getAcquiredMarkbyReport(1));
        assertEquals(20, overallReport.getAcquiredMarkbyReport(2));
        assertEquals(16, overallReport.getAcquiredMarkbyReport(3));
    }

    @Test
    public void testGetAcquiredMark()
    {
        overallReport.addReport(passengerReport);
        overallReport.addReport(luggageSlipReport);
        overallReport.addReport(luggageManifestReport);
        overallReport.addReport(flightReport);

        assertEquals(71, overallReport.getAcquiredMark());
    }

    @Test
    public void testGetReportName()
    {
        overallReport.addReport(passengerReport);
        overallReport.addReport(luggageSlipReport);
        overallReport.addReport(luggageManifestReport);
        overallReport.addReport(flightReport);

        assertEquals("Passenger", overallReport.getReportName(0));
        assertEquals("LuggageSlip", overallReport.getReportName(1));
        assertEquals("LuggageManifest", overallReport.getReportName(2));
        assertEquals("Flight", overallReport.getReportName(3));
    }

    @Test
    public void testGetRecommendationByReport()
    {
        overallReport.addReport(passengerReport);
        overallReport.addReport(luggageSlipReport);
        overallReport.addReport(luggageManifestReport);
        overallReport.addReport(flightReport);

        String expected = "\n";

        assertEquals(expected, overallReport.getRecommendationByReport(0));
        assertEquals(expected, overallReport.getRecommendationByReport(1));
        assertEquals(expected, overallReport.getRecommendationByReport(2));
        assertEquals(expected, overallReport.getRecommendationByReport(3));
    }
}
