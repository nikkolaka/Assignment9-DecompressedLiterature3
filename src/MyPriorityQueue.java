public class MyPriorityQueue <Type extends Comparable<Type>>{
    private MyArrayList<Type> heap = new MyArrayList<>();

    public void insert(Type item){
        heap.insert(item, heap.size());
        bubbleUp();
    }

    public Type removeMin(){
        Type temp = min();
        swap(0,size()-1);
        heap.remove(size()-1);
        sinkDown();
        return temp;
    }

    public Type min(){
        return heap.get(0);
    }

    public int size(){
        return heap.size();

    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public String toString(){
        return heap.toString();
    }

    private void bubbleUp(){
        if(heap.get(size()-1).compareTo(heap.get(parent(size()-1))) < 0){
            swap(size()-1,parent(size()-1));
            bubbleUp(parent(size()-1));
        }
    }
    private void bubbleUp(int index){
        if(heap.get(index).compareTo(heap.get(parent(index))) < 0){
            swap(index, parent(index));
            bubbleUp(parent(index));
        }
    }


    private void sinkDown(){
    if (left(0) < size()){
        if(heap.get(right(0)) == null ||heap.get(left(0)).compareTo(heap.get(right(0))) < 0){
            if(min().compareTo(heap.get(left(0))) > 0){
                swap(left(0),0);
                sinkDown(left(0));
            }
        } else{
            if(min().compareTo(heap.get(right(0))) > 0){
                swap(right(0),0);
                sinkDown(right(0));
            }
        }
    }


    }
    private void sinkDown(int index){
        if(left(index)<size()){
            if(heap.get(right(index)) == null || heap.get(left(index)).compareTo(heap.get(right(index))) < 0){
                if(heap.get(index).compareTo(heap.get(left(index))) > 0){
                    swap(left(index),index);
                    sinkDown(left(index));
                }
            }
        }
        if(right(index)<size()){
            if(heap.get(index).compareTo(heap.get(right(index))) > 0){
                swap(right(index),index);
                sinkDown(right(index));
            }
        }
    }

    private int parent(int index){
        if(index<3){
            return 0;
        }
        if(index % 2 == 0){
            return (index /2)-1;
        }
        return (index-1)/2;
    }

    private int right(int index){
        return (2*index)+2;
    }

    private int left(int index){
        return 2*index+1;
    }
    private void swap(int index1, int index2){
        Type temp = heap.get(index1);
        heap.set(index1,heap.get(index2));
        heap.set(index2, temp);
    }

}
