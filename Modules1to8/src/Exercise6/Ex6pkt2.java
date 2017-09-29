package Exercise6;

public class Ex6pkt2 {
    public static void main(String[] args) {
        char kar = 'z';
        String s="";
        switch (kar){
            case 'a': {
                s = "Black";
                break;
            }
            case 'b':
            case 'w':
            case 'W':
            case 'v': {
                s="White";
                break;
            }
            case 'c': {
                s = "Red";
                break;
            }
            case 'd': {
                s = "Green";
                break;
            }
        }
        System.out.println(s);
    }
}
