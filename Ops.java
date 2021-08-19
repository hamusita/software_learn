public class Ops{
    void show(Room r) {
        System.out.println(r.getS());
    }

    public void control(Room r, String s){
        int[] n = new int[3]; 
        n = parser(s);
        r.control(n);
    }

    public void optimizer(Room r){
        while(true){
            int a = r.mt.getTemperature();
            if(a < 25){
                if(15 < a){
                    break;
                }
            }else{
                r.control(6, 3, 2);
            }
        }
    }

    public int[] parser(String s){
        int[] n = new int[3];
        String[] num = s.split("_");
        if (num.length == 2){
            n[0] = Integer.parseInt(num[0]);
            n[1] = Integer.parseInt(num[1]);
            n[2] = 0;
        }else if(num.length == 3){
            n[0] = Integer.parseInt(num[0]);
            n[1] = Integer.parseInt(num[1]);
            n[2] = Integer.parseInt(num[2]);
        }else{
            n[0] = 0;
            n[1] = 0;
            n[2] = 0;
        }
        return n;
    }

}
