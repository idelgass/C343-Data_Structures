public class RunTimesCalculator {
    public void instrCount(int n)
    {
        int sum2 = 0;
        for(int i = 1; i <= n; i ++)
        {
            for(int j = 1; j <= n; j ++)
            {
                sum2 ++;
            }
        }
        int sum3 = 0;
        for(int i = 1; i <= n; i ++)
        {
            for(int j = 1; j <= i; j ++)
            {
                sum3 ++;
            }
        }
        System.out.println("Example 1 with n = " + n +"...");
        System.out.println("instrCounter = " + sum2 + " | (instrCounter / n) = " + sum2/n);
        System.out.println("");
        System.out.println("Example 2 with n = " + n +"...");
        System.out.println("instrCounter = " + sum3 + " | (instrCounter / n) = " + sum3/n);
        System.out.println("\n");
    }
}
