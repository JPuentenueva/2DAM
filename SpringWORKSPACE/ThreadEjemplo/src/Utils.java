
public class Utils {
	
	public static boolean isPrime(long n){
		boolean esPrimo = true;
		long div = 2;
		long tope = (long) Math.sqrt(n);
		while (esPrimo && div <= tope) {
			long res = n % div;
			if (res == 0)
				esPrimo = false;
			else 
				div++;
		}
		return esPrimo;
	}

}
