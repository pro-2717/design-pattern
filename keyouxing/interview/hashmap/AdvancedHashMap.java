package keyouxing.interview.hashmap;

/**
 * @author keyouxing
 */
public class AdvancedHashMap<K,V> {

    private int capacity;

    private  Entry[] table;

    private int size = 0;

    private float loadFactor;

    private int threshold;

    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    static final int MAXIMUM_CAPACITY = 1 << 30;

    public AdvancedHashMap(){
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        this.capacity = DEFAULT_INITIAL_CAPACITY;
        this.threshold = (int)(DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
        table = new Entry[DEFAULT_INITIAL_CAPACITY];
    }

    public int getCapacity() {
        return capacity;
    }

    class Entry<K,V> {
        K key;
        V value;
        int hash;
        Entry<K,V> next;

        Entry(K key, V value, int hash, Entry<K,V> next){
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = next;
        }

        K getKey() {
            return key;
        }
        V getValue() {
            return value;
        }

    }

    public V put(K key, V value){
        int hash = key.hashCode();
        int i = indexFor(key.hashCode(), table.length);
        for(Entry<K,V> e = table[i]; e != null; e = e.next) {
            Object k;
            if(hash == e.hash && ((k = e.getKey()) == key || k.equals(key))){
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }
        addEntry(i, key, value, key.hashCode());
        return null;
    }

    public V get(Object key){
        Entry<K,V> e = getEntry(key);
        return e == null ? null : e.getValue();
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void addEntry(int bucketIndex, K key, V value, int hash) {
        Entry e = table[bucketIndex];
        table[bucketIndex] = new Entry<>(key, value, hash, e);
        if(size++ >= threshold){
            resize(2 * table.length);
        }
    }

    private void resize(int newCapacity) {
        Entry[] oldTable = table;
        int oldCapacity = oldTable.length;
        if (oldCapacity == MAXIMUM_CAPACITY) {
            threshold = Integer.MAX_VALUE;
            return;
        }

        Entry[] newTable = new Entry[newCapacity];

        transform(newTable);
        table = newTable;
        threshold = (int)(newCapacity * loadFactor);
    }

    private void transform(Entry[] newTable) {
        int newCapacity = newTable.length;
        for (Entry e: table){
            while(e != null){
                Entry next = e.next;
                int hash = hash(e.hash);
                int i = indexFor(hash, newCapacity);
                e.next = newTable[i];
                newTable[i] = e;
                e = next;
            }
        }
    }

    private Entry<K,V> getEntry(Object key){
        int hash = hash(key.hashCode());
        int index = indexFor(hash, table.length);
        for (Entry<K,V> e = table[index]; e != null; e = e.next) {
            Object k;
            if(hash == e.hash && ((k=e.getKey())==key||k.equals(key))){
                return e;
            }
        }
        return null;
    }

    private boolean containsKey(Object key){
        return getEntry(key) == null;
    }

    public V remove(Object key){
        Entry<K,V> e = removeEntryForKey(key);
        return (e == null ? null : e.getValue());
    }

    private Entry<K,V> removeEntryForKey(Object key) {
        int hash = hash(key.hashCode());
        int index = indexFor(hash, table.length);
        Entry<K,V> prev = table[index];
        Entry<K,V> e = prev;
        while(e!=null){
            Entry<K,V> next = e.next;
            Object k;
            if(hash == e.hash && ((k=e.getKey())==key||k.equals(key))){
                if(e == prev){
                    table[index] = next;
                }else{
                    prev.next = next;
                }
                return e;
            }
            prev = e;
            e = next;
        }
        return null;
    }

    private int indexFor(int h, int length) {
        return h & (length-1);
    }

    private int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }
}
