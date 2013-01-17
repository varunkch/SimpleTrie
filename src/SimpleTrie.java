import java.util.ArrayList;


public class SimpleTrie
{

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MyTrie trie = new MyTrie();
    trie.addWord("assoc");
    trie.addWord("algo");
    trie.addWord("all");
    trie.addWord("also");
    trie.addWord("trie");
    trie.addWord("tree");
    trie.addWord("192.168.42.128");
    trie.addWord("192.168.42.224");
    trie.addWord("192.168.45.34");
    ArrayList<String> words = trie.getWordsFromPrefix("192.168");
    for(String str : words)
    {
      System.out.println(str);
    }
  }

}
