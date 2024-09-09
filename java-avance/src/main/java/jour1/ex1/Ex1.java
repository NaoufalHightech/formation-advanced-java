package jour1.ex1;

public class Ex1 {

    public static void main(String[] args) {

        /*
         * Écrire un programme qui simule l'exécution de 5 threads en affichant le thread en cours d’exécution à chaque fois → Utiliser la classe Thread pour cela
         * */
        for (int i=0; i< 5 ; i++) {
            Runnable task = () -> {
                System.out.println(Thread.currentThread().getName());
            };
            Thread t = new Thread(task);
            t.start();
        }

    }
}
