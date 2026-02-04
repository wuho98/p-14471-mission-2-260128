public class Rq {
    private String command;
    private int id;
    private boolean valid;

    public Rq(String cmd){
        this.command = cmd;
        valid = false;

        String[] cmdArr = command.split("\\?" , 2);
        if(cmdArr.length < 2){
            System.out.println("명령어를 다시 입력하세요");
            return;
        }

        String queryString = cmdArr[1];
        String[] params = queryString.split("=", 2);

        if(params.length == 2 && params[0].equals("id")){
            try {
                this.id = Integer.parseInt(params[1]);
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("id는 숫자여야 합니다.");
            }
        }


    }

    public boolean isValid() {
        return valid;
    }

    public int getId() {
        return id;
    }
}
