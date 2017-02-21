package com.tictactoe.api.async;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskManager<T> {
	ExecutorService executor = Executors.newCachedThreadPool();

	public void asyncProcess(List<ParallelTask<T>> listParallelTask) {
		for (ParallelTask<T> parallelTask : listParallelTask) {
			executor.submit(parallelTask);
		}
	}
}
