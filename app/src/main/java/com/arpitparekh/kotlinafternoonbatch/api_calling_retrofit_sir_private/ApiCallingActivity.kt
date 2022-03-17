package com.arpitparekh.kotlinafternoonbatch.api_calling_retrofit_sir_private

import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import com.arpitparekh.kotlinafternoonbatch.R
import com.arpitparekh.kotlinafternoonbatch.databinding.ActivityApiCallingBinding
import com.arpitparekh.kotlinafternoonbatch.databinding.AddNotesBinding
import com.arpitparekh.kotlinafternoonbatch.databinding.ProgressDialogBinding
import com.arpitparekh.kotlinafternoonbatch.databinding.ShowNoteDataBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiCallingActivity : AppCompatActivity() {

    lateinit var binding : ActivityApiCallingBinding
    lateinit var addBinding : AddNotesBinding
    lateinit var showBinding: ShowNoteDataBinding
    lateinit var dialogBinding : ProgressDialogBinding
    lateinit var api : ApiCall

    lateinit var list : List<Note>
    lateinit var adapter: ArrayAdapter<Note>
    lateinit var dialog : Dialog



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApiCallingBinding.inflate(layoutInflater)
        dialogBinding = ProgressDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dialog = Dialog(this)
        dialog.setContentView(dialogBinding.root)

        list = ArrayList()
        api = ApiAssistance.getInstance()

        setAdapter()
        showNotes()

        binding.listViewApiCalling.setOnItemClickListener(AdapterView.OnItemClickListener { adapterView, view, pos, l ->

            showBinding = ShowNoteDataBinding.inflate(layoutInflater)

            val note = list[pos]

            Log.i("per",note.toString())

            showBinding.`object` = note

            showBinding.noteId.isEnabled = false
            showBinding.noteCreate.isEnabled = false
            showBinding.noteUpdate.isEnabled = false



            AlertDialog.Builder(this)
                .setView(showBinding.root)
                .setPositiveButton("Update", DialogInterface.OnClickListener { dialogInterface, i ->
                    // update

                    updateNotes(note.id!!,showBinding.noteBody.text.toString())

                })
                .setNegativeButton("Delete", DialogInterface.OnClickListener { dialogInterface, i ->

                    // delete
                    AlertDialog.Builder(this)
                        .setPositiveButton("Yes", DialogInterface.OnClickListener { dialogInterface, i ->
                            deleteNotes(note.id!!)
                            showNotes()

                        })
                        .setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, i ->

                            dialogInterface.dismiss()
                        }).create().show()


                }).create().show()

        })

    }

    private fun deleteNotes(id: Int) {
            val call = api.deleteNote(id)
            call.enqueue(object : Callback<Note>{
                override fun onResponse(call: Call<Note>, response: Response<Note>) {
                    Log.i("note",response.body().toString())
                }

                override fun onFailure(call: Call<Note>, t: Throwable) {
                    Log.i("note",t.toString())
                }


            })
    }

    private fun updateNotes(id: Int, body: String) {

        val call = api.updateNote(id,body)

        call.enqueue(object : Callback<Note>{
            override fun onResponse(call: Call<Note>, response: Response<Note>) {
                Log.i("note",response.body().toString())

                showNotes()

            }

            override fun onFailure(call: Call<Note>, t: Throwable) {
                Log.i("note",t.toString())
            }


        })
    }

    private fun showNotes() {


        val call = api.getAllNotes()

        call.enqueue(object : Callback<List<Note>>{
            override fun onResponse(call: Call<List<Note>>, response: Response<List<Note>>) {

                list = response.body()!!

                setAdapter()

                dialog.dismiss()
            }

            override fun onFailure(call: Call<List<Note>>, t: Throwable) {
               Log.i("note",t.toString())
            }


        })

    }

    private fun setAdapter() {
        adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,list)
        binding.listViewApiCalling.adapter= adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add_notes,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        addBinding = AddNotesBinding.inflate(layoutInflater)

        if(item.itemId==R.id.action_add){

            dialog.show()

            AlertDialog.Builder(this)
                .setView(addBinding.root)
                .setPositiveButton("Add", DialogInterface.OnClickListener { dialogInterface, i ->

                    val note = addBinding.edtAddNote.text.toString()

                    addNote(note)

                    showNotes()

                }).create().show()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun addNote(note: String) {

        val call = api.createNote(note)

        call.enqueue(object : Callback<Note>{
            override fun onResponse(call: Call<Note>, response: Response<Note>) {

                Log.i("note",response.body().toString())

            }

            override fun onFailure(call: Call<Note>, t: Throwable) {
                Log.i("note",t.toString())
            }


        })

    }
}