package jp.plainblock.dl.scratch.common.layer;

import jp.plainblock.dl.scratch.common.Matrix;
import jp.plainblock.dl.scratch.common.network.Network;

public class AffineLayer implements Layer {

	private String key;
	private Network net;
	private double[][] W;
	private double[] b;
	private double[][] x;
	private double[][] dW;
	private double[] db;

	public AffineLayer(Network net, String key) {
		this.net = net;
		this.key = key;
	}

	@Override
	public double[][] forward(double[][] x) {
		this.x = x;
		this.W = net.getWeight(key);
		this.b = net.getBias(key);
		return Matrix.broadcastAdd(Matrix.dot(x, W), b);
	}

	@Override
	public double[][] backward(double[][] dy) {
		double[][] dx = Matrix.dot(dy, Matrix.transpose(W));
		this.dW = Matrix.dot(Matrix.transpose(x), dy);
		this.db = Matrix.aggregate(dy);
		return dx;
	}

	public double[][] getWeight() {
		return W;
	}

	public void setWeight(double[][] weight) {
		W = weight;
	}

	public double[] getBias() {
		return b;
	}

	public void setBias(double[] bias) {
		this.b = bias;
	}

	public double[][] dW() {
		return dW;
	}

	public double[] db() {
		return db;
	}

}
