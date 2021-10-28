package jp.plainblock.dl.scratch.common.network;

import java.util.Map;

import jp.plainblock.dl.scratch.common.bean.Grads;

public interface Network {

	double[][] predict(double[][] x);

	double loss(double[][] x, double[][] t);

	double accuracy(double[][] x, double[][] t);

	Map<String, Grads> gradient(double[][] x, double[][] t);

	void update(double[][] x, double[][] t);

	double[][] getWeight(String key);

	double[] getBias(String key);

}
