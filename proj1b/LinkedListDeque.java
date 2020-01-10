public class LinkedListDeque<Item> implements Deque<Item> {

    private int size;
    private TNode sentinel;

    public class TNode {

        public Item item;
        public TNode prev;
        public TNode next;

        public TNode(Item i, TNode p, TNode n) {
            this.item = i;
            this.prev = p;
            this.next = n;
        }

    }

    public LinkedListDeque() {
        size = 0;
        sentinel = new TNode((Item) "null", null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public LinkedListDeque(LinkedListDeque other) {
        size = 0;
        sentinel = new TNode((Item) "null", null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;

        for (int i = 0; i < other.size(); i += 1) {
            addLast((Item) other.get(i));
        }
    }

    @Override
    public void addFirst(Item item) {
        size += 1;
        sentinel.next = new TNode(item, sentinel, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
    }

    @Override
    public void addLast(Item item) {
        size += 1;
        sentinel.prev = new TNode(item, sentinel.prev, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
    }

    @Override
    public boolean isEmpty() {
        return sentinel.next == sentinel;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        TNode p = sentinel;
        while (p.next != sentinel) {
            System.out.print(p.next.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    @Override
    public Item removeFirst() {
        TNode p = sentinel.next;
        if (sentinel.next != sentinel) {
            size = size - 1;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            return p.item;
        } else
            return null;
    }

    @Override
    public Item removeLast() {
        TNode p = sentinel.prev;
        if (sentinel.prev != sentinel) {
            size = size - 1;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            return p.item;
        } else
            return null;
    }

    @Override
    public Item get(int index) {
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

}
