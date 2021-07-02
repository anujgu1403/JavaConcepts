package com.java.concepts.pattern.cor;

public class ManagerRound extends Round {
    @Override
    public boolean hire(Candidate candidate) {
        int score = 75;
        if (score > 70 && _next != null) {
            System.out.println("Manager round cleared.");
            return _next.hire(candidate);
        } else
            return false;
    }
}
