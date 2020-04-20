package com.wahyuakbarwibowo.aplikasikebunbinatang

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_list_binatang_buas.view.imgGambarBinatang as img1
import kotlinx.android.synthetic.main.item_list_binatang_buas.view.txtDesc as des1
import kotlinx.android.synthetic.main.item_list_binatang_buas.view.txtNama as nm1
import kotlinx.android.synthetic.main.item_list_binatang.view.imgGambarBinatang as img2
import kotlinx.android.synthetic.main.item_list_binatang.view.txtDesc as des2
import kotlinx.android.synthetic.main.item_list_binatang.view.txtNama as nm2

class MainActivity : AppCompatActivity() {

    var listBinatang = ArrayList<Binatang>()
    var adapter: AdapterBinatang? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listBinatang.add(
            Binatang("Kelinci", "Kelinci Hutan", R.drawable.kelinci, false)
        )
        listBinatang.add(
            Binatang("Kepiting", "Kepiting Laut", R.drawable.kepiting, true)
        )
        listBinatang.add(
            Binatang("Kuda", "Kuda suka makan rumput", R.drawable.kuda, false)
        )
        listBinatang.add(
            Binatang("Rusa", "Rusa Rumah", R.drawable.rusa, false)
        )
        listBinatang.add(
            Binatang("Zebra", "Zebra Cross", R.drawable.zebra, false)
        )

        adapter = AdapterBinatang(this, listBinatang)
        lvBinatang.adapter = adapter
    }

    inner class AdapterBinatang : BaseAdapter {
        var listBinatang = ArrayList<Binatang>()
        var context: Context? = null

        constructor(context: Context, listOfAnimals: ArrayList<Binatang>) : super() {
            this.listBinatang = listOfAnimals
            this.context = context
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val binatang = listBinatang[position]
            if (binatang.binatangBuas == true) {
                var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as
                        LayoutInflater
                var myView = inflator.inflate(R.layout.item_list_binatang_buas, null)
                myView.nm1.text = binatang.nama!!
                myView.des1.text = binatang.deskripsi!!
                myView.img1.setImageResource(binatang.gambar!!)
                myView.img1.setOnClickListener {
                    val intent = Intent(context, DetailBinatang::class.java)
                    intent.putExtra("nama", binatang.nama!!)
                    intent.putExtra("deskripsi", binatang.deskripsi!!)
                    intent.putExtra("gambar", binatang.gambar!!)
                    context!!.startActivity(intent)
                }
                return myView
            } else {
                var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as
                        LayoutInflater
                var myView = inflator.inflate(R.layout.item_list_binatang, null)
                myView.nm2.text = binatang.nama!!
                myView.des2.text = binatang.deskripsi!!
                myView.img2.setImageResource(binatang.gambar!!)
                myView.img2.setOnClickListener {
                    val intent = Intent(context, DetailBinatang::class.java)
                    intent.putExtra("nama", binatang.nama!!)
                    intent.putExtra("deskripsi", binatang.deskripsi!!)
                    intent.putExtra("gambar", binatang.gambar!!)
                    context!!.startActivity(intent)
                }
                return myView
            }
        }

        override fun getItem(position: Int): Any {
            return listBinatang[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listBinatang.size
        }
    }
}
