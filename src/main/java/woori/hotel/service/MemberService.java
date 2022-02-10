package woori.hotel.service;

import java.util.HashMap;

public interface MemberService {

	void getMember(HashMap<String, Object> paramMap);
	void confirmPhone1(HashMap<String, Object> paramMap);
	void confirmPhone2(HashMap<String, Object> paramMap);
	void resetPw(HashMap<String, Object> paramMap);
	void selectAddressByDong(HashMap<String, Object> paramMap);
	void insertMember(HashMap<String, Object> paramMap);
	void updateMember(HashMap<String, Object> paramMap);

}
