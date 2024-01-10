The Huffman tree is built according to the following steps:

1. Two smallest nodes, node1 and node2, are removed from the heap
2. These two nodes are set to be the children of a new node, newnode, with combined key
3. This newnode is then inserted back into the heap and steps 1-3 are repeated until one element remains in the heap
4. This last heap element is thus the max, and is set as the root 