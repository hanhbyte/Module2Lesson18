package threadBasic;

public class NumberGenerator implements Runnable{
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            System.out.println(this.hashCode());
            try {
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        NumberGenerator numberGenerator = new NumberGenerator();
        NumberGenerator numberGenerator1 = new NumberGenerator();
        Thread thread1 = new Thread(numberGenerator);
        Thread thread2 = new Thread(numberGenerator1);
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread1.start();
        thread2.start();
    }
}
