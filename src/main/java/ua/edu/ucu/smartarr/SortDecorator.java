package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {

    MyComparator comparator;

    public SortDecorator(SmartArray smartArray,
                         MyComparator comparator) {
        super(smartArray);
        this.comparator = comparator;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = this.smartArray.toArray();
        Arrays.sort(arr, comparator);
        return arr.clone();
    }

    @Override
    public String operationDescription() {
        return "SortDecorator";
    }

    @Override
    public int size() {
        return this.toArray().length;
    }
}
