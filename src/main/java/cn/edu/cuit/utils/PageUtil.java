package cn.edu.cuit.utils;

import java.util.ArrayList;
import java.util.List;

public class PageUtil<T> {
    public List<T> page(List<T> list, Integer page, Integer pageNumber){
        ArrayList<T> result = new ArrayList<>();
        for (int i = 0; i < pageNumber; i++) {

            if (i + pageNumber * (page - 1)>list.size()-1){
                break;
            }
            result.add(list.get(i + pageNumber * (page - 1)));
        }
        return result;
    }
}
