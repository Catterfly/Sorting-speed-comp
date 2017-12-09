package sorter;

import java.util.ArrayList;

public abstract class Merge {

    public static ArrayList<Integer> sort(ArrayList<Integer> input) {
        if (input.size() <= 1) return input;
        else {
            int ctr = 0;
            ArrayList<Integer> left = new ArrayList<>(), right = new ArrayList<>();
            for (Integer i : input) {
                if (ctr == 0) {
                    left.add(i);
                    ctr++;
                }
                else {
                    right.add(i);
                    ctr--;
                }
            }

            left = sort(left);
            right = sort(right);

            return __sort(left, right);
        }
    }

    private static ArrayList<Integer> __sort(ArrayList<Integer> left, ArrayList<Integer> right) {
        ArrayList<Integer> result = new ArrayList<>();

        while (!left.isEmpty() && !right.isEmpty()) {
            if (left.get(0) <= right.get(0)) {
                result.add(left.get(0));
                left.remove(0);
            }
            else {
                result.add(right.get(0));
                right.remove(0);
            }
        }

        while (!left.isEmpty()) {
            result.add(left.get(0));
            left.remove(0);
        }

        while (!right.isEmpty()) {
            result.add(right.get(0));
            right.remove(0);
        }

        return result;
    }
}
