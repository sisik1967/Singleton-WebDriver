import Driver.Constant;
import Driver.Singleton;

public class Main {
    public static void main(String[] args) {

        Singleton.getDriverInstance().get(Constant.URL);
    }
}
