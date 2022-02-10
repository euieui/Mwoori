package woori.hotel.service;

import java.util.HashMap;

public interface AdminBookService {

	void getAllCount(HashMap<String, Object> paramMap);

	void getAllBookList(HashMap<String, Object> paramMap);

	void getBookDetail(HashMap<String, Object> paramMap);

	void adminBookCancel(HashMap<String, Object> paramMap);

	void getCancelAllCount(HashMap<String, Object> paramMap);

	void getAdminCancelList(HashMap<String, Object> paramMap);

	

}
