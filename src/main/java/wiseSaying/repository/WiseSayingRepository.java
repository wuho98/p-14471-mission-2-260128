package wiseSaying.repository;

import wiseSaying.entity.WiseSaying;

import java.util.LinkedList;
import java.util.List;

public class WiseSayingRepository {
    private final List<WiseSaying> list = new LinkedList<>();
    private int count = 0;

    public WiseSaying add(String saying, String author){
        count++;
        WiseSaying ws = new WiseSaying(count, saying, author);
        list.add(ws);
        return ws;
    }

    public WiseSaying delete(int id){
        WiseSaying found = findById(id);
        if(found == null){
            return null;
        }

        list.remove(found);
        return found;
    }

    public WiseSaying update(int id){
        WiseSaying found = findById(id);
        if(found == null){
            return null;
        }

        return found;
    }

    public List<WiseSaying> findAll(){
        return list;
    }

    public WiseSaying findById(int id){
        for (WiseSaying s : list){
            if(id == s.getId()){
                return s;
            }
        }
        return null;
    }
}
