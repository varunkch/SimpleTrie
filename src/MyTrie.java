import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MyTrie
{
  private Node head;

  MyTrie()
  {
    head = new Node(' ');
  }

  /**
   * Adds a new word to the trie.
   * 
   * @param word
   */
  public void addWord(String word)
  {
    char[] wordArr = word.toLowerCase().toCharArray();
    Node root = this.head;
    for (int i = 0; i < wordArr.length; i++)
    {
      if (!root.children.containsKey(wordArr[i]))
      {
        root.children.put(wordArr[i], new Node(wordArr[i]));
      }
      root = root.children.get(wordArr[i]);
    }
    root.children.put(' ', new Node(' '));
  }

  /**
   * Gets words from the trie that match the prefix specified as argument
   * 
   * @param prefix
   * @return
   */
  public ArrayList<String> getWordsFromPrefix(String prefix)
  {
    char[] prefixArr = prefix.toLowerCase().toCharArray();
    Node root = this.head;
    ArrayList<String> words = new ArrayList<String>();
    for (int i = 0; i < prefixArr.length; i++)
    {
      if (!root.children.containsKey(prefixArr[i]))
      {
        return words;
      }
      root = root.children.get(prefixArr[i]);
    }
    ArrayList<ArrayList<Character>> paths = new ArrayList<ArrayList<Character>>();
    ArrayList<Character> path = new ArrayList<Character>();
    getWordsTillLeaf(root, path, paths, 0);

    for (int i = 0; i < paths.size(); i++)
    {
      ArrayList<Character> currentPath = paths.get(i);
      StringBuilder builder = new StringBuilder(prefix);
      for (int j = 1; j < currentPath.size(); j++)
      {
        builder.append(currentPath.get(j));
      }
      words.add(builder.toString());
    }
    return words;
  }

  private void getWordsTillLeaf(Node root, ArrayList<Character> path, ArrayList<ArrayList<Character>> paths, int index)
  {
    if (root.getChar() == ' ')
    {
      ArrayList<Character> list = new ArrayList<Character>();
      for (int i = 0; i < index; i++)
      {
        list.add(path.get(i));
      }
      paths.add(list);
      return;
    }
    path.add(index, root.getChar());
    Set<Character> keySet = root.children.keySet();
    Iterator<Character> keys = keySet.iterator();
    while (keys.hasNext())
    {
      char key = keys.next();
      /*Recurse on every child*/
      getWordsTillLeaf(root.children.get(key), path, paths, index + 1);
    }
  }

  private class Node
  {
    char                     c;
    HashMap<Character, Node> children;

    Node(char c)
    {
      this.c = c;
      this.children = new HashMap<Character, Node>();
    }

    char getChar()
    {
      return this.c;
    }

    @Override
    public int hashCode()
    {
      final int prime = 31;
      int result = 1;
      result = prime * result + getOuterType().hashCode();
      result = prime * result + c;
      return result;
    }

    @Override
    public boolean equals(Object obj)
    {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Node other = (Node) obj;
      if (!getOuterType().equals(other.getOuterType()))
        return false;
      if (c != other.c)
        return false;
      return true;
    }

    private MyTrie getOuterType()
    {
      return MyTrie.this;
    }
  }

}
