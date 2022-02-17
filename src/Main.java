import java.io.IOException;

public class Main {
    public static String authorFile;
    public static String commandFile;


    public static void main(String[] args) throws IOException {
	    authorFile = args[0];
	    commandFile = args[1];

        Command.command(commandFile);
    }
}
