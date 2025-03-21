class Node {
    String key;
    int value;
    Node next;

    public Node(String key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class HashMap {
    private int size;
    private Node[] buckets;

    public HashMap(int size) {
        this.size = size;
        this.buckets = new Node[size];
    }

    private int hash(String key) {
        return Math.abs(key.hashCode()) % size;
    }

    public void insert(String key, int value) {
        int index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = new Node(key, value);
        } else {
            Node current = buckets[index];
            while (true) {
                if (current.key.equals(key)) {
                    current.value = value; // Update existing key
                    return;
                }
                if (current.next == null) {
                    break;
                }
                current = current.next;
            }
            current.next = new Node(key, value);
        }
    }

    public Integer get(String key) {
        int index = hash(key);
        Node current = buckets[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public void remove(String key) {
        int index = hash(key);
        Node current = buckets[index];
        Node prev = null;
        while (current != null) {
            if (current.key.equals(key)) {
                if (prev != null) {
                    prev.next = current.next;
                } else {
                    buckets[index] = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print("Bucket " + i + ": ");
            Node current = buckets[i];
            while (current != null) {
                System.out.print("(" + current.key + ": " + current.value + ") -> ");
                current = current.next;
            }
            System.out.println("None");
        }
    }

    public static void main(String[] args) {
        HashMap hashMap = new HashMap(10);
        hashMap.insert("name", 100);
        hashMap.insert("age", 25);
        hashMap.insert("city", 50);
        hashMap.display();
        System.out.println("Age: " + hashMap.get("age"));
        hashMap.remove("age");
        hashMap.display();
    }
}