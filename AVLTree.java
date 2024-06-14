public class AVLTree<T extends Comparable<T>> {
   private Node<T> root;

   public AVLTree() {
      this.root = null;
   }


   private int height(Node<T> node) {
      if(node == null)
         return 0;
      else 
         return node.height;
   }

   private Node<T> rightRotate(Node<T> y) {
      Node<T> x = y.left;
      // aux -> left son y
      Node<T> aux = x.right;
      // x = raiz -> y rigth son
      x.right = y;   
      y.left = aux;

      
      y.height = Math.max(height(y.left), height(y.right)) + 1;
      x.height = Math.max(height(x.left), height(x.right)) + 1;

      return x;
   }


   private Node<T> leftRotate(Node<T> x) {
      Node<T> y = x.right;
      Node<T> aux = y.left;

      y.left = x;
      x.right = aux;

      x.height = Math.max(height(x.left), height(x.right)) + 1;
      y.height = Math.max(height(y.left), height(y.right)) + 1;

      return y;
   }

   private int getBalance(Node<T> node) {
      if(node == null){
         return 0;
      }else
         return height(node.left) - height(node.right);
   }

   public void insert(T val) {
      root = insert(root, val);
   }

   private Node<T> insert(Node<T> node, T val) {
      if (node == null) {
         return new Node<>(val);
      }

      if (val.compareTo(node.val) < 0) {
         node.left = insert(node.left, val);
      } else if (val.compareTo(node.val) > 0) {
         node.right = insert(node.right, val);
      } else {
         return node; 
      }

      node.height = 1 + Math.max(height(node.left), height(node.right));

      int balance = getBalance(node);


      // Left Left 
      if (balance > 1 && val.compareTo(node.left.val) < 0) {
         return rightRotate(node);
      }

      // Right Right 
      if (balance < -1 && val.compareTo(node.right.val) > 0) {
         return leftRotate(node);
      }

      // Left Right 


      // Right Left 


      return node;
   }

   public void preOrder() {
      preOrderAux(root);
   }

   public void preOrderAux(Node<T> node) {
      if (node != null) {
         System.out.print(node.val + " ");
         preOrderAux(node.left);
         preOrderAux(node.right);
      }
   }


}
