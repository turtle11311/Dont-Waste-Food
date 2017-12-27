package com.dwf.dontwastefood

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.dwf.dontwastefood.proto.UserModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
        RecipeCategoryFragment.OnListFragmentInteractionListener,
        HomeFragment.OnFragmentInteractionListener {


    private val fragmentManager: FragmentManager = supportFragmentManager

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        val transaction = fragmentManager.beginTransaction()
        when (item.itemId) {
            R.id.navigation_home -> {
                transaction
                        .replace(fragment_container.id, HomeFragment.newInstance("", ""))
                        .setTransition(FragmentTransaction.TRANSIT_ENTER_MASK)
                        .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_recipe -> {
                transaction
                        .replace(fragment_container.id, RecipeCategoryFragment.newInstance())
                        .setTransition(FragmentTransaction.TRANSIT_ENTER_MASK)
                        .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_member_centre -> {
                transaction
                        .replace(fragment_container.id, CustomerMemberCentreFragment.newInstance("", ""))
                        .setTransition(FragmentTransaction.TRANSIT_ENTER_MASK)
                        .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_favorite -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        mUser = intent.getSerializableExtra(LoginActivity.EXTRA_USER) as UserModel.User?

        fragmentManager.beginTransaction()
                .replace(fragment_container.id, HomeFragment.newInstance("", ""))
                .setTransition(FragmentTransaction.TRANSIT_ENTER_MASK)
                .commit()
    }

    override fun onRecipeCategorySelect(item: RecipeCategory?) {
        Log.d(TAG, item?.name)
    }

    override fun onRecipeClicked(uri: Uri) {
        val intent = Intent(this@MainActivity, RecipeActivity::class.java)
        startActivity(intent)
    }

    companion object {
        private val TAG = "MainActivity"
        var mUser: UserModel.User? = null
    }
}
