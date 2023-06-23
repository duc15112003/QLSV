package Controll;

public class Validate_Login {
	
	public static boolean checkuser(String user) {
		if(user.equals("")) {
			return false;
		}else {
			return true;
		}
	}
	public static boolean checkpass(String pass) {
		if(pass.equals("")) {
			return false;
		}else {
			return true;
		}
	}
	public static boolean checkemail(String email) {
		if(email.equals("")) {
			return false;
		}else {
			return true;
		}
	}

}
