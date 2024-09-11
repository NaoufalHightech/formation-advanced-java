package jour3.ex4;

public class Preference {
    private final long userId;
    private final boolean notificationsEnabled;
    private final String theme;

    public Preference(long userId, boolean notificationsEnabled, String theme) {
        this.userId = userId;
        this.notificationsEnabled = notificationsEnabled;
        this.theme = theme;
    }

    public long getUserId() {
        return userId;
    }

    public boolean isNotificationsEnabled() {
        return notificationsEnabled;
    }

    public String getTheme() {
        return theme;
    }

    @Override
    public String toString() {
        return "Preference{userId='" + userId + "', notificationsEnabled=" + notificationsEnabled + ", theme='" + theme + "'}";
    }
}

