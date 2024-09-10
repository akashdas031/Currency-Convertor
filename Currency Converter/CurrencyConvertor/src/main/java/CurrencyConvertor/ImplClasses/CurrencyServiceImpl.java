package CurrencyConvertor.ImplClasses;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import CurrencyConvertor.Entities.CurrencyEntity;
import CurrencyConvertor.Services.CurrencyService;
@Service
public class CurrencyServiceImpl implements CurrencyService{

	 Logger logger=LoggerFactory.getLogger(CurrencyServiceImpl.class);
	
	private static final String[] countryCode= {"USD", "EUR", "JPY", "GBP", "AUD", "CAD", "CHF", "CNY", "INR", "BRL"};
	private static	final double[][] exchangeRates = {
		        // USD   EUR    JPY    GBP    AUD    CAD    CHF    CNY    INR    BRL
		        {1.00, 0.85, 110.0, 0.75, 1.35, 1.25, 0.90, 6.45, 83.53, 5.00}, // USD
		        {1.18, 1.00, 129.5, 0.88, 1.59, 1.47, 1.06, 7.58, 88.2, 5.88}, // EUR
		        {0.0091, 0.0077, 1.00, 0.0068, 0.012, 0.011, 0.0082, 0.058, 0.68, 0.045}, // JPY
		        {1.33, 1.14, 147.2, 1.00, 1.81, 1.66, 1.20, 8.62, 100.3, 6.67}, // GBP
		        {0.74, 0.63, 83.0, 0.55, 1.00, 0.92, 0.67, 4.76, 55.4, 3.68}, // AUD
		        {0.80, 0.68, 90.0, 0.60, 1.09, 1.00, 0.73, 5.16, 60.2, 4.00}, // CAD
		        {1.11, 0.94, 122.0, 0.83, 1.49, 1.37, 1.00, 7.10, 82.5, 5.47}, // CHF
		        {0.16, 0.13, 17.1, 0.12, 0.21, 0.19, 0.14, 1.00, 11.6, 0.77}, // CNY
		        {0.011968001066751964, 0.011, 1.47, 0.010, 0.018, 0.017, 0.012, 0.086, 1.00, 0.066}, // INR
		        {0.20, 0.17, 22.0, 0.15, 0.27, 0.25, 0.18, 1.30, 15.2, 1.00}  // BRL
		    };
	private static final Map<String,Integer> m=new HashMap<>();
		static {
			try {
				for(int i=0;i< countryCode.length;i++) {
					m.put(countryCode[i], i);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	@Override
	public  double exchangeRate(CurrencyEntity ce) {
		Integer fromIndex=m.get(ce.getFrom().toUpperCase());
		logger.info("from index"+fromIndex);
		Integer toIndex=m.get(ce.getTo().toUpperCase());
		logger.info("to index"+toIndex);
		if(fromIndex == null || toIndex == null) {
			throw new IllegalArgumentException("Invalid Country Code");
	}
		
		double exchangeRate=exchangeRates[fromIndex][toIndex];
		logger.info("exchange Rate"+exchangeRate);
		double res=exchangeRate*ce.getAmount();
		logger.info("Final amount "+res);
		return res;
		
	
	// get Exchange rate
			 
		/*String key=ce.getFrom()+"_"+ce.getTo();
		logger.info(key);
		double rate=1;
		if(m.containsKey(key)) {
			double rem=m.get(key);
			rate=ce.getRate()*rem;
			ce.setRate(rate);
			logger.info(""+ce.getRate());
			*/
		/*	}
		
		
	}*/
	}
}
