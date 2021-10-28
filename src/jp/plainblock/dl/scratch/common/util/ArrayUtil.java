package jp.plainblock.dl.scratch.common.util;

public class ArrayUtil {

	public static void print(double[] target) {
		System.out.print("[");
		for (int i = 0; i < target.length; i++) {
			if (i > 0) {
				System.out.print(", ");
			}
			System.out.print(target[i]);
		}
		System.out.println("]");
	}

	public static void print(double[][] target) {
		if (target.length != 0) {
			System.out.print("[");
		}
		for (int i = 0; i < target.length; i++) {
			if (i > 0) {
				System.out.println("");
				System.out.print(",");
			}
			System.out.print("[");
			for (int j = 0; j < target[0].length; j++) {
				if (j > 0) {
					System.out.print(", ");
				}
				System.out.print(target[i][j]);
			}
			System.out.print("]");
		}
		if (target.length != 0) {
			System.out.println("]");
		}
	}

}
