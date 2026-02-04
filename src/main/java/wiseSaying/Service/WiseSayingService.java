package wiseSaying.Service;

import wiseSaying.entity.WiseSaying;
import wiseSaying.repository.WiseSayingRepository;

import java.util.List;

public class WiseSayingService {
    WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();

    public WiseSaying add(String author, String saying){
        return wiseSayingRepository.add(saying, author);
    }

    public boolean delete(int id){
        WiseSaying found = wiseSayingRepository.findById(id);
        if(found == null){
            return false;
        }

        wiseSayingRepository.delete(id);

        return true;
    }

    public WiseSaying update(int id){
        return wiseSayingRepository.update(id);
    }

    public List<WiseSaying> findAll() {
        return wiseSayingRepository.findAll();
    }

    public void modify(WiseSaying ws, String say, String author){
        ws.setSay(say);
        ws.setAuthor(author);
    }
}
