package in.mani.service;


public class GeneratePNRNumberService {
	public static int getPNRNumber() {
		long min = 10000000;
		long max = 99999999;
		int pnrNumber = (int)(Math.random()*(max-min+1)+min); 
		return pnrNumber;
	}
}

