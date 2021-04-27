package com.java.design.pattern.cor;

public class HrRound extends Round {
    @Override
    public boolean hire(Candidate candidate) {
        int score = 65;
        if (score > 60) {
            System.out.println("HR round cleared.");
            return true;
        } else
            return false;
    }
}
