package com.moya.api.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MoyaFactory implements Log, ApplicationContextAware {

	ApplicationContext applicationContext;
	private static Log log = null;

	// private static MoyaFactory moyaFactory = null;
	//
	//
	public static Log getLogger(Class<?> c) {
		log = LogFactory.getLog(c.getName());
		return log;

	}

	@Override
	public void debug(Object arg0) {

	}

	@Override
	public void debug(Object arg0, Throwable arg1) {

	}

	@Override
	public void error(Object arg0) {

	}

	public void logException(Exception e, String moduleName, String pageName) {

		log.error(e);
	}

	@Override
	public void error(Object arg0, Throwable arg1) {

		// exceptionDao.save((ExceptionRequest) arg0);

	}

	@Override
	public void fatal(Object arg0) {

	}

	@Override
	public void fatal(Object arg0, Throwable arg1) {

	}

	@Override
	public void info(Object arg0) {
		log.info(arg0);
	}

	@Override
	public void info(Object arg0, Throwable arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isDebugEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isErrorEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFatalEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInfoEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTraceEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isWarnEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void trace(Object arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void trace(Object arg0, Throwable arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void warn(Object arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void warn(Object arg0, Throwable arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		this.applicationContext = applicationContext;

	}
}
