import java.util.Random;

public class RandomDNA {
    public static String RandomDNAGen()
    {
        String s = "";
        Random rand = new Random();
        for (int i = 1; i < 20; i++) {
            switch (rand.nextInt(4)){
                case 0:
                    s += "A";
                    break;
                case 1:
                    s += "T";
                    break;
                case 2:
                    s += "C";
                    break;
                case 3:
                    s += "G";
                    break;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(RandomDNAGen());
    }
}
