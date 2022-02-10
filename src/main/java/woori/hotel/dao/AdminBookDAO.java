package woori.hotel.dao;

import java.util.HashMap;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper(value="AdminBookDAO")
public interface AdminBookDAO {

	// get all count
	void getAllCount(HashMap<String, Object> paramMap);

	void getAllCountWithId(HashMap<String, Object> paramMap);

	void getAllCountWithIdBooknums(HashMap<String, Object> paramMap);

	void getAllCountWithBooknum(HashMap<String, Object> paramMap);

	void getAllCountWithIndateOutdate(HashMap<String, Object> paramMap);

	void getAllCountWithIndate(HashMap<String, Object> paramMap);

	void getAllCountWithOutdate(HashMap<String, Object> paramMap);

	void getAllCountWithIdIndateOutdate(HashMap<String, Object> paramMap);

	void getAllCountWithIdIndate(HashMap<String, Object> paramMap);

	void getAllCountWithIdOutdate(HashMap<String, Object> paramMap);

	// get book list
	void getAllBookList(HashMap<String, Object> paramMap);

	void getAllBookListWithBooknum(HashMap<String, Object> paramMap);

	void getAllBookListWithId(HashMap<String, Object> paramMap);

	void getAllBookListWithIdBooknum(HashMap<String, Object> paramMap);

	void getAllBookListWithIndateOutdate(HashMap<String, Object> paramMap);

	void getAllBookListWithIndate(HashMap<String, Object> paramMap);

	void getAllBookListWithOutdate(HashMap<String, Object> paramMap);

	void getAllBookListWithIdIndateOutdate(HashMap<String, Object> paramMap);

	void getAllBookListWithIdIndate(HashMap<String, Object> paramMap);

	void getAllBookListWithIdOutdate(HashMap<String, Object> paramMap);
	
	
	
	

}
