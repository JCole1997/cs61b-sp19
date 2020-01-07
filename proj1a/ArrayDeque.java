import java.util.Objects;

public class ArrayDeque<Item> {
    private Item[] item;
    private int size;
    private int nextFirst;
    private int nextLast;
    private final int INITIAL_CAPACITY = 8;

    public ArrayDeque() {
        size = 0;
        item = (Item[]) new Object[INITIAL_CAPACITY];
        nextFirst = 0;
        nextLast = 1;
    }

    public ArrayDeque(ArrayDeque other) {
        item = (Item[]) new Object[other.size];
        nextFirst = other.nextFirst;
        nextLast = other.nextLast;
        size = other.size;

        System.arraycopy(other.item, 0, item, 0, other.size);
    }

    public int minusOne(int index) {
        return Math.floorMod(index - 1, item.length);
    }

    public int plusOne(int index) {
        return Math.floorMod(index + 1, item.length);
    }

    public int plusOne(int index, int length) {
        return Math.floorMod(index + 1, length);
    }


    private void resize() {
        if (size == item.length) {
            expand();
        }
        if (size < item.length / 4 && item.length > 8) {
            reduce();
        }
    }

    private void expand() {
        resizeHelper(item.length * 2);
    }

    private void reduce() {
        resizeHelper(item.length / 2);
    }

    private void resizeHelper(int capacity) {
        Item[] temp = item;
        int begin = plusOne(nextFirst);
        int end = minusOne(nextLast);
        item = (Item[]) new Object[capacity];
        nextFirst = 0;
        nextLast = 1;
        for (int i = begin; i != end; i = plusOne(i, temp.length)) {
            item[nextLast] = temp[i];
            nextLast = plusOne(nextLast);
        }
        item[nextLast] = temp[end];
        nextLast = plusOne(nextLast);
    }


    public void addFirst(Item x) {
        resize();
        item[nextFirst] = x;
        nextFirst = minusOne(nextFirst);
        size++;
    }

    public Item getFirst() {
        return item[plusOne(nextFirst)];
    }

    public Item removeFirst() {
        resize();
        Item p = getFirst();
        nextFirst = plusOne(nextFirst);
        item[nextFirst] = null;
        size--;
        return p;
    }

    public void addLast(Item x) {
        resize();
        item[nextLast] = x;
        nextLast = plusOne(nextLast);
        size++;
    }

    public Item getLast() {
        return item[minusOne(nextLast)];
    }

    public Item removeLast() {
        resize();
        Item p = getLast();
        nextLast = minusOne(nextLast);
        item[nextLast] = null;
        size--;
        return p;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int index = plusOne(nextFirst); index != nextLast; index = plusOne(index)) {
            System.out.print(item[index]);
            System.out.print(" ");
        }
        System.out.println();
    }

    public Item get(int index) {
        if (index < 0 || index >= size)
            return null;
        index = Math.floorMod(plusOne(nextFirst) + index, item.length);
        return item[index];
    }

}
