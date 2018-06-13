package com.amangarg.recrotask2.view

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.content.Intent
import android.support.v7.widget.Toolbar
import android.widget.Button
import com.amangarg.recrotask2.R
import com.amangarg.recrotask2.models.ProductModel
import com.amangarg.recrotask2.utils.BaseConfiguration

import com.amangarg.recrotask2.utils.BaseConfiguration.SHARED_PREF_NAME
import com.amangarg.recrotask2.utils.PostRequest
import com.amangarg.recrotask2.utils.postResponseInterface
import org.json.JSONObject
import android.support.v4.view.ViewPager
import com.amangarg.recrotask2.utils.ViewAdapter


class MainActivity : AppCompatActivity(), postResponseInterface {

    var productListRespone = "{\n" +
            "\n" +
            "  \"dt\": [\n" +
            "\n" +
            "    {\n" +
            "\n" +
            "      \"ProductName\": \" Pop Stocks\",\n" +
            "\n" +
            "      \"ProductId\": 104,\n" +
            "\n" +
            "      \"Subscribed\": true,\n" +
            "\n" +
            "      \"Trial\": false,\n" +
            "\n" +
            "      \"New\": false\n" +
            "\n" +
            "    },\n" +
            "\n" +
            "    {\n" +
            "\n" +
            "      \"ProductName\": \"Pop BTST\",\n" +
            "\n" +
            "      \"ProductId\": 148,\n" +
            "\n" +
            "      \"Subscribed\": true,\n" +
            "\n" +
            "      \"Trial\": false,\n" +
            "\n" +
            "      \"New\": false\n" +
            "\n" +
            "    },\n" +
            "\n" +
            "    {\n" +
            "\n" +
            "      \"ProductName\": \"Pop Futures and Options\",\n" +
            "\n" +
            "      \"ProductId\": 134,\n" +
            "\n" +
            "      \"Subscribed\": true,\n" +
            "\n" +
            "      \"Trial\": false,\n" +
            "\n" +
            "      \"New\": false\n" +
            "\n" +
            "    },\n" +
            "\n" +
            "    {\n" +
            "\n" +
            "      \"ProductName\": \"Pop Index\",\n" +
            "\n" +
            "      \"ProductId\": 149,\n" +
            "\n" +
            "      \"Subscribed\": true,\n" +
            "\n" +
            "      \"Trial\": false,\n" +
            "\n" +
            "      \"New\": false\n" +
            "\n" +
            "    },\n" +
            "\n" +
            "    {\n" +
            "\n" +
            "      \"ProductName\": \"Pop Options\",\n" +
            "\n" +
            "      \"ProductId\": 150,\n" +
            "\n" +
            "      \"Subscribed\": true,\n" +
            "\n" +
            "      \"Trial\": false,\n" +
            "\n" +
            "      \"New\": false\n" +
            "\n" +
            "    },\n" +
            "\n" +
            "    {\n" +
            "\n" +
            "      \"ProductName\": \"Technical Advisory Service\",\n" +
            "\n" +
            "      \"ProductId\": 163,\n" +
            "\n" +
            "      \"Subscribed\": true,\n" +
            "\n" +
            "      \"Trial\": false,\n" +
            "\n" +
            "      \"New\": false\n" +
            "\n" +
            "    }\n" +
            "\n" +
            "  ]\n" +
            "\n" +
            "}\n" +
            "\n"

    override fun onResponseReceived(response: String?, URL_NAME: String?, responseCode: Int?) {

//        val jsonResponse = JSONObject(productListRespone);
//        val productList = jsonResponse.getJSONArray("dt")
//        val adapterList = ArrayList<ProductModel>()
//        for (obj in productList){
//            var model = ProductModel()
//        }
//

    }

    private var email: TextView? = null
    private var signOut: Button? = null
    //    private var authListener: FirebaseAuth.AuthStateListener? = null
//    private var auth: FirebaseAuth? = null

    val sp = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById(R.id.toolbar) as Toolbar
        toolbar.setTitle(getString(R.string.app_name))
        setSupportActionBar(toolbar)
        val sp = getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
//        val user_deatil = sp.getString("user_info", null)
        val user_logged_in = sp.getBoolean("user_logged_in", false)
        if (user_logged_in == null) {
            startActivity(Intent(this, LoginActivity::class.java))
        } else {
            // TODO: Uncomment code after finding out the issue in Productlist API
//            val user_id = sp.getString("userid", null)
//            val company_id = sp.getString("companyid", null)
//            val token = sp.getString("token", null)
//

//            val productBodyRequest = JSONObject()
//            productBodyRequest.put("userid",user_id)
//            productBodyRequest.put("companyid",company_id)
//            productBodyRequest.put("token",token)

//            val postRequest = PostRequest(BaseConfiguration.LOGIN_URL, productBodyRequest.toString())
//            postRequest.setResponseInterface(this@MainActivity)

            val jsonResponse = JSONObject(productListRespone);
            val productList = jsonResponse.getJSONArray("dt")

            val viewPager = findViewById<View>(R.id.viewpager) as ViewPager
            viewPager.adapter = ViewAdapter(this@MainActivity,productList)
            viewPager.offscreenPageLimit = 5
            viewPager.pageMargin = 15
            viewPager.clipChildren = false
        }


//
//        if (name != null) {
//            textView.setText("Welcome $name")
//        }
//        //get firebase auth instance
//        auth = FirebaseAuth.getInstance()
//
//        //get current user
//        val user = FirebaseAuth.getInstance().currentUser
//
//        authListener = FirebaseAuth.AuthStateListener { firebaseAuth ->
//            val user = firebaseAuth.currentUser
//            if (user == null) {
//                // user auth state is changed - user is null
//                // launch login activity
//                startActivity(Intent(this@MainActivity, LoginActivity::class.java))
//                finish()
//            }
//        }
//
//        signOut = findViewById(R.id.sign_out) as Button
//        email = findViewById(R.id.email) as TextView
//
//        email!!.text = user!!.email
//
//        signOut!!.setOnClickListener(View.OnClickListener { signOut() })

    }


    override fun onBackPressed() {
        super.onBackPressed()
        val sp = getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
//        val user_deatil = sp.getString("user_info", null)
        val user_logged_in = sp.getString("user_logged_in", null)
        if (user_logged_in == null) {
            startActivity(Intent(this, LoginActivity::class.java))
        }
//        val user_logged_in = sp.getString("user_logged_in", null)
//        if (user_logged_in == null) {
//            startActivity(Intent(this, LoginActivity::class.java))
//        }
    }
    //sign out method
//    fun signOut() {
//        auth!!.signOut()
//    }

//    public override fun onStart() {
//        super.onStart()
//        auth!!.addAuthStateListener(authListener!!)
//    }

//    public override fun onStop() {
//        super.onStop()
//        if (authListener != null) {
//            auth!!.removeAuthStateListener(authListener!!)
//        }
//    }
}
