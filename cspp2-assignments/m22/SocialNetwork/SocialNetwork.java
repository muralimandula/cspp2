import java.util.HashMap;
import java.util.ArrayList;
/**
 * class for SocialNetwork.
 */
public final class SocialNetwork {
  /**
   * network hashmap.
   */
  private HashMap<String, ArrayList<String>> network;

    /**
     * Constructs the object.
     */
  SocialNetwork() {
    network = new HashMap<>();
  }

  /**
   * Gets the network.
   *
   * @return     The network.
   */
  public HashMap getNetwork() {
    return network;
  }

  /**
   * Adds to network.
   *
   * @param      key     The key
   * @param      values  The values
   */
  public void addToNetwork(final String key, final String[] values) {
    ArrayList<String> temp = new ArrayList<>();
    for (String member : values) {
      temp.add(member);
    }
    network.putIfAbsent(key, temp);
  }

  /**
   * Gets the connections.
   *
   * @param      name  The name
   *
   * @return     The connections.
   */
  public ArrayList getConnections(final String name) {
    return network.get(name);
  }

  /**
   * Adds a connection.
   *
   * @param      key     The key
   * @param      member  The member
   */
  public void addConnections(final String key, final String member) {
    network.putIfAbsent(key, new ArrayList<>());
    network.get(key).add(member);
  }

  /**
   * Gets the common connections.
   *
   * @param      key1  The key 1
   * @param      key2  The key 2
   *
   * @return     The common connections.
   */
  public ArrayList getCommonConnections(final String key1, final String key2) {
    ArrayList<String> mem1 = network.get(key1);
    ArrayList<String> mem2 = network.get(key2);
    mem1.retainAll(mem2);
    return mem1;
  }

}

