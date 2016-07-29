
import org.scalatest.FunSuite

/**
  * Created by ChengIng on 7/28/16.
  */
class ExampleSuite extends FunSuite{

  test("Test example") {
    val a = 100
    val result = a-100
    assert(result === 0)
  }
}
