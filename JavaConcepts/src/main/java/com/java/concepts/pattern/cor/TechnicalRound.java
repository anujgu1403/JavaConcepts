package com.java.concepts.pattern.cor;

public class TechnicalRound extends Round {

    @Override
    public boolean hire(Candidate candidate) {

        int score = 85;

        if (score > 80 && _next != null) {
            System.out.println("Technical round cleared.");
            return _next.hire(candidate);
        } else
            return false;
    }
}
