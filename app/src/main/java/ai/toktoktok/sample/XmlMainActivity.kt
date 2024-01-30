package ai.toktoktok.sample

import ai.toktoktok.sdk.TokTokTok
import ai.toktoktok.sdk.TokTokTokFloatingActionButton
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RelativeLayout

class XmlMainActivity : AppCompatActivity() {
    private lateinit var rlMain: RelativeLayout
    private lateinit var fabTokTokTok: TokTokTokFloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xml_main)

        // find TokTokTokFloatingActionButton in xml.
        fabTokTokTok = findViewById(R.id.fabTokTokTok)

        // init TokTokTok class & show TokTokTokFloatingActionButton.
        TokTokTok.init(this)
        TokTokTok.show(this, fabTokTokTok)
        TokTokTok.setToktoktokListener(object : TokTokTok.TokTokTokListener {
            override fun onContentsClosed() {
                Log.d(XmlMainActivity::class.java.simpleName, "onContentsClosed()")
            }

            override fun onContentsLoaded() {
                Log.d(XmlMainActivity::class.java.simpleName, "onContentsLoaded()")
            }

            override fun onFailedToLoadContents(errorCode: Int, errorMsg: String) {
                Log.d(XmlMainActivity::class.java.simpleName,
                    "onFailedToLoadContents($errorCode, $errorMsg)")
            }

            override fun onContentsStarted() {
                Log.d(XmlMainActivity::class.java.simpleName, "onContentsStarted()")
            }
        })
    }

    override fun onResume() {
        super.onResume()
        TokTokTok.startFabAnimation(this, fabTokTokTok)
    }

    override fun onPause() {
        super.onPause()
        TokTokTok.stopFabAnimation()
    }
}