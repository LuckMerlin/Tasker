package com.merlin.task;

public abstract class FileTask<T> extends AbsTask<T> {
    public interface Cover{
        int REPLACE=2001;
        int KEEP_ALL=2002;
        int SKIP=2003;
    }

}
