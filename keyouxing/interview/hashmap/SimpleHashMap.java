package keyouxing.interview.hashmap;

/**
 * @author keyouxing
 */
public class SimpleHashMap<K,V> {

    private int capacity = 16;

    private  Entry<K,V>[] table = new Entry[capacity];

    private int size = 0;
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

    public V get(K key){
        int hash = key.hashCode();
        int i = indexFor(key.hashCode(), table.length);
        for(Entry<K,V> e = table[i]; e != null; e = e.next){
            Object k;
            if(hash == e.hash && ((k=e.getKey())==key || k.equals(key))){
                return e.getValue();
            }
        }
        return null;
    }

    public boolean isEmpty(){
        return size==0;
    }

    private void addEntry(int bucketIndex, K key, V value, int hash) {
        Entry<K,V> e = table[bucketIndex];
        table[bucketIndex] = new Entry<>(key, value, hash, e);
        size++;
    }

    private int indexFor(int hashCode, int length) {
        return hashCode % length;
    }
}
