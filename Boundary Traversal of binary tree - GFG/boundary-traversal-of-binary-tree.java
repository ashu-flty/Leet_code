//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            
            ArrayList <Integer> res = T.boundary(root);
            for (Integer num : res) System.out.print (num + " ");
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends

class Solution

{

    boolean isLeaf(Node root){

        return root.left==null && root.right==null;

    }

    public void addLeftBoundary(Node root,ArrayList<Integer> ans){

        Node x=root.left;

        while(x!=null){

            if(isLeaf(x)==false) ans.add(x.data);

            if(x.left!=null) x=x.left;

            else{

                x=x.right;

            }

        }

    }

    public void addRightBoundary(Node root,ArrayList<Integer> answer){

        Node x=root.right;

        ArrayList<Integer> ans=new ArrayList<>();

        while(x!=null){

            

            if(isLeaf(x)==false) ans.add(x.data);

            if(x.right!=null) x=x.right;

            else x=x.left;

    }

    for(int i=ans.size()-1;i>=0;i--){

        answer.add(ans.get(i));

    }

    }

    void addLeafNode(Node root,ArrayList<Integer> ans){

        if(isLeaf(root)){

            ans.add(root.data);

            return;

        }

        if(root.left!=null) addLeafNode(root.left,ans);

        if(root.right!=null) addLeafNode(root.right,ans);

    }

 ArrayList <Integer> boundary(Node node)

 {

     ArrayList<Integer> ans=new ArrayList<>();

     if(isLeaf(node)==false) ans.add(node.data);

     addLeftBoundary(node,ans);

     addLeafNode(node,ans);

     addRightBoundary(node,ans);

     return ans;

 }

}
