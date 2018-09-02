package com.vijfhart.casus.tree.file;

public enum FilePrintOption {
	HUMAN_READABLE, DATE, DIRS_ONLY, FILES_ONLY,
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
		
	}
	,MIN_DEPTH {		
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
    	if (value.startsWith("-lang:")) {
        	FilePrintOption.stringValue = value.substring(value.lastIndexOf(":")+1);
    		return LANGUAGE;		
    	}
    	if (value.startsWith("-maxDepth:")) {
        	FilePrintOption.intValue = Integer.parseInt(value.substring(value.lastIndexOf(":")+1));
    		return MAX_DEPTH;		
    	}    	
    	if (value.startsWith("-minDepth:")) {
        	FilePrintOption.intValue = Integer.parseInt(value.substring(value.lastIndexOf(":")+1));
    		return MIN_DEPTH;		
    	}      	
        return null;
    }

}
