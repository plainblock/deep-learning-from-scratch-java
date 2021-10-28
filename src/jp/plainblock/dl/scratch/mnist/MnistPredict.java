package jp.plainblock.dl.scratch.mnist;

import java.math.BigDecimal;
import java.util.Random;

import jp.plainblock.dl.scratch.common.DataSet;
import jp.plainblock.dl.scratch.common.Function;
import jp.plainblock.dl.scratch.common.Matrix;
import jp.plainblock.dl.scratch.common.network.TwoLayerNetwork;

public class MnistPredict {

	public static void main(String...args) {
		TwoLayerNetwork net = new TwoLayerNetwork(MnistData.MODEL_PATH);
		DataSet test = MnistData.loadTestData();

		Random rand = new Random();
		int index = rand.nextInt(test.getSize());
		double[][] target = new double[1][test.getDimension()];
		target[0] = test.getFeatures()[index];
		double[][] predict = Function.softmax(net.predict(target));

		System.out.println("Predict: " + Matrix.maxIndex(predict[0]));
		System.out.println("");
		for (int i = 0; i < predict[0].length; i++) {
			double p = predict[0][i];
			System.out.println(i + ": " + BigDecimal.valueOf(p).toPlainString());
		}
		System.out.println("");
		MnistData.printImage(test, index);
	}
}
