public class MyHashTable <Key extends Comparable<Key>, Value>{
    private Integer capacity;
    private Key[] keyBuckets;
    private Value[] valueBuckets;
    private Integer size = 0;

    public MyArrayList<Key> keys = new MyArrayList<>();
    public Integer comparisons = 0;
    public Integer maxProbe = 0;


    public MyHashTable(Integer capacity){
        this.capacity = capacity;
        keyBuckets = (Key[]) new Comparable[capacity];
        valueBuckets = (Value[]) new Object[capacity];
    }

    private Integer hash(Key key){
        int hash = Math.abs(key.hashCode()) % capacity;


        return hash;
    }

    public Value get(Key key){
        Integer hashTemp = hash(key);
        boolean secondPass = false;
        Integer tempProbe = 0;

        Value temp = null;

        for (int i = hashTemp; i < capacity; i++) {

            if(secondPass && i == hashTemp){

                break;
            }
            if(keyBuckets[hashTemp] == null){

                break;
            }
            if(keyBuckets[i] == null){

                break;
            }
            tempProbe++;
            if(keyBuckets[i].compareTo(key) == 0){

                temp = valueBuckets[i];
                break;
            }

            if(i == capacity - 1){
                i = 0;
                secondPass = true;
            }


        }
        maxProbe = probeTest(tempProbe);
        return temp;
    }

    public void put(Key key, Value value){
        Integer hashTemp = hash(key);

        boolean secondPass = false;

        Integer tempProbe = 0;

        for (int i = hashTemp; i < capacity; i++) {

            if(secondPass && i == hashTemp){
                break;
            }

            tempProbe++;

            if(keyBuckets[i] != null && keyBuckets[i].compareTo(key) == 0){
                keyBuckets[i] = key;
                valueBuckets[i] = value;

                break;
            }
            comparisons++;
            if(keyBuckets[i] == null){
                keys.insert(key, keys.size());
                keyBuckets[i] = key;
                valueBuckets[i] = value;
                size++;
                break;
            }

            if(i == capacity - 1){
                i = 0;
                secondPass = true;
            }
        }
        maxProbe = probeTest(tempProbe);
    }

    public Integer size(){
        return size;
    }

    private Integer probeTest(Integer probe){
        if(probe > maxProbe){
            return probe;
        } else {
            return maxProbe;
        }
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (int i = 0; i < capacity; i++) {



            if(keyBuckets[i] != null){
                if(str.length() == 1){
                    str.append(keyBuckets[i]).append(":").append(valueBuckets[i]);
                } else{
                    str.append(",").append(keyBuckets[i]).append(":").append(valueBuckets[i]);
                }

            }




        }
        str.append("]");

        return str.toString();
    }

/*    public boolean contains(Value val){
        boolean searchOver = false;
        Value firstVal = get((Key) val);
        while(!searchOver){
            if(val == get((Key) val)){
                searchOver = true;
            }
        }
    }*/



}
