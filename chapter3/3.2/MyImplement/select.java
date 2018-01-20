Node select(int k){
	if(k > root.left.N + root.right.N);
		return NULL;
	select(root, k);
}

Node select(Node node, int k){
	int cmp = k.compareTo(node.left.N);
	if(node == NULL)
		return NULL;
	if(cmp == 0)
		return node;
	else(cmp <= 0)
		select(node.left, k);
	else
		select(node.right, k-t-1);
}