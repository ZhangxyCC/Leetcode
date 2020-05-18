class LRUCache {
    class Node{
        int key;
        int val;
        Node next;
        Node pre;
        Node(int key, int val){
            this.val = val;
            this.key = key;
        }
    }
    private HashMap<Integer, Node> map;
    private Node start;
    private Node end;
    private int capacity;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        start = new Node(-1, -1);
        end = new Node(-1, -1);
        start.next = end;
        end.pre = start;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))   return -1;
        Node n = this.map.get(key);
        moveToFront(n);
        return n.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.get(key).val = value;
            moveToFront(map.get(key));
            return;
        }
        if(map.size() == this.capacity){
            map.remove(this.end.pre.key);
            deleteNode(this.end.pre);
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insertNode(newNode);
        
    }
    private void moveToFront(Node n){
        if(this.start.next == n) return;
        deleteNode(n);
        this.start.next.pre = n;
        n.next = this.start.next;
        this.start.next = n;
        n.pre = this.start;
    }
    private void deleteNode(Node n){
        Node next = n.next;
        n.pre.next = n.next;
        n.next.pre = n.pre;
        n.next = null;
        n.pre = null;
    }
    private void insertNode(Node n){
        this.start.next.pre = n;
        n.next = this.start.next;
        this.start.next = n;
        n.pre = this.start;
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */