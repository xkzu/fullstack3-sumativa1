package cl.duoc.app.mantenedor_usuarios.util;

public class UsuarioUtil {

    private UsuarioUtil() {}

    public static boolean isEmptyOrNull(String string) {
        return null == string || string.isEmpty();
    }
}
