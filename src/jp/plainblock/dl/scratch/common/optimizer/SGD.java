package jp.plainblock.dl.scratch.common.optimizer;

import jp.plainblock.dl.scratch.common.Matrix;

public class SGD implements Optimizer {

	private double learningRate = 0.01;

	public SGD() {
		// pass
	}

	public SGD(double learningRate) {
		this.learningRate = learningRate;
	}

	@Override
	public double[] update(double[] param, double[] grad) {
		return Matrix.subi(param, Matrix.broadcastMul(grad, learningRate));
	}

	@Override
	public double[][] update(double[][] param, double[][] grad) {
		return Matrix.subi(param, Matrix.broadcastMul(grad, learningRate));
	}

	public double getLearningRate() {
		return learningRate;
	}

	public void setLearningRate(double learningRate) {
		this.learningRate = learningRate;
	}

}
