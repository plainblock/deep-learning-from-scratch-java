package jp.plainblock.dl.scratch.common.optimizer;

import jp.plainblock.dl.scratch.common.Matrix;

public class AdaGrad implements Optimizer {

	private double learningRate = 0.01;
	private double[] squaredSum1;
	private double[][] squaredSum2;

	public AdaGrad() {
		// pass
	}

	public AdaGrad(double learningRate) {
		this.learningRate = learningRate;
	}

	@Override
	public double[] update(double[] param, double[] grad) {
		if (squaredSum1 == null) {
			squaredSum1 = new double[param.length];
		}
		Matrix.addi(squaredSum1, Matrix.pow(grad, 2));
		double[] h = squaredSum1;
		h = Matrix.powi(h, 0.5);
		h = Matrix.broadcastAddi(h, 1e-7);
		h = Matrix.divi(Matrix.broadcastMul(grad, learningRate), h);
		return Matrix.subi(param, h);
	}

	@Override
	public double[][] update(double[][] param, double[][] grad) {
		if (squaredSum2 == null) {
			squaredSum2 = new double[param.length][param[0].length];
		}
		Matrix.addi(squaredSum2, Matrix.pow(grad, 2));
		double[][] h = squaredSum2;
		h = Matrix.powi(h, 0.5);
		h = Matrix.broadcastAddi(h, 1e-7);
		h = Matrix.divi(Matrix.broadcastMul(grad, learningRate), h);
		return Matrix.subi(param, h);
	}

	public double getLearningRate() {
		return learningRate;
	}

	public void setLearningRate(double learningRate) {
		this.learningRate = learningRate;
	}

	public double[] getSquaredSum1() {
		return squaredSum1;
	}

	public double[][] getSquaredSum2() {
		return squaredSum2;
	}

}
