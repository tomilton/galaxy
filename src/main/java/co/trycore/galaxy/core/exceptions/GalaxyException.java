package co.trycore.galaxy.core.exceptions;

public class GalaxyException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public GalaxyException(String meseage) {
        super(meseage);
    }

    public GalaxyException(String message, Throwable cause) {
        super(message, cause);
    }

}
