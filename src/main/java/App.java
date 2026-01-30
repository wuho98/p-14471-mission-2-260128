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

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                control.add();
            } else if (cmd.startsWith("삭제")) {
                String[] str = cmd.split("=");
                try {
                    int id = Integer.parseInt(str[1]);
                    control.delete(id);
                }catch (NumberFormatException e){
                    System.out.println("다시 하시오");
                }
            } else if (cmd.startsWith("수정")){
                String[] str = cmd.split("=");
                try {
                    int id = Integer.parseInt(str[1]);
                    control.update(id);
                }catch (NumberFormatException e){
                    System.out.println("다시 하시오");
                }
            } else if (cmd.equals("목록")){
                control.listUp();
            }
        }
    }
}
