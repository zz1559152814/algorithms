void deletemin(){
	deletemin(root);
}


//more complict than function below
void deletemin(Node node){
	if(node.left.left == NULL){
		node.left = node.left.right;
		return;
	}
	deletemin(node.left);
}

Node deletemin(Node node){
	if(node.left == NULL)
		return node.right;
	node.left = deletemin(node.left);
	x.N = size(node.left) + size(node.right) - 1;
}

void delete(Key key){
	delete(root, key);
}

Node delete(Node node, Key key){
	if(node == NULL)
		return NUll;

	int cmp = key.compareTo(node.key);
	if(cmp < 0)
		node.left = delete(node.left, key);
	else(cmp > 0)
		node.right = delete(node.right, key);
	else{
		if(node.right == NULL) 
			return node.left;
		if(node.left == null)
			return node.right;
		Node tmp = node;
		node = min(tmp);
		node.right = delete(tmp.right);
		node.left  = tmp.left;
	}
	return node;
}