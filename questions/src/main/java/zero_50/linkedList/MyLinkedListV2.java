package zero_50.linkedList;

/**
 * No707 双链表 速度更快
 */
class ListNodeV2 {
    int val;
    ListNodeV2 next;
    ListNodeV2 pre;
    ListNodeV2() {
    }
    ListNodeV2(int val) {
        this.val = val;
    }
}

class MyLinkedListV2 {
    int size;
    // 哨兵
    ListNodeV2 head;
    ListNodeV2 tail;
    public MyLinkedListV2() {
        size = 0;
        head = new ListNodeV2(-1);
        tail = new ListNodeV2(-1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int index) {
        if (index<0 || index>=size){
            return -1;
        }
        ListNodeV2 cur = head;
       if (index<(size-1)/2){
           for (int i = 0; i < index; i++) {
               cur = cur.next;
           }
       }else {
           cur = tail;
           for (int i = 0; i <=size-1-index ; i++) {
               cur = cur.pre;
           }
       }
       return cur.val;
    }

    public void addAtHead(int val) {
        ListNodeV2 cur = head;
        ListNodeV2 node = new ListNodeV2(val);
        node.next = cur.next;
        cur.next.pre = node;
        head.next = node;
        node.pre = head;
        size++;
    }

    public void addAtTail(int val) {
        ListNodeV2 cur = tail;
        ListNodeV2 node = new ListNodeV2(val);
        node.next = tail;
        node.pre = tail.pre;
        cur.pre.next = node;
        cur.pre = node;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index>size){
            return;
        }
        if (index<0){
            index=0;
        }
        ListNodeV2 cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        ListNodeV2 newNode = new ListNodeV2(val);
        newNode.next = cur.next;
        cur.next.pre = newNode;
        newNode.pre = cur;
        cur.next = newNode;
    }

    public void deleteAtIndex(int index) {
        if(index >= size || index < 0){return;}
        ListNodeV2 cur = head;
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }
        cur.next.next.pre = cur;
        cur.next = cur.next.next;
        size--;
    }
}
