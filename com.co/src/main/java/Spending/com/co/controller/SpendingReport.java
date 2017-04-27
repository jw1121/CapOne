package Spending.com.co.controller;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Spending.com.co.business.LevelMoney;
import Spending.com.co.model.SpentIncome;
import Spending.com.co.model.Transaction;

@RestController
public class SpendingReport {
	List<Transaction> trans;
	
	@RequestMapping("/getmonthlyaverage")
	public Map<String, String> getMonthlyAvg(@RequestParam(value="api", defaultValue="false") boolean api) {
		
		if(trans == null || trans.size() == 0) {
			trans = LevelMoney.getAllTransaction();		
		} else if(api) {
			trans = LevelMoney.getAllTransaction();		
		}
		
		return getMonthlyAvgTable(trans);
	}
	
	@RequestMapping("/getmonthlyspentIncomeavg")
	public Map<String, SpentIncome> getMonthlySpentIncomeAvg(@RequestParam(value="api", defaultValue="false") boolean api) {
		if(trans == null || trans.size() == 0) {
			trans = LevelMoney.getAllTransaction();		
		} else if(api) {
			trans = LevelMoney.getAllTransaction();		
		}
		
		return getMonthlySpentIncomeAvgTable(trans);
	}
	
	@RequestMapping("/getignorecc")
	public Map<String, SpentIncome>getignorecc(@RequestParam(value="api", defaultValue="false") boolean api) {
		if(trans == null || trans.size() == 0) {
			trans = LevelMoney.getAllTransaction();		
		} else if(api) {
			trans = LevelMoney.getAllTransaction();		
		}
		
		return IgnoreCCMonthlyAvgTable(trans);
	}
	
	
	private Map<String, SpentIncome> IgnoreCCMonthlyAvgTable(List<Transaction> allTrans) {
		
		HashMap<String, TransSum> avg = new HashMap<String, TransSum>();
		
		if(allTrans == null || allTrans.isEmpty()) return new HashMap<String, SpentIncome>();

		for(Transaction tran : allTrans) {
			String yrsMnth = getYearMonth(tran.getTransactionTime());
			
			String merchant = tran.getRawMerchant();
			if(merchant.contains("CC PAYMENT") || merchant.contains("CREDIT CARD")) continue;
			TransSum monthlySum = null;
			monthlySum = avg.get(yrsMnth);
			if(monthlySum == null) {				
				avg.put(yrsMnth, new TransSum(tran.getAmount(), 1, false));
			} else {
				avg.put(yrsMnth, monthlySum.addSpentIncome(tran.getAmount()));
			}
		}
		
		Map<String, SpentIncome> map = new TreeMap<String, SpentIncome>();
		for(Map.Entry<String,TransSum> entry : avg.entrySet()) {
			  String key = entry.getKey();
			  TransSum value = entry.getValue();
			  
			  String spent = getAverage(-value.getSpent(), value.getSpentCount());
			  String income = getAverage(value.getIncome(), value.getIncomeCount());
			  map.put(key, new SpentIncome(spent, income));
			}
		return map;
	}


	private Map<String, SpentIncome> getMonthlySpentIncomeAvgTable(List<Transaction> allTrans) {
		
		HashMap<String, TransSum> avg = new HashMap<String, TransSum>();
		
		if(allTrans == null || allTrans.isEmpty()) return new HashMap<String, SpentIncome>();

		for(Transaction tran : allTrans) {
			String yrsMnth = getYearMonth(tran.getTransactionTime());
			
			TransSum monthlySum = null;
			monthlySum = avg.get(yrsMnth);
			if(monthlySum == null) {				
				avg.put(yrsMnth, new TransSum(tran.getAmount(), 1, false));
			} else {
				avg.put(yrsMnth, monthlySum.addSpentIncome(tran.getAmount()));
			}
		}
		
		Map<String, SpentIncome> map = new TreeMap<String, SpentIncome>();
		for(Map.Entry<String,TransSum> entry : avg.entrySet()) {
			  String key = entry.getKey();
			  TransSum value = entry.getValue();
			  
			  String spent = getAverage(-value.getSpent(), value.getSpentCount());
			  String income = getAverage(value.getIncome(), value.getIncomeCount());
			  map.put(key, new SpentIncome(spent, income));
			}
		return map;
	}
	
	
	private Map<String, String> getMonthlyAvgTable(List<Transaction> allTrans) {
		
		HashMap<String, TransSum> avg = new HashMap<String, TransSum>();
		
		if(allTrans == null || allTrans.isEmpty()) return new HashMap<String, String>();

		TransSum monthlySum = null;
		for(Transaction tran : allTrans) {
			String yrsMnth = getYearMonth(tran.getTransactionTime());
			
			monthlySum = avg.get(yrsMnth);
			if(monthlySum == null) {
				avg.put(yrsMnth, new TransSum(tran.getAmount(), 1));
			} else {
				avg.put(yrsMnth, monthlySum.addTotal(tran.getAmount()));
			}
		}
		
		Map<String, String> map = new TreeMap<String, String>();
		for(Map.Entry<String,TransSum> entry : avg.entrySet()) {
			  String key = entry.getKey();
			  TransSum value = entry.getValue();
			  map.put(key, getAverage(value.getTotal(), value.getCount()));
			}
		return map;
	}
	
	private static DecimalFormat df = new DecimalFormat(".00");
	
	private String getAverage(long amount, int count) {
		return "$" + df.format(amount/count);
	}
	
	private String getYearMonth(String datetime) {
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.ssss'Z'");
		DateTime dt = formatter.parseDateTime(datetime);
		
		DateTimeFormatter formatt = DateTimeFormat.forPattern("yyyy-MM");
		return formatt.print(dt);
	}
	
	
	private class TransSum implements Serializable {
		
		long spent;
		long income;
		long total;
		int spentCount;
		int incomeCount;
		int count;
		
		public TransSum() {
		}
		
		public TransSum(long total, int count) {
			this.total = total;
			this.count = count;
		}
		
		public TransSum(long amount, int count, boolean isTotal) {
			if(!isTotal) {
				if(amount > 0) {
					this.income = income;
					incomeCount++;
				} else {
					this.spent = spent;
					spentCount++;
				}
			} else {
				this.total = amount;				
				this.count = count;	
			}
		}

		public TransSum addSpentIncome(long amount) {
			if(amount > 0) {
				this.income += amount;
				incomeCount++;
			} else {
				this.spent += amount;
				spentCount++;
			}
			
			return this;
		}

		public TransSum addTotal(long total) {
			this.total += total;
			this.count++;
			
			return this;
		}

		public long getSpent() {
			return spent;
		}

		public void setSpent(long spent) {
			this.spent = spent;
		}

		public long getIncome() {
			return income;
		}

		public void setIncome(long income) {
			this.income = income;
		}

		public long getTotal() {
			return total;
		}

		public void setTotal(long total) {
			this.total = total;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		public int getSpentCount() {
			return spentCount;
		}

		public void setSpentCount(int spentCount) {
			this.spentCount = spentCount;
		}

		public int getIncomeCount() {
			return incomeCount;
		}

		public void setIncomeCount(int incomeCount) {
			this.incomeCount = incomeCount;
		}
	}
}
