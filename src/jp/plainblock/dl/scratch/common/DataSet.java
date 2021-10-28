package jp.plainblock.dl.scratch.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataSet {

	private double[][] features;
	private double[][] labels;

	public DataSet(double[][] features, double[][] labels) {
		this.features = features;
		this.labels = labels;
	}

	public DataSet(double[][] features, double[] labels, int kinds) {
		this.features = features;
		this.labels = toOnehots(labels, kinds);
	}

	public DataSet generateBatch(int batchSize) {
		List<Integer> indexList = generateIndexList(batchSize);
		double[][] batchFeatures = electData(features, indexList);
		double[][] batchLabels = electData(labels, indexList);
		return new DataSet(batchFeatures, batchLabels);
	}

	private List<Integer> generateIndexList(int batchSize) {
		List<Integer> tmpList = new ArrayList<>();
		for (int i = 0; i < features.length; i++) {
			tmpList.add(i);
		}
		Collections.shuffle(tmpList);
		List<Integer> indexList = new ArrayList<>();
		for (int i = 0; i < batchSize; i++) {
			indexList.add(tmpList.get(i));
		}
		return indexList;
	}

	private double[][] electData(double[][] target, List<Integer> indexList) {
		double[][] data = new double[indexList.size()][target[0].length];
		int i = 0;
		for (Integer index : indexList) {
			data[i] = target[index];
			i++;
		}
		return data;
	}

	private double[] toOnehot(double label, int kinds) {
		double[] onehot = new double[kinds];
		for (int i = 0; i < kinds; i++) {
			if (i == label) {
				onehot[i] = 1.0;
			} else {
				onehot[i] = 0.0;
			}
		}
		return onehot;
	}

	private double[][] toOnehots(double[] labels, int kinds) {
		double[][] onehots = new double[labels.length][kinds];
		for (int i = 0; i < labels.length; i++) {
			onehots[i] = toOnehot(labels[i], kinds);
		}
		return onehots;
	}

	public double[][] getFeatures() {
		return features;
	}

	public double[][] getLabels() {
		return labels;
	}

	public int getSize() {
		return features.length;
	}

	public int getDimension() {
		return features[0].length;
	}

}
