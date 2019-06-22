package net.lzzy.algorithm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import net.lzzy.algorithm.algorlib.BaseSort;
import net.lzzy.algorithm.algorlib.DirectSort;
import net.lzzy.algorithm.algorlib.InsertSort;
import net.lzzy.algorithm.algorlib.SortFactory;

import java.util.Calendar;
import java.util.Objects;
import java.util.Random;

/**
 * @author Administrator
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Integer[] items;
    private EditText edtItems;
    private TextView tvResult;
    private  Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initSpinner();
        initViews();
    }
    private void initViews() {
            edtItems = findViewById(R.id.activity_main_edt_items);
            findViewById(R.id.activity_main_btn_generate).setOnClickListener(this);
            findViewById(R.id.activity_main_btn_sort).setOnClickListener(this);
            tvResult = findViewById(R.id.activity_main_tv_result);
        }
    private void initSpinner() {
         spinner=findViewById(R.id.activity_main_sp);
        spinner.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item, SortFactory.getSortNames()));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_main_btn_generate:
                generateItems();
                displayItems(edtItems);
                break;
            case R.id.activity_main_btn_sort:
                BaseSort<Integer>sort=SortFactory.getInstance(spinner.getSelectedItemPosition(),items);
                BaseSort<Integer> sortNotNull= Objects.requireNonNull(sort);
                sortNotNull.sortWithtime();
                String result=sortNotNull.getReault();
                tvResult.setText(result);
                Toast.makeText(this, "总时长", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    private void displayItems(TextView tv) {
        String display = "";
        for (Integer i : items) {
            display = display.concat(i + ",");
        }
        display = display.substring(0, display.length() - 1);
        tv.setText(display);
    }

    private void directSort() {
        //todo:直接选择排序的具体实现
        //todo:for循环
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

    //todo:直接插入排序
private void insertSort(){
    //i 当前的位置大于等于有序区中的所有值然后排序结束，进行下一趟排序，i 位置的前面为有序区
    // i 当前位置里的数值和前一个进行比较，如果 i 值小于有序区中的数值时，
    //  则i被放到监视哨 R0 中，然后以 j 为扫描指针，有序区最大数值往 i 的位置移动，在有序区寻找 i 的合适位置
    ////R0 中的数值大于 j 中的数值时则把 R0 中的数值放到 j+1 中的位置，
    for(int i=1;i<items.length;i++){
        int j=i-1;
        if (items[j].compareTo(items[i])<0){
            continue;
        }
        Integer hhh=items[i];
        while (j>=0 && items [j].compareTo(hhh)>0){
            items[j+1]=items[j];
            j--;
        }
        items[j+1]= hhh;
    }
}

    private void swap(int m, int n) {
        int tmp=items[m];
        items[m]=items[n];
        items[n]=tmp;
    }
    private void generateItems() {
        items = new Integer[10];
        Random generator = new Random();
        for (int i = 0; i < items.length; i++) {
            items[i] = generator.nextInt(99);
        }
    }
}
