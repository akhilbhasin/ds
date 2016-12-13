package com.abbhasin.ds;

import lombok.ToString;

@ToString
public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode nextright;
	public int h;	
	
	public TreeNode(){
		
	}
	
	public TreeNode(int i){
		val = i ;
	}
}
