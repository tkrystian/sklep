package pl.camp.it.sklep.database;

import pl.camp.it.sklep.model.User;

public class UserDB {
    final User[] users = new User[2];

    public UserDB() {
        this.users[0] = new User("admin", "admin", User.Role.ADMIN);
        this.users[1] = new User("user", "user", User.Role.USER);
    }

    public User[] getUsers() {
        return users;
    }

    public User findUserByLogin(String login){
        for (User user : this.users){
            if (user.getLogin().equals(login)){
                return user;
            }
        }
        return null;
    }
}
