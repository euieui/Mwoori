package woori.hotel.service.impl;

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

}
