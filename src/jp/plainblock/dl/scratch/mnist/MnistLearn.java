package jp.plainblock.dl.scratch.mnist;

import java.util.ArrayList;
import java.util.List;

import jp.plainblock.dl.scratch.common.DataSet;
import jp.plainblock.dl.scratch.common.network.TwoLayerNetwork;
import jp.plainblock.dl.scratch.common.optimizer.Optimizer;
import jp.plainblock.dl.scratch.common.util.ModelUtil;

public class MnistLearn {

	private static int input = 784;
	private static int hidden = 50;
	private static int output = 10;
	private static double weightRate = 0.01;

	private static int iters = 12000;
	private static int batchSize = 100;

	public static void main(String...args) {
		TwoLayerNetwork net = new TwoLayerNetwork(input, hidden, output, weightRate);
		net.setOptimizers(Optimizer.getOptimizers(Optimizer.Type.Momentum, net.getForKeys()));

		System.out.println("Loading datasets...");
		DataSet train = MnistData.loadTrainData();
		DataSet test = MnistData.loadTestData();
		System.out.println("Complete!");

		double minLoss = Double.MAX_VALUE;
		List<Double> lossList = new ArrayList<>();
		List<Double> trainAccList = new ArrayList<>();
		List<Double> testAccList = new ArrayList<>();

		System.out.println("Start learning...");
		int epoch = train.getFeatures().length / batchSize;
		for (int i = 1; i <= iters; i++) {
			DataSet batch = train.generateBatch(batchSize);
			net.update(batch.getFeatures(), batch.getLabels());

			double loss = net.loss(batch.getFeatures(), batch.getLabels());
			lossList.add(loss);
			if (minLoss > loss) {
				minLoss = loss;
				ModelUtil.save(MnistData.MODEL_PATH, net.getParams());
			}

			if (i % epoch == 0) {
				double trainAcc = net.accuracy(train.getFeatures(), train.getLabels());
				double testAcc = net.accuracy(test.getFeatures(), test.getLabels());
				trainAccList.add(trainAcc);
				testAccList.add(testAcc);
				System.out.println("iters: " + i + " trainAcc: " + trainAcc + " testAcc: " + testAcc);
			}
		}
		System.out.println("Complete!");
	}
}
