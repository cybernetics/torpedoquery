package com.netappsid.jpaquery.internal;

import java.lang.reflect.Method;

import javassist.util.proxy.ProxyFactory;


public class InnerJoinHandler<T> implements QueryHandler<T> {

	@Override
	public T handleCall(QueryBuilder queryImpl, Method thisMethod) {

		Class<?> returnType = thisMethod.getReturnType();

		try {
			final ProxyFactory proxyFactory = new ProxyFactory();
			proxyFactory.setSuperclass(returnType);
			proxyFactory.setInterfaces(new Class[] { Query.class });

			FJPAMethodHandler fjpaMethodHandler = new FJPAMethodHandler(
					returnType, queryImpl.getIncrement());
			Query join = (Query) proxyFactory.create(null, null,
					fjpaMethodHandler);

			queryImpl.addJoin(new InnerJoin(fjpaMethodHandler.getQueryBuilder(),queryImpl.getFieldName(thisMethod)));

			return (T) join;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}