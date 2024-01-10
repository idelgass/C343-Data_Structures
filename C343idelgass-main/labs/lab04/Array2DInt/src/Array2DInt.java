import java.util.Arrays;

public class Array2DInt implements Array2DIntADT {
    int[] data;
    int numOfRows;
    int numOfColumns;

    //m = number of rows, n = number of columns
    public Array2DInt(int[] incomingData, int m, int n) {
        data = incomingData;
        numOfRows = m; //Note this is also column length
        numOfColumns = n; //Note this is also row length
    }

    public int convertIndex2DTo1D(int x, int y){return x * numOfColumns + y;}

    public void print(){
        for(int i = 0; i <= data.length - 1; i++){
            System.out.print(data[i]);
            if(i < data.length - 1) {System.out.print(", ");}
            if((i + 1) % numOfColumns == 0) {System.out.println();}
        }
    }

    @Override
    public void set(int x, int y, int num) {data[convertIndex2DTo1D(x,y)] = num;}

    @Override
    public int get(int x, int y) {return data[convertIndex2DTo1D(x,y)];}

    @Override
    public void setElementsToZero() {
        for(int i = 0; i < data.length; i++) {data[i] = 0;}
    }

    @Override
    public int[] rowGet(int x) {
        int[] returnRow = new int[numOfColumns];
        for(int i = 0; i < numOfColumns; i++){
            returnRow[i] = data[convertIndex2DTo1D(x, i)];
        }
        return returnRow;
    }

    @Override
    public void rowDelete(int x) {
        int[] shrunkMatrix = new int[(numOfRows- 1)*numOfColumns];
        int shrunkIndex = 0;
        for(int i = 0; i < data.length; i++){
            if(i < x * numOfColumns - 1 || i > x*numOfColumns + numOfColumns - 1){
                shrunkMatrix[shrunkIndex] = data[i];
                shrunkIndex++;
            }
        }
        data = shrunkMatrix;
        numOfRows--;
    }

    @Override
    public int[] columnGet(int y) {
        int[] returnColumn = new int[numOfRows];
        for(int i = 0; i < numOfRows; i++){
            returnColumn[i] = data[convertIndex2DTo1D(i, y)];
        }
        return returnColumn;
    }

    @Override
    public void columnDelete(int y) {
        int[] shrunkMatrix = new int[(numOfColumns- 1)*numOfRows];
        int shrunkIndex = 0;
        for(int i = 0; i < data.length; i++){
            if(i < y * numOfRows - 1 || i > y*numOfRows + numOfRows - 1){
                shrunkMatrix[shrunkIndex] = data[i];
                shrunkIndex++;
            }
        }
        data = shrunkMatrix;
        numOfColumns--;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6,7,8,9};
        Array2DInt matrix1 = new Array2DInt(arr1,3,3);
        matrix1.print();
        System.out.println();
        System.out.println(Arrays.toString(matrix1.columnGet(1)));
        System.out.println(Arrays.toString(matrix1.rowGet(2)));
        System.out.println();
        matrix1.print();
        System.out.println();
        System.out.println(matrix1.get(0,0));
        System.out.println(matrix1.get(0,2));
        System.out.println(matrix1.get(2,2));
        matrix1.set(1,1,100);
        System.out.println();
        matrix1.print();
        System.out.println();
        matrix1.rowDelete(1);
        System.out.println();
        matrix1.print();
        System.out.println();
        matrix1.setElementsToZero();
        System.out.println();
        matrix1.print();
        System.out.println("\n\n");
        int[] arr2 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        Array2DInt matrix2 = new Array2DInt(arr2,4,4);
        matrix2.print();
        System.out.println();
        System.out.println(Arrays.toString(matrix2.columnGet(2)));
        System.out.println(Arrays.toString(matrix2.rowGet(0)));
        System.out.println();
        matrix2.print();
        System.out.println();
        System.out.println(matrix2.get(1,0));
        System.out.println(matrix2.get(1,2));
        System.out.println(matrix2.get(1,1));
        matrix2.set(0,2,100);
        System.out.println();
        matrix2.print();
        System.out.println();
        matrix2.columnDelete(0);
        System.out.println();
        matrix2.print();
        System.out.println();
        matrix2.setElementsToZero();
        System.out.println();
        matrix2.print();
        System.out.println("\n\n");
        int[] arr3 = {1,2,3,4,5,6,7,8,9,10,11,12};
        Array2DInt matrix3 = new Array2DInt(arr3,3,4);
        matrix3.print();
        System.out.println();
        System.out.println(Arrays.toString(matrix3.columnGet(3)));
        System.out.println(Arrays.toString(matrix3.rowGet(1)));
        System.out.println();
        matrix3.print();
        System.out.println();
        System.out.println(matrix3.get(1,2));
        System.out.println(matrix3.get(2,3));
        System.out.println(matrix3.get(2,0));
        matrix3.set(2,3,100);
        System.out.println();
        matrix3.print();
        System.out.println();
        matrix3.setElementsToZero();
        System.out.println();
        matrix3.print();
        System.out.println("\n\n");
    }
}
