package com.merlin.task;

public class FromTo<F,T> {
    private final F mFrom;
    private final T mTo;

    public FromTo(F from,T to){
        mFrom=from;
        mTo=to;
    }

    public final F getFrom() {
        return mFrom;
    }

    public final T getTo() {
        return mTo;
    }
}
