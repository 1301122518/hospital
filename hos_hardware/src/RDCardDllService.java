/**
 * Created by Admin on 2016/4/24.
 */
import com.sun.jna.Library;

import com.sun.jna.Native;

import com.sun.jna.WString;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

public class RDCardDllService {


    public interface RDCardDll extends Library {

        /**

         * 当前路径是在项目下，而不是bin输出目录下。

         */

        RDCardDll INSTANCE = (RDCardDll)Native.loadLibrary("RdCard.dll", RDCardDll.class);
        public int UComman1(byte[] pCmd, int parg0, int parg1, int parg2);


    }

    public static void main(String[] args) {
        System.out.println("Hello World!");

        byte[] test3 = {0x41};

        RDCardDll.INSTANCE.UComman1(test3, 0,8811,9986);

        Main test = new Main();
//        int test2 = test.UComman1(test3,0,8811,9986);
        // System.out.println(test.get());
    }



}
