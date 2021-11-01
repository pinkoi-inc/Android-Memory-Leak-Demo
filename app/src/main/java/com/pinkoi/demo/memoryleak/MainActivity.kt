package com.pinkoi.demo.memoryleak

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pinkoi.demo.memoryleak.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding
  var downloadTask: DownloadTask? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    downloadTask = DownloadTask()
    downloadTask?.start()
  }

  class DownloadTask : Thread() {

    override fun run() {
      sleep(60 * 1000)//60 second
    }

  }
}