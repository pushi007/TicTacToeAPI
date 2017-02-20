package com.moya.api.request;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8506044422768219581L;

	private int game[][];

}
