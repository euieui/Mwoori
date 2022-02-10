package woori.hotel.service;

import java.util.HashMap;

public interface QnaService {

	void listQna(HashMap<String, Object> paramMap);

	void insertQna(HashMap<String, Object> paramMap);

	void getQna(HashMap<String, Object> paramMap);

	void deleteQna(HashMap<String, Object> paramMap);

	void updateQna(HashMap<String, Object> paramMap);

}
