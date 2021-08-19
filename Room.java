import java.util.*;

public class Room{
    public static Door dr;
    public static AirCleaner acl;
    public static AirConditioner acd;
    public static Window win;
    public static Light lt;
    public static Curtain ct;
    public static Meter mt;

    public static void Room() {
        mt = new Meter();
        ct = new Curtain();
        lt = new Light();
        win= new Window();
        acd= new AirConditioner();
        acl= new AirCleaner();
        dr = new Door();
    }

    public static String getS(){
        String s = "\n";
        s += "door:\n" + dr.getStatus()  + "\n";
        s += "AirCleaner:\n" + acl.getStatus() + "\n";
        s += "AirConditioner:\n" + acd.getStatus() + "\n";
        s += "Window:\n" + win.getStatus() + "\n";
        s += "Light:\n" + lt.getStatus()  + "\n";
        s += "Curtain:\n" + ct.getStatus()  + "\n";
        s += "Meter:\n" + mt.getStatus()  + "\n";
        return s;
    }

    public void control(int... op){
        switch (op[0]){
            case 0:
                dr.selectFunc(op[1], op[2]);
            case 1:
                mt.selectFunc(op[1], op[2]);
            case 2:
                win.selectFunc(op[1], op[2]);
            case 3:
                ct.selectFunc(op[1], op[2]);
            case 4:
                acl.selectFunc(op[1], op[2]);
            case 5:
                lt.selectFunc(op[1], op[2]);
            case 6:
                acd.selectFunc(op[1], op[2]);
        }
    }

    static class Door{
        public static int key = 0;
        public static String[] s = {"key"};

        public static String getStatus(){
            return status(s,key);
        }

        public static void lock(){
            key = 1;
        }
        
        public static void unlodk(){
            key = 0;
        }

        public static void selectFunc(int fid, int opt){
            if(fid == 0){
                getStatus();
            }else if (fid == 1) {
                lock();
            }else if (fid == 2) {
                unlodk();
            }else{
                System.out.println("function select error.");
            }
        }
    }

    static class AirCleaner{
        public static int power = 0;
        public static int remaining = 100;
        public static int state = 0;
        public static String[] s = {"power", "remaining", "state"};

        public static String getStatus(){
            return status(s, power, remaining, state);
        }

        public static void powerOn(){
            power = 1;
        }
        
        public static void powerOff(){
            power = 0;
            state = 0;
        }

        public static void humidification(){
            if(remaining == 0){
                System.out.println("Amount of water remaining erroe");
            }else{
                state = 1;
                remaining -= 10;
            }
        }

        public static void dehumidification(){
            state = 2;
        }

        public static void selectFunc(int fid, int opt){
            if(fid == 0){
                getStatus();
            }else if (fid == 1) {
                powerOn();
            }else if (fid == 2) {
                powerOff();
            }else if (fid == 3) {
                humidification();
            }else if (fid == 4) {
                dehumidification();
            }else{
                System.out.println("function select error.");
            }
        }
    }

    static class AirConditioner{
        public static int power = 0;
        public static int mode = 0; //1:warm 2:cool
        public static int str = 0;
        public static int dir = 0;//0:defolt 1:up 2:mid 3:down
        public static String[] s = {"power", "mode", "str", "dir"};

        public static String getStatus(){
            return status(s, power, mode, str, dir);
        }

        public static void powerOn(){
            power = 1;
            mode = 1;
        }
        
        public static void powerOff(){
            power = 0;
            mode = 0;
            str = 0;
            dir = 0;
        }

        public static void switchMode(int opt){
            
            power = 1;
            try{
                mode = opt == 1 ? 2 : 1;
            }catch (Exception e) {
                System.out.println("option error, no change.");
            }
            
        }

        public static void switchPower(int opt){
            try{
                str = opt;
            }catch (Exception e) {
                System.out.println("option error, no change.");
            }
        }

        public static void switchDir(int opt){
            try{
                str = opt;
            }catch (Exception e) {
                System.out.println("option error, no change.");
            }
        }

        public static void selectFunc(int fid, int opt){
            if(fid == 0){
                getStatus();
            }else if (fid == 1) {
                powerOn();
            }else if (fid == 2) {
                powerOff();
            }else if (fid == 3) {
                switchMode(opt);
            }else if (fid == 4) {
                switchPower(opt);
            }else if (fid == 5) {
                switchDir(opt);
            }else{
                System.out.println("function select error.");
            }
        }
    }

    static class Window{
        public static int state = 0;
        public static String[] s = {"state"};

        public static String getStatus(){
            return status(s, state);
        }

        public static void open(){
            state = 2;
        }
        
        public static void semiOpen(){
            state = 1;
        }

        public static void close(){
            state = 0;
        }

        public static void selectFunc(int fid, int opt){
            if(fid == 0){
                getStatus();
            }else if (fid == 1) {
                open();
            }else if (fid == 2) {
                semiOpen();
            }else if (fid == 3) {
                close();
            }else{
                System.out.println("function select error.");
            }
        }
    }

    static class Meter{
        public static int temp = 0;
        public static int hum  = 0;
        public static int brt  = 0;
        public static Random random = new Random();
        public static String[] s = {"temp", "hum", "brt"};


        public static String getStatus(){
            return status(s, temp, hum, brt);
        }

        public static int getTemperature(){
            temp = random.nextInt(100);
            return temp;
        }

        public static int getHumidity(){
            hum  = random.nextInt(100);
            return hum;
        }

        public static int getBrightness(){
            brt  = random.nextInt(100);
            return brt;
        }

        public static void selectFunc(int fid, int opt){
            if(fid == 0){
                getStatus();
            }else if (fid == 1) {
                getTemperature();
            }else if (fid == 2) {
                getHumidity();
            }else if (fid == 3) {
                getBrightness();
            }else{
                System.out.println("function select error.");
            }
        }
    }

    static class Curtain{
        public static int state = 0;
        public static String[] s = {"state"};

        public static String getStatus(){
            return status(s, state);
        }

        public static void open(){
            state = 1;
        }

        public static void close(){
            state = 0;
        }

        public static void selectFunc(int fid, int opt){
            if(fid == 0){
                getStatus();
            }else if (fid == 1) {
                open();
            }else if (fid == 2) {
                close();
            }else{
                System.out.println("function select error.");
            }
        }
    }

    static class Light{
        public static int power = 0;
        public static int brightness = 0;
        public static String[] s = {"power", "brightness"};

        public static String getStatus(){
            return status(s, power, brightness);
        }

        public static void powerOn(){
            power = 1;
        }
        
        public static void powerOff(){
            power = 0;
        }

        public static void changeBrightness(int opt){
            brightness = opt;
        }

        public static void selectFunc(int fid, int opt){
            if(fid == 0){
                getStatus();
            }else if (fid == 1) {
                powerOn();
            }else if (fid == 2) {
                powerOff();
            }else if (fid == 3) {
                changeBrightness(opt);
            }else{
                System.out.println("function select error.");
            }
        }
    }

    public static String status(String[] name, int... stetas) {
        String s = "\n";
        int cnt = 0;
        for (int num: stetas){
            s += name[cnt] + ":" +num;
            s += "\n";
            cnt++;
        }
        return s;
    }
}