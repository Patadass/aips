public class DLL<E>{
    private DLLNode<E> first,last;
    public DLL(){
        this.first = null;
        this.last = null;
    }
    public void insertFirst(E o){
        DLLNode<E> ph = new DLLNode<>(o, null, first);
        if(first == null){
            last = ph;
        }else{
            first.pred = ph;
        }
        first = ph;
    }
    public void insertLast(E o){
        if(first == null){
            insertFirst(o);
        }else{
            DLLNode<E> ph = new DLLNode<>(o, last, null);
            last.succ = ph;
            last = ph;
        }
    }
    public void insertAfter(E o, DLLNode<E> node){
        if(node == last){
            insertLast(o);
        }
        DLLNode<E> ph = new DLLNode<>(o,node,node.succ);
        node.succ.pred = ph;
        node.succ = ph;
    }
    public void insertBefore(E o, DLLNode<E> node){
        if(node == first){
            insertFirst(o);
        }
        DLLNode<E> ph = new DLLNode<>(o, node.pred, node);
        node.pred.succ = ph;
        node.pred = ph;
    }
    public E deleteFirst(){
        if(first != null){
            DLLNode<E> ph = first;
            first = first.succ;
            if(first != null){
                first.pred = null;
            }else{
                last = null;
            }
            return ph.element;
        }
        return null;

    }
    public E deleteLast(){
        if(last != null){
            DLLNode<E> ph = last;
            last = last.pred;
            if(last != null){
                last.succ = null;
            }else{
                first = null;
            }
            return ph.element;
        }
        return null;
    }
    public E delete(DLLNode<E> node){
        if(node == first){
            deleteFirst();
        }
        if(node == last){
            deleteLast();
        }
        node.pred.succ = node.succ;
        node.succ.pred = node.pred;
        return node.element;
    }



    public DLLNode<E> getLast(){
        return last;
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder("[");
        DLLNode<E> ph = first;
        while(ph != null){
            s.append(ph.element).append((ph.succ != null) ? "," : "");
            ph = ph.succ;
        }
        s.append("]");
        return s.toString();
    }
}
