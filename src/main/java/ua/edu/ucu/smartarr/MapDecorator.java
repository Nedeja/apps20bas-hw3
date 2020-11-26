package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    MyFunction function;

    public MapDecorator(SmartArray smartArray, MyFunction function) {
        super(smartArray);
        this.function = function;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = this.smartArray.toArray();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = this.function.apply(arr[i]);
        }
        return arr.clone();
    }

    @Override
    public String operationDescription() {
        return "MapDecorator";
    }

    @Override
    public int size() {
        return this.toArray().length;
    }
}
