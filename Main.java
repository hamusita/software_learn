import java.util.*;

class Main{
    public static void Main(String[] args){
        System.out.println("start program");
        Scanner scan = new Scanner(System.in);
        Ops o = new Ops();
        Room r = new Room();

        System.out.println("plz input ops");
        while(true){
            System.out.println(">   ");
            String str = scan.nextLine();
            
            if (str == "exit"){
                scan.close();
                break;
            }else{
                if (str == "show"){
                    o.Operator.show(r);
                }else if (str == "cntl"){
                    System.out.println("plz input ops id");
                    System.out.println(">>> ");
                    str = scan.nextLine();
                    o.show(r);
                }else if (str == "optim"){
                    System.out.println("plz input ops id");
                    System.out.println(">>> ");
                    str = scan.nextLine();
                    o.control(-1);
                }else{
                    System.out.println("ops error");
                }
            }
        }
        System.out.println("fin program.");
    }

}