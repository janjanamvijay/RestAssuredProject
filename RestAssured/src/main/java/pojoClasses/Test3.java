package pojoClasses;

public class Test3 {
  public static void main(String args[]){
    int length = s.length();
    int i = 0;
    int index = 0;
        while (i < length) {
        if (s.charAt(i) == 'b') {
            index = i;
            break;
        }
        i++;
    }
        while (i < length) {
        if (s.charAt(i) == 'a') {
            return false;
        }
        i++;
    }
        return true;
}
}
