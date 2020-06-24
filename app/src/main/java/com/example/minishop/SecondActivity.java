package com.example.minishop;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.minishop.adapters.Adapter;
import com.example.minishop.model.Item;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    private ListView listView;
    private Adapter cartGoodsAdapter;
    private LayoutInflater layoutInflater;
    private ArrayList<Item> items;
    private TextView tv_count;
    private View view_header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
        Intent intent = getIntent();
        items = intent.getParcelableArrayListExtra("Мой лист");
        createMyListView();
    }

    private void createMyListView() {
        cartGoodsAdapter = new Adapter(this, items);
        layoutInflater = LayoutInflater.from(this);
        view_header = layoutInflater.inflate(R.layout.header, null);
        tv_count = (TextView) view_header.findViewById(R.id.tv_text);
        tv_count.setText(cartGoodsAdapter.getCount() + " товаров");
        listView.addHeaderView(view_header);

        listView.setAdapter(cartGoodsAdapter);
    }

    private void initView () {
        listView = (ListView) findViewById(R.id.listGoodsInCart);
    }

}
