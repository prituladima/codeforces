package com.prituladima.javacommunity;

import guru.nidi.graphviz.attribute.*;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.Graph;
import guru.nidi.graphviz.model.MutableGraph;
import guru.nidi.graphviz.model.Node;
import guru.nidi.graphviz.parse.Parser;

import java.io.File;
import java.io.IOException;

import static guru.nidi.graphviz.attribute.Label.Justification.LEFT;
import static guru.nidi.graphviz.attribute.Rank.RankDir.LEFT_TO_RIGHT;
import static guru.nidi.graphviz.model.Factory.graph;
import static guru.nidi.graphviz.model.Factory.node;
import static guru.nidi.graphviz.model.Factory.to;

public class GraphViz {
    public static void main(String[] args) throws IOException {
        if (false) {
            Graph g = graph("example1").directed()
                    .graphAttr().with(Rank.dir(LEFT_TO_RIGHT))
                    .with(
                            node("a").with(Color.RED).link(node("b")),
                            node("b").link(to(node("c")).with(Style.DASHED))
                    );
            Graphviz.fromGraph(g).height(100).render(Format.PNG).toFile(new File("ex1.png"));

            Node
                    main = node("main").with(Label.html("<b>main</b><br/>start"), Color.rgb("1020d0").font()),
                    init = node(Label.markdown("**_init_**")),
                    execute = node("execute"),
                    compare = node("compare").with(Shape.RECTANGLE, Style.FILLED, Color.hsv(.7, .3, 1.0)),
                    mkString = node("mkString").with(Label.lines(LEFT, "make", "a", "multi-line")),
                    printf = node("printf");

            Graph g2 = graph("example2").directed().with(
                    main.link(
                            to(node("parse").link(execute)).with(LinkAttr.weight(8)),
                            to(init).with(Style.DOTTED),
                            node("cleanup"),
                            to(printf).with(Style.BOLD, Label.of("100 times"), Color.RED)),
                    execute.link(
                            graph().with(mkString, printf),
                            to(compare).with(Color.RED)),
                    init.link(mkString));

            Graphviz.fromGraph(g2).width(900).render(Format.PNG).toFile(new File("ex2.png"));
        }

    }
}
