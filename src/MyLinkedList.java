public class MyLinkedList <Type extends Comparable<Type>>{

    private Node first = null;
    private Node current = null;
    private Node previous = null;
    private int size = 0;
    public long comparisons = 0;

    private class Node {
        Type item;
        Node next;

        Node(Type data){
            this.item = data;
            this.next = null;
        }
        public String toString(){
            return item.toString();
        }

    }
    public void addBefore(Type item){
        Node newNode = new Node(item);

        if(current == first){
            first = newNode;
            previous = first;
            previous.next = current;
        } else{
            newNode.next = current;
            previous.next = newNode;
            previous = previous.next;

        }
        size++;
    }
    public void addAfter(Type item){
        if(current != null){
            Node newNode = new Node(item);
            if (current.next != null) {
                newNode.next = current.next;
            }
            current.next = newNode;
            size++;

        }
    }
    public Type remove(){
        if(current != null){
            Type data = current.item;
            if(current == first){
                first = first.next;
                current = first;
            } else{
                current = previous;
                current.next = current.next.next;
                current = current.next;

            }

            size --;
            return data;
        }
        return null;
    }
    public Type current(){
        if(current == null){
            return null;
        } else{
            return current.item;
        }
    }
    public Type first(){
        if(first == null){
            return null;
        } else{
            current = first;
            previous = null;
            return current.item;
        }
    }
    public Type next(){
        if(current.next != null){
            previous = current;
            current = current.next;
            return current.item;
        } else {
            previous = current;
            current = null;
            return null;
        }
    }

    public boolean contains(Type item){
        Node tempNode = first;
        comparisons++;
        while(tempNode != null){
            comparisons++;
            if(tempNode.item.compareTo(item) == 0){
                return true;
            }
            tempNode = tempNode.next;
        }
        return false;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void sort(){
        if(first != null){
            current = first;
            Type temp;

            for(int i = 0; i < size ; i++){
                current = first;

                for(int j = 0; j < size - i -1; j++){

                    if(current.item.compareTo(current.next.item) > 0){
                        temp = current.item;
                        current.item = current.next.item;
                        current.next.item = temp;

                    }
                    current = current.next;

                }
            }
        }

    }
    public String toString(){
        Node tempNode = first;
        if(tempNode == null){
            return "[]";
        }
        StringBuilder string = new StringBuilder("[" + tempNode);
        if(tempNode.next != null){
            string.append(", ");
        }
        tempNode = tempNode.next;
        while(tempNode != null){
            string.append(tempNode);
            if (tempNode.next != null){
                string.append(", ");
            }
            tempNode = tempNode.next;
        }
        string.append("]");
        return string.toString();
    }



}
