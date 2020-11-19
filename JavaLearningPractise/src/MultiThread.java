import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class MultiThread {
    private static class Thread1 implements Runnable{
        @Override
        public void run(){
            synchronized (MultiThread.class){
                System.out.println("enter thread1...");
                System.out.println("thread1 is waiting");

                try{
                    MultiThread.class.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

                System.out.println("thread1 is going on...");
                System.out.println("thread1 is being over");
            }
        }
    }

    private static class Thread2 implements Runnable{
        @Override
        public void run(){
            synchronized (MultiThread.class){
                System.out.println("enter thread2 ...");
                System.out.println("thread2 notify other thread can release wait status...");
                //notify唤醒thread1 但是sleep方法没有释放对象锁，所以还是没有办法
                MultiThread.class.notify();
                System.out.println("thread2 is sleeping ten millisecond...");

                try{
                    Thread.sleep(10);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("Thread2 is going on ...");
                System.out.println("thread2 is being over!");
            }
        }
    }


    public static void main(String[] args) {
        new Thread(new Thread1()).start();
        try{
            Thread.sleep(10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        new Thread(new Thread2()).start();
    }
}
