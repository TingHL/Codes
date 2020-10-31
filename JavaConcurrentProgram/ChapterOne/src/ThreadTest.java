import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest {
    public static class MyThread extends Thread{
        @Override
        public void run(){
            System.out.println("I am a child thread");
        }
    }

    public static class RunnableTask implements Runnable{

        @Override
        public void run() {
            System.out.println("I am a child thread");
        }
    }

    //创建任务
    public static class CallerTask implements Callable<String> {
        @Override
        public String call() throws Exception{
            return "hello";
        }
    }

    public static void main(String[] args){
        MyThread myThread=new MyThread();
        myThread.start();

        RunnableTask runnableTask=new RunnableTask();
        new Thread(runnableTask).start();
        new Thread(runnableTask).start();

        FutureTask<String> futureTask=new FutureTask<>(new CallerTask());
        new Thread(futureTask).start();
        try {
            String result=futureTask.get();
            System.out.println(result);
        }catch (ExecutionException | InterruptedException e){
            e.printStackTrace();
        }
    }
}
