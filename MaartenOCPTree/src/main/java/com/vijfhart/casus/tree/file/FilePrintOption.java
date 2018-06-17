package com.vijfhart.casus.tree.file;

public enum FilePrintOption {
	HUMAN_READABLE, DATE, DIRS_ONLY, 
	LANGUAGE{
		@Override
		public String toString() {
			return super.toString()+" : "+stringValue;
		}		
	}, 
	MAX_DEPTH {		
		@Override
		public String toString() {
		return super.toString()+" : "+intValue;
	}	
		
	};
	//
	private static int intValue;
	private static String stringValue;
	//
	public int getIntValue() {
		return intValue;
	}

	public String getStringValue() {
		return stringValue;
	}
    /**
     * Omzetten van waarde naar bijhorende enum FilePrintOption
     * @param value
     * @return FilePrintOption
     */
    public static FilePrintOption getEnum(String value) {
    	if (value.equals("-h")) return HUMAN_READABLE;
    	if (value.equals("-d")) return DIRS_ONLY;
    	if (value.equals("-t")) return DATE;
    	if (value.substring(0,2).equals("-l")) {
        	FilePrintOption.stringValue = value.substring(value.lastIndexOf(":")+1);
    		return LANGUAGE;		
    	}
    	if (value.substring(0,2).equals("-m")) {
        	FilePrintOption.intValue = Integer.parseInt(value.substring(value.lastIndexOf(":")+1));
    		return MAX_DEPTH;		
    	}    	
        return null;
    }

}
