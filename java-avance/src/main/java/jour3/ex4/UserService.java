package jour3.ex4;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserService {
    private final ExecutorService executor = Executors.newCachedThreadPool();

    public CompletableFuture<User> fetchUser(long id) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching user : " + id);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return new User(id, "User-" + id);
        }, executor);
    }

    public CompletableFuture<Preference> fetchUserPreferences(long userId) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching user prefernces : " + userId);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return new Preference(userId, true, "Dark");
        }, executor);
    }

    public ExecutorService getExecutor() {
        return executor;
    }
}

