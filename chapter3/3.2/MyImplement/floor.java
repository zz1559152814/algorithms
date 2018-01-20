Value floor(Key key){
	floor(root, key);
}

Node floor(Node node, Key key){
	Node n;
	if(node == NULL)
		return NULL;
	int cmp = key.compareTo(node.key);
	if(cmp)
		return node;
	else if(cmp < 0)
		return floor(node.left, key);
	else if(cmp > 0){
		n = floor(node.right, key);

		if(n==NULL)
			return node.right;
		else
			return n;
	}
}