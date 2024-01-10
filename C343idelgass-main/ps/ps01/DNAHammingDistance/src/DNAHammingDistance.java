public class DNAHammingDistance {
    public  int computeHammingDistance(String s1, String s2) throws IllegalArgumentException
    {
        int hammingDist = 0;
        if (s1.length() != s2.length()) {throw new IllegalArgumentException();}
        else
        {
            for(int i = 0; i < s1.length(); i++)
            {
                if (s1.charAt(i) != s2.charAt(i)) {hammingDist++;}
            }
            return hammingDist;
        }
    }
}
