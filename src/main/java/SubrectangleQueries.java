class SubrectangleQueries {

    private final int[][] rectangle;

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {

        for (var i = row1; i <= row2; i++) {
            for (var j = col1; j <= col2; j++) {
                this.rectangle[i][j] = newValue;
            }
        }
    }

    // i = [0 -> 3]
    // j = [0 -> 2]

    public int getValue(int row, int col) {
        return rectangle[row][col];
    }
}




// ["SubrectangleQueries"              ,"getValue","updateSubrectangle","getValue" ,"getValue","updateSubrectangle","getValue","getValue"]
// [[[[1,2,1],[4,3,4],[3,2,1],[1,1,1]]],[0,2]     ,[0,0,3,2,5]         ,[0,2]      ,[3,1]     ,[3,0,3,2,10]        ,[3,1]     ,[0,2]]
// [null                               ,1         ,null                ,5          ,5         ,null                ,10        ,5]

// var rectangle= SubrectangleQueries([[[1,2,1],[4,3,4],[3,2,1],[1,1,1]]])
// rectangle.getValue(0,2)
