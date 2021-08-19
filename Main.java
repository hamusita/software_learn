import java.util.*;

class Main{
    public static void main(String[] args){
        System.out.println("start program");
        Scanner scan = new Scanner(System.in);
        Ops o = new Ops();
        Room r = new Room();

        while(true){
            System.out.println("plz input ops");
            System.out.print(">   ");
            String str = scan.nextLine();
            System.out.println(str);
            
            if (str.equals("exit")){
                scan.close();
                break;
            }else{
                if (str.equals("show")){
                    o.show(r);
                }else if (str.equals("ctrl")){
                    System.out.println("plz input ops id");
                    System.out.print(">>> ");
                    str = scan.nextLine();
                    o.control(r, str);
                }else if (str.equals("optm")){
                    System.out.println("optimizing");
                    o.optimizer(r);
                    System.out.println("fin optimize");
                }else{
                    System.out.println("ops error");
                }
            }
        }
        System.out.println("fin program.");
        System.exit(0);
    }

}