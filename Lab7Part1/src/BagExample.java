public class BagExample
{
  

void processMessage(String msg)
   {
      Bag bag = new BagImpl(this);
      bag.set(msg);
      MessagePipe pipe = new MessagePipe();
      pipe.send(bag);
   }

private final class BagImpl implements Bag {
	   
	   private final BagExample example;
	   Object o;
	   /**
	    * @paramBagExample
	    */
	  BagImpl(BagExample example)
	   {
	      this.example = example;
	      // TODO Auto-generated constructor stub
	   }
		

		public Object get()
      {
         return o;
      }

		public void set(Object o)
      {
         this.o = o;
      }
	}
}