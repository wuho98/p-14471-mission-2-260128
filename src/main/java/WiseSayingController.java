import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    List<WiseSaying> list = new LinkedList<>();
    int count = 0;
    Scanner sc;

    public WiseSayingController(Scanner sc){
        this.sc = sc;
    }
    //명언 등록
    public void add(){
        count++;
        System.out.print("명언 :");
        String say = sc.nextLine();
        System.out.print("작가 :");
        String author = sc.nextLine();

        WiseSaying sl = new WiseSaying(count, say, author);
        list.add(sl);

        System.out.println(count + "번 명언이 등록되었습니다.");

    }
    //명언 삭제
    public void delete(int id){
        WiseSaying found = findById(id);
        if(found == null){
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }

        list.remove(found);
        System.out.println(id + "번 명언이 삭제되었습니다.");

    }
    //명언 수정
    public void update(int id){
        WiseSaying found = findById(id);
        if(found == null){
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }

        System.out.println("명언(기존) : " + found.getSay());
        System.out.print("명언 : ");
        found.setSay(sc.nextLine());

        System.out.println("작가(기존) : " + found.getAuthor());
        System.out.print("작가 : ");
        found.setAuthor(sc.nextLine());
    }
    //목록 있는지 찾기
    public void listUp(){
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for (int i = list.size() - 1; i >= 0; i--) {
            WiseSaying s = list.get(i);
            System.out.println( s.getId() + " / " + s.getAuthor() + " / " + s.getSay());

        }
    }
    // 명언이 목록 안에 있는지 찾기
    private WiseSaying findById(int id){
        for (WiseSaying s : list){
            if(id == s.getId()){
                return s;
            }
        }
        return null;
    }
}
