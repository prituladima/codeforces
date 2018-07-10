package com.prituladima.geeksforgeeks.geometric_algorithms.lines.sweep;

public class Segment {

    SPoint p;
    SPoint q;

    public Segment(SPoint p, SPoint q) {
        if(p.x == q.x){
            this.p = p;
            this.q = q;
        }else if(p.x > q.x){
            this.p = q;
            this.q = p;
            this.q.isLeft = true;
        }else {
            this.p = p;
            this.q = q;
            this.p.isLeft = true;
        }

        this.p.s = this;
        this.q.s = this;
    }


    public SPoint getP() {
        return p;
    }

    public SPoint getQ() {
        return q;
    }
}
