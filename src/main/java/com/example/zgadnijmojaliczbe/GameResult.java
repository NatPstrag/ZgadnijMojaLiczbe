package com.example.zgadnijmojaliczbe;

public class GameResult{
    private final String id;
    private int tries = 0;
    private String result;
    private final long startTime;
    private int totalTime;

    public GameResult(String id, String result, int totalTime) {
        this.id = id;
        this.result = result;
        this.totalTime=0;
        this.startTime=System.nanoTime();
    }

    public long getStartTime() {
        return startTime;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public void incrementCounter() {
        tries++;
    }

    public int getTries() {
        return tries;
    }

    public void setTries(int tries) {
        this.tries = tries;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getId() {
        return id;
    }


}