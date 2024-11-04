public class SLL<E>{
    private SLLNode<E> first;
    SLL(){
        this.first = null;
    }
    void insertFirst(E o){
        SLLNode<E> nn = new SLLNode<>(o, null);
        nn.succ = first;
        first = nn;
    }
    void insertLast(E o){
        if(first == null){
            insertFirst(o);
            return;
        }
        SLLNode<E> ph = first;
        while(ph.succ != null){
            ph = ph.succ;
        }
        ph.succ = new SLLNode<>(o,null);
    }
    void insertAfter(E o, SLLNode<E> node){
        if(first == null){
            return;
        }
        SLLNode<E> ph = first;
        while (ph != node && ph.succ != null){
            ph = ph.succ;
        }
        if(ph == node){
            SLLNode<E> nn = new SLLNode<>(o,null);
            nn.succ = ph.succ;
            ph.succ = nn;
        }
    }
    void insertBefore(E o, SLLNode<E> node){
        if(first == null){
            return;
        }
        if(first == node){
            insertFirst(o);
            return;
        }
        SLLNode<E> ph = first;
        while(ph.succ != node && ph.succ.succ != null){
            ph = ph.succ;
        }
        if(ph.succ == node){
            SLLNode<E> nn = new SLLNode<>(o,null);
            nn.succ = ph.succ;
            ph.succ = nn;
        }
    }
    void moveNodeAfter(SLLNode<E> mv,SLLNode<E> node){
        if(first == null || mv == node){
            return;
        }
        delete(mv);
        insertAfter(mv.element, node);
    }
    SLLNode<E> delete(SLLNode<E> node){
        if(first == null){
            return null;
        }
        SLLNode<E> ph = first;
        if(node == first){
            first = first.succ;
            return ph;
        }
        while (ph.succ != node && ph.succ != null){
            ph = ph.succ;
        }
        if(ph.succ == node){
            ph.succ = node.succ;
        }
        return null;
    }

    SLLNode<E> find(E o) {
        if (first == null) {
            return null;
        }
        SLLNode<E> ph = first;
        while (!ph.element.equals(o) && ph.succ != null) {
            ph = ph.succ;
        }
        if (ph.element.equals(o)) {
            return ph;
        }
        return null;
    }
    SLLNode<E> getNode(int pos){
        if(first == null){
            return null;
        }
        SLLNode<E> ph = first;
        for(int i = 0;i < pos && ph != null;i++){
            ph = ph.succ;
        }
        return ph;
    }
    void print(){
        if(first == null){
            return;
        }
        SLLNode<E> ph = first;
        while(ph != null){
            System.out.print(ph.element + " ");
            ph = ph.succ;
        }
    }
}
