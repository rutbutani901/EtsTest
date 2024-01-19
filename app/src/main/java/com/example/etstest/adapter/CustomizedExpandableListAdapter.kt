package com.example.etstest.adapter

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.example.etstest.R


class CustomizedExpandableListAdapter     // constructor
    (
    private val context: Context, private val expandableTitleList: List<String>,
    private val expandableDetailList: HashMap<String, List<String>>
) : BaseExpandableListAdapter()
{
    // Gets the data associated with the given child within the given group.
    override fun getChild(lstPosn: Int, expanded_ListPosition: Int): Any {
        return expandableDetailList[expandableTitleList[lstPosn]]!![expanded_ListPosition]
    }

    // Gets the ID for the given child within the given group.
    // This ID must be unique across all children within the group. Hence we can pick the child uniquely
    override fun getChildId(listPosition: Int, expanded_ListPosition: Int): Long {
        return expanded_ListPosition.toLong()
    }

    // Gets a View that displays the data for the given child within the given group.
    override fun getChildView(
        lstPosn: Int, expanded_ListPosition: Int,
        isLastChild: Boolean, convertView: View?, parent: ViewGroup
    ): View {
        var convertView = convertView
        val expandedListText = getChild(lstPosn, expanded_ListPosition) as String
        if (convertView == null) {
            val layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = layoutInflater.inflate(R.layout.item_category_child, null)
        }
        val expandedListTextView = convertView?.findViewById<View>(R.id.text) as TextView
        expandedListTextView.text = expandedListText
        return convertView
    }

    // Gets the number of children in a specified group.
    override fun getChildrenCount(listPosition: Int): Int {
        return expandableDetailList[expandableTitleList[listPosition]]!!.size
    }

    // Gets the data associated with the given group.
    override fun getGroup(listPosition: Int): Any {
        return expandableTitleList[listPosition]
    }

    // Gets the number of groups.
    override fun getGroupCount(): Int {
        return expandableTitleList.size
    }

    // Gets the ID for the group at the given position. This group ID must be unique across groups.
    override fun getGroupId(listPosition: Int): Long {
        return listPosition.toLong()
    }

    // Gets a View that displays the given group.
    // This View is only for the group--the Views for the group's children
    // will be fetched using getChildView()
    override fun getGroupView(
        listPosition: Int,
        isExpanded: Boolean,
        convertView: View,
        parent: ViewGroup
    ): View {
        var convertView = convertView
        val listTitle = getGroup(listPosition) as String
        if (convertView == null) {
            val layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = layoutInflater.inflate(R.layout.item_category, null)
        }
        val listTitleTextView = convertView.findViewById<View>(R.id.text) as TextView
        listTitleTextView.setTypeface(null, Typeface.BOLD)
        listTitleTextView.text = listTitle
        return convertView
    }

    // Indicates whether the child and group IDs are stable across changes to the underlying data.
    override fun hasStableIds(): Boolean {
        return false
    }

    // Whether the child at the specified position is selectable.
    override fun isChildSelectable(listPosition: Int, expandedListPosition: Int): Boolean {
        return true
    }
}

//class ExpandableCategoryAdapter
//    (
//    private val context: Context,
//    private val titleList: List<String>,
//    private val childList: HashMap<String, List<ChildCategoryModel>>) : BaseExpandableListAdapter()
//{
//
//    override fun getChild(groupPosition: Int, childPosition: Int): Any {
//        return childList[titleList[groupPosition]]!![childPosition]
//    }
//
//    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
//        return childPosition.toLong()
//    }
//
//
//
//    override fun getChildView(
//        groupPosition: Int, childPosition: Int,
//        isLastChild: Boolean, convertView: View, parent: ViewGroup
//    ): View {
//        var convertView = convertView
//        val expandedListText = getChild(groupPosition, childPosition) as String
//        if (convertView == null) {
//            val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//            convertView = layoutInflater.inflate(R.layout.item_category_child, null)
//        }
//        val expandedListTextView = convertView.findViewById<View>(R.id.text) as TextView
//        expandedListTextView.text = expandedListText
//        return convertView
//    }
//
//
//
//
//    override fun getChildrenCount(listPosition: Int): Int {
//        return childList[titleList[listPosition]]!!.size
//    }
//
//    // Gets the data associated with the given group.
//    override fun getGroup(listPosition: Int): Any {
//        return titleList[listPosition]
//    }
//
//    // Gets the number of groups.
//    override fun getGroupCount(): Int {
//        return titleList.size
//    }
//
//    // Gets the ID for the group at the given position. This group ID must be unique across groups.
//    override fun getGroupId(listPosition: Int): Long {
//        return listPosition.toLong()
//    }
//
//    // Gets a View that displays the given group.
//    // This View is only for the group--the Views for the group's children
//    // will be fetched using getChildView()
//    override fun getGroupView(
//        listPosition: Int,
//        isExpanded: Boolean,
//        convertView: View,
//        parent: ViewGroup
//    ): View {
//        var convertView = convertView
//        val listTitle = getGroup(listPosition) as String
//        if (convertView == null) {
//            val layoutInflater =
//                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//            convertView = layoutInflater.inflate(R.layout.item_category, null)
//        }
//        val listTitleTextView = convertView.findViewById<View>(R.id.text) as TextView
//        listTitleTextView.setTypeface(null, Typeface.BOLD)
//        listTitleTextView.text = listTitle
//        return convertView
//    }
//
//    // Indicates whether the child and group IDs are stable across changes to the underlying data.
//    override fun hasStableIds(): Boolean {
//        return false
//    }
//
//    // Whether the child at the specified position is selectable.
//    override fun isChildSelectable(listPosition: Int, expandedListPosition: Int): Boolean {
//        return true
//    }
//}
