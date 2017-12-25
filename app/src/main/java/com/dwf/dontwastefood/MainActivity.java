package com.dwf.dontwastefood;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.dwf.dontwastefood.proto.UserModel;
import com.dwf.dontwastefood.proto.UserModel.User;
import com.google.protobuf.Message;
import com.google.protobuf.TextFormat;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static List<User> userList;

    private static final String TAG = "MainActivity";

    private TextView mTextMessage;
    private AssetManager mAssetManager;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_recipe:
                    mTextMessage.setText(R.string.title_recipe);
                    return true;
                case R.id.navigation_profile:
                    mTextMessage.setText(R.string.title_profile);
                    return true;
                case R.id.navigation_favorite:
                    mTextMessage.setText(R.string.title_favorite);
                    return true;
            }
            return false;
        }
    };

    private void loadData() throws IOException {
        UserModel.UsersOrBuilder users = UserModel.Users.newBuilder();
        InputStream input = mAssetManager.open("users.prototext");
        InputStreamReader reader = new InputStreamReader(input);
        TextFormat.Parser.newBuilder().build().merge(reader, (Message.Builder) users);
        userList = users.getUserList();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAssetManager = getAssets();
        mTextMessage = findViewById(R.id.message);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
