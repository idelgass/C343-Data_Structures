public interface Array2DIntADT {
    //Set array[i][j] to num
    void set(int x, int y, int num);

    //Get array[i][j]
    int get(int x, int y);

    //Sets entire matrix to 0
    void setElementsToZero();

    //Returns array corresponding to row i
    int[] rowGet(int x);

    //Delete row i and shift >i rows up
    void rowDelete(int x);

    //Returns array corresponding to column j
    int[] columnGet(int y);

    //Delete column j and shift >j rows left
    void columnDelete(int y);
}
