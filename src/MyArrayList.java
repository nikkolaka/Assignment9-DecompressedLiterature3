

public class MyArrayList <Type extends Comparable<Type>>{
    private int capacity = 16;
    private Type[] list = (Type[]) new Comparable[capacity];
    public long comparisons = 0;

    private int size = 0;



    public void insert(Type item, int index){
        if(index<=capacity && index>=0){
            size++;
            if(size>capacity){
                resize();
            }
            for(int i = size-1; i>index; i--){
                list[i] = list[i-1];
            }
            list[index] = item;
        }

    }
    public Type remove(int index){
        if(index<size && index>=0){
            Type data = list[index];
            list[index] = null;
            for(int i = index ; i<size; i++){
                if(i+1 == capacity || list[i+1] == null){
                    list[i] = null;
                } else{
                    list[i] = list[i+1];
                }

            }
            size--;
            return data;
        }
        else{
            return null;
        }
    }
    //Upgrade to use comparable
    public boolean contains(Type item){
        comparisons++;
        for(int i = 0; i<size;i++){
            comparisons++;
            if(item.compareTo(list[i]) == 0){

                return true;
            }
        }

        return false;
    }
    //Upgrade to use comparable
    public int indexOf(Type item){
        for(int i = 0; i<size;i++){
            if(item.compareTo(list[i]) == 0){
                return i;
            }
        }
        return -1;
    }
    public Type get(int index){
        if(index<size && index>=0){
            return list[index];
        }
        return null;
    }
    public void set(int index, Type item){
        if(index<size && index>=0) {
            list[index] = item;
        }
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public String toString(){
        if(size == 0){
            return "[]";
        }
        StringBuilder string = new StringBuilder("[" + list[0]);
        for (int i = 1; i<size;i++){
            string.append(", ").append(list[i]);
        }
        string.append("]");
        return string.toString();
    }
    private void resize(){
        capacity = capacity*2;
        Type[] temp = (Type[]) new Comparable[capacity];

        for(int i=0; i<size-1;i++){
            temp[i] = list[i];
        }
        list = temp;
    }

    public void sort(){

        Type temp;

        for(int i = 0; i < size ; i++){

            for(int j = 0; j < size - i -1; j++){

                if(get(j).compareTo(get(j+1)) > 0){
                    temp = get(j);
                    set(j,get(j+1));
                    set(j+1, temp);
                }

            }
        }

    }

}
