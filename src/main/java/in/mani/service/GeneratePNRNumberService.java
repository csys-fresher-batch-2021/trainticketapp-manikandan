package in.mani.service;

public class GeneratePNRNumberService {

	private GeneratePNRNumberService() {

	}

	public static int getPNRNumber() {
		long min = 10000000;
		long max = 99999999;
		return (int) (Math.random() * (max - min + 1) + min);
	}
}
