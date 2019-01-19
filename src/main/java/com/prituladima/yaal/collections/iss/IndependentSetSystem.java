package com.prituladima.yaal.collections.iss;

/**
 *  */
public interface IndependentSetSystem {
    public boolean join(int first, int second);

    public int get(int index);

    public int getSetCount();

    public void setListener(Listener listener);

    public static interface Listener {
        public void joined(int joinedRoot, int root);
    }
}
