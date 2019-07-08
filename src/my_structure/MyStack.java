package my_structure;

/**
 * 用数组模拟栈
 * @param <E>
 */
public class MyStack<E> {

    //数组模拟栈
    private E[] arr;
    //当前元素个数
    private int currentSize;
    //数组的默认容量
    public static final int DEFAULT_SIZE=10;

    public MyStack() {
        currentSize =0;
        arr= (E[]) new Object[DEFAULT_SIZE];
    }


    public MyStack(int size){
        currentSize =0;
        if(size > 0){
            arr= (E[]) new Object[size];
        }else {
            throw new IllegalArgumentException("the input param 'size' must greater than zero");
        }
    }

//    private void init(){
//        currentSize =0;
//        ensureSize(DEFAULT_SIZE);
//    }

    public int size(){
        return currentSize;
    }

    public boolean isEmpty(){
        return currentSize ==0;
    }

    /**
     * 扩充栈容量
     * @param newSize 新的栈容量
     */
    private void ensureSize(int newSize) {
        if(newSize< currentSize){
            return;
        }else{
            E[] oldArr=arr;
            arr=(E[])new Object[newSize];
            for (int i = 0; i < currentSize; i++) {
                arr[i]=oldArr[i];
            }
        }

    }

    /**
     * 入栈
     * @param e
     */
    public void push(E e){
        if(arr.length== currentSize){
            ensureSize(currentSize +DEFAULT_SIZE);
        }
        arr[currentSize++]= e;
    }

    /**
     * 出栈
     * @return
     */
    public E pop(){
        if(isEmpty()){
            return null;
        }else {
            E e =arr[currentSize -1];
            arr[--currentSize]=null;
            return e;
        }

    }

    /**
     * 获取栈尾元素
     * @return
     */
    public E nextValue(){
        if(isEmpty()){
            return null;
        }else{
            return arr[currentSize -1];
        }
    }

    @Override
    public String toString() {
        StringBuffer sb=new StringBuffer();
        for (E e : arr) {
            sb.append(e +"\t");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MyStack<Integer> stack=new MyStack<>(11);
        for (int i = 0; i < 11; i++) {
            stack.push(i+1);
        }
        System.out.println(stack);
        System.out.print("出栈：");
        int size=stack.size();
        for (int i = 0; i < size; i++) {
            System.out.print(stack.pop()+"\t");
        }
    }
}
