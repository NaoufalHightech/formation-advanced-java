package jour3.ex4;

import java.util.concurrent.CompletableFuture;

public class ex4 {
    /**
     * Créer un système de création de Users et de leurs préférences de façon asynchrone via des CompletableFuture et en utilisant un cachedThreadPoolExecutor.
     * Le résultat de la création d’un user et de ces préférences doivent être combiné afin d’afficher l'user final et ses préférences associées (Pensez à créer un objet compose d’un user et de ces préférences)
     * Un user est identifié par un id unique et un nom
     * Une préférence doit avoir une référence vers un user par id, un boolean indiquant si les notifications sont activées et un thème (String)
     * <p>
     * utiliser uniquement les objects suivants:
     * <p>
     * CompletableFuture, cachedThreadPoolExecutor pour la partie asynchrone et concurrentielle
     * <p>
     * pensez a definir une class UserService qui propose deux methodes:
     * <p>
     * fetchUser qui returne un potentiel User
     * <p>
     * fetchUserPreferences qui retourne ces potentielles references
     * <p>
     * dans le main faire appel a ces deux methodes pour combiner et retourner un user donnée ainsi que ces preferences encapsuler dans un object combinedUser
     */

    public static void main(String[] args) {
        UserService userService = new UserService();
        long userId = 123;

        CompletableFuture<User> userFuture = userService.fetchUser(userId);
        CompletableFuture<Preference> preferenceFuture = userService.fetchUserPreferences(userId);

        CompletableFuture<CombinedUser> combinedUserFuture = userFuture
                .thenCombine(preferenceFuture, (u,p) -> {
                    return new CombinedUser(u,p);
                });
        combinedUserFuture.thenAccept(result -> {
            System.out.println("La combinaison des deux futures est termine : " + result);
        }).exceptionally(ex -> {
            System.err.println("An error occurred: " + ex.getMessage());
            return null;
        });
            // Shutdown the executor service
            userService.getExecutor().shutdown();



    }
}
