package magi.info.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("infoService")
public class InfoServiceImpl implements InfoService {
	@Autowired
	InfoInter infoInter;

	@Override
	public int login(String phone, String password) {
		int result = -1;
		String pw = infoInter.selectPW(phone);
		if (pw != null) {
			if (pw.equals(password)) {
				result = 0;
			} else {
				result = 1;
			}
		}else{
			result = 2;
		}
		return result;
	}
}
