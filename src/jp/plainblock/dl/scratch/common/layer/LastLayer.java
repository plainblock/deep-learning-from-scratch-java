package jp.plainblock.dl.scratch.common.layer;

public interface LastLayer {

	double forward(double[][] x, double[][] t);

	double[][] backward(double dy);

}
