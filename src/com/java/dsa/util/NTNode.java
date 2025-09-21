package com.java.dsa.util;

import java.util.List;

public class NTNode {

	public int val;
	public List<NTNode> neighbors;

	public NTNode() {
	}

	public NTNode(int _val) {
		val = _val;
	}

	public NTNode(int _val, List<NTNode> _children) {
		val = _val;
		neighbors = _children;
	}

	@Override
	public String toString() {
		return "NTNode [val=" + val + ", children=" + neighbors + "]";
	}
	
	
}
