package main;

import sorter.*;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;


public class MainClass {

    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File("list.txt"));
            String sourceString = input.nextLine();
            input.close();
            String[] sourceArray = sourceString.split(", ");
            ArrayList<Integer> source = new ArrayList<>();

            for (String s : sourceArray) source.add(Integer.parseInt(s));

            //System.out.println(source);
            //System.exit(0);

            ArrayList<Integer> sorted, sourceCopy;
            ArrayList<Long> timeRadix = new ArrayList<>(), timeMerge = new ArrayList<>(), timeQuick = new ArrayList<>();

            int rounds = 11;
            long t;

            System.err.println("Doing " + rounds + " runs...");
            LoopHelper radixHelper = new LoopHelper(source, Radix::sort);
            LoopHelper mergeHelper = new LoopHelper(source, Merge::sort);
            LoopHelper quickHelper = new LoopHelper(source, Quick::sort);

            for (int i = 1; i <= rounds; i++) {
                //System.err.println("Run no. " + i);

                timeRadix.add(radixHelper.call());
                timeMerge.add(mergeHelper.call());
                timeQuick.add(quickHelper.call());
            }

            System.err.println(rounds + " runs done. Calculating average run times...");

            BigInteger radixAverage = new BigInteger("0");
            for (long l : timeRadix) radixAverage = radixAverage.add(BigInteger.valueOf(l));
            radixAverage = radixAverage.divide(BigInteger.valueOf(rounds));
            System.out.println("Average run time for Radixsort: " + radixAverage + " ns");

            BigInteger mergeAverage = new BigInteger("0");
            for (long l : timeMerge) mergeAverage = mergeAverage.add(BigInteger.valueOf(l));
            mergeAverage = mergeAverage.divide(BigInteger.valueOf(rounds));
            System.out.println("Average run time for Mergesort: " + mergeAverage + " ns");

            BigInteger quickAverage = new BigInteger("0");
            for (long l : timeQuick) quickAverage = quickAverage.add(BigInteger.valueOf(l));
            quickAverage = quickAverage.divide(BigInteger.valueOf(rounds));
            System.out.println("Average run time for Quicksort: " + quickAverage + " ns");
        }
        catch (Exception x) {
            x.printStackTrace();
        }
    }
}
