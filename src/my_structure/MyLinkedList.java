package my_structure;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import java.util.Set;

class MyLinkedList {

    private int size;
    private ListNode first;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        ListNode node = node(index);
        if (node == null) return -1;
        return node.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        // 如果index为负数，插入到头部？！
        // if (index == 0) { 
        if (index <= 0) {
            first = new ListNode(val, first);
        } else {
            ListNode prev = node(index - 1);
            if (prev == null) return;
            prev.next = new ListNode(val, prev.next);
        }
        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (rangeCheck(index) == false) return;
        if (index == 0) {
            first = first.next;
        } else {
            ListNode prev = node(index - 1);
            if (prev == null) return;
            prev.next = prev.next.next;
        }
        size--;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        ListNode node = first;
        while (node != null){
            sb.append(node.val + ",");
            if(node.next != null) node = node.next;
            else break;
        }
        return sb.length()>0 ? sb.substring(0, sb.length()-1) : sb.toString();
    }

    /**
     * 根据索引查找对应节点
     */
    private ListNode node(int index) {
        if (rangeCheck(index) == false) return null;
        ListNode node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private boolean rangeCheck(int index) {
        return !(index < 0 || index > (size - 1));
    }

    /**
     * ListNode 节点
     */
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this(val);
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
//        int param_1 = obj.get(1);
//        System.out.println(param_1);
//        obj.addAtHead(1);
//        obj.addAtTail(2);
//        obj.addAtIndex(0, 3);
//        System.out.println(obj);
//        obj.deleteAtIndex(1);
//        System.out.println(obj);
    }

    class T extends AbstractProcessor{

        @Override
        public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
            return false;
        }

        @Override
        public Set<String> getSupportedAnnotationTypes() {
            return super.getSupportedAnnotationTypes();
        }

        @Override
        public SourceVersion getSupportedSourceVersion() {
            return super.getSupportedSourceVersion();
        }

        @Override
        public synchronized void init(ProcessingEnvironment processingEnv) {
            super.init(processingEnv);
        }
    }
}

/**
 * Your my_structure.MyLinkedList object will be instantiated and called as such:
 * my_structure.MyLinkedList obj = new my_structure.MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
