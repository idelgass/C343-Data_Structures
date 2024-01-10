import java.util.Random;

public class RandomDNA {

    public String generateDNAstring(int n) {
        String lDNA = "";
        Random lRandomizer = new Random();

        // place your Lab 01 implementation here
        for (int i = 1; i < n; i++) {
            switch (lRandomizer.nextInt(4)){
                case 0:
                    lDNA += "A";
                    break;
                case 1:
                    lDNA += "T";
                    break;
                case 2:
                    lDNA += "C";
                    break;
                case 3:
                    lDNA += "G";
                    break;
            }
        }
        return lDNA;
    }

    // a test client
    public static void main(String[] argv) {
        RandomDNA myRandomDNA = new RandomDNA();
        String myDNAstring = "";
        for (int i = 10; i<=1000; i = i * 10) {
            System.out.println("");
            myDNAstring = myRandomDNA.generateDNAstring(i);
            System.out.println("a DNA sequence " + i + " characters long: " + myDNAstring);
        }

        DNAHammingDistance dnaHammingDistance = new DNAHammingDistance();
        String dnaString1 = myRandomDNA.generateDNAstring(100);
        String dnaString2 = myRandomDNA.generateDNAstring(100);
        String dnaString3 = myRandomDNA.generateDNAstring(100);

        System.out.println(dnaHammingDistance.computeHammingDistance(dnaString1, dnaString2));
        System.out.println(dnaHammingDistance.computeHammingDistance(dnaString2, dnaString3));
        System.out.println(dnaHammingDistance.computeHammingDistance(dnaString1, dnaString3));
    }
}
