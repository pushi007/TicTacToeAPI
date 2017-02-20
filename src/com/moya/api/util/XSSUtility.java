package com.moya.api.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class XSSUtility implements ApplicationContextAware {
	ApplicationContext applicationContext;

	public String cleanXSS(String value) {

		value = value.replaceAll("<", "& lt;").replaceAll(">", "& gt;");

		value = value.replaceAll("'", "& #39;");
		value = value.replaceAll("eval\\((.*)\\)", "");
		value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
		value = value.replaceAll("<script>", "");
		value = value.replaceAll("</script>", "");
		value = value.replaceAll("(?i)(?:<|>|\\\\u003C|\\\\u003E)", "");
		return value;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;

	}

}
