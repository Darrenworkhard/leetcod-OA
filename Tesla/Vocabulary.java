vocabulary = ["apple", "carrot", "pear", "apricot", "vegetable" ... N ]

func oneOff(vocabulary, word) => true/false 

applx => true

appl => false

bpple => true

apxxx => false

N*maxlen()*26

public boolean oneOff(String[] vocabulary, String word)
{
	if(word.length() == 0) return false;
  
  for(String s : vocabulary)
  {
    char[] charArray = s.toCharArray();
    //apple
  	for(int i = 0; i < s.lenght(); i++)
    {
      //a pple
      for(int j = 0; j < 26; j++)
      {
        //apple , bpple , cpple ...
        charArray[i] =  j + 'a';
        String newString = new String(charArray);
        if(newString.equals(word))
        {
          return true;
        }
      }
    }
    return false;
  }
}

HashSet<String> set = ["apple", "carrot", "pear", "apricot", "vegetable" ... N ];
// word.lenght() * 26
char[] charArray = word.toCharArray();
//apple
for(int i = 0; i < word.lenght(); i++)
{
  //a pple
  for(int j = 0; j < 26; j++)
  {
    //apple , bpple , cpple ...
    charArray[i] =  j + 'a';
    String newString = new String(charArray);
    if(set.contains(newString))
    {
      return true;
    }
  }
}
return false;

//
HashSet<String> set = ["apple", "apples", "pear", "run", "running", "vegetable" ... N ];

apple
bpple

apples

    *
  /  |  \
a    b   c
|    |   \
p    o    p
|       
p
|
l
|
e
|
s




























