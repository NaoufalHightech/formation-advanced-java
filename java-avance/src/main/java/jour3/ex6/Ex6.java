package jour3.ex6;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class Ex6 {
    /**
     * Écrivez un programme Java utilisant L’API Http2(java.net.*​
     * <p>
     * ) pour :​
     * ​
     * <p>
     * Instancier un client HTTP et construire une requête de type GET pour récupérer une ressource publique disponible sous l’adresse web : https://jsonplaceholder.typicode.com/posts/1 sous forme d’objet URI :​
     * <p>
     * ​
     * <p>
     * Récupérer le résultat et le parcourir afin d’afficher les informations de la réponse, notamment le body et le status de réponse​
     * <p>
     * Pensez à gérer les exceptions en rajoutant des logs dans la console de votre IDE​
     * <p>
     * ​
     * <p>
     * Instancier un client Http et construire une requête de type POST pour envoyer une ressource de type JSON a l’adresse publique disponible sous l’adresse web : https://jsonplaceholder.typicode.com/posts  sous forme d’objet URI :​
     * <p>
     * ​
     * <p>
     * Récupérer le résultat et le traiter de façon asynchrone à l’aide de l’objet CompletableFuture d’afficher les informations de la réponse notamment le body et le status de réponse​
     * <p>
     * Pensez à gérer les exceptions en rajoutant des logs dans la console de votre IDE​
     */

    public static void main(String[] args) {
        // Instancier le client HTTP
        HttpClient client = HttpClient.newHttpClient();
        // Requête GET pour récupérer une ressource
        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1"))
                .GET()
                .build();

        client.sendAsync(getRequest, HttpResponse.BodyHandlers.ofString())
                .thenApply(response -> {
                    System.out.println("Status Code: " + response.statusCode());
                    System.out.println("Response Body: " + response.body());
                    return response;
                })
                .exceptionally(ex -> {
                    // Je m'enfiche de l'exception
                    return null;
                })
                .join(); // j'attends le resultat


        // Requête POST pour envoyer des données JSON
        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString("{\"title\": \"toto\", \"body\": \"tata\", \"userId\": 123}"))
                .build();

        // Envoyer la requête POST et gérer la réponse de manière asynchrone
        CompletableFuture<HttpResponse<String>> postResponseFuture = client.sendAsync(postRequest, HttpResponse.BodyHandlers.ofString());

        try {
            HttpResponse<String> postResponse = postResponseFuture.get(); // Utiliser get() pour obtenir la réponse de manière bloquante
            System.out.println("Status Code: " + postResponse.statusCode());
            System.out.println(" Response Body: " + postResponse.body());
        } catch (Exception ex) {
            // Je fais quoi?
        }
    }
}
