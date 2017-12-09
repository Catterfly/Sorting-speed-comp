package main;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.function.Function;

public class LoopHelper implements Callable<Long> {

    private ArrayList<Integer> input;
    private Function<ArrayList<Integer>, ArrayList<Integer>> sorter;

    public LoopHelper(ArrayList<Integer> input, Function<ArrayList<Integer>, ArrayList<Integer>> sorter) {
        this.input = input;
        this.sorter = sorter;
    }

    @Override
    public Long call() throws Exception {
        ArrayList<Integer> sorted;
        long t = System.nanoTime();
        sorted = sorter.apply(input);
        return (System.nanoTime() - t);
    }
}
