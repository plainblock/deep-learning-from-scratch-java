package jp.plainblock.dl.scratch.common.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public class FileUtil {

	public static void download(String inputUrl, String outputPath) throws MalformedURLException {
		URL url = new URL(inputUrl);
		File file = new File(outputPath);
		if (!file.exists()) {
			try (ReadableByteChannel rbc = Channels.newChannel(url.openStream());
					FileChannel fc = new FileOutputStream(file).getChannel()) {
				System.out.println("Downloading " + file.getName() + " ...");
				fc.transferFrom(rbc, 0, Long.MAX_VALUE);
				System.out.println("Complete!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(file.getName() + " already exists.");
		}
	}

}
