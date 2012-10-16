package utils;

public final class GlobalPath
{
    public final String uid;
    public final String path;

    private GlobalPath(String uid, String path)
    {
        this.uid = uid;
        this.path = path;
    }

    /**
     * Parse a 'global path' string of the form "[uid]:[path]" into UID and path
     * parts.
     */
    public static GlobalPath parse(String s)
        throws FormatException
    {
        int colonPos = s.indexOf(':');
        if (colonPos < 0) throw new FormatException("missing colon");
        String uid = s.substring(0, colonPos);
        String path = s.substring(colonPos+1);
        if (uid.length() == 0) throw new FormatException("empty UID");
        if (!path.startsWith("/")) throw new FormatException("path doesn't start with \"/\": \"" + path + "\"");
        return new GlobalPath(uid, path);
    }

    @SuppressWarnings("serial")
	public static final class FormatException extends Exception
    {
        public FormatException(String message) { super(message); }
    }
}