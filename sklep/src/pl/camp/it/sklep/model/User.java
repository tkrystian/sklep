package pl.camp.it.sklep.model;

public class User {
    private String login;
    private String password;
    private Role role;

    public User() {
    }

    public User(String login, String password, Role role) {
        this(login, password);
        this.role = role;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public Role getRole() {
        return role;
    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof User temp)){
            return false;
        }
        return this.login.equals(temp.login) && this.password.equals(temp.password);
    }
    public enum Role{
        USER, ADMIN
    }

}
