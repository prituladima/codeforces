package com.prituladima.codeforce.contests.contest1081;

import com.prituladima.codeforce.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BProshalnayaVecherinka {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = in.nextArr(n);

        Map<Integer, Integer> ms = new HashMap<>();
        for (int i = 0; i < n; i++) {
            ms.merge(a[i], 1, Integer::sum);
        }

        if(ms.keySet().size() > 2){
            out.println("Impossible");
            return;
        }

        if(ms.keySet().size()==1 && ms.keySet().contains(0) && ms.get(0) == n){
            out.println("Possible");
            for (int i = 0; i < n; i++) {
                out.print(1 + " ");
            }
            return;
        }

        List<Integer > list = new ArrayList<>(ms.keySet());
        if(ms.keySet().size()==1 && list.get(0) * 2 == n){
            out.println("Possible");
            for (int i = 0; i < n; i++) {
                out.print((i % 2 + 1) + " ");
            }
            return;
        }



        if (ms.keySet().size() == 2 && list.get(0)*ms.get(list.get(0))  == list.get(1)*ms.get(list.get(1))){
            out.println("Possible");
            int k = a[0];
            for (int i = 0; i < n; i++) {
                out.print((k == a[i] ? 1 : 2) + " ");
            }
            return;
        }

        out.println("Impossible");


    }
}
