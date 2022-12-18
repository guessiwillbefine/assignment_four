package ua.vadim.dao;

import ua.vadim.model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UserData {
    private UserData() {/*no use*/}

    private static final List<User> users = new ArrayList<>();
    private static final Lock lock = new ReentrantLock();

    static {
        users.add(new User("username1", "password1", "Maxim", "Maximov"));
        users.add(new User("username2", "password7", "Denis", "Denisov"));
        users.add(new User("username3", "password8", "Andrew", "Andreich"));
        users.add(new User("username4", "password9", "Corey", "Taylor"));
        users.add(new User("username5", "password10", "Alex", "Turner"));
        users.add(new User("username6", "password11", "Tyler", "Joseph"));
    }

    public static boolean register(User user) {
        lock.lock();
        boolean present = isPresent(user);
        System.err.println(present);
        if (!present) {
            users.add(user);
        }
        lock.unlock();
        return !present;
    }

    private static boolean isPresent(User user) {
        lock.lock();
        boolean isPresent = users.stream().anyMatch(x -> x.getUsername().equals(user.getUsername()));
        lock.unlock();
        return isPresent;
    }

    public static boolean authenticate(User user) {
        lock.lock();
        if (!user.getUsername().isBlank() && !user.getPassword().isBlank()) {
            boolean userMatch = users.stream().anyMatch(x -> x.equals(user));
            lock.unlock();
            return userMatch;
        }
        lock.unlock();
        return false;
    }

    public static Collection<User> getAll() {
        return Collections.unmodifiableCollection(users);
    }
}
