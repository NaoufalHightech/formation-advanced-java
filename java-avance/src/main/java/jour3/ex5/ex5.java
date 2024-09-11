package jour3.ex5;

public class ex5 {

    /**
     * Écrivez un programme Java utilisant ProcessHandle pour récupérer  et afficher des informations sur tous les processus en cours  d'exécution sur le système.
     * Le programme doit être capable de :
     *
     * Récupérer une liste de tous les processus en cours d'exécution à  l'aide de ProcessHandle.allProcesses().
     *
     * Pour chaque processus récupéré, afficher des informations telles  que son ID, la commande utilisée pour le démarrer, ses arguments  et son état.
     *
     * Vous devez implémenter cette fonctionnalité dans une  méthode displayAllProcessesInfo() dans une
     * classe ProcessInfoViewer. Assurez-vous de gérer les exceptions qui
     * pourraient survenir lors de l'accès aux informations sur les  processus.
     */

    public static void main(String[] args) {
        ProcessInfoViewer processInfoViewer = new ProcessInfoViewer();
        processInfoViewer.displayAllProcessesInfo();
    }

}
