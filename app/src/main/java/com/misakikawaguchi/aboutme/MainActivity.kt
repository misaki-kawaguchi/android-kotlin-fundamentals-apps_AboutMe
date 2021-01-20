package com.misakikawaguchi.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ボタンを押す
        findViewById<Button>(R.id.done_button).setOnClickListener {
            addNickname(it)
        }

        // 名前を表示した箇所をクリックする
        findViewById<TextView>(R.id.nickname_text).setOnClickListener {
            updateNickName(it)
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

        // キーボードを隠す
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    // 名前を編集する処理
    private fun updateNickName(view: View) {
        // 名前を入力する箇所
        val editText = findViewById<EditText>(R.id.nickname_edit)
        // ボタン
        val doneButton = findViewById<Button>(R.id.done_button)

        // 名前を入力した箇所は見えるようにする
        editText.visibility = View.VISIBLE
        // ボタンを見えるようにする
        doneButton.visibility = View.VISIBLE
        // 表示したテキストは見えないようにする
        view.visibility = View.GONE

        // フォーカスを設定
        editText.requestFocus()
    }
}