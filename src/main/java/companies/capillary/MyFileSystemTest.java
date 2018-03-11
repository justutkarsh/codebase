package companies.capillary;

import java.nio.file.Paths;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by utkarsh on 08/03/18.
 */

public class MyFileSystemTest {


  static MyFileSystem testFS;

  @BeforeClass
  public static void setUp(){
    testFS = new MyFileSystem();
  }
  @Test
  public void testAddPath(){
    testFS.add(Paths.get(""),"root","nothing");
    testFS.add(Paths.get("root"),"child1","child1data");
    testFS.add(Paths.get("root"),"child2","child2data");
    testFS.add(Paths.get("root", "child1"),"subchild1","subchild1data");
    testFS.print();
  }



  @Test
  public void testDeletePath(){

    testFS.add(Paths.get(""),"root","nothing");
    testFS.add(Paths.get("root"),"child1","child1data");
    testFS.add(Paths.get("root"),"child2","child2data");
    testFS.add(Paths.get("root","child1"),"subchild1","subchild1data");

    testFS.print();

    testFS.delete(Paths.get("root","child1"),true);

    testFS.print();




  }


}
