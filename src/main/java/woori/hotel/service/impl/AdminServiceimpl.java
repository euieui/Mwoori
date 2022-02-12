package woori.hotel.service.impl;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import woori.hotel.dao.AdminDAO;
import woori.hotel.service.AdminService;
 
@Service(value="AdminService")
public class AdminServiceimpl extends EgovAbstractServiceImpl implements AdminService{
	@Resource(name="AdminDAO") AdminDAO adao;

	@Override
	public void getAdmin(HashMap<String, Object> paramMap) {
		adao.getAdmin(paramMap);
	}
	@Override
	public void getallcountQnaList1(HashMap<String, Object> paramMap) {
		adao.getallcountQnaList1(paramMap);	
		  
	}
	@Override
	public void getallcountQnaList(HashMap<String, Object> paramMap) {

			
		adao.getallcountQnaList(paramMap);
	}



	@Override
	public void getQna(HashMap<String, Object> paramMap) {
		adao.getQna(paramMap);
		
	}

	@Override
	public void updateQnaReply(HashMap<String, Object> paramMap) {
		adao.updateQnaReply(paramMap);
		
	}
	@Override
	public void adminlistQna(HashMap<String, Object> paramMap) {
	
		adao.adminlistQna(paramMap);
		
	}

	@Override
	public void adminlistQna2(HashMap<String, Object> paramMap) {
		adao.adminlistQna2(paramMap);		
	}

	@Override
	public void adminlistQna3(HashMap<String, Object> paramMap) {
		adao.adminlistQna3(paramMap);		
	}

	@Override
	public void adminlistQna4(HashMap<String, Object> paramMap) {
		adao.adminlistQna4(paramMap);		
	  }
	@Override
	public void listMember(HashMap<String, Object> paramMap) {
		adao.listMember(paramMap);		
	}
	@Override
	public void getAllCountMember(HashMap<String, Object> paramMap) {
		adao.getAllCountMember(paramMap);		
	} 




	

}
