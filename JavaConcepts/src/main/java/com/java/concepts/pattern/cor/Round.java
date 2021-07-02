package com.java.concepts.pattern.cor;

public abstract class Round {
    protected Round _next;
    public abstract boolean hire(Candidate candidate);
    public void setNextRound(Round next){
        this._next=next;
    }
}
