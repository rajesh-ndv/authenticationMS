package Service;


import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class BasicTestClass {

    public boolean isExists(List<Integer> list,int target){
        Collections.sort(list);
        int i=0,j=list.size()-1;
        while (i<j){
            int currSum = list.get(i)+list.get(j);
            if(currSum==target){
                return true;
            }else if(currSum<target){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }
}
