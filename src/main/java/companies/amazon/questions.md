Challenging situationns you faced and how you resolved them.

//utkarsh
sdlkfjldkfj

find the size of largest connected component in a given binary matrix
horizontally and vertically adjacent 1's are connected to each other

1 1 1 0 0
1 0 0 0 1
0 0 0 1 1

Boolean isValid(int x, int y){
 if(x>=matrix.length || x<0) return false;
 if(y>=matrix[0].length || y<0 ) return false;
 
 else return true; 
}

int  findLargestComponent(int [][] matrix){

    int []dirx={1,-1,0,0};
    int []diry={0,0,1,-1};
  int currComponentSize=0,maxComponentSize=Integer.MIN_INTEGER;
   Queue<Integer[]> queue = new LinkedList<>();

  for(int i=0;i<matrix.length;i++)
    for(int j=0;j<matrix[0].length;j++)
   {
   
     if(matrix[i][j]==1){
    
      matrix[i][j] = -1;
     queue.add(new Integer[]{i,j});
     
     
     while(!queue.isEmpty()){
      int [] curr = queue.pop();
      for(int k=0;k<dirx.length;k++){
     
       int newx=curr[0]+dirx[k];
       int newy=curr[1]+diry[k];
     
       if(matrix[newx][newy]==1)
        {
        if(isValid(newx,newy)
        {
         matrix[i][j]=-1;
         curComponentSize++;
         queue.add( new Integer[]{newx,newy})
        }
     }
     
     }
     }
     if(currComponentSize>maxComponentSize){
       maxComponentSize = currComponentSize;
       }
       
       
       return maxComponentSize;
  }
 }
}






answer - 4 


pow(2,3)= 8
pow(3,2) = 9


  pow(2,100000)
  pow(4,50000)
  pow(3,2000) pow(9,1000)
  
  
 Double pow(Double b, Double e)   
      
      if(e>0) return helper(b,e);
     else return 1/helper(b,-1*e);
    
  }  
  
 Double helper(Double b, Double e)
 {
   
     
     if(e==0) return 1;
     
     if(b == 1 || b== 0 || e==1 )
       return b;
       
       
    if(e%2==1) 
      return b*pow(b,e-1)
      else {
      return pow(b*b,e/2);
      }
   
 
 }   
  
  

Double pow(Double base, Double exponent)
{
   
   
   if(exponent>0)
   {
   Double result =1;
   while(exponent-- > 0)
    {
      result*=base; 
        
    }
    return result;
   }
   
   if(exponent<0){
   {
   Double result =1;
   while(exponent++ < 0)
    {
      result/=base; 
        
    }
    return result;
   

}

