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
      if (balance > 1 && val.compareTo(node.left.val) > 0) {
         node.left = leftRotate(node.left);
         return rightRotate(node);
      }

      // Right Left 
      if (balance < -1 && val.compareTo(node.right.val) < 0) {
         node.right = rightRotate(node.right);
         return leftRotate(node);
     }

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
   public Node<T> search(T data) {
      return auxSearch(root, data);
   }

   private Node<T> auxSearch(Node<T> root, T data) {
      if (root == null) {
          System.out.println("Elemento no existente");
          return null;
      }
      int rpta = root.val.compareTo(data);
      if (rpta == 0) {
          return root;
      }
      if (rpta > 0) {
          return auxSearch(root.left, data);
      } else {
          return auxSearch(root.right, data);
      }
   }

   private Node<T> min(Node<T> node) {
      while (node.left != null) {
          node = node.left;
      }
      return node;
   }

   private Node<T> max(Node<T> node) {
      while (node.right != null) {
          node = node.right;
      }
      return node;
   }

   public Node<T> parent(T data){
      if(data.equals(root.val) || search(data)==null){
         System.out.println("Nodo Padre inexistente");
         return null;
      }else{
         return parentAux(root, data);
      }
   }
   public Node<T> parentAux(Node<T> root, T data){
      int rpta = root.val.compareTo(data);
      if(rpta > 0){
         if(root.left.val.equals(data)) return root;
         return parentAux(root.left, data);
      }else{
         if(root.right.val.equals(data)) return root;
         return parentAux(root.right, data);
      }
   }

   public void son(T data){
      auxSon(search(data));
   }
   public void auxSon(Node<T> root){
      if(root != null){
         auxSon(root.left);
         System.out.println(root.val);
         auxSon(root.right);
      }
   }
}
