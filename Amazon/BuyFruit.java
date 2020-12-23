import java.util.*;

public class BuyFruit {
    public static void main(String[] args) {

        int[] from = new int[] { 1, 2, 2, 3, 4, 5, 4 };
        String[][] code = {{"apple","apple"},{"banana","anything", "banana"}, {"apple","banana"}};
        List<List<String>> codeList = new ArrayList<>();
        for(String[] s : code)
        {
            codeList.add(Arrays.asList(s));
        }
        
        String[] cart = {"anything", "apple", "banana", "orange", "banana", "apple", "banana", "banana", "banana"};
        List<String> ShoppingCart = Arrays.asList(cart);  
        int ans = checkWinner2(codeList, ShoppingCart);

        System.out.println(ans);
    }

    //中間可跳號只要排序對即可
    //EX: list : apple apple banana orange banana
    //ShoppingCart : apple banana apple banana orange banana
    //(O)
    //上述範例需要顯示1
    public static int checkWinner(List<List<String>> codeList, List<String> ShoppingCart)
	{
		if(codeList.size() == 0) return -1;
		
		List<String> lists = new ArrayList<>();
		for(int i = 0; i < codeList.size(); i++)
		{
			List<String> list = codeList.get(i);
			for(int index = 0; index < list.size(); index++)
			{
				lists.add(list.get(index));
			}
		}
		
		int i = 0; 
		int j = 0;
		while(j < ShoppingCart.size())
		{
			if(lists.get(i).equals(ShoppingCart.get(j)) || lists.get(i).equals("anything"))
			{
				i++;
				j++;
			}
			else
				j++;
		}
		
		return i == lists.size() ? 1 : 0;
	}

    //https://www.youtube.com/watch?v=D3GDFfCOLss&ab_channel=%E4%B8%83%E4%BA%BA%E5%B0%8F%E7%B5%84-%E8%AB%8B%E6%8F%90%E9%80%9F%E8%A7%80%E7%9C%8B%21%21
    //T O(N)
    //S O(N)
    //上述範例需要顯示0
    public static int checkWinner2(List<List<String>> codeList, List<String> ShoppingCart)
	{
		if(codeList.size() == 0) return 0;
		int codeIndex = 0; 
		for(int i = 0; i < ShoppingCart.size(); i++)
		{
            if(ShoppingCart.get(i).equals(codeList.get(codeIndex).get(0)) || ShoppingCart.get(i).equals("anything") 
            || codeList.get(codeIndex).get(0).equals("anything"))
            {
                int tempI = i;
                int tempJ = 0;
                List<String> list = codeList.get(codeIndex);
                //Start check
                for(int j = 0; j < list.size() && tempI < ShoppingCart.size(); j++)
                {
                    if(list.get(j).equals("anything") || ShoppingCart.get(tempI).equals("anything") || ShoppingCart.get(tempI).equals(list.get(j)))
                    {
                        tempJ++;
                        tempI++;
                    }
                    else
                        break;
                }
                //check is all match
                if(tempJ == list.size())
                {
                    //pass this check
                    i = --tempI;
                    codeIndex++;
                }
            }

            if(codeIndex == codeList.size())
                return 1;
		}
		return codeIndex == codeList.size() ? 1 : 0;
		
	}
}
