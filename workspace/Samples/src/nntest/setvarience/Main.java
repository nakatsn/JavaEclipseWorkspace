package nntest.setvarience;

import java.util.HashSet;
import java.util.Set;

import nntest.util.NNUtil;

public class Main {

	public static void main(String[] args) {
		
		long lngstart = NNUtil.start();
		
		// TODO Auto-generated method stub
		Main main = new Main();
		
		Set<Integer> s1 = new HashSet<Integer>();
		Set<Integer> s2 = new HashSet<Integer>();
		
		NNUtil.log("construct start");
		main.constructSetData(s1, 10000);
		main.constructSetData(s2, 100000);
		NNUtil.log("construct end");
		
		NNUtil.log("s1 size:" + NNUtil.getObjectSize(s1));
		NNUtil.log("s2 size:" + NNUtil.getObjectSize(s2));
		
		
		NNUtil.log("count:" + s1.size());
		NNUtil.log("diff start");
		s1.removeAll(s2);
		NNUtil.log("diff end");
		NNUtil.log("count:" + s1.size());
		
		NNUtil.end(lngstart);
	}
	
	private void constructSetData(Set<Integer> s, int amount) {
		int add = 0;
		int count = 0;
		for (int i = 0; i < amount; i++) {
			add = (int)(Math.random() * 10);
			count += add;
			s.add(new Integer(count));
		}
	}
}
