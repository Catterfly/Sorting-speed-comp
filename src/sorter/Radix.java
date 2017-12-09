package sorter;

import java.util.ArrayList;

public abstract class Radix {

    public static ArrayList<Integer> sort(ArrayList<Integer> input) {
        int maxLen = input.get(0).toString().length();

        for (Integer i : input) {
            if (i.toString().length() > maxLen) maxLen = i.toString().length();
        }

        ArrayList<String> inStr = new ArrayList<>();
        String tmp1;

        for (Integer i : input) {
            tmp1 = i.toString();

            while (tmp1.length() < maxLen) tmp1 = "0" + tmp1;

            inStr.add(tmp1);
        }

        for (int i = maxLen - 1; i >= 0; i--) {
            ArrayList<String> zero = new ArrayList<>();
            ArrayList<String> one = new ArrayList<>();
            ArrayList<String> two = new ArrayList<>();
            ArrayList<String> three = new ArrayList<>();
            ArrayList<String> four = new ArrayList<>();
            ArrayList<String> five = new ArrayList<>();
            ArrayList<String> six = new ArrayList<>();
            ArrayList<String> seven = new ArrayList<>();
            ArrayList<String> eight = new ArrayList<>();
            ArrayList<String> nine = new ArrayList<>();
            ArrayList<String> nInStr = new ArrayList<>();

            for (String s : inStr) {
                switch (s.charAt(i)) {
                    case '0':
                        zero.add(s); break;
                    case '1':
                        one.add(s); break;
                    case '2':
                        two.add(s); break;
                    case '3':
                        three.add(s); break;
                    case '4':
                        four.add(s); break;
                    case '5':
                        five.add(s); break;
                    case '6':
                        six.add(s); break;
                    case '7':
                        seven.add(s); break;
                    case '8':
                        eight.add(s); break;
                    case '9':
                        nine.add(s); break;
                }
            }

            nInStr.addAll(zero);
            nInStr.addAll(one);
            nInStr.addAll(two);
            nInStr.addAll(three);
            nInStr.addAll(four);
            nInStr.addAll(five);
            nInStr.addAll(six);
            nInStr.addAll(seven);
            nInStr.addAll(eight);
            nInStr.addAll(nine);

            inStr = nInStr;
        }

        ArrayList<Integer> res = new ArrayList<>();

        for (String s : inStr) {
            res.add(Integer.parseInt(s));
        }

        return res;
    }
}
