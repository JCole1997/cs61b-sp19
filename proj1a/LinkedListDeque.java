public class LinkedListDeque<T> {

    private int size;
    private TNode sentinel;

    public class TNode {

        public T item;
        public TNode prev;
        public TNode next;

        public TNode(T i, TNode p, TNode n) {
            this.item = i;
            this.prev = p;
            this.next = n;
        }

    }

    public LinkedListDeque() {
        size = 0;
        sentinel = new TNode((T) "null", null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public LinkedListDeque(LinkedListDeque other) {
        size = 0;
        sentinel = new TNode((T) "null", null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;

        for (int i = 0; i < other.size(); i += 1) {
            addLast((T) other.get(i));
        }
    }

    public void addFirst(T item) {
        size += 1;
        sentinel.next = new TNode(item, sentinel, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
    }

    public void addLast(T item) {
        size += 1;
        sentinel.prev = new TNode(item, sentinel.prev, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
    }

    public boolean isEmpty() {
        return sentinel.next == sentinel;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        TNode p = sentinel;
        while (p.next != sentinel) {
            System.out.print(p.next.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        TNode p = sentinel.next;
        if (sentinel.next != sentinel) {
            size = size - 1;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            return p.item;
        } else
            return null;
    }

    public T removeLast() {
        TNode p = sentinel.prev;
        if (sentinel.prev != sentinel) {
            size = size - 1;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            return p.item;
        } else
            return null;
    }

    public T get(int index) {
        TNode p = sentinel;
        if (size < index + 1)
            return null;
        else {
            for (int i = 0; i <= index; i++) {
                p = p.next;
            }
            return p.item;
        }
    }

    public T getRecursiveHelper(int index, int count, TNode ptr) {
        if (index == count) {
            return ptr.item;
        }
        return getRecursiveHelper(index, count + 1, ptr.next);
    }

    public T getRecursive(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        int count = 0;
        TNode ptr = sentinel.next;
        return getRecursiveHelper(index, count, ptr);
    }


}
