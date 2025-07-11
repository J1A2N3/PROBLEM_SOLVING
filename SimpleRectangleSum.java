package DSA_PRBLMS;
public class SimpleRectangleSum {
    public static void main(String[] args) {
        int[][] mat = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9,10,11,12},
            {13,14,15,16}
        };
        int r1 = 1, c1 = 1, r2 = 3, c2 = 3;
        int sum = 0;
        System.out.println("Rectangle:");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
            	//printing submatrix
                if (i >= r1 && i <= r2 && j >= c1 && j <= c2) {
                    System.out.print(mat[i][j] + " ");
                    sum += mat[i][j];
                } 
            }
            System.out.println();
        }
        System.out.println("Rectangle Sum: " + sum);
    }
}
/*
INPUT:
mat = {
{1, 2, 3, 4},
{5, 6, 7, 8},
{9,10,11,12},
{13,14,15,16}
}
r1 = 1, c1 = 1
r2 = 2, c2 = 2

OUTPUT:
Rectangle:      
 6 7 
10 11       
Rectangle Sum: 34

TIME COMP: O(N square)
SPACE COMP: O(1)
*/