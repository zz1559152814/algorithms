Value find(Node node, Key key){
	int cmp = node.compareTo(key);
	if(!node.size()){
		if(cmp)
			find(node.right, key);
		else(node.compareTo(key)==0)
			return node.val;
		else
			find(node.left, key);
	}
	else
		return null;
}
