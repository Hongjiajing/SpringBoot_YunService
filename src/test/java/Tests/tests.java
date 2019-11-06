package Tests;

public class tests {
    public static void main(String[] args) {
        String a = "正常,1";
        String[] split = a.split(",");
        System.out.println(split[0]);
        System.out.println(split[1]);
    }
}
