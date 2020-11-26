package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    MyPredicate predicate;

    public FilterDecorator(SmartArray smartArray,
                           MyPredicate predicate) {
        super(smartArray);
        this.predicate = predicate;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = this.smartArray.toArray();
        Object[] workingArr = new Object[arr.length];
        int ind = 0;
        for (int i = 0; i < arr.length; i++) {
            if (this.predicate.test(arr[i])) {
                workingArr[ind] = arr[i];
                ind++;
            }
        }
        return Arrays.copyOf(workingArr, ind);
    }

    @Override
    public String operationDescription() {
        return "FilterDecorator";
    }

    @Override
    public int size() {
        return this.toArray().length;
    }
}
