package woori.hotel.dao;

import java.util.HashMap;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
 
@Mapper(value="AdminDAO")
public interface AdminDAO {   

	void getAdmin(HashMap<String, Object> paramMap);

	void getallcountQnaList(HashMap<String, Object> paramMap);

	void adminlistQna(HashMap<String, Object> paramMap);

	  void getQna(HashMap<String, Object> paramMap);

	void updateQnaReply(HashMap<String, Object> paramMap);

	void adminlistQna2(HashMap<String, Object> paramMap);

	void adminlistQna3(HashMap<String, Object> paramMap);

	void adminlistQna4(HashMap<String, Object> paramMap);

	void getallcountQnaList1(HashMap<String, Object> paramMap);

	void listMember(HashMap<String, Object> paramMap);

	void getAllCountMember(HashMap<String, Object> paramMap);

 

}
