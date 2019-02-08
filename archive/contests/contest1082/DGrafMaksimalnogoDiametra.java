package com.prituladima.codeforce.contests.contest1082;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;
import java.util.*;

public class DGrafMaksimalnogoDiametra {
    private static class Vertex {

        public Vertex(int deg, int vertexNumber) {
            this.deg = deg;
            this.vertexNumber = vertexNumber;
        }

        int deg;
        int vertexNumber;

        public int getDeg() {
            return deg;
        }

        public int getVertexNumber() {
            return vertexNumber;
        }
    }

    public void solve(int testNumber, InputReader in, PrintWriter out) {


        int n = in.nextInt();
        int[] a = in.nextArr(n);

        int sum = Arrays.stream(a).sum();

        if (sum < 2 * n - 2) {
            out.println("NO");
            return;
        }
//        out.print("YES ");

        List<DGrafMaksimalnogoDiametra.Vertex> vertices = new ArrayList<>();
        List<DGrafMaksimalnogoDiametra.Vertex> ones = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            DGrafMaksimalnogoDiametra.Vertex vertex = new DGrafMaksimalnogoDiametra.Vertex(a[i], i + 1);
            if (a[i] >= 2) {
                vertices.add(vertex);
            } else {
                ones.add(vertex);
            }
        }

        out.printf("YES %d\n%s\n", ((vertices.size() - 1) + Math.min(ones.size(), 2)), n - 1);

        List<Integer> v = new ArrayList<>();
        List<Integer> u = new ArrayList<>();

        Collections.sort(vertices, Comparator.comparing(DGrafMaksimalnogoDiametra.Vertex::getDeg).reversed());

        for (int i = 1; i < vertices.size(); i++) {

            v.add(vertices.get(i - 1).vertexNumber);
            u.add(vertices.get(i).vertexNumber);

            vertices.get(i - 1).deg--;
            vertices.get(i).deg--;
        }

        if (ones.size() > 0) {

            v.add(vertices.get(vertices.size() - 1).vertexNumber);
            u.add(ones.get(0).vertexNumber);

            vertices.get(vertices.size() - 1).deg--;
            ones.get(0).deg--;

            int j = 1;
            for (int i = 0; i < vertices.size(); i++) {

                while (vertices.get(i).deg > 0 && ones.size() > j) {
                    v.add(vertices.get(i).vertexNumber);
                    u.add(ones.get(j).vertexNumber);

                    vertices.get(i).deg--;
                    ones.get(j++).deg--;

                }
            }


        }

        for (int k = 0; k < v.size(); k++) {
            out.printf("%d %d\n", v.get(k), u.get(k));
        }

    }
}
