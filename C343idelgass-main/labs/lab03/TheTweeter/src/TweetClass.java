public class TweetClass {
    private String content;
    private String author;

    public String getContent() {return content;}
    public void setContent(String content) {this.content = content;}
    public String getAuthor() {return author;}
    public void setAuthor(String author) {this.author = author;}

    public TweetClass(String content, String author)
    {
        this.content = content;
        this.author = author;
    }

    public void printContent(){System.out.println(getContent());}

    public boolean contains(String s)
    {
        if (content.contains(s)) {return true;}
        else {return false;}
    }

    public static void main(String[] args) {
        TweetClass testTweet = new TweetClass("It is now possible to learn about a person's mobility preferences from data generated by their smartphone", "someperson");
        System.out.println(testTweet.getContent());
        System.out.println(testTweet.getAuthor());
        System.out.println("testTweet contains \"mobility\": " + testTweet.contains("mobility"));
        System.out.println("testTweet contains \"Arrakis\": " + testTweet.contains("Arrakis"));
    }
}
