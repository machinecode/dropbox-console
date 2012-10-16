import utils.Connection;

import com.dropbox.client2.exception.DropboxException;

public class Simulation {

	public static void main(String[] args) {

		if (args.length == 0) {
			Connection.printUsage(System.out);
		} else {
			String command = args[0];
			if (command.equals("reset")) {
				// doReset(args);
			} else if (command.equals("link")) {
				try {
					Connection.doLink();
				} catch (DropboxException e) {
					e.printStackTrace();
				}
			} else if (command.equals("list")) {
				try {
					Connection.doList();
				} catch (DropboxException e) {
					e.printStackTrace();
				}
			}
			/*
			 * else if (command.equals("copy")) { //doCopy(args); }
			 */
			else if (command.equals("upload")) {
				Connection.doUpload(args[1], args[2]);
			} else if (command.equals("chunkupload")) {
				Connection.doChunkUpload(args[1]);
			} else {
				System.err.println("ERROR: Unknown command: \"" + command
						+ "\"");
				System.err.println("Run with no arguments for help.");
			}
		}
	}
}
