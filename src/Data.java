public class Data {

    private static final String VALID_CHARACTERS = "abcdefghijklmnopqrstufvxwzABCDEFGHIJKLMNOPQRSTUFVXWZ123456789_";

    public Data() {
    }

    public static boolean validate(String login,
                                   String password,
                                   String confirmPassword) {
        try {
            check(login, password, confirmPassword);
        } catch (WrongLoginException exception | WrongPasswordException exception) {
            System.out.println(exception.getMessage());
            return false;
        }
        return true;
    }

    public static void check(String login,
                             String password,
                             String confirmPassword) {
        if (validate(login)) {
            throw new WrongLoginException("Логин невалидный!");
        }
        if (validate(password)) {
            throw new WrongPasswordException("Пароль невалидный!");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли должны совпадать!");
        }
    }

    private static boolean validate(String s) {
        if (s.length() > 20) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!VALID_CHARACTERS.contains(String.valueOf(s.charAt()))) {
                return false;
            }
        }
        return true;
    }
