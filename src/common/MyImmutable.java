package common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyImmutable {

    private final int id;
    private final String name;
    private final Map<Integer,String> map;
    private final List<String> list;

    public MyImmutable(int id, String name, Map<Integer,String> map, List<String> list){
        this.list = list;
        this.id = id;
        this.map = map;
        this.name = name;
    }

    //getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<Integer, String> getMap() {
        return new HashMap<>(map);
    }

    public List<String> getList() {
        return new ArrayList<>(list);
    }
}
