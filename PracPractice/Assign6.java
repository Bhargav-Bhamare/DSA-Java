package PracPractice;

public class Assign6 {
    //N Queen 
    
    public static void printBoard(char board[][]){
        System.out.println("---------Chess Board----------");
        for(int i =0;i<board.length;i++){
            for(int j =0;j<board.length;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean isSafe(char board[][], int row, int col){
        //Vertical Up
        for(int i = row-1;i>=0;i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        //Diagonal Left Up
        for(int i = row-1,j=col-1;)
    }
    public static void nQueens(char board[][], int row){
        if(row == board.length){
            printBoard(board);
            return;
        }
        for(int j = 0;j < board.length;j++){
            if(isSafe(board,row,j)){
                board[row][j] = 'Q';
                nQueens(board, row+1);
                board[row][j] = 'x';
            }
        }
    }
    
}
