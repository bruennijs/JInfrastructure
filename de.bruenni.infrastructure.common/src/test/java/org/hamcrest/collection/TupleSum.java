package org.hamcrest.collection;

import infrastructure.util.Tuple2;

/**
 * helper class
 */
public class TupleSum extends Tuple2<Integer, String> {

	public TupleSum(Integer i, String s) {
		super(i, s);
	}

	public static TupleSum create(Tuple2<Integer, String> tuple)
	{
		return new TupleSum(tuple.getT1(), tuple.getT2());
	}

	/**
	 * Calculates sum
	 * @return
	 */
	public Integer sum() throws NumberFormatException
	{
		return getT1() + Integer.parseInt(getT2());
	}

	public static <T extends Tuple2<Integer, String>> boolean isInstanceOf(T instance) {
		return instance instanceof TupleSum;
	}
}
