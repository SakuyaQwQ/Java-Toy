public class Main {
    public static void main(String[] args) {
        NormalUser user = new NormalUser();
        User proxy = (User) (new InvocationHandlerImpl(user)).getProxy();
        proxy.logout();
    }
}
