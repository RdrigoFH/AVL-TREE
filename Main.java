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

      tree.preOrder();
  }
   
}
