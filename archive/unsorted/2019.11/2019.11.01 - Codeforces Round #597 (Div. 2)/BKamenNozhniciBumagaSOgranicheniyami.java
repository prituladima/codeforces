package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class BKamenNozhniciBumagaSOgranicheniyami {
    private String yes = "YES", no = "NO";
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int a = in.nextInt(), b = in.nextInt(), c = in.nextInt();
            char[] s = in.nextToken().toCharArray();
            int ans = 0;
            char[] steps = new char[n];
            for(int i = 0; i < s.length; i ++){
                char winner = winner(s[i]);
                if(winner == 'S'){
                    if(c > 0){
                        ans++;
                        c--;
                        steps[i] = winner;
                    }
                    else steps [i] = 'K';
                }
                if(winner == 'P'){
                    if(b > 0){
                        ans++;
                        b--;
                        steps[i] = winner;
                    }
                    else steps [i] = 'K';
                }
                if(winner == 'R'){
                    if(a > 0){
                        ans++;
                        a--;
                        steps[i] = winner;
                    }
                    else steps [i] = 'K';
                }
            }
            for(int i = 0; i < n; i ++){
                if(steps[i] == 'K'){
                    if(c > 0){
                        c--;
                        steps[i] = 'S';
                    }else if(b > 0){
                        b--;
                        steps[i] = 'P';
                    }else {
                        a--;
                        steps[i] = 'R';
                    }
                }

            }



            if(ans >= (n / 2 + n % 2)){
                out.println(yes);
                out.println(String.valueOf(steps));
            }else {
                out.println(no);
            }

        }
    }

    private char winner(char c){
        if(c == 'S') return 'R';
        else if(c == 'P') return 'S';
        else return 'P';
    }
}
