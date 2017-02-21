package com.tictactoe.api.async;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public abstract class Task<T> implements Callable<FutureTask<T>>{

}
