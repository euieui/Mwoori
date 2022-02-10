package woori.hotel.dao;

import java.util.HashMap;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper(value="QnaDAO")
public interface QnaDAO {

	void listQna(HashMap<String, Object> paramMap);

	void insertQna(HashMap<String, Object> paramMap);

	void getQna(HashMap<String, Object> paramMap);

	void deleteQna(HashMap<String, Object> paramMap);

	void updateQna(HashMap<String, Object> paramMap);

}
