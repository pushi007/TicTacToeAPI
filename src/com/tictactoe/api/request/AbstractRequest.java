package com.tictactoe.api.request;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8931431414583649434L;
	private String systemIP;
	private String systemMac;

}
