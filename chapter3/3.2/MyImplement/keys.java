Iterable<Key> keys(){
	keys(min(), max());
}

Iterable<Key> keys(Key lo, Key hi){
	Queue<Key> queue = new Queue<Key>();
	keys(root, queue, lo, hi);
	return Queue;
}

void keys(Node node, Queue<Key> queue, Key lo, Key hi){
	if(node == NULL)
		return;
	int cmplo = lo.compareTo(node.key);
	int cmphi = hi.compareTo(node.key);

	if(cmplo<0)
		keys(node.left, queue, lo, hi);
	if(cmplo<=0&&cmp>=0)
		queue.enqueue(node);
	if(cmphi>0)
		keys(node.right, queue, lo, hi);
}

public static void main(String[] args) {
	for(Key:keys())
	{
		dosthing...;
	}
}