package com.moya.api.async;

import java.util.concurrent.FutureTask;

public class ParallelTask<T> extends Task<T> {

	@Override
	public FutureTask<T> call() throws Exception {
		// Logic to be executed in parallel
		return null;
	}
}
