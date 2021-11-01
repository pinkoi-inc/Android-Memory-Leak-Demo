package com.pinkoi.demo.memoryleak

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pinkoi.demo.memoryleak.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding
  var downloadTask: DownloadTask? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    downloadTask = DownloadTask(this)
    downloadTask?.start()
  }

  class DownloadTask(val holdActivity: Activity) : Thread() {

    var toast: Toast? = null
    override fun run() {
      sleep(30 * 1000)//30 second
      holdActivity.runOnUiThread {
        toast = Toast.makeText(holdActivity, "download finish", Toast.LENGTH_SHORT)
        toast?.show()
      }
    }

  }
}