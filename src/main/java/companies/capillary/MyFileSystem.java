package companies.capillary;

import static companies.capillary.FSNode.SEPARATOR;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Data
@EqualsAndHashCode(of = {"name"})
@ToString(exclude = {"children"})
// Non Thread safe impl.
class FSNode<T> {

  public static final String SEPARATOR = "//";
  private String name;
  private Map<String, FSNode> children;
  private T data;

  public FSNode(String name, T data) {
    this.name = name;
    this.data = data;
    children = new HashMap<>();
  }
}

@Slf4j
public class MyFileSystem {

  public FSNode<String> root = new FSNode<>("", "");

  public <T> void add(FSNode<T> fsNode, String name, T data) {
    if (fsNode.getChildren().containsKey(name)) {
      throw new RuntimeException("path already exists for " + fsNode.getName() + SEPARATOR + name);
    }

    FSNode<T> tfsNode = new FSNode<>(name, data);
    fsNode.getChildren().put(name, tfsNode);
  }

  public <T> void delete(FSNode<T> fsNode, String name, boolean recursive) {
    if (!fsNode.getChildren().containsKey(name)) {
      throw new RuntimeException("path does not exists for " + fsNode.getName() + SEPARATOR + name);
    }

    if (recursive) {
      fsNode.getChildren().remove(name);
    } else if (!recursive && fsNode.getChildren().isEmpty()) {
      fsNode.getChildren().remove(name);
    } else {
      throw new RuntimeException("folder is not empty");
    }
  }

  public <T> void add(Path path, String name, T data) {
    FSNode<T> currentNode = getFsNode(path);

    add(currentNode, name, data);
  }

  public <T> void delete(Path path, String name, boolean recursive) {
    FSNode<T> currentNode = getFsNode(path);

    delete(currentNode, name, recursive);
  }

  public <T> void delete(Path path, boolean recursive) {
    FSNode<T> currentNode = getFsNode(path.getParent());

    delete(currentNode, path.getFileName().toString(), recursive);
  }

  private <T> FSNode<T> getFsNode(Path path) {
    FSNode<T> currentNode = (FSNode<T>) root;

    if (null == path || path.getFileName().toString().equals("")) {
      return currentNode;
    }

    Iterator<Path> iterator = path.iterator();
    while (iterator.hasNext() && currentNode != null) {
      Path next = iterator.next();
      currentNode = currentNode.getChildren().get(next.toString());
      if (null == currentNode) {
        throw new RuntimeException(
            "cannot find path with name : " + next.getFileName() + " inside : " + next.getParent());
      }
    }
    return currentNode;
  }

  private <T> void print(FSNode<T> root) {
    if (null == root) {
      return;
    }

    System.out.println(root.getName() + ":" + root.getData());
    root.getChildren().values().stream().forEach(fsNode -> print(fsNode));
  }

  public <T> void print() {
    this.print(root);
  }

}
