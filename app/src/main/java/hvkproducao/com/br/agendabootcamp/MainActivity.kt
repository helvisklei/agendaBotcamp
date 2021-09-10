package hvkproducao.com.br.agendabootcamp

import android.content.Intent
import android.icu.text.CaseMap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.provider.CalendarContract.CONTENT_URI
import android.provider.CalendarContract.Events.*
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSetEvent = findViewById(R.id.set_event) as Button // uma constante porque o botão não muda
        btnSetEvent.setOnClickListener {

            val intent = Intent(Intent.ACTION_INSERT)
                .setData(CONTENT_URI)
                .putExtra(TITLE, "Bootcamp Dio")
                .putExtra(EVENT_LOCATION, "on line")
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, System.currentTimeMillis()) // pega o inicio do evento o horário
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME,System.currentTimeMillis() + (60*60*1000)) // (60 segundos * 60 minutos * 1000) dá 1 hora

            startActivity(intent)
        }
    }
}