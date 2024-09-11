package jour3.ex4;

public class CombinedUser {
    private User user;
    private Preference preference;

    public CombinedUser(User user, Preference preference) {
        this.user = user;
        this.preference = preference;
    }

    @Override
    public String toString() {
        return "CombinedUser{" +
                "user=" + user +
                ", preference=" + preference +
                '}';
    }
}
