package jp.plainblock.dl.scratch.common.layer;

public interface Layer {

	double[][] forward(double[][] x);

	double[][] backward(double[][] dy);

	double[][] dW();

	double[] db();

}
