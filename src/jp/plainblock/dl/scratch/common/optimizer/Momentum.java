package jp.plainblock.dl.scratch.common.optimizer;

import jp.plainblock.dl.scratch.common.Matrix;

public class Momentum implements Optimizer {

	private double learningRate = 0.01;
	private double momentum = 0.9;
	private double[] velocity1;
	private double[][] velocity2;

	public Momentum() {
		// pass
	}

	public Momentum(double learningRate) {
		this.learningRate = learningRate;
	}

	public Momentum(double learningRate, double momentum) {
		this.learningRate = learningRate;
		this.momentum = momentum;
	}

	@Override
	public double[] update(double[] param, double[] grad) {
		if (velocity1 == null) {
			velocity1 = new double[param.length];
		}
		Matrix.broadcastMuli(velocity1, momentum);
		Matrix.subi(velocity1, Matrix.broadcastMul(grad, learningRate));
		return Matrix.addi(param, velocity1);
	}

	@Override
	public double[][] update(double[][] param, double[][] grad){
		if (velocity2 == null) {
			velocity2 = new double[param.length][param[0].length];
		}
		Matrix.broadcastMuli(velocity2, momentum);
		Matrix.subi(velocity2, Matrix.broadcastMul(grad, learningRate));
		return Matrix.addi(param, velocity2);
	}

	public double getLearningRate() {
		return learningRate;
	}

	public void setLearningRate(double learningRate) {
		this.learningRate = learningRate;
	}

	public double getMomentum() {
		return momentum;
	}

	public void setMomentum(double momentum) {
		this.momentum = momentum;
	}

	public double[] getVelocity1() {
		return velocity1;
	}

	public double[][] getVelocity2() {
		return velocity2;
	}

}
