package hanged;

class Utils {
    static int getRandomInteger(int minimum, int maximum) {
        return  minimum + (int)(Math.random() * maximum); 
    }
}
