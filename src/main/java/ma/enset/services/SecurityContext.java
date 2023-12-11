package ma.enset.services;

public class SecurityContext {
    private static String username = "";
    private static String password = "";
    private static String[] roles = {};

    public static void authenticate(String u, String p, String[] r) {
        if (username == null || password == null || roles == null)
            throw new RuntimeException("Invalid username or password or roles");

        else if (username.equals("root") && password.equals("1234")) {
            username = u;
            password = p;
            roles = r;
        } else throw new RuntimeException("Invalid username or password or roles");

    }

    public static boolean hasRole(String role) {
        for (String r : roles) {
            if (r.equals(role)) return true;
        }
        return false;
    }
}
