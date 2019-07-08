package my_structure;

import java.util.Arrays;

class MyMinSatck {

    private Integer[] arr;
    private static final int DEFAULT_SIZE = 10;
    private int max_size = DEFAULT_SIZE; //默认最大长度等于初始长度，可进行扩容操作
    private int size = 0;
    private int min;

    /** initialize your data structure here. */
    public MyMinSatck() {
        arr = new Integer[DEFAULT_SIZE];
    }

    public void push(int x) {

        if (isEmpty()){
            min = x;
        }

        if(x < min){
            min = min - (min - x);
        }

        ifFullAndExpand();
        arr[size++] = x;
        System.out.println("push stack : " + x);
    }

    public void pop() {
        if(!isEmpty()){
            System.out.println("pop stack : " + arr[size-1]);
            arr[--size] = null;

        }
    }

    public int top() {
        System.out.println("current stack top: "+arr[size-1]);
        return arr[size-1];
    }

    public int getMin() {
        int min = 0;
        for(int i=1; i<size;i++){
            if(arr[i]<arr[min]){
                min = i;
            }
        }
        System.out.println("current stack Min: "+arr[min]);
        return arr[min];
    }

    private boolean isEmpty(){
        return size == 0;
    }

    private void ifFullAndExpand(){
        if(size == max_size){
            expand();
        }
    }

    private void expand(){
        max_size = size * 2;
        arr = Arrays.copyOf(arr, max_size);
    }

    public static void main(String[] args) {
        MyMinSatck minStack = new MyMinSatck();
        minStack.push(-5);
        minStack.push(0);
        minStack.push(-3);
        minStack.push(4);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();
        minStack.pop();


    }

}

