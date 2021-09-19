/**
 * Author: Mehak Khan
 * Revised: 27 March, 2021
 * 
 * Description: All tests
 */

package src;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   TestGameBoard.class,	
   TestOperations.class,
   //TestCourseT.class,
   TestTileT.class
  // TestGameBoard.class
})

public class AllTests
{
}