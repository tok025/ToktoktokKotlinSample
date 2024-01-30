package ai.toktoktok.sample

import ai.toktoktok.sdk.TokTokTok
import ai.toktoktok.sdk.TokTokTokFloatingActionButton
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.RelativeLayout

class ProgrammaticMainActivity : AppCompatActivity() {
    private lateinit var rlMain: RelativeLayout
    private lateinit var fabTokTokTok: TokTokTokFloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_programmatic_main)

        rlMain = findViewById(R.id.rlMain)
        fabTokTokTok = TokTokTokFloatingActionButton(this)
        val layoutParams = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutParams.setMargins(48, 48, 48, 48)
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT)
        rlMain.addView(fabTokTokTok, layoutParams)

        TokTokTok.init(this)
        TokTokTok.show(this, fabTokTokTok)
        TokTokTok.setToktoktokListener(object : TokTokTok.TokTokTokListener {
            override fun onContentsClosed() {
                Log.d(ProgrammaticMainActivity::class.java.simpleName, "onContentsClosed()")
            }
            override fun onContentsLoaded() {
                Log.d(ProgrammaticMainActivity::class.java.simpleName, "onContentsLoaded()")
            }
            override fun onFailedToLoadContents(errorCode: Int, errorMsg: String) {
                Log.d(ProgrammaticMainActivity::class.java.simpleName,
                    "onFailedToLoadContents($errorCode, $errorMsg)")
            }
            override fun onContentsStarted() {
                Log.d(ProgrammaticMainActivity::class.java.simpleName, "onContentsStarted()")
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