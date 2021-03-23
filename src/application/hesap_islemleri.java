package application;

public class hesap_islemleri  extends deiskenler{

	public hesap_islemleri () {
		
	}
	
	double multiply (double sayi1 , double sayi2)
	{
		return sayi1 * sayi2 ;
		
	}
	
	double divply (double sayi1 , double sayi2)
	{
		return sayi1 / sayi2 ;
		
	}
	
	
}

 class hesaplama extends hesap_islemleri {
	
	public hesaplama () {
		
	}
	//overload
	double add (double sayi1 , double sayi2 ) {
		return sayi1 + sayi2 ;
		
	}
	
	double add (double sayi1 , double sayi2 , double sayi3 ) {
		return sayi1 + sayi2 + sayi3 ;
		
	}
	
	double subsract (double sayi1 , double sayi2 )
	{
		return sayi1+ sayi2 ;
		
	}
	
	@Override
	double divply (double sayi1 , double sayi2)
	{
		if (sayi2 == 0) {
			System.out.println("ivalid");
			return 0 ;
		}
		return sayi1 / sayi2 ;
		
	}
}
