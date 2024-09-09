package jour1.ex1;

public class Ex2 {
    private int counter = 0;

    public void increment1(){
        counter++;
    }

    public synchronized void increment2(){
        counter++;
    }

    /**
     * Écrire un programme pour tester la synchronisation entre deux threads, pour se faire :
     * Créer une classe SynchronizationExample qui possède un attribut counter avec deux méthodes, une qui incrémente le compteur de façon synchronisé et l’autre sans synchronisation
     * Instancier votre classe dans le main et simuler le comportement avec 4 threads, deux qui exploitent la synchronisation et les deux autres non
     * @param args
     */
    public static void main(String[] args) {
        Ex2 example = new Ex2();
        Runnable task1 = () -> {
            for (int i = 0; i < 1000; i++) {
                example.increment1();
            }
        };

        Runnable task2 = () -> {
            for (int i = 0; i < 1000; i++) {
                example.increment2();
            }
        };

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task1);
        Thread thread3 = new Thread(task2);
        Thread thread4 = new Thread(task2);

        thread1.start();
        thread2.start();
        //thread3.start();
        //thread4.start();
        try {
            thread1.join();
            thread2.join();
//            thread3.join();
            //          thread4.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Counter : " + example.counter);
    }
}
