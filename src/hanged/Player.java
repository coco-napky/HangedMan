package hanged;

class Player {

    String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Player(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Player{" + "username=" + username + '}';
    }
   
}
