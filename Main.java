import java.util.Scanner;
public class Main {
   public static void main(String[] args) {
      AVLTree<Integer> tree = new AVLTree<>();
      Scanner sc = new Scanner(System.in);
      System.out.println("Ingrese la palabra");
      String word = sc.nextLine();
      for(int i = 0; i < word.length(); i++){
         tree.insert((int)(word.charAt(i)));
      }
      Node<Integer> aux = tree.parent(49);
      tree.preOrder();
      tree.insert(49);
      tree.insert(10);
      tree.insert(5);
      tree.son(10);
      tree.preOrder();
      tree.search(49);
      tree.insert(89);
      tree.preOrder();

      tree.insert(8);
      tree.preOrder();

      tree.insert(45);
      tree.insert(360);
      tree.insert(21);
      tree.preOrder();
  }
   
}
