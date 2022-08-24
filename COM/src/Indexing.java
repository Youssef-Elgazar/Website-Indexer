import java.io.*;
import java.util.Scanner;

public class Indexing {

        public static void main ( String[] args){
            AVL tree = new AVL();

            try {
                File file = new File("C:\\Users\\LEGION\\Documents\\GitHub\\Website-Indexer\\COM\\src\\data.txt");
                FileReader reader = new FileReader(file);
                BufferedReader input = new BufferedReader(reader) ;

                try{
                    String data;
                    while ((data = input.readLine()) != null ){
                        String[] s = data.split(" > ");
                        data = input.readLine() ;
                        tree.insert(s);
                    }
                    input.close();
                }
                catch(IOException o){
                    System.out.println("file is empty");
                }
            }catch (FileNotFoundException e ){
                System.out.println("file not found");
            }

            System.out.println("\"Your Website Indexer\"");
            System.out.println("File is loaded");

            System.out.println("~.~.~.~.~.~.~  MENU  ~.~.~.~.~.~.~");
            System.out.println("1 - Display the full index");
            System.out.println("2 - Searc for URL ");
            System.out.println("3 - Search for an IP address");
            System.out.println("4 - Add an extra page ");
            System.out.println("5 - exit");
            System.out.println("~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~");

            Scanner input = new Scanner(System.in);
            System.out.print("option : ");
            int answer = input.nextInt();

            while (answer != 5){
                switch(answer){
                    case 1 :
                        tree.inorder();
                        break ;
                    case 2 :
                        System.out.println("Please enter the page: ");
                        String page = input.next();
                        if ( tree.searchForURl(page) == null ){
                            System.out.println("Page not found :( ");
                        }
                        else {
                            tree.searchForURl(page).LL.display();
                        }
                        System.out.println("~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~");
                        break ;
                    case 3 :
                        Boolean x = true ;
                        while (x == true){
                            System.out.println("Please enter the URL: ");
                            String IP = input.next();
                            String regex = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
                            String pattern = regex + "\\."+ regex + "\\."+ regex + "\\."+ regex;
                            if(IP.matches(pattern)){
                                if ( tree.searchForIP(IP) == null ){
                                    System.out.println("IP not found :( ");
                                }
                                else {
                                    tree.searchForIP(IP).LL.display();
                                }
                                x = false;
                            }
                            else{
                                System.out.println("IP has to in this format : xxx.xxx.xxx.xxx");
                                x = true ;
                            }
                        }
                        break ;

                    case 4 :
                        String[] NewPage = new String[2] ;
                        System.out.print("enter page URL : ");
                        NewPage[0] = input.next() ;
                        System.out.println("enter page IP : ");
                        NewPage[1] = input.next() ;
                        tree.insert(NewPage);

                        System.out.println("~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~");
                }

                System.out.println("~.~.~.~.~.~.~  MENU  ~.~.~.~.~.~.~");
                System.out.println("1 - Display the full index");
                System.out.println("2 - Searc for URL ");
                System.out.println("3 - Search for an IP address");
                System.out.println("4 - Add an extra page ");
                System.out.println("5 - exit");
                System.out.println("~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~");

                System.out.print("option : ");
                answer = input.nextInt();

            }
            input.close();

        }
    }