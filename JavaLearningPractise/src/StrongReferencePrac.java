public class StrongReferencePrac {
    @Override
    protected void finalize() throws Throwable{
        System.out.println("StrongReference 被回收了");
    }

    public static void main(String[] args) {
        StrongReferencePrac strongReferencePrac =new StrongReferencePrac();
        strongReferencePrac =null;
        System.gc();
    }
}
