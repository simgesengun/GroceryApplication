package com.simgesengun.groceryapplication.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.android.material.snackbar.Snackbar
import com.simgesengun.groceryapplication.R
import com.simgesengun.groceryapplication.databinding.FragmentHomepageBinding
import com.simgesengun.groceryapplication.entity.Category
import com.simgesengun.groceryapplication.entity.CategoryAdapter
import com.simgesengun.groceryapplication.entity.Item
import java.util.ArrayList

class HomepageFragment : Fragment() {

    private lateinit var categoryList : ArrayList<Category>
    private lateinit var itemList : ArrayList<Item>
    private lateinit var adapter : CategoryAdapter
    private lateinit var design : FragmentHomepageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        design = DataBindingUtil.inflate(inflater, R.layout.fragment_homepage, container, false)

        //Toolbar
        (activity as AppCompatActivity).setSupportActionBar(design.toolbarHomepage)

        createItemList()
        createCategoryList()

        adapter = CategoryAdapter(requireContext(),categoryList)
        design.categoryAdapter = adapter

        return design.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Snackbar.make(design.toolbarHomepage, "${item.title} clicked", Snackbar.LENGTH_SHORT).show()
        return true
    }


    private fun createCategoryList(){
        categoryList = ArrayList()

        val c1 = Category(1,getString(R.string.cat_on_sale),"ic_cat_on_sale")
        val c2 = Category(2,getString(R.string.cat_new),"ic_cat_new")
        val c3 = Category(3,getString(R.string.cat_water),"ic_cat_water")
        val c4 = Category(4,getString(R.string.cat_fruits_n_veg),"ic_cat_fruits_n_veg")
        val c5 = Category(5,getString(R.string.cat_bakery),"ic_cat_bakery")
        val c6 = Category(6,getString(R.string.cat_snacks),"ic_cat_snacks")
        val c7 = Category(7,getString(R.string.cat_ice_cream),"ic_cat_ice_cream")
        val c8 = Category(8,getString(R.string.cat_food),"ic_cat_food")
        val c9 = Category(9,getString(R.string.cat_drinks),"ic_cat_drinks")
        val c10 = Category(10,getString(R.string.cat_fit_n_form),"ic_cat_fit_n_form")
        val c11 = Category(11,getString(R.string.cat_milk_n_breakfast),"ic_cat_milk_n_breakfast")
        val c12 = Category(12,getString(R.string.cat_staple_food),"ic_cat_staple_food")
        val c13 = Category(13,getString(R.string.cat_personal_care),"ic_cat_personal_care")
        val c14 = Category(14,getString(R.string.cat_home_care),"ic_cat_home_care")
        val c15 = Category(15,getString(R.string.cat_home_life),"ic_cat_home_life")
        val c16 = Category(16,getString(R.string.cat_technology),"ic_cat_technology")
        val c17 = Category(17,getString(R.string.cat_tobacco),"ic_cat_tobacco")
        val c18 = Category(18,getString(R.string.cat_alcohol),"ic_cat_alcohol")
        val c19 = Category(19,getString(R.string.cat_pets),"ic_cat_pets")
        val c20 = Category(20,getString(R.string.cat_baby),"ic_cat_baby")
        val c21 = Category(21,getString(R.string.cat_sexual_health),"ic_cat_sexual_health")
        val c22 = Category(22,getString(R.string.cat_clothing),"ic_cat_clothing")


        categoryList.add(c1)
        categoryList.add(c2)
        categoryList.add(c3)
        categoryList.add(c4)
        categoryList.add(c5)
        categoryList.add(c6)
        categoryList.add(c7)
        categoryList.add(c8)
        categoryList.add(c9)
        categoryList.add(c10)
        categoryList.add(c11)
        categoryList.add(c12)
        categoryList.add(c13)
        categoryList.add(c14)
        categoryList.add(c15)
        categoryList.add(c16)
        categoryList.add(c17)
        categoryList.add(c18)
        categoryList.add(c19)
        categoryList.add(c20)
        categoryList.add(c21)
        categoryList.add(c22)

        for (c in categoryList){
            when(c.id){
                1 -> c.items = itemList.filter { it.is_on_sale }
                2 -> c.items = itemList.filter { it.is_new }
                else -> c.items = itemList.filter { it.category_id == c.id }
            }
        }
    }

    private fun createItemList(){
        itemList = ArrayList()

        val i1 = Item(1,"Damacana (5L)",80.5, 3, true, true)
        val i2 = Item(2,"Muz",80.5, 4, true)
        val i3 = Item(3,"Ekmek",80.5, 5, false)
        val i4 = Item(4,"Cips (1 kg)",80.5, 6, false)
        val i5 = Item(5,"Dondurma (2 kg)",80.5, 7, true, true)
        val i6 = Item(6,"Sandviç",80.5, 8, true)
        val i7 = Item(7,"Meyve Suyu (1 lt)",80.5, 9, true)
        val i8 = Item(8,"Fit Bar",80.5, 10, true)
        val i9 = Item(9,"Süt (1.5 lt)",80.5, 11, true, true)
        val i10 = Item(10,"Makarna",80.5, 12, true)
        val i11 = Item(11,"Diş Macunu",80.5, 13, true)
        val i12 = Item(12,"Deterjan",80.5, 14, true)
        val i13 = Item(13,"Lamba",80.5, 15, false,true)
        val i14 = Item(14,"Şarj Kablosu",80.5, 16, false,true)
        val i15 = Item(15,"Lamba",80.5, 15, false)
        val i16 = Item(16,"Beer",80.5, 16, false)
        val i17 = Item(17,"Marlboro",80.5, 19, false)
        val i18 = Item(18,"Bebek Maması",80.5, 20, true)
        val i19 = Item(19,"Masaj Jeli",80.5, 21, false)
        val i20 = Item(20,"Terlik",80.5, 22, true)


        itemList.add(i1)
        itemList.add(i2)
        itemList.add(i3)
        itemList.add(i4)
        itemList.add(i5)
        itemList.add(i6)
        itemList.add(i7)
        itemList.add(i8)
        itemList.add(i9)
        itemList.add(i10)
        itemList.add(i11)
        itemList.add(i12)
        itemList.add(i13)
        itemList.add(i14)
        itemList.add(i15)
        itemList.add(i16)
        itemList.add(i17)
        itemList.add(i18)
        itemList.add(i19)
        itemList.add(i20)
    }
}