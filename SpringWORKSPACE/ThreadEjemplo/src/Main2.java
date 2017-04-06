
public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread h = new Thread() {
				
			@Override
			public void run() {
				generarPrimos();
			}
			
			
			public void generarPrimos(){
				int numerosPrimos = 0;
				int max = 1000;
				int min = 0;
				
				while(numerosPrimos < 100){
					long currNum = (long) Math.floor(Math.random()*(max-min+1)+min); 
					if(Utils.isPrime(currNum)){
						numerosPrimos++;
						System.out.println(numerosPrimos+"- "+currNum);
					}
				}
			}

		};
		
		h.run();
	}

}