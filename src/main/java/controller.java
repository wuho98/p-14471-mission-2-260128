import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class controller {
    List<sayList> list = new LinkedList<>();
    int count = 0;
    Scanner sc;

    public controller(Scanner sc){
        this.sc = sc;
    }
    //명언 등록 깃허브
    public void add(){
        count++;
        System.out.print("명언 :");
        String say = sc.nextLine();
        System.out.print("작가 :");
        String author = sc.nextLine();

        sayList sl = new sayList(count, say, author);
        list.add(sl);

        System.out.println(count + "번 명언이 등록되었습니다.");

    }
    //명언 삭제
    public void delete(int id){
        sayList found = findById(id);
        if(found == null){
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }

        list.remove(found);
        System.out.println(id + "번 명언이 삭제되었습니다.");

    }
    //명언 수정
    public void update(int id){
        sayList found = findById(id);
        if(found == null){
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }

        System.out.println("명언(기존) : " + found.say);
        System.out.print("명언 : ");
        found.say = sc.nextLine();

        System.out.println("작가(기존) : " + found.author);
        System.out.print("작가 : ");
        found.author = sc.nextLine();
    }
    //목록 있는지 찾기
    public void listUp(){
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for (int i = list.size() - 1; i >= 0; i--) {
            sayList s = list.get(i);
            System.out.println(s.id + " / " + s.author + " / " + s.say);

        }
    }
    // 명언이 목록 안에 있는지 찾기
    private sayList findById(int id){
        for (sayList s : list){
            if(id == s.id){
                return s;
            }
        }
        return null;
    }
}
