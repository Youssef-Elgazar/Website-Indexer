import java.util.*;

public class Menu {
  static Scanner console = new Scanner(System.in);

  public static void display() {
    System.out.println("-------- MENU --------");
    System.out.println("1. Display The Full Index.");
    System.out.println("2. Search for URL by Domain Name.");
    System.out.println("3. Search for IPs.");
    System.out.println("4. Exit.");
    System.out.println("---------------------------");
    System.out.print("Option: ");

    process(console.nextInt());
  }

  public static void process(int option) {
    switch(option){
      case 1:
        // Display AVL.
        break;
      case 2:
        // Search for URL.
        break;
      case 3:
        // Search for IPs.
        break;
      case 4:
        System.exit(0);
        break;
      default:
        System.out.println("Invalid Option.");
        display();
        break;
    }
  }
}
