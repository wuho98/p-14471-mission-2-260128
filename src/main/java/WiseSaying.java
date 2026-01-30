public class WiseSaying {
    private int id; //이름
    private String say; //명언
    private String author; //작가

    public WiseSaying(int id, String say, String author){
        this.id = id;
        this.say = say;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getSay() {
        return say;
    }

    public void setSay(String say) {
        this.say = say;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
