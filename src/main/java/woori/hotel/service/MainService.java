package woori.hotel.service;

import java.util.ArrayList;
import java.util.HashMap;

public interface MainService {

	

	void confirmRoom(HashMap<String, Object> paramMapDBool);

	void imglist(HashMap<String, Object> paramMap);
	
	ArrayList<Integer> remainList(String checkin, String checkout, String kind);

	void insertRoom(ArrayList<Integer> remainList, String string, ArrayList<Integer> userNumList, String checkin,
			String checkout);
}
