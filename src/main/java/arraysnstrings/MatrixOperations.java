package arraysnstrings;

import java.util.HashSet;

public class MatrixOperations {
	int [][] matrix;
	int rows;
	int cols;

	public MatrixOperations(int [][] matrix,int rows,int cols){
		this.matrix=matrix;
		this.rows=rows;
		this.cols=cols;
	}

	public  void printMatrix(){

		for(int i=0;i<rows;i++){
			for (int j=0;j<cols;j++)
			{
				System.out.print(matrix[i][j]+",");

			}
			System.out.println();
		}
	}


	public void  setMatrix0 (){
		HashSet<Integer> rowSet = new HashSet<Integer>();
		HashSet<Integer> colSet = new HashSet<Integer>();
		for (int j=0;j<cols;j++)
			for(int i=0;i<rows;i++){

				if(matrix[i][j]==0){
					rowSet.add(i);
					colSet.add(j);
				}
			}

		for(int a=0;a<rows;a++){
			for(int b:colSet){
				matrix[a][b]=0;
			}
		}
		for(int a=0;a<cols;a++){
			for(int b:rowSet){
				matrix[a][b]=0;
			}
		}


	}


	public static void main(String[] args) {
		int [][] matrix ={{1,2,0},{0,3,3},{1,2,8}};

		MatrixOperations mo = new MatrixOperations(matrix, 3, 3);
		mo.printMatrix();
		mo.setMatrix0();
		mo.printMatrix();

	}

}

