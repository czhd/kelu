package pro.kelu.missyou.util;

import pro.kelu.missyou.bo.PageCounter;

public class CommonUtil {

    public static PageCounter converToPageParameter(int start, int count) {
        int pageNum = start / count;
        return PageCounter.builder()
                .page(pageNum)
                .count(count)
                .build();
    }
}
