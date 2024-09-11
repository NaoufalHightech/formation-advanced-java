package jour3.ex5;

import java.util.Optional;
import java.util.stream.Stream;

public class ProcessInfoViewer {


    /*
    ProcessHandle.allProcesses().forEach(process -> {
            try {
                System.out.println(Map.of(
                        "pid", process.pid(),
                        "command", process.info().command().orElse(""),
                        "arguments", process.info().arguments().map(arguments -> String.join(", ", arguments)).orElse(""),
                        "status", process.isAlive() ? "alive" : "dead"
                ));
            } catch (Exception e) {
                System.out.println("Couldn't access process infos. " + e);
            }
        });

     */
    public void displayAllProcessesInfo() {
        try {
            Stream<ProcessHandle> processStream = ProcessHandle.allProcesses();

            processStream.forEach(processHandle -> {
                try {
                    // l'ID du processus
                    long pid = processHandle.pid();
                    System.out.print("ID du processus: " + pid);

                    // la commande et les arguments du processus
                    Optional<String> command = processHandle.info().command();
                    Optional<String[]> arguments = processHandle.info().arguments();

                    if (command.isPresent()) {
                        System.out.print(", Commande: " + command.get());
                    } else {
                        System.out.print(", Commande: inconnue");
                    }

                    if (arguments.isPresent()) {
                        System.out.print(", Arguments: ");
                        for (String arg : arguments.get()) {
                            System.out.print(arg + " ");
                        }
                    } else {
                        System.out.print(", Arguments: inconnus");
                    }

                    // Afficher l'état du processus
                    ProcessHandle.Info info = processHandle.info();
                    if (info.startInstant().isPresent()) {
                        System.out.print(", Démarré à: " + info.startInstant().get());
                    } else {
                        System.out.print(", Date de démarrage: inconnue");
                    }

                    System.out.println(); // Nouvelle ligne pour chaque processus

                } catch (Exception e) {
                    System.out.println("Erreur lors de la récupération des informations du processus avec ID: " + processHandle.pid());
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            System.out.println("Erreur lors de la récupération des processus.");
            e.printStackTrace();
        }
    }
}
