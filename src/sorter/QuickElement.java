package sorter;

import java.util.ArrayList;

public class QuickElement {
    private ArrayList<Integer> left = new ArrayList<>(), right = new ArrayList<>();
    private Integer pivot;

    //Default constructor
    public QuickElement(ArrayList<Integer> left, ArrayList<Integer> right, Integer pivot) {
        this.left = left;
        this.right = right;
        this.pivot = pivot;
    }

    //Copy constructor
    public QuickElement(QuickElement org) {
        this(org.getLeft(), org.getRight(), org.getPivot());
    }

    //Constructor from ArrayList
    public QuickElement(ArrayList<Integer> original) {
        Integer pivot = original.get(0);
        original.remove(0);

        if (original.isEmpty()) {
            left = new ArrayList<>();
            right = new ArrayList<>();
        }

        ArrayList<Integer> left = new ArrayList<>(), right = new ArrayList<>();

        for (Integer i : original) {
            if (i <= pivot) left.add(i);
            else right.add(i);
        }

        this.left = left;
        this.right = right;
        this.pivot = pivot;
    }

    public ArrayList<Integer> getLeft() {
        return left;
    }

    public ArrayList<Integer> getRight() {
        return right;
    }

    public Integer getPivot() {
        return pivot;
    }

    public void setLeft(ArrayList<Integer> left) {
        this.left = left;
    }

    public void setRight(ArrayList<Integer> right) {
        this.right = right;
    }

    public void setPivot(Integer pivot) {
        this.pivot = pivot;
    }

    public ArrayList<Integer> mergeToArray() {
        ArrayList<Integer> result = new ArrayList<>();

        result.addAll(left);
        result.add(pivot);
        result.addAll(right);

        return result;
    }

    public boolean onlyPivot() {
        return (left.isEmpty() && right.isEmpty());
    }

    public boolean leftEmpty() {
        return left.isEmpty();
    }

    public boolean rightEmpty() {
        return right.isEmpty();
    }
}
