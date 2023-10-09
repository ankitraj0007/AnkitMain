package designpattern.behavioural.iterator;

import java.util.List;

public class NameIterator implements MyIterator{

    String[] names;
    int index;

    public NameIterator(String[] names) {
        this.names = names;
    }

    @Override
    public boolean hasNext() {
        return index < names.length;
    }

    @Override
    public String next() {
        if(hasNext()){
            return names[index++];
        }else {
            return null;
        }
    }
}
