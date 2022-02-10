package woori.hotel.service;

import java.util.HashMap;

public interface AdminService{

	void getAdmin(HashMap<String, Object> paramMap);


	void adminlistQna(HashMap<String, Object> paramMap);

	void getallcountQnaList(HashMap<String, Object> paramMap);


	void getQna(HashMap<String, Object> paramMap);

}
