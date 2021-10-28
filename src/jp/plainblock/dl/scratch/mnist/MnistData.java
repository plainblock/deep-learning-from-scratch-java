package jp.plainblock.dl.scratch.mnist;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.zip.GZIPInputStream;

import jp.plainblock.dl.scratch.common.DataSet;
import jp.plainblock.dl.scratch.common.Matrix;
import jp.plainblock.dl.scratch.common.util.FileUtil;

public class MnistData {

	// MNIST dataset parameters
    private static final String TRAIN_IMAGE = "train-images-idx3-ubyte.gz";
    private static final String TRAIN_LABEL = "train-labels-idx1-ubyte.gz";
    private static final String TEST_IMAGE = "t10k-images-idx3-ubyte.gz";
    private static final String TEST_LABEL = "t10k-labels-idx1-ubyte.gz";
    private static final String URL = "http://yann.lecun.com/exdb/mnist/";
    private static final int WIDTH = 28;
    private static final int HEIGHT = 28;

    public static final String DIR_PATH = "model/mnist/";
	public static final String MODEL_PATH = DIR_PATH + "model.txt";

    public static DataSet loadTrainData() {
    	File image = new File(DIR_PATH + TRAIN_IMAGE);
    	File label = new File(DIR_PATH + TRAIN_LABEL);
    	if (!image.exists() || !label.exists()) download();
    	return new DataSet(loadImage(image), loadLabel(label), 10);
    }

    public static DataSet loadTestData() {
    	File image = new File(DIR_PATH + TEST_IMAGE);
    	File label = new File(DIR_PATH + TEST_LABEL);
    	if (!image.exists() || !label.exists()) download();
    	return new DataSet(loadImage(image), loadLabel(label), 10);
    }

    public static void download() {
    	String[] list = {TRAIN_IMAGE, TRAIN_LABEL, TEST_IMAGE, TEST_LABEL};
    	for (String name : list) {
    		try {
    			FileUtil.download(URL + name, DIR_PATH + name);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    }

    private static double[][] loadImage(File image) {
    	try (DataInputStream in = new DataInputStream(new GZIPInputStream(new FileInputStream(image)))) {
    		int header = in.readInt();
    		if (header != 0x00000803) throw new IOException("Invalid image header");
    		int size = in.readInt();
    		int rows = in.readInt();
    		int columns = in.readInt();
    		int dimension = rows * columns;
    		double[][] images = new double[size][dimension];
    		for (int i = 0; i < size; i++) {
    			for (int j = 0; j < dimension; j++) {
    				images[i][j] = (double) in.readUnsignedByte() / 255.0;
    			}
    		}
    		return images;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    }

    private static double[] loadLabel(File label) {
    	try (DataInputStream in = new DataInputStream(new GZIPInputStream(new FileInputStream(label)))) {
            int header = in.readInt();
            if (header != 0x00000801) throw new IOException("Invalid label header");
            int size = in.readInt();
            double[] labels = new double[size];
            for (int i = 0; i < size; i++) {
            	labels[i] = in.readUnsignedByte();
            }
            return labels;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    }

    public static void printImage(DataSet data, int index) {
    	System.out.println("Label: " + Matrix.maxIndex(data.getLabels()[index]));
    	for (int i = 0; i < WIDTH; i++) {
    		for (int j = 0; j < HEIGHT; j++) {
    			double value = data.getFeatures()[index][i * WIDTH + j];
    			if (value > 0.0) {
    				System.out.print("**");
    			} else {
    				System.out.print("  ");
    			}
    		}
    		System.out.println();
    	}
    }

	public static void printProbability(double[] x) {
		for (int i = 0; i < x.length; i++) {
			double p = x[i];
			System.out.println(i + ": " + BigDecimal.valueOf(p).toPlainString());
		}
	}

}
