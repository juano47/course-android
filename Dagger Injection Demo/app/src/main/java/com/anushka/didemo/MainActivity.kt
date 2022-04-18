package com.anushka.didemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var smartPhone: SmartPhone
    //con el cambio hecho en SmartPhoneModule no solo se puede inyectar el smartPhone sino cualquier otra
    //clase que este en el arbol de dependencias de smartPhoneModule
    @Inject
    lateinit var memoryCardModule: MemoryCardModule

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerSmartPhoneComponent.create()
            .inject(this)

        smartPhone.makeACallWithRecording()

       /* val smartPhone = SmartPhone(
            Battery(),
            SIMCard(ServiceProvider()),
            MemoryCard()
        )
            .makeACallWithRecording()*/
    }
}
