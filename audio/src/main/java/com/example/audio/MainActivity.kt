package com.example.audio

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    var i=1;
    lateinit var seekbar : SeekBar
    lateinit var mdi:MediaPlayer
    lateinit var runnable:Runnable
    lateinit var handler:Handler
    lateinit var playpause:FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val media:MediaPlayer
        setContentView(R.layout.activity_main)


        val button : Button =findViewById(R.id.play)
        media=MediaPlayer.create(this,R.raw.jgm)
        mdi=media
        seekbar=findViewById(R.id.seekBar)
        handler=Handler(Looper.getMainLooper())
        seekbar()
val PLAYPAUSE: FloatingActionButton =findViewById(R.id.alpha)
        playpause=PLAYPAUSE
        PLAYPAUSE.setOnClickListener{
            toggle(PLAYPAUSE,media)
        }
        button.setOnClickListener{
            media.start()
        }
    }
    private fun toggle(butt : FloatingActionButton,media:MediaPlayer){
        i++;
        if(i%2==0){
            butt.setImageResource(R.drawable.pause)
            media.start();
        }else{
            butt.setImageResource(R.drawable.play)
            media.pause()
        }
    }
    fun seekbar(){
        seekbar.max=mdi.duration
        seekbar.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            /**
             * Notification that the progress level has changed. Clients can use the fromUser parameter
             * to distinguish user-initiated changes from those that occurred programmatically.
             *
             * @param seekBar The SeekBar whose progress has changed
             * @param progress The current progress level. This will be in the range min..max where min
             * and max were set by [ProgressBar.setMin] and
             * [ProgressBar.setMax], respectively. (The default values for
             * min is 0 and max is 100.)
             * @param fromUser True if the progress change was initiated by the user.
             */
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if(fromUser){
                   mdi.seekTo(progress)

                }
            }

            /**
             * Notification that the user has started a touch gesture. Clients may want to use this
             * to disable advancing the seekbar.
             * @param seekBar The SeekBar in which the touch gesture began
             */
            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            /**
             * Notification that the user has finished a touch gesture. Clients may want to use this
             * to re-enable advancing the seekbar.
             * @param seekBar The SeekBar in which the touch gesture began
             */
            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

        Toast.makeText(this,mdi.duration.toString(),Toast.LENGTH_LONG).show()
        runnable=Runnable{
            seekbar.progress=mdi.currentPosition
            findViewById<TextView>(R.id.textView).text=(mdi.currentPosition/1000).toString()
            if(Math.abs(mdi.duration-mdi.currentPosition)<1000){
                findViewById<TextView>(R.id.textView).text="Jai Hind"
                toggle(playpause,mdi)
            }
            handler.postDelayed(runnable,1000)
        }
        handler.postDelayed(runnable,1000)
    }
}