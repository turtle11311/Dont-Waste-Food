package com.dwf.dontwastefood


import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [HomeFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null

    private var mListener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments.getString(ARG_PARAM1)
            mParam2 = arguments.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater?.inflate(R.layout.fragment_home, container, false)
        if (view != null) {
            // Iris add
            val imageView: ImageButton = view.findViewById(R.id.imageView)
            imageView.setImageResource(R.drawable.food_bar1)

            // mini_food bar
            val tr_pic: TableRow = view.findViewById(R.id.mini_food_bar)
            val tr_name: TableRow = view.findViewById(R.id.mini_food_names)
            val tr_price: TableRow = view.findViewById(R.id.mini_food_prices)
            tr_pic.gravity = Gravity.CENTER_HORIZONTAL
            tr_name.gravity = Gravity.CENTER_HORIZONTAL
            tr_price.gravity = Gravity.CENTER_HORIZONTAL

            val ibtn = arrayOfNulls<ImageButton>(6)
            val ntx = arrayOfNulls<TextView>(6)
            val ptx = arrayOfNulls<TextView>(6)
            val image_res = intArrayOf(R.drawable.mini_food1, R.drawable.mini_food2, R.drawable.mini_food3, R.drawable.mini_food5, R.drawable.mini_food6, R.drawable.mini_food7, R.drawable.mini_food8, R.drawable.mini_food9)
            val image_name = arrayOf("玉米", "蘋果", "雞肉", "雞蛋", "起司", "香腸", "檸檬", "紅豆")
            val image_price = arrayOf("30元", "20元", "65元", "8元", "30元", "35元", "20元", "0.2元")
            for (i in 0..5) { // 6 boxes in a line
                // pic
                ibtn[i] = ImageButton(this.context)
                ibtn[i]?.id = 111000 + i // num started with 111 , based with 111000 => mini food pics
                val lp = TableRow.LayoutParams(150, 150)
                lp.setMargins(10, 10, 10, 10)
                ibtn[i]?.layoutParams = lp
                ibtn[i]?.setPadding(10, 10, 10, 10)
                ibtn[i]?.scaleType = ImageView.ScaleType.FIT_CENTER
                ibtn[i]?.adjustViewBounds = true
                ibtn[i]?.setImageResource(image_res[i])
                tr_pic.addView(ibtn[i])
                // name
                val lp2 = TableRow.LayoutParams(150, 50)
                lp2.setMargins(15, 5, 15, 0)
                ntx[i] = TextView(this.context)
                ntx[i]?.id = 222000 + i // num started with 222 , based with 222000 => mini food names
                ntx[i]?.layoutParams = lp2
                ntx[i]?.text = image_name[i]
                ntx[i]?.gravity = Gravity.CENTER_HORIZONTAL
                tr_name.addView(ntx[i])
                // price
                ptx[i] = TextView(this.context)
                ptx[i]?.id = 333000 + i // num started with 333 , based with 333000 => mini food prices
                ptx[i]?.layoutParams = lp2
                ptx[i]?.text = image_price[i]
                ptx[i]?.gravity = Gravity.CENTER_HORIZONTAL
                tr_price.addView(ptx[i])
            }

            val tl_stared: TableLayout = view.findViewById(R.id.stared_food)
            val trs = arrayOfNulls<TableRow>(3)
            val tempbtn = arrayOfNulls<ImageButton>(6)
            val star_image_pic = intArrayOf(R.drawable.food1, R.drawable.food2, R.drawable.food3, R.drawable.food4, R.drawable.food5, R.drawable.food6)
            var count = 0
            val lp3 = TableRow.LayoutParams(525, 300)
            lp3.setMargins(20, 20, 20, 20)
            for (i in 0..2) {
                trs[i] = TableRow(this.context)
                trs[i]?.gravity = Gravity.CENTER_HORIZONTAL
                for (j in 0..1) {
                    tempbtn[count] = ImageButton(this.context)
                    tempbtn[count]?.id = 444000 + count // num started with 444 , based with 444000 =>  food pics
                    tempbtn[count]?.layoutParams = lp3
                    tempbtn[count]?.setPadding(10, 10, 10, 10)
                    tempbtn[count]?.scaleType = ImageView.ScaleType.FIT_CENTER
                    tempbtn[count]?.adjustViewBounds = true
                    tempbtn[count]?.setImageResource(star_image_pic[count])
                    trs[i]?.addView(tempbtn[count])
                    count += 1
                }
                tl_stared.addView(trs[i])
            }

            val tl_season: TableLayout = view.findViewById(R.id.season_food)
            val trs_s = arrayOfNulls<TableRow>(2)
            val tempbtn2 = arrayOfNulls<ImageButton>(4)
            val star_image_pic_s = intArrayOf(R.drawable.sfood1, R.drawable.sfood2, R.drawable.sfood3, R.drawable.sfood4)
            count = 0
            for (i in 0..1) {
                trs_s[i] = TableRow(this.context)
                trs_s[i]?.gravity = Gravity.CENTER_HORIZONTAL
                for (j in 0..1) {
                    tempbtn2[count] = ImageButton(this.context)
                    tempbtn2[count]?.id = 555000 + count // num started with 555 , based with 555000 => season  food pics
                    tempbtn2[count]?.layoutParams = lp3
                    tempbtn2[count]?.setPadding(10, 10, 10, 10)
                    tempbtn2[count]?.scaleType = ImageView.ScaleType.FIT_CENTER
                    tempbtn2[count]?.adjustViewBounds = true
                    tempbtn2[count]?.setImageResource(star_image_pic_s[count])
                    trs_s[i]?.addView(tempbtn2[count])
                    count += 1
                }
                tl_season.addView(trs_s[i])
            }
        }
        return view
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        if (mListener != null) {
            mListener!!.onFragmentInteraction(uri)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            mListener = context
        } else {
//            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html) for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String, param2: String): HomeFragment {
            val fragment = HomeFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}// Required empty public constructor
