package com.dwf.dontwastefood

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.ViewGroup
import android.widget.*


class RecipeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)

        val ll = findViewById<LinearLayout>(R.id.recipe_detail)

        val row_name = TableRow(this)
        val row_lp = TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 150)
        row_lp.setMargins(15, 5, 15, 0)
        row_lp.gravity = Gravity.CENTER_HORIZONTAL
        row_name.layoutParams = row_lp
        row_name.setPadding(50, 30, 20, 20)
        val food_name = "Rice Dumpling"
        val name_lp = TableRow.LayoutParams(800, ViewGroup.LayoutParams.WRAP_CONTENT)
        val name = TextView(this)
        name.text = food_name
        name.textSize = 28f
        name.layoutParams = name_lp
        row_name.addView(name)
        val star = ImageButton(this)
        val star_lp = TableRow.LayoutParams(150, 100)
        var star_state = false
        star.setBackgroundColor(Color.TRANSPARENT)
        star.setOnClickListener {
            star_state = !star_state
            if (star_state)
                star.setImageResource(android.R.drawable.btn_star_big_on)
            else
                star.setImageResource(android.R.drawable.btn_star_big_off)
        }
        if (star_state)
            star.setImageResource(android.R.drawable.btn_star_big_on)
        else
            star.setImageResource(android.R.drawable.btn_star_big_off)
        star.layoutParams = star_lp
        row_name.addView(star)
        ll.addView(row_name)

        val author = TextView(this)
        author.text = "by Ca Ca Cooking"
        author.setPadding(70, 10, 50, 10)
        author.textSize = 18f
        ll.addView(author)

        val row_lp2 = TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 100)
        row_lp2.setMargins(15, 5, 15, 0)
        val row_star_and_class = TableRow(this)
        row_star_and_class.setLayoutParams(row_lp2)
        row_star_and_class.setPadding(50, 20, 20, 20)
        val tag_lp = TableRow.LayoutParams(200, 100)
        //tag_lp.gravity = Gravity.CENTER_HORIZONTAL;
        val class_tag = TextView(this)
        class_tag.layoutParams = tag_lp
        class_tag.text = "Dessert"
        class_tag.gravity = Gravity.CENTER_HORIZONTAL
        class_tag.setBackgroundColor(Color.parseColor("#FFB6C1"))
        row_star_and_class.addView(class_tag)
        ll.addView(row_star_and_class)

        val food = ImageButton(this)
        food.setImageResource(R.drawable.food_bar1)
        val food_lp = TableRow.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, 700)
        //food_lp.setMargins(15,5,15,5);
        food.scaleType = ImageView.ScaleType.FIT_CENTER
        food.adjustViewBounds = true
        food.layoutParams = food_lp
        ll.addView(food)

        val ingredients = TextView(this)
        ingredients.text = "✓ Ingredients : "
        ingredients.setPadding(50, 10, 50, 10)
        ingredients.textSize = 20f
        ingredients.setTextColor(Color.parseColor("#24936E"))
        ll.addView(ingredients)

        val ingredients_detail = TextView(this)
        ingredients_detail.text = " 長糯米 5杯, 五花肉 3條, 乾香菇 15朵, 油蔥酥 1小碟,\n 蝦米 1小碟, 菜脯 150g, 粽葉 約30顆, 醬油 1大匙,\n 蠔油 1大匙, 米酒 1大匙, 冰糖 1小匙, 胡椒粉 少許,\n 香油 1匙"
        ingredients_detail.textSize = 16f
        ingredients_detail.setPadding(60, 10, 50, 10)
        ingredients_detail.setTextColor(Color.BLACK)
        ll.addView(ingredients_detail)

        val cooking = TextView(this)
        cooking.text = "✓ Cooking Methods : "
        cooking.setPadding(50, 10, 50, 10)
        cooking.textSize = 20f
        cooking.setTextColor(Color.parseColor("#24936E"))
        ll.addView(cooking)

        val cooking_detail = TextView(this)
        var receipe_text = "1. 煮一鍋滾水，加入少許的油，將粽葉放入汆燙10分鐘後瀝起，水龍頭開著以活水刷洗乾淨。\n"
        receipe_text += "2. 長糯米泡水兩個小時後瀝乾。\n"
        receipe_text += "3. 準備一個煮鍋，糯米放入後，加3匙的滷汁及2米杯量的水，外面放3米杯量的水蒸熟備用。\n"
        receipe_text += "4. 先將1條五花肉切成細長狀下鍋煸香盛起，另2條五花肉切成塊狀，滷製後備用(可參考\"家常滷肉\"食譜哦)；乾香菇泡軟切細段，蝦米及菜脯泡水20分鐘後瀝乾備用。\n"
        receipe_text += "5. 熱鍋加1匙沙拉油及1匙香油，依序將蝦米、香菇、菜脯、五花肉細條、油蔥酥下鍋炒香，以1大匙的醬油、1大匙的蠔油、1大匙的米酒、1小匙的冰糖、少許的胡椒粉調味，加入2碗量的水煨炒至稍微收汁關火。\n"
        receipe_text += "6. 將煮好的糯米與配料均勻拌在一起，待涼後就可以開始包粽子了哦!\n"
        receipe_text += "7. 將兩片粽葉交錯疊好，葉梗在外，粽葉光滑面朝內，於1/3處摺成漏斗狀，填入1匙量的糯米。\n"
        receipe_text += "8. 中間放入一塊滷好的五花肉塊。\n"
        receipe_text += "9. 再把糯米均勻填滿，以湯匙壓緊。\n"
        receipe_text += "10. 將粽葉蓋上往內摺起，收緊後整理成三角立體型。\n"
        receipe_text += "11. 以棉繩繞兩圈，第一圈要勒緊一點，第二圈再以活結綁妥。\n"
        receipe_text += "12. 綁好的粽子放入電鍋，外鍋放2米杯量的水，把粽葉及糯米的味道結合在一起。\n"
        receipe_text += "13. 蒸好後，慶端午的肉粽就完成了哦!"
        cooking_detail.text = receipe_text
        cooking_detail.textSize = 16f
        cooking_detail.setPadding(60, 10, 50, 30)
        cooking_detail.setTextColor(Color.BLACK)
        ll.addView(cooking_detail)
    }
}
