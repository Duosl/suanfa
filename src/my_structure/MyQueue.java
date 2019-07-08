package my_structure;

/**
 * 用数组模拟队列
 * @param <T>
 */
public class MyQueue<T> {

    //用数组模拟队列
    private T[] arr;
    //当前队列的容量
    private int theSize;
    //初始容量
    public static final int DEFAULT_SIZE=10;

    public MyQueue() {
        init();
    }

    private void init() {
        theSize=0;
        ensureSize(DEFAULT_SIZE);
    }

    public int size(){
        return theSize;
    }

    public boolean isEmpty(){
        return theSize==0;
    }

    /**
     * 扩容
     * @param newSize
     */
    private void ensureSize(int newSize) {
        if(newSize<theSize){
            return;
        }else{
            T[] oldArr=arr;
            arr=(T[])new Object[newSize];
            for (int i = 0; i < theSize; i++) {
                arr[i]=oldArr[i];
            }
        }
    }

    /**
     * 入队
     * @param t
     */
    public void push(T t){
        if(arr.length==theSize){
            ensureSize(theSize+DEFAULT_SIZE);
        }
        arr[theSize++]=t;
    }

    /**
     * 出队
     * @return 出队的元素
     */
    public T pop(){
        if(isEmpty()){
            return null;
        }else{
            T t=arr[0];
            for (int i = 1; i < theSize; i++) {
                arr[i-1]=arr[i];
            }
            arr[--theSize]=null;
            return t;
        }
    }

    /**
     * 获取队头元素
     * @return
     */
    public T nextValue(){
        if (isEmpty()){
            return null;
        }else {
            return arr[0];
        }
    }

    @Override
    public String toString() {
        StringBuffer sb=new StringBuffer();
        for (T t: arr) {
            sb.append(t+"\t");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue=new MyQueue<>();
        for (int i = 0; i < 11; i++) {
            queue.push(i+1);
        }
        System.out.println(queue);
        System.out.print("出列：");
        int size=queue.size();
        for (int i = 0; i < size; i++) {
            System.out.print(queue.pop()+"\t");
        }

    }
}
