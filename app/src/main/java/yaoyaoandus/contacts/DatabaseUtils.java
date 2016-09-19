package yaoyaoandus.contacts;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by LJY on 16/9/17.
 */
public class DatabaseUtils extends SQLiteOpenHelper{

    //1登陆用户账号，users(用户ID,用户名,密码,昵称,头像,电话,邮箱)
    final static String create_users="CREATE TABLE users (" +
            "  id INT,\n" +
            "  name VARCHAR(20),\n" +
            "  password VARCHAR(20) ,\n" +
            "  nicename VARCHAR(20) ,\n" +
            "  picture VARCHAR(20) ,\n" +
            "  phone VARCHAR(16) ,\n" +
            "  email VARCHAR(20) ,\n" +
            "  PRIMARY KEY (id)\n" +
            ");";

    //2我收到的名片cards_received(卡ID，用户ID，用户名，卡信息）
    final static String create_cards_received="CREATE TABLE cards_received (\n" +
            "  card_id INT,\n" +
            "  user_id INT,\n" +
            "  user_name varchar(20),\n"+
            "  content tinytext,\n" +
            "  PRIMARY KEY (card_id)\n" +
            ");";

    //3我的名片mycards（卡ID,卡名字，content）
    final static String create_mycards="CREATE TABLE mycards (\n" +
            "  card_id INT,\n" +
            "  card_name VARCHAR(20),\n"+
            "  content TINYTEXT,\n" +
            "  PRIMARY KEY (card_id)\n" +
            ");";

    //4我的群groups(群ID，创建者用户ID，群名，detail描述信息)
    final static String create_groups="CREATE TABLE groups (\n" +
            "  id INT,\n" +
            "  user_id INT,\n" +
            "  name VARCHAR(20),\n" +
            "  detail VARCHAR(50),\n" +
            "  PRIMARY KEY (id)\n" +
            ");";

    //5黑名单管理users-blockeds(用户屏蔽的对象的ID)
    final static String create_users_blockeds="CREATE TABLE users_blockeds (\n" +
            "  blocked_id INT,\n" +
            "  PRIMARY KEY (blocked_id)\n" +
            ");\n";

    //6我的名片发给了哪些人cards-sendto(卡片ID，对象ID，对象名字)
    final static String create_cards_sendto="CREATE TABLE cards_sendto (\n" +
            "  card_id INT,\n" +
            "  user_id INT,\n" +
            "  user_name VARCHAR(20)\n" +
            ");\n";

    //7我的名片发给了哪些群cards_groups(卡片ID，群ID，群名字)
    final static String create_cards_groups="CREATE TABLE cards_groups (\n" +
            "  card_id INT,\n" +
            "  group_id INT,\n" +
            "  group_name VARCHAR(20)\n" +
            ");\n";

    //8每个群里都有哪些卡片groups_contain(群ID，用户ID，用户名）
    final static String create_groups_contain="CREATE TABLE groups_contain (\n" +
            "  group_id INT,\n" +
            "  user_id INT,\n" +
            "  user_name VARCHAR(20)\n" +
            ");\n";

    Context c;

    public DatabaseUtils(Context context, String name, int version)
    {
        super(context,name,null,version);
        c=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(create_users);
        db.execSQL(create_cards_groups);
        db.execSQL(create_cards_received);
        db.execSQL(create_cards_sendto);
        db.execSQL(create_groups);
        db.execSQL(create_mycards);
        db.execSQL(create_users_blockeds);
        db.execSQL(create_groups_contain);
        //Toast.makeText(c,"create成功",Toast.LENGTH_SHORT).show();

        //本次登陆的用户同学
        //1登陆用户账号，users(用户ID，用户名,密码,昵称,头像,电话,邮箱)
        db.execSQL("insert into users values " +
                "(1,'高明','123456','小高同学','tupian','13688888789','583480035@qq.com')");
        //2我受到的名片cards_received(卡ID，用户ID，用户名，卡信息）
        db.execSQL("insert into cards_received values " +
                "(3,2,'陈立','15823031029')");
        db.execSQL("insert into cards_received values " +
                "(4,3,'郭经理','88456231')");
        db.execSQL("insert into cards_received values " +
                "(5,4,'林新','17865198377')");
        db.execSQL("insert into cards_received values " +
                "(6,5,'林正心','19820203332')");
        db.execSQL("insert into cards_received values " +
                "(7,6,'许晶晶','16327271856')");
        db.execSQL("insert into cards_received values " +
                "(8,7,'张起灵','82221710')");
        //3我的名片mycards（卡ID,卡名字，content）
        db.execSQL("insert into mycards values " +
                "(1,'高明','13688888789')");
        db.execSQL("insert into mycards values " +
                "(2,'高先生','13688888789')");
        //4我的群groups(群ID，创建者用户ID，群名，detail描述信息)
        db.execSQL("insert into groups values " +
                "(1,2,'小学同学','小学的时候天真无邪')");
        db.execSQL("insert into groups values " +
                "(2,2,'初中同学','美好的初中')");
        db.execSQL("insert into groups values " +
                "(3,6,'高中同学','高中的我们一起奋斗')");
        //5黑名单管理users-blockeds(用户屏蔽的对象的ID)
        //6我的名片发给了哪些人cards-sendto(卡片ID，对象ID，对象名字)
        db.execSQL("insert into cards_sendto values " +
                "(1,2,'陈立')");
        db.execSQL("insert into cards_sendto values " +
                "(1,3,'郭经理')");
        db.execSQL("insert into cards_sendto values " +
                "(2,4,'林新')");
        db.execSQL("insert into cards_sendto values " +
                "(2,6,'许晶晶')");
        db.execSQL("insert into cards_sendto values " +
                "(2,7,'张起灵')");
        //7我的名片发给了哪些群cards_groups(卡片ID，群ID，群名字)
        db.execSQL("insert into cards_groups values " +
                "(1,1,'小学同学')");
        //8每个群里都有哪些卡片groups_contain(群ID，用户ID，用户名）
        db.execSQL("insert into groups_contain values " +
                "(1,1,'高明')");
        db.execSQL("insert into groups_contain values " +
                "(1,2,'陈立')");
        db.execSQL("insert into groups_contain values " +
                "(1,8,'王萌萌')");
        db.execSQL("insert into groups_contain values " +
                "(2,1,'高明')");
        db.execSQL("insert into groups_contain values " +
                "(2,2,'陈立')");
        db.execSQL("insert into groups_contain values " +
                "(3,1,'高明')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}
