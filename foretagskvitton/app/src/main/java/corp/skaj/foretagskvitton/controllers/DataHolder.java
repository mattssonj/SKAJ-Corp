package corp.skaj.foretagskvitton.controllers;

import android.app.Application;

import java.util.List;

import corp.skaj.foretagskvitton.model.User;

public class DataHolder extends Application {
    private boolean ONCE = true;
    private List<String> strings;
    private User user;

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }

    public void setUser(User user) {
        if (ONCE) {
            this.user = user;
            ONCE = false;
        } else {
            System.out.println("ALREADY DID DIS ");
        }

    }

    public User getUser() {
        if (user == null) {
            user = new User("USER_SANJIN");
        }
        return user;
    }

    public List<String> getStrings() {
        return strings;
    }
}
