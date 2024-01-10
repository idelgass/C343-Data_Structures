import java.util.ArrayList;

public class TheTweeter {
    private ArrayList<TweetClass> tweetList;

    public TheTweeter() {tweetList = new ArrayList<>();}

    public ArrayList<TweetClass> getTweetList() {return new ArrayList<>(tweetList);}
    public void setTweetList(ArrayList<TweetClass> tweetList) {this.tweetList = tweetList;}

    public void add(TweetClass tweet){tweetList.add(tweet);}
    public void remove(String author)
    {
        for(TweetClass tweet : tweetList)
        {
            if (tweet.getAuthor() == author) {tweetList.remove(tweet);}
        }
    }
    public TweetClass get(String author)
    {
        for(TweetClass tweet : tweetList)
        {
            if (tweet.getAuthor() == author) {return tweet;}
        }
        return null;
    }

    public String tweetListToString() // Converts tweetlist to a comma separated string with each tweet being represented by the author
    {
        String output = "";
        for (TweetClass tweet : tweetList) {
            if (tweetList.get(0) == tweet) {output += tweet.getAuthor();} //only runs for first card to avoid comma being placed at start of string
            else {output += ", " + tweet.getAuthor();}
        }
        return output;
    }

    public static void main(String[] args) {
        TheTweeter theTweeter = new TheTweeter();
        TweetClass testTweet1 = new TweetClass("content1", "author1");
        TweetClass testTweet2 = new TweetClass("content2", "author2");
        TweetClass testTweet3 = new TweetClass("content3", "author3");
        TweetClass testTweet4 = new TweetClass("content4", "author4");
        TweetClass testTweet5 = new TweetClass("content5", "author5");
        TweetClass testTweet6 = new TweetClass("content6", "author6");


        System.out.println(theTweeter.tweetListToString());
        theTweeter.tweetList.add(testTweet1);
        theTweeter.tweetList.add(testTweet2);
        theTweeter.tweetList.add(testTweet3);
        theTweeter.tweetList.add(testTweet4);
        theTweeter.tweetList.add(testTweet5);
        theTweeter.tweetList.add(testTweet6);
        System.out.println(theTweeter.tweetListToString());
        theTweeter.tweetList.remove(testTweet1);
        System.out.println(theTweeter.tweetListToString());
        System.out.println(theTweeter.get("author4").getContent());


    }
}
