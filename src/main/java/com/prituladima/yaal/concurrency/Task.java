package com.prituladima.yaal.concurrency;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

/**
 *  */
public interface Task {
    public void read(InputReader in);

    public void solve();

    public void write(OutputWriter out, int testNumber);
}
