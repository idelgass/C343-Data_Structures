public class CountingInstructions {
    public static void main(String[] args) {
        RunTimesCalculator myCalc = new RunTimesCalculator();
        myCalc.instrCount(10);
        myCalc.instrCount(100);
        myCalc.instrCount(1000);
        myCalc.instrCount(10000);
    }
}
