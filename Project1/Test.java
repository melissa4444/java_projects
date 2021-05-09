class Test {
static void f1()
{ throw new RuntimeException("hello"); }
static void f2()
{
try
{ f1(); }
catch (Exception e)
{ System.out.println("FFF"); }
finally
{ System.out.println("GGG"); }
f1();
System.out.println("HHH");
}
public static void main(String[] argv)
{
try
{ f2();
f1(); }
catch (Exception e)
{ System.out.println("AAA"); }
try
{
f1(); }
catch (Exception e)
{ System.out.println("BBB"); }
finally
{ System.out.println("CCC"); }
System.out.println("DDD");
f2();
System.out.println("EEE");
f1();
}} // END class Test 