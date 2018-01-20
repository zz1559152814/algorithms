Node rotateleft(Node node){
	Node newroot = node.left;

	node.right = newroot.left;
	newroot.color 	= n;
	newroot.left	= node;
	node.color	 	= node.color;

	newroot.N 		= node.N;
	node.N 			= size(node.left) + size(newroot.right) + 1;
	return newroot;
}

Node rotateright(Node node){
	Node newroot = node.right;

	node.left = newroot.right;
	newroot.color 	= n;
	newroot.right	= node;
	node.color	 	= node.color;

	newroot.N 		= node.N;
	node.N 			= size(node.right) + size(newroot.left) + 1;
	return newroot;
}