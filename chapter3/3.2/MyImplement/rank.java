int rank(Key key){
	rank(root, key);
}

int rank(Node node, Key key){
	if(node == NULL)
		return NULL;
	int cmp = key.compareTo(node.key);
	if(cmp == 0)
		return size(node.left);
	else(cmp < 0)
		return rank(node.left);
	else
		return rank(node.right);
}