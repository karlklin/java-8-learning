package java8.in.action.behaviour.parametrization;

public interface Formatter<T> {
	String accept(T t);
}
