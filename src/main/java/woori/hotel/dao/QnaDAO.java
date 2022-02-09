package woori.hotel.dao;

import java.util.HashMap;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper(value="QnaDAO")
public interface QnaDAO {

	void listQna(HashMap<String, Object> paramMap);

}
