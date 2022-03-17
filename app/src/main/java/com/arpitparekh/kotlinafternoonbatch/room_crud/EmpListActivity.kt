package com.arpitparekh.kotlinafternoonbatch.room_crud

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import com.arpitparekh.kotlinafternoonbatch.databinding.ActivityEmpListBinding
import com.arpitparekh.kotlinafternoonbatch.databinding.EmpUpdateDialogBinding

class EmpListActivity : AppCompatActivity() {

    lateinit var binding : ActivityEmpListBinding
    lateinit var binding1 : EmpUpdateDialogBinding
    lateinit var dao : EmpDao
    lateinit var list : List<Emp>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmpListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dao = UtilityHelper.getInstance(this).getDao()
        list = ArrayList<Emp>()

        showData()

        binding.btnSubmit.setOnClickListener {

            val name = binding.edtNameEmpRoom.text.toString()
            val email = binding.edtEmailRoom.text.toString()

            val e = Emp(name,email)

            dao.insertData(e)

            showData()

        }

        binding.listView.setOnItemClickListener { adapterView, view, position, l ->

            binding1 = EmpUpdateDialogBinding.inflate(layoutInflater)

            val e1 : Emp = list[position]  // primary key

            binding1.edtNameEmpRoom.setText(e1.name)
            binding1.edtEmailRoom.setText(e1.email)

            AlertDialog.Builder(this)
                .setTitle("Select One")
                .setMessage("Choose Truth or Dare")
                .setPositiveButton("Truth", DialogInterface.OnClickListener { dialogInterface, i ->

                    // update

                    AlertDialog.Builder(this)
                        .setTitle("Truth shall let u free")
                        .setView(binding1.root)
                        .setPositiveButton("Suffer", DialogInterface.OnClickListener { dialogInterface, i ->


                            e1.name = binding1.edtNameEmpRoom.text.toString()
                            e1.email = binding1.edtEmailRoom.text.toString()

                            dao.updateData(e1)

                            showData()

                        }).create().show()


                }).setNegativeButton("Dare", DialogInterface.OnClickListener { dialogInterface, i ->

                    // delete

                    dao.deleteData(e1)
                    showData()

                }).create().show()

        }
    }

    private fun showData() {

        list = dao.fetchData()
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,list)
        binding.listView.adapter =adapter

    }
}