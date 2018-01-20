//the sign of print is {node.left==NULL}
void print(Node node){
	if(node==NULL)
		return;
	print(node.left);
	StdOut.println(node.key);
	print(node.right);
}

