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
        for(int i = row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        //Diagonal Right Up
        for(int i = row-1,j=col+1;i>=0 && j<board.length;i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
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


//Vertex colour Question 

// static int n = 4;

// static int colors = 3;



// static int[][] graph = {

//     {0, 1, 1, 1},

//     {1, 0, 1, 0},

//     {1, 1, 0, 1},

//     {1, 0, 1, 0}

// };



// static int[] color = new int[n];



// static boolean isSafe(int v, int c) {

//     for (int i = 0; i < n; i++) {

//         if (graph[v][i] == 1 && color[i] == c)

//             return false;

//     }

//     return true;

// }



// static boolean solve(int v) {

//     if (v == n)

//         return true;



//     for (int c = 1; c <= colors; c++) {

//         if (isSafe(v, c)) {

//             color[v] = c;



//             if (solve(v + 1))

//                 return true;



//             color[v] = 0;

//         }

//     }



//     return false;

// }



// public static void main(String[] args) {

//     if (solve(0)) {

//         System.out.println("Vertex\tColor");



//         for (int i = 0; i < n; i++)

//             System.out.println(i + "\t" + color[i]);

//     } else {

//         System.out.println("Solution does not exist.");

//     }

// }


