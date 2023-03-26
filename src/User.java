class User {
private String username;
private String password;
private int money;
public User(String username, String password) {
    this.username = username;
    this.password = password;
    this.money = 50;
}

public String getUsername() {
    return this.username;
}

public String getPassword() {
    return this.password;
}

public int getMoney() {
    return this.money;
}

public void setMoney(int money) {
    this.money = money;
}
}