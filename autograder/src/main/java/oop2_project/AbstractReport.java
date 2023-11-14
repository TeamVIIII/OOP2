package oop2_project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public abstract class AbstractReport implements Report 
{
    protected Map<String, Integer> markPerTest;
    protected Map<String, String> recommendationPerTest;
    private int highestPossible = 0;
    private int acquiredMark = 0;
    private List<String> reportRecommendations = new ArrayList<>();

    public AbstractReport(Result r, int highestPossible)
    {
        markPerTest = new HashMap<>();
        recommendationPerTest = new HashMap<>();
        reportRecommendations = new ArrayList<>();
        
        setMarksPerTest();
        setRecommendationsPerTest();
        setHighestPossible(highestPossible);

        setAcquiredMark(highestPossible, r); 
        setRecommendations(r);

    }

    protected abstract void setMarksPerTest();
    protected abstract void setRecommendationsPerTest();

    private void setHighestPossible(int x)
    {
        this.highestPossible = x;
    }

    private void setAcquiredMark(int x, Result r)
    {
        this.acquiredMark = x;
        
        if(!r.wasSuccessful())
        {
            for (Failure f : r.getFailures()) 
            {
                String methodName = f.getDescription().getMethodName();
                if (markPerTest.containsKey(methodName)) 
                {
                    this.acquiredMark -= markPerTest.get(methodName);
                    reportRecommendations.add(recommendationPerTest.get(methodName));
                } 
            }
        }
    }

    private void setRecommendations(Result r)
    {
        if(!r.wasSuccessful())
        {
            for (Failure f : r.getFailures()) 
            {
                String methodName = f.getDescription().getMethodName();

                if (markPerTest.containsKey(methodName)) 
                    reportRecommendations.add(recommendationPerTest.get(methodName));
                
            }
        }
    }

    public int getTotalMark()
    {
        return this.highestPossible;
    }

    public int getAcquiredMark()
    {
        return this.acquiredMark;
    }

    public String recommendationsToString()
    {
        String message = "";

        for(String s : reportRecommendations)
        {
            message = message + s + "\n";
        }

        return message;
    }

}
