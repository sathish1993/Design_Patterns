package fileVisitors.util;

public class MyLogger{
    /*DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
      DEBUG_VALUE=3 [Print to stdout everytime a thread's run() method is called]
      DEBUG_VALUE=2 [Print to stdout everytime when a word is added]
      DEBUG_VALUE=1 [Print to stdout everytime when a word is deleted]
      DEBUG_VALUE=0 [No output should be printed from the applicatio to stdout. It is ok to write to the output file though" ]
    */

    public static enum DebugLevel {RELEASE, PRINT_RESULT, WORD_ADD, WORD_VISIT, CONSTRUCTOR
                                   };

    private static DebugLevel debugLevel;


    public static void setDebugValue (int levelIn) {
    	switch (levelIn) {
    	  case 4: debugLevel = DebugLevel.CONSTRUCTOR; break;
        case 3: debugLevel = DebugLevel.WORD_VISIT; break;
        case 2: debugLevel = DebugLevel.WORD_ADD; break;
        case 1: debugLevel = DebugLevel.PRINT_RESULT; break;
    	  case 0: debugLevel = DebugLevel.RELEASE; break;
    	}
    }

    public static void setDebugValue (DebugLevel levelIn) {
	     debugLevel = levelIn;
    }

    // @return None
    public static void writeMessage (String  message, DebugLevel levelIn ) {
    	if (levelIn == debugLevel)
    	    System.out.println(message);
        }

    /**
	 * @return String
	 */
    public String toString() {
      return "Debug Level is " + debugLevel;
    }
}
