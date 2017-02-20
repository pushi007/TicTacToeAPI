package com.moya.api.response;

import java.util.List;

public interface ResponseBuilder<T, K> {
	public T build(List<K> list, String status);
}
