package hanged;

class Player {

    String username;
    int score;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    public Player(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Player{" + "username=" + username + '}';
    }
   
}
