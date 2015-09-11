package com.example.testfundapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.amigold.fundapter.BindDictionary;
import com.amigold.fundapter.FunDapter;
import com.amigold.fundapter.extractors.StringExtractor;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvProduct = (ListView) findViewById(R.id.lvProduct);
//        ArrayList<String> products = new ArrayList<String>();
//        products.add("Coke");
//        products.add("Pepsi");
//        products.add("Red Bull");
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                this, android.R.layout.simple_list_item_1, products
//        );

        ArrayList<Product> products = new ArrayList<Product>();
        Product p1 = new Product();
        p1.id = 1;
        p1.name = "Coke";
        p1.qty = 20;
        p1.price = 0.5;
        products.add(p1);

        Product p2 = new Product();
        p2.id = 2;
        p2.name = "Pepsi";
        p2.qty = 15;
        p2.price = 0.5;

        products.add(p2);

        BindDictionary<Product> dict = new BindDictionary<Product>();
        dict.addStringField(R.id.tvName_layout_product,
                new StringExtractor<Product>() {
                    @Override
                    public String getStringValue(Product product, int i) {
                        return product.name;
                    }
                }
        );


        dict.addStringField(R.id.tvQty_layout_product,
                new StringExtractor<Product>() {
                    @Override
                    public String getStringValue(Product product, int i) {
                        return product.qty.toString();
                    }
                }
        );
        dict.addStringField(R.id.tvPrice_layout_product,
                new StringExtractor<Product>() {
                    @Override
                    public String getStringValue(Product product, int i) {
                        return product.price.toString();
                    }
                }
        );

        FunDapter adapter = new FunDapter(this, products,
                R.layout.layout_product, dict);

        lvProduct.setAdapter(adapter);
    }

}
