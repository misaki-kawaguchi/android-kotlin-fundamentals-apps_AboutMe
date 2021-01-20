package com.misakikawaguchi.aboutme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ボタンを押す
        findViewById<Button>(R.id.done_button).setOnClickListener {
            addNickname(it)
        }
    }


    // ボタンを押した時の処理
    private fun addNickname(view: View) {
        // 名前を入力する箇所
        val editText = findViewById<EditText>(R.id.nickname_edit)
        // 名前を表示する箇所
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)

        // 名前を入力したテキストを名前を表示する箇所に代入する
        nicknameTextView.text = editText.text

        // 名前を入力した箇所は見えなくする
        editText.visibility = View.GONE
        // ボタンを見えなくする
        view.visibility = View.GONE
        // 名前を表示する箇所を見せる
        nicknameTextView.visibility = View.VISIBLE
    }


}