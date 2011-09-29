package com.infoarmy.task.two;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FeedParser
{
    int totalProcessingTime = 0;
    int maxProcessingTime = 0;
    
    /**
     * To maintain the order of the Feeds, in the insertion order.
     */
    List<Feed> feeds = new LinkedList<Feed>();
    
    public List<Feed> parse(File inputFile) throws IOException
    {
        FileInputStream fstream = new FileInputStream(inputFile);
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        Pattern pattern = Pattern.compile("^(.*):\\s(\\d+)(.*)$");
        String strLine;
        int currentFeedId = 0;
        while ((strLine = br.readLine()) != null)
        {
            Matcher matcher = pattern.matcher(strLine);
            
            if (matcher.matches() && strLine.contains("Feed id"))
            {
                currentFeedId = Integer.parseInt(matcher.group(2));
            }
            if (matcher.matches() && strLine.contains("ProcessingTimeTook"))
            {
                int processingTimeInMillis = Integer.parseInt(matcher.group(2));
                feeds.add(new Feed(currentFeedId, processingTimeInMillis));
                
                if (maxProcessingTime < processingTimeInMillis)
                {
                    maxProcessingTime = processingTimeInMillis;
                }
                totalProcessingTime  += processingTimeInMillis;
                
            }
        }

        return feeds;
    }

    public int getAverageProcessingTime()
    {
        return totalProcessingTime/feeds.size();
    }

    public int getMaxProcessingTIme()
    {
        return maxProcessingTime;
    }
}
