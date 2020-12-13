package Chapter3;

import java.util.Arrays;

public class ReferenceCounting {
    public Object instance=null;

    private static final int _1M=1024*1024;

    private byte[] bigSize=new byte[2*_1M];

    public static void main(String[] args) {
        ReferenceCounting objA=new ReferenceCounting();
        ReferenceCounting objB=new ReferenceCounting();

        objA.instance=objB;
        objB.instance=objA;

        objA=null;
        objB=null;

        System.gc();
    }
}
