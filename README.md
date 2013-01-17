SimpleTrie
==========

Java implementation of the Trie data structure.

Tries are excellent for features like auto suggest in a web browser, or recommendations in a spell check program.

Inserting and finding a string of length 'L' takes O(L) time.

This SimpleTrie supports two operations:

1) addWord (String word) - adds a word to the trie

2) getWordFromPrefix (String prefix) - Returns all the words in the trie that match the prefix. 

For example, 

(a) If "algo" and "algorithms" are two words in the rie; getWordFromPrefix("alg") will return "algo" and "algorithms". 

(b) If 192.168.37.96, 192.168.37.84, 192.168.45.65 are three IP Adresses in the trie; getWordsFromPrefix("192.168.37") will return the 192.168.37.96 and 192.168.37.84

