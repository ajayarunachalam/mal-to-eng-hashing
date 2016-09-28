import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MlToEnMetaphone {

	private TreeMap<String,String>vowels; 
	private TreeMap<String,String>consonants; 
	private TreeMap<String,String>chillus;
	private TreeMap<String,String>compounds;
	private TreeMap<String,String>modifiers;
	private String compoundString;
	private String modifierString;
	private String vowelString;
	private String consonantString;
	
	MlToEnMetaphone(){
		intializeVowels();
		initializeConsonants();
		initializeChillus();
		intializeCompounds();
		intializeModifiers();
	}
	
	private void intializeVowels(){
		vowels = new TreeMap<String,String>();
		vowels.put("അ", "a");vowels.put("ആ", "aa");vowels.put("ഇ", "i");
		vowels.put("ഈ", "ee");vowels.put("ഉ", "u");vowels.put("ഊ", "oo");
		vowels.put("ഋ", "ru");vowels.put("എ", "e");vowels.put("ഏ", "e");
		vowels.put("ഐ", "ai");vowels.put("ഒ", "o");vowels.put("ഓ", "o");
		vowels.put("ഔ", "au");
		vowelString = "അ|ആ|ഇ|ഈ|ഉ|ഊ|ഋ|എ|ഏ|ഐ|ഒ|ഓ|ഔ";
	}
	
	private void initializeConsonants(){
		consonants = new TreeMap<String,String>();
		consonants.put("ക", "k");consonants.put("ഖ", "kh");consonants.put("ഗ", "g");consonants.put("ഘ", "gh");consonants.put("ങ", "ng");
		consonants.put("ച", "ch");consonants.put("ഛ", "chh");consonants.put("ജ", "j");consonants.put("ഝ", "jh");consonants.put("ഞ", "nj");
		consonants.put("ട", "t");consonants.put("ഠ", "dt");consonants.put("ഡ", "d");consonants.put("ഢ", "dd");consonants.put("ണ", "n");
		consonants.put("ത", "th");consonants.put("ഥ", "th");consonants.put("ദ", "d");consonants.put("ധ", "dh");consonants.put("ന", "n");
		consonants.put("പ", "p");consonants.put("ഫ", "ph");consonants.put("ബ", "b");consonants.put("ഭ", "bh");consonants.put("മ", "m");
		consonants.put("യ", "y");consonants.put("ര", "r");consonants.put("ല", "l");consonants.put("വ", "v");
		consonants.put("ശ", "sh");consonants.put("ഷ", "sh");consonants.put("സ", "s");consonants.put("ഹ", "h");
		consonants.put("ള", "l");consonants.put("ഴ", "zh");consonants.put("റ", "r");
		consonantString = "ക|ഖ|ഗ|ഘ|ങ|ച|ഛ|ജ|ഝ|ഞ|ട|ഠ|ഡ|ഢ|ണ|ത|ഥ|ദ|ധ|ന|പ|ഫ|ബ|ഭ|മ|യ|ര|ല|വ|ശ|ഷ|സ|ഹ|ള|ഴ|റ";
	}
	
	private void initializeChillus(){
		chillus = new TreeMap<String,String>();
		chillus.put("ൽ", "l");chillus.put("ൾ", "l");chillus.put("ൺ", "n");
		chillus.put("ൻ", "n");chillus.put("ർ", "r");chillus.put("ൿ", "k");
	}
	
	private void intializeCompounds(){
		compounds = new TreeMap<String,String>();
		compounds.put("ക്ക", "kk");compounds.put("ഗ്ഗ", "gg");compounds.put("ങ്ങ", "ng");compounds.put("ച്ച", "cch");
		compounds.put("ജ്ജ", "jj");compounds.put("ഞ്ഞ", "nj");compounds.put("ട്ട", "tt");compounds.put("ണ്ണ", "nn");
		compounds.put("ത്ത", "tth");compounds.put("ദ്ദ", "ddh");compounds.put("ദ്ധ", "ddh");compounds.put("ന്ന", "nn");
		compounds.put("ന്ത", "nth");compounds.put("ങ്ക", "nk");compounds.put("ണ്ട", "nd");compounds.put("ബ്ബ", "bb");
		compounds.put("പ്പ", "pp");compounds.put("മ്മ", "mm");compounds.put("യ്യ", "yy");compounds.put("ല്ല", "ll");
		compounds.put("വ്വ", "vv");compounds.put("ശ്ശ", "sh");compounds.put("സ്സ", "s");//compounds.put("ള്ള", "L12");
		compounds.put("ക്സ", "ks");
		compounds.put("ഞ്ച", "nch");compounds.put("ക്ഷ", "ksh");compounds.put("മ്പ", "mp");compounds.put("റ്റ", "tt");
		compounds.put("ന്റ", "nt");compounds.put("ന്ത", "nth");//compounds.put("്ര", "R");compounds.put("്രു", "R");
		compounds.put("ന്ത്യ", "nthy");
		compoundString = "ക്ക|ഗ്ഗ|ങ്ങ|ച്ച|ജ്ജ|ഞ്ഞ|ട്ട|ണ്ണ|ത്ത|ദ്ദ|ദ്ധ|ന്ന|ന്ത|ങ്ക|ണ്ട|ബ്ബ|പ്പ|മ്മ|യ്യ|ല്ല|വ്വ|ശ്ശ|സ്സ|ക്സ|ഞ്ച|ക്ഷ|മ്പ|റ്റ|ന്റ|ന്ത|ന്ത്യ";
	}
	
	private void intializeModifiers(){
		modifiers = new TreeMap<String,String>();
		modifiers.put("ു്", "u");modifiers.put("ാ", "aa");modifiers.put("ി", "i");modifiers.put("ീ", "ee");
		modifiers.put("ു", "u");modifiers.put("ൂ", "oo");modifiers.put("ൃ", "ru");
		modifiers.put("െ", "e");modifiers.put("േ", "e");modifiers.put("ൈ", "y");
		modifiers.put("ൊ", "o");modifiers.put("ോ", "o");modifiers.put("ൌ", "ou");modifiers.put("ൗ", "au");
		modifiers.put("ഃ", "a");modifiers.put("ം", "m");
		modifierString = "ു്|ാ|ി|ീ|ു|ൂ|ൃ|െ|േ|ൈ|ൊ|ോ|ൌ|ൗ|ഃ";
	}

	
	public String mlToEnprocess(String input){
		
		// Create a Pattern object
		Matcher m = Pattern.compile("("+compoundString+")("+modifierString+")").matcher(input);
	    while(m.find()) {
			if(compounds.containsKey(m.group(1)) && modifiers.containsKey(m.group(2))){
    			input = input.replaceAll( m.group(1)+m.group(2), compounds.get(m.group(1))+modifiers.get(m.group(2)));
			}   
		}
	    
	    m = Pattern.compile("("+consonantString+")("+modifierString+")").matcher(input);
	    while(m.find()) {
			if(consonants.containsKey(m.group(1)) && modifiers.containsKey(m.group(2))){
    			input = input.replaceAll( m.group(1)+m.group(2), consonants.get(m.group(1))+modifiers.get(m.group(2)));
			}
		}
	    
	    m = Pattern.compile("("+vowelString+")("+modifierString+")").matcher(input);
	    while(m.find()) {
			if(vowels.containsKey(m.group(1)) && modifiers.containsKey(m.group(2))){
    			input = input.replaceAll( m.group(1)+m.group(2), vowels.get(m.group(1))+modifiers.get(m.group(2)));
			}
		}
		for(Map.Entry<String,String> entry : compounds.entrySet()) {
		  input = input.replaceAll(entry.getKey()+"്$", entry.getValue()+"u");
		  input = input.replaceAll(entry.getKey()+"്", entry.getValue());	
		  input = input.replaceAll(entry.getKey(), entry.getValue()+"a");
		}
		for(Map.Entry<String,String> entry : consonants.entrySet()) {
		  input = input.replaceAll(entry.getKey()+"്$", entry.getValue()+"u");
		  input = input.replaceAll(entry.getKey()+"്", entry.getValue());	
		  input = input.replaceAll(entry.getKey(), entry.getValue()+"a");
		}
		for(Map.Entry<String,String> entry : vowels.entrySet()) {
		  input = input.replaceAll(entry.getKey(), entry.getValue());
		}
		for(Map.Entry<String,String> entry : chillus.entrySet()) {
		  input = input.replaceAll(entry.getKey(), entry.getValue());
		}
		for(Map.Entry<String,String> entry : modifiers.entrySet()) {
		  input = input.replaceAll(entry.getKey(), entry.getValue());
		}
		
		return input;
	}
	
	public static void main(String args[]){
		
		String input="നീലക്കുയില്‍";
		//input="കണ്ണകി";
		//input="വിഭക്ത്യാഭാസം";
		//input="രാഷ്ട്രീയം";
		MlToEnMetaphone meta = new MlToEnMetaphone();
		input = meta.mlToEnprocess(input);
		System.out.println(input);
	}

}
