package CurrencyConvertor.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CurrencyConvertor.Entities.CurrencyEntity;
import CurrencyConvertor.Helper.ResponseMessage;
import CurrencyConvertor.Services.CurrencyService;

@RestController
@RequestMapping("/currency/v1")
@CrossOrigin
public class CurrencyController {

	@Autowired
	private CurrencyService cs;
	
	 Logger logger=LoggerFactory.getLogger(CurrencyController.class);
	@PostMapping("/convert")
	public ResponseEntity<ResponseMessage> getCurrencyValue(@RequestBody CurrencyEntity ce){
		logger.info("Rate that getting from resp"+ce.getAmount());
		double val=cs.exchangeRate(ce);
		double rate=val;
		logger.info("Rate before response"+val);
		ResponseMessage msg = ResponseMessage.builder().status(HttpStatus.OK).message("Success").rate(rate).build();
		return ResponseEntity.ok(msg);
	}
}
