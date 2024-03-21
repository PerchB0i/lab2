public class Main {
    public static void main(String[] args) {
        String s = "aa,bb,cc";
        String[] splited = s.split(",");
        for (String str:
             splited) {
            System.out.print(str);
        }
    }
}