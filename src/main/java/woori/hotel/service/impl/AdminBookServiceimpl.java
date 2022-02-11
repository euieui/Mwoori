package woori.hotel.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import woori.hotel.dao.AdminBookDAO;
import woori.hotel.service.AdminBookService;

@Service(value="AdminBookService")
public class AdminBookServiceimpl extends EgovAbstractServiceImpl implements AdminBookService{
	@Resource(name="AdminBookDAO") AdminBookDAO abdao;

	@Override
	public void getAllCount(HashMap<String, Object> paramMap) {
		String id = (String) paramMap.get("id");
		String booknums = paramMap.get("booknums").toString();
		String indate = (String) paramMap.get("indate");
		String outdate = (String) paramMap.get("outdate");
		System.out.println("카운트 메소드 in");
		if(id.equals("") && booknums.equals("") && indate.equals("") && outdate.equals("")) {
			abdao.getAllCount(paramMap);
			System.out.println("전체 검색 count in");}
		else if(!id.equals("") && booknums.equals("") && indate.equals("") && outdate.equals(""))
			abdao.getAllCountWithId(paramMap);
		else if(!id.equals("") && !booknums.equals("") && indate.equals("") && outdate.equals(""))
			abdao.getAllCountWithIdBooknums(paramMap);
		else if(id.equals("") && !booknums.equals("") && indate.equals("") && outdate.equals("")) {
			abdao.getAllCountWithBooknum(paramMap);
			System.out.println("booknum in!!");}
		else if((id.equals("") && booknums.equals("") && !indate.equals("")) ||
				(id.equals("") && booknums.equals("") && !outdate.equals(""))) {
			if(!indate.equals("") && !outdate.equals(""))
				abdao.getAllCountWithIndateOutdate(paramMap);
			else if(!indate.equals("") && outdate.equals(""))
				abdao.getAllCountWithIndate(paramMap);
			else if(indate.equals("") && !outdate.equals(""))
				abdao.getAllCountWithOutdate(paramMap);
		} else if((booknums.equals("") && !id.equals("") && !indate.equals("")) ||
				(booknums.equals("") && !id.equals("") && !outdate.equals(""))) {
			if(!indate.equals("") && !outdate.equals(""))
				abdao.getAllCountWithIdIndateOutdate(paramMap);
			else if(!indate.equals("") && outdate.equals(""))
				abdao.getAllCountWithIdIndate(paramMap);
			else if(indate.equals("") && !outdate.equals(""))
				abdao.getAllCountWithIdOutdate(paramMap);
		}else {System.out.println("else!");}
	}

	@Override
	public void getAllBookList(HashMap<String, Object> paramMap) {
		String id = (String) paramMap.get("id");
		String booknums = paramMap.get("booknums").toString();
		String indate = (String) paramMap.get("indate");
		String outdate = (String) paramMap.get("outdate");
		System.out.println("id : "+id+", booknum : "+booknums+", indate : "+indate+", outdate : "+outdate);
		if(id.equals("") && booknums.equals("") && indate.equals("") && outdate.equals("")) 
			abdao.getAllBookList(paramMap);
		else if(id.equals("") && !booknums.equals("") && indate.equals("") && outdate.equals("")) 
			abdao.getAllBookListWithBooknum(paramMap);
		else if(!id.equals("") && booknums.equals("") && indate.equals("") && outdate.equals(""))
			abdao.getAllBookListWithId(paramMap);
		else if(!id.equals("") && !booknums.equals("") && indate.equals("") && outdate.equals(""))
			abdao.getAllBookListWithIdBooknum(paramMap);
		else if((id.equals("") && booknums.equals("") && !indate.equals("")) || 
				(id.equals("") && booknums.equals("") && !outdate.equals(""))) {
			if(!indate.equals("") && !outdate.equals(""))
				abdao.getAllBookListWithIndateOutdate(paramMap);
			else if(!indate.equals("") && outdate.equals(""))
				abdao.getAllBookListWithIndate(paramMap);
			else if(indate.equals("") && !outdate.equals(""))
				abdao.getAllBookListWithOutdate(paramMap);
		} else if((!id.equals("") && booknums.equals("") && !indate.equals("")) || 
				(!id.equals("") && booknums.equals("") && !outdate.equals(""))) {
			if(!indate.equals("") && !outdate.equals(""))
				abdao.getAllBookListWithIdIndateOutdate(paramMap);
			else if(!indate.equals("") && outdate.equals(""))
				abdao.getAllBookListWithIdIndate(paramMap);
			else if(indate.equals("") && !outdate.equals(""))
				abdao.getAllBookListWithIdOutdate(paramMap);
		}
		
		
	}

	@Override
	public void getBookDetail(HashMap<String, Object> paramMap) {
		abdao.getBookDetail(paramMap);
	}

	@Override
	public void adminBookCancel(HashMap<String, Object> paramMap) {
		abdao.adminBookCancel(paramMap);
	}

	@Override
	public void getCancelAllCount(HashMap<String, Object> paramMap) {
		abdao.getCancelAllCount(paramMap);
	}

	@Override
	public void getAdminCancelList(HashMap<String, Object> paramMap) {
		abdao.getAdminCancelList(paramMap);
	}

	@Override
	public void getMaxBed(HashMap<String, Object> paramMap) {
		abdao.getMaxBed(paramMap);
	}

	@Override
	public void changePeople(HashMap<String, Object> paramMap) {
		abdao.changePeople(paramMap);
	}

	@Override
	public void requestBookCancel(HashMap<String, Object> paramMap) {
		String result = paramMap.get("result").toString();
		int price = (int) paramMap.get("price");
		int bdseq = (int) paramMap.get("bdseq");
		if(result.equals("0")) {
			abdao.adminBookCancel(paramMap);
		} else if(result.equals("1")) {
			
			int totalPrice = 0;
			int calPrice;
			Date today = new Date();
			String checkinStr = paramMap.get("checkin").toString();
			String checkoutStr = paramMap.get("checkout").toString();
			Date checkinTs = Timestamp.valueOf(checkinStr);
			Date checkoutTs = Timestamp.valueOf(checkoutStr);
			
			int checkinYear = checkinTs.getYear() + 1900; 
			int checkoutYear = checkoutTs.getYear() + 1900;
			long confirmTime = (checkinTs.getTime() - today.getTime())/1000;
			
			String confirm5St = Integer.toString(checkinYear); confirm5St += "-05-01 00:00:00.0";
			Date confirm5Ts = Timestamp.valueOf(confirm5St);
			String confirm11St = Integer.toString(checkinYear); confirm11St += "-11-01 00:00:00.0";
			Date confirm11Ts = Timestamp.valueOf(confirm11St);
			String confirm1224St = Integer.toString(checkinYear); confirm1224St += "-12-24 00:00:00.0";
			Date confirm1224Ts = Timestamp.valueOf(confirm1224St);
			
			String confirm0101St = Integer.toString(checkoutYear); confirm0101St += "-01-01 00:00:00.0";
			Date confirm0101Ts = Timestamp.valueOf(confirm0101St);
			
			long calDateDays = calDays(checkinTs, checkoutTs);
			calPrice = (int) (price / calDateDays);
			
		
			
			
			// 21600 6시간 유예초 180초  21780
			// 체크인 하루전 18시 이후에 취소하는지 안하는지?
			if(21780>=confirmTime) {
				// 체크인과 체크아웃 년도가 같은지?
				if(checkinTs.getYear() == checkoutTs.getYear()) {
					// 체크인이 5월 전 체크아웃 5월 전 
					if(confirm5Ts.compareTo(checkinTs)>0 && confirm5Ts.compareTo(checkoutTs)>=0) {
						totalPrice = calTotalPrice10(checkinTs, checkoutTs,calPrice);
						paramMap.put("refund", totalPrice);
						abdao.requestBookCancel(paramMap);
					// 체크인 5월전 체크아웃 5월 후	
					}else if (confirm5Ts.compareTo(checkinTs)>0 && confirm5Ts.compareTo(checkoutTs)<0 ){
						totalPrice = calTotalPriceBtw(checkinTs, checkoutTs, confirm5Ts,calPrice);
						paramMap.put("refund", totalPrice);
						abdao.requestBookCancel(paramMap);
					// 체크인이 5월뒤에 체크아웃이 10.31 안에있을때
					}else if( confirm5Ts.compareTo(checkinTs)<=0 && confirm11Ts.compareTo(checkoutTs)>0) {
						totalPrice = calTotalPrice80(checkinTs, checkoutTs,calPrice);
						paramMap.put("refund", totalPrice);
						abdao.requestBookCancel(paramMap);
					//체크인이 11월 안 체크아웃이 11월 밖	
					}else if(confirm11Ts.compareTo(checkinTs)>0 && confirm11Ts.compareTo(checkoutTs)<0 ) {
						totalPrice = calTotalPriceBtwReverse(checkinTs, checkoutTs, confirm11Ts,calPrice);
						paramMap.put("refund", totalPrice);
						abdao.requestBookCancel(paramMap);
					//체크인이 11월 이후 체크아웃으 1224 전
					}else if(confirm11Ts.compareTo(checkinTs)<=0 && confirm1224Ts.compareTo(checkoutTs)>=0) {
						totalPrice = calTotalPrice10(checkinTs, checkoutTs,calPrice);
						paramMap.put("refund", totalPrice);
						abdao.requestBookCancel(paramMap);
					// 체크인이 1224전 체크아웃이 1224 후
					}else if(confirm1224Ts.compareTo(checkinTs)>0 && confirm1224Ts.compareTo(checkoutTs)<=0) {
						totalPrice = calTotalPriceBtw(checkinTs, checkoutTs, confirm1224Ts,calPrice);
						paramMap.put("refund", totalPrice);
						abdao.requestBookCancel(paramMap);
					}else {
						totalPrice = calTotalPrice80(checkinTs, checkoutTs,calPrice);
						paramMap.put("refund", totalPrice);
						abdao.requestBookCancel(paramMap);
					}
					
					
				// 체크인과 체크아웃 년도가 안같은 경우
				}else { 
					// 두가지가 있다 첫째 1224 전에 체크인
					if(confirm1224Ts.compareTo(checkinTs)>0) {
						int totalPrice1 = calTotalPrice10(checkinTs,confirm1224Ts,calPrice); 
						int totalPrice2 = calTotalPrice80(confirm1224Ts, confirm0101Ts,calPrice);
						int totalPrice3 = calTotalPrice10(confirm0101Ts,checkoutTs,calPrice);
						totalPrice = totalPrice1 + totalPrice2 + totalPrice3;
						paramMap.put("refund", totalPrice);
						abdao.requestBookCancel(paramMap);
					// 둘때 1224후 체크인
					} else {
						int totalPrice1 = calTotalPrice80(checkinTs, confirm0101Ts,calPrice);
						int totalPrice2 = calTotalPrice10(confirm0101Ts,checkoutTs,calPrice);
						totalPrice = totalPrice1 + totalPrice2;
						paramMap.put("refund", totalPrice);
						abdao.requestBookCancel(paramMap);
					}
				}		
			}else {
				totalPrice = price;
				paramMap.put("refund", totalPrice);
				abdao.requestBookCancel(paramMap);
	}
		}

}
	
	
	private int calTotalPriceBtwReverse(Date checkinTs, Date checkoutTs, Date confirmDate, int calPrice) {
		int totalPrice;
		long calDateDays1 = calDays(checkinTs,confirmDate);
		totalPrice= (int) (calPrice*calDateDays1*20/100);
		long calDateDays2 = calDays(confirmDate, checkoutTs);
		totalPrice += (int)(calPrice*calDateDays2*90/100);
		return totalPrice;
	}

	private int calTotalPrice80(Date checkinTs, Date checkoutTs, int calPrice) {
		long calDateDays = calDays(checkinTs,checkoutTs);
		System.out.println("calDateDays :" + calDateDays);
		return (int)((calPrice*calDateDays)*20/100);
	}

	private int calTotalPriceBtw(Date checkinTs, Date checkoutTs, Date confirmDate, int calPrice) {
		int totalPrice;
		long calDateDays1 = calDays(checkinTs,confirmDate);
		totalPrice= (int) (calPrice*calDateDays1*90/100);
		long calDateDays2 = calDays(confirmDate, checkoutTs);
		totalPrice += (int)(calPrice*calDateDays2*20/100);
		return totalPrice;
	}

	private int calTotalPrice10(Date checkinTs, Date checkoutTs, int calPrice) {
		long calDateDays = calDays(checkinTs,checkoutTs);
		System.out.println("calDateDays :" + calDateDays);
		return (int)((calPrice*calDateDays)*90/100);
	}

	private long calDays(Date date1, Date date2) {
		long calDate = date1.getTime() - date2.getTime();
		
		long calDateDays = calDate / ( 24*60*60*1000); 
		calDateDays = Math.abs(calDateDays);
		return calDateDays;
	}

	@Override
	public void updateBookResult(HashMap<String, Object> paramMap) {
		abdao.updateBookResult(paramMap);
	}
	
	
	
	
}
