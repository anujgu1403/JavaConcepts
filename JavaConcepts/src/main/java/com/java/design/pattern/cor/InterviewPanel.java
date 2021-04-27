package com.java.design.pattern.cor;

public class InterviewPanel extends Round{
    private Round _firstRound;

    public InterviewPanel() {
        var technicalRound = new TechnicalRound();
        var managerRound = new ManagerRound();
        var hrRound = new HrRound();
        _firstRound = technicalRound;
        technicalRound.setNextRound(managerRound);
        managerRound.setNextRound(hrRound);
    }

    public boolean hire(Candidate candidate) {
        return _firstRound.hire(candidate);
    }
}
