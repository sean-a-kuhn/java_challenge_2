/* This program takes a node from a directed graph of GNodes and returns an ArrayList containing
*  all possible paths from the passed in node to all accessible leaf nodes.
*/

import java.util.ArrayList;

public class GNodePaths{
   public static void main(String[] args){
   
      public ArrayList<ArrayList<GNode>> paths(GNode node){
      
         // create ArrayList to hold ArrayLists of GNodes
         ArrayList<ArrayList<GNode>> returnMe = new ArrayList<ArraList<GNode>>();
         
         // create ArrayList to hold GNodes
         ArrayList<GNode> al = new ArrayList<GNode>();
         
         // run function that adds paths to ArrayList returnme
         returnMe = findPaths(al, node);
         
         // send updated ArrayList to function call
         return returnMe;        
      }   
   }

   /* This function passes in a GNode of a directed graphs and generates an arraylist of GNode arraylists 
   *     representing all possible paths from the passed in node to its leaf nodes
   *  function receives the following arguments:
   *     Arraylist returnPaths: two-dimensional arraylist to hold arraylists of all GNode paths from passed in
   *        root node to all leaf GNodes
   *     ArrayList currentPath: one-dimensional arraylist to hold list of orderd GNodes in path from
   *        root node to a leaf node
   *     GNode node: an object of type GNode
   *  function returns two-dimensional arraylist
   */
   public void ArrayList<ArrayList<GNode>> findPaths(ArrayList currentPath, GNode node){
      
      // Generate 2d arraylist(arraylist of GNode arraylists) to return to method call
      ArrayList<ArrayList<Gnode>> returnPaths = new ArrayList<ArrayList<GNode>>();
      
      /* Create a local arraylist to represent currently generated path of GNodes by copying passed in 
      *     arraylist of GNodes and appending current node
      *  This creates a shallow copy of the one-dimensional arraylist, and doesn't alter the contained GNodes
      */
      ArrayList<GNode> copyCurrentPath = new ArrayList<GNode>(currentPath);
      copyCurrentPath.add(node);
      
      // Create array representing children GNodes of current GNode
      GNode[] children = node.getChildren();
      
      // If current node has no child(ren), then GNode is leaf and can add path to two-dimensional arraylist
      if (children.length == 0){
         returnPaths.add(copyCurrentPath);      
      }
      
      // If current node has child(ren), continue appending 2d arraylists to returnPaths through all children 
      //    nodes by calling function on parameters *copyCurrentPath and each child node
      else {      
         for (GNode child : children){
            returnPaths.addAll(findPaths(copyCurrentPath, child));
         }
      }
      // Send 2d arraylist to method call
      return returnPaths; 
   }
}