public class op extends dimension {
    public int up() {
        right();
        left();
        return 1;
    }   
    public int down() {
        return -1;
    }

    public static void main(String[] args) {
        
    }
}

class dimension {
    public double right() {
        return Math.sin(1);
    }

    public double left() {
        return Math.cos(-1);
    }
}