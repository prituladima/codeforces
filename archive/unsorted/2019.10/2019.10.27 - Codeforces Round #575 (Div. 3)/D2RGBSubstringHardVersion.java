package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class D2RGBSubstringHardVersion {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = in.nextInt();
        while (t-- > 0){
            int n = in.nextInt();
            int k = in.nextInt();
            char[] s = in.nextToken().toCharArray();
            char[] ALF = {'R', 'G', 'B'};

            int min_ans = Integer.MAX_VALUE;
            for(int c = 0; c < 3; c++){
                int local_ans = 0;
                for(int i = 0; i < k; i++){
                    if(s[i] != ALF[getRGBInd(i, c)]){
                        local_ans ++;
                    }
                }
                min_ans = Math.min(min_ans, local_ans);
                for(int i = k; i < n; i++){
                    if(s[i] != ALF[getRGBInd(i, c)]){
                        local_ans ++;
                    }
                    int j = i - k;
                    if(s[j] != ALF[getRGBInd(j, c)]){
                        local_ans --;
                    }
                    min_ans = Math.min(min_ans, local_ans);
                }

            }


            out.println(min_ans);

        }

    }

    private int getRGBInd(int i, int rgbInd){
        return (i + rgbInd) % 3;
    }
}
