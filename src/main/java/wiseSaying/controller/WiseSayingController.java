    package wiseSaying.controller;

    import wiseSaying.Service.WiseSayingService;
    import wiseSaying.entity.WiseSaying;

    import java.util.List;
    import java.util.Scanner;

    public class WiseSayingController {
        private final WiseSayingService wiseSayingService = new WiseSayingService();
        private final Scanner sc;

        public WiseSayingController(Scanner sc){
            this.sc = sc;
        }
        //명언 등록
        public void add(){
            System.out.print("명언 :");
            String say = sc.nextLine();
            System.out.print("작가 :");
            String author = sc.nextLine();

            WiseSaying ws = wiseSayingService.add(author,say);

            System.out.println(ws.getId() + "번 명언이 등록되었습니다.");

        }
        //명언 삭제
        public void delete(int id){
            if(!wiseSayingService.delete(id)){
                System.out.println(id + "번 명언은 존재하지 않습니다.");
                return;
            }
            System.out.println(id + "번 명언이 삭제되었습니다.");
        }

        //명언 수정
        public void update(int id){
            WiseSaying ws = wiseSayingService.update(id);
            if(ws == null){
                System.out.println(id + "번 명언은 존재하지 않습니다.");
                return;
            }

            System.out.println("명언(기존) : " + ws.getSay());
            System.out.print("명언 : ");
            String say = sc.nextLine();

            System.out.println("작가(기존) : " + ws.getAuthor());
            System.out.print("작가 : ");
            String author = sc.nextLine();

            wiseSayingService.modify(ws, say, author);
        }
        //목록 찾기
        public void listUp(){
            List<WiseSaying> ws = wiseSayingService.findAll();
            System.out.println("번호 / 작가 / 명언");
            System.out.println("----------------------");
            for (int i = ws.size() - 1; i >= 0; i--) {
                WiseSaying s = ws.get(i);
                System.out.println(s.getId() + " / " + s.getAuthor() + " / " + s.getSay());
            }
        }
    }
