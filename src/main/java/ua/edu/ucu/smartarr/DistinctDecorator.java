package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
    }

    @Override
    public Object[] toArray() {
        Object[] arr = this.smartArray.toArray();
        Object[] workingArr = new Object[arr.length];
        int ind = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean repeating = false;
            for (int j = 0; j < i; j++) {
                if (arr[i].equals(arr[j])) {
                    repeating = true;
                    break;
                }
            }
            if (!repeating) {
                workingArr[ind] = arr[i];
                ind++;
            }
        }
        return Arrays.copyOf(workingArr, ind);
    }

    @Override
    public String operationDescription() {
        return "DistinctDecorator";
    }

    @Override
    public int size() {
        return this.toArray().length;
    }

}
