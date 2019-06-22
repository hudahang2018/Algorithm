package net.lzzy.algorithm.algorlib;

/**
 *
 * @author lzzy_gxy
 * @date 2019/6/13
 * Description:
 */
public class DirectSort<T extends Comparable<? super T>> extends BaseSort<T> {
    DirectSort(T[]items){
        super(items);
    }

    @Override
    public void sort() {
        //分为有序区和无序区，每一趟排序都在无序区依次进行对比，记录对比区域的最小元素的位置。
        //然后把无序区第一个元素和所记录的最小元素进行交换，无序区少一个、有序区多一个，循环往复直至无序区
        //元素数量为0
        //for i j 嵌套循环
        for(int i=0;i<=items.length-1;i++){
            int minPos=i;
            for (int j=i+1;j< items.length;j++){
                if(items[minPos].compareTo(items[j])>0){
                    //记录无序区最小的元素
                    minPos=j;
                }
                //生成方法如下
                swap(minPos,i);
            }

        }
    }
}
