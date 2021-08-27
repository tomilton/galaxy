package co.trycore.galaxy.core.common.util;

public class UtilityString {

    private UtilityString() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Valida si una cadena esta vacia
     *
     * @param cadena
     * @return
     */
    public static boolean cadenaVacia(final String cadena) {
        boolean cadenaVacia = false;
        if (cadena == null || cadena.trim().isEmpty()) {
            cadenaVacia = true;
        }
        return cadenaVacia;
    }

}
