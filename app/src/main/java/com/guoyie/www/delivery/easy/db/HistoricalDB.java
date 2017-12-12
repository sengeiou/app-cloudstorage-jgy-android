package com.guoyie.www.delivery.easy.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 *  author：柯军
 * project：New_GuoYieAndroid
 * package：com.guoyie.www.gyapp.db
 * email：774169396@qq.com
 * data：17/03/26
 */
public class HistoricalDB extends SQLiteOpenHelper {
    protected SQLiteDatabase database;
    /**
     * 数据库名称
     **/
    public static final  String DATABASE_NAME    = "chinajgy.db";
    /**
     * 数据库版本号
     **/
    private static final int    DATABASE_VERSION = 1;
    private Context context;
    private int type;

    public HistoricalDB(Context context , int type) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        this.type=type;
    }

    /**
     * 数据库SQL语句 添加一个表
     **/
    String NAME_TABLE_CREATE1 = "create table gy1(" + "_id INTEGER PRIMARY KEY AUTOINCREMENT," + "gy_name TEXT," + "gy_createTm TEXT);";
    String NAME_TABLE_CREATE2 = "create table gy2(" + "_id INTEGER PRIMARY KEY AUTOINCREMENT," + "gy_name TEXT," + "gy_createTm TEXT);";
    String NAME_TABLE_CREATE3 = "create table gy3(" + "_id INTEGER PRIMARY KEY AUTOINCREMENT," + "gy_name TEXT," + "gy_createTm TEXT);";
    String NAME_TABLE_CREATE4 = "create table gy4(" + "_id INTEGER PRIMARY KEY AUTOINCREMENT," + "gy_name TEXT," + "gy_createTm TEXT);";
    @Override
    public void onCreate(SQLiteDatabase db) {
        switch (type){
            case 1:
                db.execSQL(NAME_TABLE_CREATE1);
                break;
            case 2:
                db.execSQL(NAME_TABLE_CREATE2);
                break;
            case 3:
                db.execSQL(NAME_TABLE_CREATE3);
                break;
            case 4:
                db.execSQL(NAME_TABLE_CREATE4);
                break;

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    /**
     * 查询搜索记录
     */
    public List<String> selectedHistorical() {
        List<String> list = null;
        // 订单保存时的时间
        database = getReadableDatabase();
        Cursor c = database.query("gy"+type, null, null, null, null, null,
                "_id desc");
        if (c != null) {
            list = new ArrayList<>();
            while (c.moveToNext()) {
                String name = c.getString(c.getColumnIndex("gy_name"));
                list.add(name);
            }
        }
        c.close();
        database.close();
        return list;
    }

    /**
     * 查询此记录是否存在
     */
    public boolean isHistorical(String tag) {
        database = getReadableDatabase();
        String sql = null;
        switch (type){
            case 1:
                sql="SELECT * from gy1 where gy_name ='" + tag + "'";
                break;
            case 2:
                sql="SELECT * from gy2 where gy_name ='" + tag + "'";
                break;
            case 3:
                sql="SELECT * from gy3 where gy_name ='" + tag + "'";
                break;
            case 4:
                sql="SELECT * from gy4 where gy_name ='" + tag + "'";
                break;
        }


        Cursor cur = database.rawQuery(sql, null);
        try {
            if (cur != null) {
                if (cur.moveToFirst()) {
                    do {
                        return true;
                    } while (cur.moveToNext());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cur.close();
        }
        return false;
    }

    /**
     * 保存搜索历史记录
     */
    public void saveHistorical(String tag) {
        // 保存前，先判断数据库是否存在此数据
        if (!isHistorical(tag)) {
            // 订单保存时的时间
            String create_time = String.valueOf(System.currentTimeMillis())
                    .substring(0, 10);
            database = getReadableDatabase();
            ContentValues values = new ContentValues();
            values.put("gy_name", tag);
            values.put("gy_createTm", create_time);
            database.insert("gy", null, values);
            database.close();
        }
    }

    /**
     * 删除搜索历史记录
     */
    public void deleteTitle(String tag) {
        database = getReadableDatabase();
        database.delete("gy"+type, "gy_name = ?", new String[]{tag});
        database.close();
    }
}
