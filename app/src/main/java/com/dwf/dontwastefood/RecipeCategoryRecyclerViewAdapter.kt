package com.dwf.dontwastefood

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.dwf.dontwastefood.RecipeCategoryFragment.OnListFragmentInteractionListener

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class RecipeCategoryRecyclerViewAdapter(private val mValues: List<RecipeCategory>, private val mListener: OnListFragmentInteractionListener?) : RecyclerView.Adapter<RecipeCategoryRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_recipecategory, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mItem = mValues[position]
        holder.mImageView.setImageDrawable(mValues[position].drawable)
        holder.mContentView.text = mValues[position].name

        holder.mView.setOnClickListener {
            mListener?.onRecipeCategorySelect(holder.mItem)
        }
    }

    override fun getItemCount(): Int {
        return mValues.size
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mImageView: ImageView = mView.findViewById(R.id.image_recipe_category)
        val mContentView: TextView = mView.findViewById(R.id.text_recipe_category)
        var mItem: RecipeCategory? = null

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}
