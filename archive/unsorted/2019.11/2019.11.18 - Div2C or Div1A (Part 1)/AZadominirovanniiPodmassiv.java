package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;

public class AZadominirovanniiPodmassiv {
//    int MAXN = (int) 1e5 + 10;


    public void solve(int testNumber, InputReader in, OutputWriter out) {


        int t = in.nextInt();
        while (t-- > 0) {

            int n = in.nextInt();
            int[] a = in.nextIntArray(n);
            if (n < 2) {
                out.println(-1);
            } else {


                Map<Integer, Integer> rightValueToIndex = new HashMap<>();
                int minDist = n + 1;

                for (int i = 0; i < n; i++) {
                    if(rightValueToIndex.containsKey(a[i])){
                        minDist = Math.min(i - rightValueToIndex.get(a[i]) + 1, minDist);
                    }
                    rightValueToIndex.put(a[i], i);
                }


                if(minDist == n + 1){
                    out.println(-1);
                }else {
                    out.println(minDist);
                }

//                int maxOcc = 0;
//                int maxOccVal = -1;
//                int[] occ = new int[n + 20];
//                //Arrays.fill(occ, 0);
//                for (int i = 0; i < n; i++) {
//                    occ[a[i]]++;
//                    if (maxOcc < occ[a[i]]) {
//                        maxOcc = occ[a[i]];
//                        maxOccVal = a[i];
//                    }
//                }
//
//                if (maxOcc < 2) {
//                    out.println(-1);
//                    continue;
//                }


//                Set<Integer> set = new HashSet<>();
//
//                for (int value : a) {
//                    if (occ[value] == occ[maxOccVal]) {
//                        set.add(value);
//                    }
//                }
//
//                if (set.size() > 2) {
//                    out.println(-1);
//                } else {
//                    List<Integer> indexes = new ArrayList<>();
//                    for (int i = 0; i < n; i++) {
//                        if (maxOccVal == a[i]) {
//                            indexes.add(i);
//                        }
//                    }
//
//                    int minDist = Integer.MAX_VALUE;
////                    List<Integer> dist = new ArrayList<>();
//                    for (int i = 1; i < indexes.size(); i++) {
//                        final int localDist = indexes.get(i) - indexes.get(i - 1);
////                        dist.add(localDist);
//                        minDist = Math.min(minDist, localDist);
//                    }
//                    out.println(minDist + 1);
//
//                }


            }

        }

    }
}
