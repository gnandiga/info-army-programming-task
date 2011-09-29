package com.infoarmy.task.two;

public class Feed
{

    private final int feedId;
    private final int processingTimeInMillis;

    public Feed(int feedId, int processingTimeInMillis)
    {
        this.feedId = feedId;
        this.processingTimeInMillis = processingTimeInMillis;
    }

    public int getFeedId()
    {
        return feedId;
    }

    public int getProcessingTimeInMillis()
    {
        return processingTimeInMillis;
    }
}
