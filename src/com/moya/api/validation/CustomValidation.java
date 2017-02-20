package com.moya.api.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class CustomValidation {

	public boolean validate(Object object) {
		if (object instanceof String) {
			String string = (String) object;
			if (StringUtils.isNotBlank(string)) {
				return true;
			}
		} else if (object instanceof List) {
			List list = (List) object;
			if (!(list.isEmpty()) && list.size() > 0) {
				return true;
			}
		} else if (object instanceof Map) {
			Map map = (Map) object;
			if (!(map.isEmpty()) && map.size() > 0)
				return true;
		}
		return false;
	}

	// No special characters in string
	public boolean validateStringAsAbsolute(String string) {
		if (string != null && !(string.isEmpty())) {
			if (string.matches("^(?=.*[a-zA-Z]).+")) {
				return true;
			}
		}
		return false;
	}

	// Validation for String as int
	public boolean validateStringAsInteger(String string) {
		if (validate(string)) {
			Pattern pattern = Pattern.compile("\\d+");
			if (pattern.matcher(string).matches()) {
				return true;
			}
		}
		return false;
	}

	// Validation for String as BigInteger
	public boolean validateStringAsBigInteger(String string) {
		if (validate(string) && !(string.matches("[0]+"))) {
			Pattern pattern = Pattern.compile("\\d+");
			if (pattern.matcher(string).matches()) {
				return true;
			}
		}
		// }
		return false;
	}

	public boolean nameValidation(String str) {
		if (validate(str)) {
			Pattern pattern = Pattern.compile("^[a-zA-Z0-9\\s']*$");
			if (pattern.matcher(str).matches()) {
				return true;
			}
		}
		return false;
	}

	public boolean dateValidation(String date) {
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");

			try {
				Date dt = sdf.parse(date);
				return true;
			} catch (ParseException e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	public boolean adressFieldValidation(String str) {
		String regex = "^[a-zA-Z0-9\\s\\_\\.\\-\\;\\/\\n\\r\\,]*$";
		if (validate(str)) {
			Pattern pattern = Pattern.compile(regex);
			if (pattern.matcher(str).matches()) {
				return true;
			}
		}
		return false;
	}

	public boolean emailFieldValidation(String str) {
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		Pattern pattern = Pattern.compile(regex);
		if (pattern.matcher(str).matches()) {
			return true;
		}
		return false;
	}

	public boolean alphaNumeric(String str) {
		String regex = "^[a-zA-Z0-9-]*$";
		Pattern pattern = Pattern.compile(regex);
		if (pattern.matcher(str).matches()) {
			return true;
		}
		return false;
	}

	public boolean validateOrganizationalDesignation(String str) {
		String regex = "^[a-zA-Z\\s-]*$";
		Pattern pattern = Pattern.compile(regex);
		if (pattern.matcher(str).matches()) {
			return true;
		}
		return false;
	}

	public boolean calculateAge(String date) {
		Calendar dob = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");
		try {
			dob.setTime(sdf.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar today = Calendar.getInstance();
		int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
		if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR))
			age--;
		if (age > 29 || age < 14) {
			return false;
		}
		return true;
	}

	public Date convertStringLongToDate(String str){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		Date date=null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(Long.parseLong(str));
        try {
                
            date = formatter.parse(formatter.format(calendar.getTime()));

        } catch (ParseException e) {
            
        }

		return date;
	}
	
	public Date convertStringToDate(String str){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date=new Date();
		
        try {
                
            date = formatter.parse(str);

        } catch (ParseException e) {
            
        }

		return date;
	}
	

	public String convertDateToString(Date dt) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String str = null;
		try {
			str = sdf.format(dt);
		} catch (Exception e) {
		}
		return str;
	}

	public Integer convertStringToInteger(String str) {
		int num = 0;
		if (StringUtils.isNoneEmpty(str)) {
			num = Integer.parseInt(str);
		}
		return num;
	}

	public String convertLongToString(Long longVal)
	{
		String value=null;
		value=String.valueOf(longVal);
		return value;
	}
	
	public Long convertStringToLong(String str) {
		Long num = 0l;
		if (StringUtils.isNoneEmpty(str)) {
			num = Long.parseLong(str);
		}
		return num;
	}
	
//	public Long convertIntegerToLong(Inter str) {
//		Long num = 0l;
//		if (StringUtils.isNoneEmpty(str)) {
//			num = Long.parseLong(str);
//		}
//		return num;
//	}
	
	public String convertIntegerToString(int num) {
		String str = null;
		str = String.valueOf(num);
		return str;
	}

}
