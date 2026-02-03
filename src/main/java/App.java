import java.util.Scanner;

public class App {
    public void run(){
        Scanner sc = new Scanner(System.in);
        WiseSayingController control = new WiseSayingController(sc);

        // 반복문
        while (true) {
            System.out.println("== 명언 앱 ==");
            System.out.print("명령) ");

            String cmd = sc.nextLine();
            Rq rq = new Rq();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                control.add();
            } else if (cmd.startsWith("삭제")) {
                rq.parse(cmd);
                if(rq.isValid()) {
                    control.delete(rq.getId());
                }
            } else if (cmd.startsWith("수정")){
                rq.parse(cmd);
                if(rq.isValid()) {
                    control.update(rq.getId());
                }
            } else if (cmd.equals("목록")){
                control.listUp();
            } else {
                System.out.println("명령어를 다시 입력하세요");
            }
        }
    }
}
