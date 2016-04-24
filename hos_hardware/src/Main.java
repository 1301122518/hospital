import com.sun.jna.Library;

import com.sun.jna.Native;

import com.sun.jna.WString;

public class Main {

    static{
//        System.setProperty ("java.library.path", "C:\\hos_hardware\\src") ;
//        System.loadLibrary("RdCard.dll");
    }

    public native static int UComman1(byte[] pCmd, int parg0, int parg1, int parg2);
    //public native static void set(int i);

    public static void main(String[] args) {
        System.out.println("Hello World!");

        byte[] test3 = {0x41};

        Main test = new Main();
//        int test2 = test.UComman1(test3,0,8811,9986);
       // System.out.println(test.get());


    }
}
