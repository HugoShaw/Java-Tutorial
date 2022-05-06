package studio4;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

import support.cse131.ArgsProcessor;
import support.cse131.FileChoosers;
import support.cse131.Scanners;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class DrawingFiles {
	public static ArgsProcessor createArgsProcessorFromFile(String[] argsFromMain) {
		URL url = DrawingFiles.class.getResource("resources");
		String directoryName = url.getFile();
		File directory = new File(directoryName);
		File file = FileChoosers.chooseFile(argsFromMain, directory);
		if (file != null) {
			try {
				return Scanners.createArgsProcessorFromFile(file);
			} catch (FileNotFoundException fnfe) {
				throw new RuntimeException(file.getAbsolutePath(), fnfe);
			}
		} else {
			return null;
		}
	}
}
