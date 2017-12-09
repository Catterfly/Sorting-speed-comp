package sorter;

import java.util.ArrayList;

public abstract class Quick {

    public static ArrayList<Integer> sort (ArrayList<Integer> input) {
        QuickElement raw1 = new QuickElement(input);
        ArrayList<Integer> result = new ArrayList<>();

        if (raw1.onlyPivot()) {
            result.add(raw1.getPivot());
            return result;
        }
        else {
            ArrayList<Integer> left = new ArrayList<>(), right = new ArrayList<>();

            if (!raw1.leftEmpty()) left = raw1.getLeft();
            if (!raw1.rightEmpty()) right = raw1.getRight();

            if (left.isEmpty()) {
                right = sort(right);

                result.add(raw1.getPivot());
                result.addAll(right);

                return result;
            }
            else if (right.isEmpty()) {
                left = sort(left);

                result.addAll(left);
                result.add(raw1.getPivot());

                return result;
            }
            else {
                left = sort(left);
                right = sort(right);

                result.addAll(left);
                result.add(raw1.getPivot());
                result.addAll(right);

                return result;
            }
        }
    }
}
