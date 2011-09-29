package com.infoarmy.task.two;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class FeedParserTest
{

    @Test
    public void verifyFeedParser()
    {
        FeedParser feedParser = new FeedParser();

        try
        {
            List<Feed> feeds = feedParser.parse(new File(
                    "src/test/resources/tasktwo-inputfile.txt"));
            
            Iterator<Feed> iterator = feeds.iterator();
            
            Feed f1 = iterator.next();
            Assert.assertEquals(3338, f1.getFeedId());
            System.out.println("Feed id: " + f1.getFeedId());
            
            Feed f2 = iterator.next();
            Assert.assertEquals(5338, f2.getFeedId());
            System.out.println("Feed id: " + f2.getFeedId());
            
            Feed f3 = iterator.next();
            Assert.assertEquals(6338, f3.getFeedId());
            System.out.println("Feed id: " + f3.getFeedId());
            
            
            Assert.assertEquals(20, feedParser.getAverageProcessingTime());
            System.out.println("Average Processing Time: " + feedParser.getAverageProcessingTime());
            
            Assert.assertEquals(30, feedParser.getMaxProcessingTIme());
            System.out.println("Maximum Processing Time: " + feedParser.getMaxProcessingTIme());

            System.out.println("Last Feed id: " + f3.getFeedId());
            
        } catch (IOException e)
        {
            Assert.fail(e.getMessage());
        }
    }

}
