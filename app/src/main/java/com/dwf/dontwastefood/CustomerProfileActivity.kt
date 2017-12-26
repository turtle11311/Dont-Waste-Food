package com.dwf.dontwastefood

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.renderscript.Allocation
import android.renderscript.Element
import android.renderscript.RenderScript
import android.renderscript.ScriptIntrinsicBlur
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Space
import android.widget.TableRow
import kotlinx.android.synthetic.main.activity_customer_profile.*


class CustomerProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_profile)

        val scale = resources.displayMetrics.density

        accountText.text = MainActivity.mUser?.account
        usernameText.text = MainActivity.mUser?.username
        emailText.text = MainActivity.mUser?.email
        var tags = MainActivity.mUser?.tagList

        for (i in 0 until tags!!.size) {
            // spacing
            val sp = Space(this)
            sp.id = i
            sp.layoutParams = TableRow.LayoutParams(50, 100)

            val btn = Button(this)
            btn.id = i
            btn.text = tags[i]
            val gd = GradientDrawable()


            // Specify the shape of drawable
            gd.shape = GradientDrawable.RECTANGLE

            // Set the fill color of drawable
            gd.setColor(Color.TRANSPARENT) // make the background transparent

            // Create a 2 pixels width red colored border for drawable
            gd.setStroke(2, Color.RED) // border width and color

            // Make the border rounded
            gd.cornerRadius = 15.0f // border corner radius

            // Finally, apply the GradientDrawable as TextView background
            btn.background = gd

            btn.layoutParams = TableRow.LayoutParams(padding_ndp(25 * tags[i].length, scale), padding_ndp(40, scale))


            favorite.addView(sp)
            favorite.addView(btn)
        }

        val bm = BitmapFactory.decodeResource(resources, R.drawable.ttt)
        val d = BitmapDrawable(resources, Blur(bm))

        header.background = d

    }

    private fun padding_ndp(n: Int, scale: Float): Int {
        return (n * scale + 0.5f).toInt()
    }

    // android blur function
    private fun Blur(src: Bitmap): Bitmap {

        val result = Bitmap.createBitmap(src.width, src.height, Bitmap.Config.ARGB_8888)
        val rs = RenderScript.create(this)
        val blur = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs))
        val `in` = Allocation.createFromBitmap(rs, src)
        val out = Allocation.createFromBitmap(rs, result)
        blur.setRadius(25f)
        blur.setInput(`in`)
        blur.forEach(out)
        out.copyTo(result)
        rs.destroy()
        return result
    }

    companion object {
        private val TAG = "CustomerProfileActivity"
    }
}


