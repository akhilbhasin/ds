package com.abbhasin.ds;

import java.util.ArrayList;
import java.util.List;

public class NTreeNode {
	
	public int val;
	public List<NTreeNode> children;
	
	public NTreeNode(int val){
		this.val = val;
		children = new ArrayList<>();
	}


}
