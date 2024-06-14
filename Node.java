public class Node<T extends Comparable<T>> {
   protected T val;
   protected Node<T> right;
   protected Node<T> left;
   protected int height;

   public Node(T val){
      this.val = val;
      this.height = 1;
   }
}
