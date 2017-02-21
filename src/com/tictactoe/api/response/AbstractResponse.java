package com.tictactoe.api.response;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractResponse implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7695717549748771270L;
	private String status;
}
