//{ Driver Code Starts
import java.util.*;



class Get_Min_From_Stack
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int q = sc.nextInt();
			GfG g = new GfG();
			while(q>0)
			{
				int qt = sc.nextInt();
				
				if(qt == 1)
				{
					int att = sc.nextInt();
					g.push(att);
					//System.out.println(att);
				}
				else if(qt == 2)
				{
					System.out.print(g.pop()+" ");
				}
				else if(qt == 3)
				{
					System.out.print(g.getMin()+" ");
				}
			
			q--;
			}
			System.out.println();
		T--;
		}
		
	}
}



// } Driver Code Ends


class GfG

{

    // int minEle;

    Stack<Integer> s=new Stack();

 

    /*returns min element from stack*/

    int minV=Integer.MAX_VALUE;

    Stack<Integer>s2=new Stack();

    int getMin()

    {

 // Your code here 

     if(s.isEmpty()){

         return -1;

     }

     return minV;

    }

    

    /*returns poped element from stack*/

    int pop()

    {

 // Your code here

     int v=0;

   if(!s.isEmpty()){

        

     v=s.peek();

     if(v==minV){

         s.pop();

         minV=Integer.MAX_VALUE;

         while(!s.isEmpty()){

             int element=s.peek();

             if(element<=minV){

                 minV=element;

             }

             s2.push(element);

             s.pop();

         }

         while(!s2.isEmpty()){

             int e=s2.peek();

             s2.pop();

             s.push(e);

         }

         return v;

     }else{

         return s.pop();

    }

   }

    return -1;

    }

 

    /*push element x into the stack*/

    void push(int x)

    {

 // Your code here

     if(x<=minV){

         minV=x;

     }

       s.push(x);

 

    } 

}

