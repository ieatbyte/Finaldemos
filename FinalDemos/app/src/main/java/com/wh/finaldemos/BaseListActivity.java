package com.wh.finaldemos;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wanghui5-s on 2015/11/18.
 */
public abstract class BaseListActivity extends ListActivity {

    private List<Demo> demos;
    private DemoGroup demoGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<Map<String, Object>> items = new ArrayList<Map<String, Object>>();
        Class demoGroupClass = getDemoGroupClass();
        try {
            demoGroup = (DemoGroup) demoGroupClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (demoGroup != null) {
            demos = getData();
            if (demos != null) {
                for (Demo e : demos) {
                    Map<String, Object> itemData = new HashMap<String, Object>();
                    itemData.put("name", e.getTitle());
                    items.add(itemData);
                }
                SimpleAdapter adapter = new SimpleAdapter(this, items, android.R.layout.simple_list_item_1, new String[]{"name"}, new int[]{android.R.id.text1});
                setListAdapter(adapter);
            }
        }
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Log.d("BaseListActivity", "onListItemClick:" + getData().get(position));
        demos.get(position).start();
    }

    public List<Demo> getData() {
        if (demoGroup != null) {
            return demoGroup.getSubDemos();
        }
        return null;
    }

    public abstract Class getDemoGroupClass();
}
