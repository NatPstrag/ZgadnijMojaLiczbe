package com.example.zgadnijmojaliczbe;

public class Score  implements Comparable<Score> {
    private String id;
    private int tries;
    private int time;

    public Score(String id, int tries, int time) {
        this.id = id;
        this.tries = tries;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTries() {
        return tries;
    }

    public void setTries(int tries) {
        this.tries = tries;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public int compareTo(Score o) {
        int compareage = ((Score)o).getTries();
        return compareage - this.tries;

    }

    @Override
    public String toString() {
        return "Score{" +
                "id='" + id + '\'' +
                ", tries=" + tries +
                ", time=" + time +
                '}';
    }
}
