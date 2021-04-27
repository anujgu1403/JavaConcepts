package com.java.design.pattern.cor;

public class ConductInterview {
    public static void main(String[] args) {
        Candidate candidate = new Candidate("Anuj");
        var interviewPanel = new InterviewPanel();
        if(interviewPanel.hire(candidate)){
            System.out.println("You are HIRED "+candidate.getName());
        }else {
            System.out.println("Better luck next time "+candidate.getName());
        }

        Round a = new Round() {
            @Override
            public boolean hire(Candidate candidate) {
                return true;
            }
        };
        System.out.println(a.hire(candidate)+" ******");
    }
}
