package oop2_project;

import java.util.ArrayList;
import java.util.List;

public class OverallReport implements Report
{
    private final int overallTotal;
    private final List <Report> allReports;

    public OverallReport()
    {
        this.overallTotal = 71;
        this.allReports = new ArrayList<>(4);
    }

    public void addReport(Report r)
    {
        allReports.add(r);
    }

    public void removeReport(Report r)
    {
        allReports.remove(r);
        // System.out.println(allReports.size());
    }

    public int getAcquiredMark()
    {
        int acquired = 0;
        for(Report r : allReports)
        {
            int reportMark = r.getAcquiredMark();
            acquired += reportMark;
            System.out.println(reportMark);
        }

        return acquired+5;
    }
    
    
    public String recommendationsToString()
    {
        String recommended = "";

        for(Report r : allReports)
        {
            recommended = recommended + r.recommendationsToString() + "\n";
        }

        return recommended;
    }

    public int getTotalMark()
    {
        return this.overallTotal;
    }

}
