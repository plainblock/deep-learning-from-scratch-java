package jp.plainblock.dl.scratch.common.bean;

public class Params {

	private double[][] weight;
	private double[] bias;

	public Params(double[][] weight, double[] bias) {
		this.weight = weight;
		this.bias = bias;
	}

	public double[][] getWeight() {
		return weight;
	}

	public void setWeight(double[][] weight) {
		this.weight = weight;
	}

	public double[] getBias() {
		return bias;
	}

	public void setBias(double[] bias) {
		this.bias = bias;
	}

}
