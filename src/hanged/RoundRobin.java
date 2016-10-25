package hanged;

import java.util.ArrayList;

public class RoundRobin<T> extends ArrayList {

    public RoundRobin() {
        super();
    }

    public T next() {
        T first = (T) this.get(0);
        this.remove(first);
        this.add(first);
        return first;
    }

    public T getCurrent() {
        return (T)this.get(0);
    }
}
