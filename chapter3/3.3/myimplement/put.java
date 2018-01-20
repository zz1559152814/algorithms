void put(Key key, Value val){
	put(root, key, val);
}

Node put(Node node, Key key, Value val){
	if(node == NULL)
		Node new = Node(key, val, 1, Red);

	int cmp = key.compareTo(node.key);
	if(cmp == 0)
		node.val   	= val;
	else if(cmp<0)
		node.left  	= put(node.left , key);
	else
		node.right 	= put(node.right, key);

	if(isRed(node.left)&&!isRed(node.left.left))
		node = rotateright(node);
	if(isRed(node.right)&&!isRed(node.left))
		node = rotateleft(node);
	if(isRed(node.left)&&isRed(node.right))
		node = filpcolor(node);

	node.N = size(node.left + node.right + 1);
	return node;
}