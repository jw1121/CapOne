package Spending.com.co.business;

import java.util.List;

import org.springframework.web.client.RestTemplate;

import Spending.com.co.model.Args;
import Spending.com.co.model.GetAllTransactionRequest;
import Spending.com.co.model.GetAllTransactionResponse;
import Spending.com.co.model.LoginRequest;
import Spending.com.co.model.LoginResponse;
import Spending.com.co.model.Transaction;

public class LevelMoney {

	private String getToken() {
		final String uri = "https://2016.api.levelmoney.com/api/v2/core/login";
		 
	    LoginRequest login = new LoginRequest();
	    LoginRequest.LoginArgs args = login.new LoginArgs();
	    
	    login.setEmail("interview@levelmoney.com");
	    login.setPassword("password2");
	    args.setUid(1110590645);
	    args.setJsonStrictMode(false);
	    args.setJsonVerboseResponse(false);
	    args.setApiToken("AppTokenForInterview");
	    args.setToken("9B5F6DB2ABB2D1D909339FBFF94E4424");
	    login.setArgs(args);
	    
	    RestTemplate restTemplate = new RestTemplate();
	    LoginResponse result = restTemplate.postForObject( uri, login, LoginResponse.class);
	 
	    if(result == null) return null;
	    if(!result.getError().equalsIgnoreCase("no-error")) return null;
	    
	    return result.getToken();
		
	}
	
	public static List<Transaction> getAllTransaction() {
		
	    final String uri = "https://2016.api.levelmoney.com/api/v2/core/get-all-transactions";
	 
	    Args arg = new Args();
	    arg.setUid(1110590645);
	    arg.setToken("E36600A79B2419931601C4BE9B6DC32E");
	    arg.setApiToken("AppTokenForInterview");
	    arg.setJsonStrictMode(false);
	    arg.setJsonVerboseResponse(false);
	    
	    GetAllTransactionRequest req = new GetAllTransactionRequest();
	    req.setArgs(arg);
	    
	    RestTemplate restTemplate = new RestTemplate();
	    GetAllTransactionResponse result = restTemplate.postForObject( uri, req, GetAllTransactionResponse.class);
	 
	    if(result == null) return null;
	    if(!result.getError().equalsIgnoreCase("no-error")) return null;
	    if(result.getTransactions() == null) return null;
	    if(result.getTransactions().isEmpty()) return null;
	    
	    return result.getTransactions();
	}

}
