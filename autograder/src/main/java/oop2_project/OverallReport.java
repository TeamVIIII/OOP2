package oop2_project;

import java.util.ArrayList;
import java.util.List;
public class OverallReport implements Report
{
    private final int overallTotal;
    private final List <Report> allReports;
    private final List<String> reportNames;
    boolean compiled;

    public Report getReport(int i){
        return allReports.get(i);
    }
    public String getRecommendationByReport(int i){
        String recommended = "";
        recommended = allReports.get(i).recommendationsToString()+"\n";
        return recommended;
    }

    public int getNumReports(){
        return allReports.size();
    }

    public String getReportName(int i){
        return reportNames.get(i);
    }

    public OverallReport()
    {
        this.overallTotal = 71;
        this.allReports = new ArrayList<>(4);
        this.reportNames = new ArrayList<>(4);
        reportNames.add("Passenger");
        reportNames.add("LuggageSlip");
        reportNames.add("LuggageManifest");
        reportNames.add("Flight");
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

    public int getAcquiredMarkbyReport(int x)
    {
        int mark = 0;

        if(x>=0 && x<=3)
        {
            Report r = allReports.get(x);
            return r.getAcquiredMark();
             
        }

        return mark;
    }

    public int getTotalMarkbyReport(int x)
    {
        int mark = 0;

        if(x>=0 && x<=3)
        {
            Report r = allReports.get(x);
            return r.getTotalMark();
             
        }
        return mark;
    }

}
