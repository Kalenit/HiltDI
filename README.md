# HiltDI


/**
 * 
 * Steps for Hilt 
 * 1 Project level gradle 
 *     // Add the Kotlin Android plugin
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.hilt) apply false
 * 
 * 2 Module level gradle 
 * 
    // Apply the KSP plugin

    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
 * 
 * 
 * 3 Add dependency
 * 
 *   implementation(libs.hilt)
    ksp(libs.hilt.compiler) // Use `ksp` instead of `kapt`
    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.3.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    
    4 libs.version
   
   hilt = "2.59.2"
	ksp = "2.3.5"

[libraries]
	hilt = { group = "com.google.dagger", name = "hilt-android", version.ref = "hilt" }
	hilt-compiler = { group = "com.google.dagger", name = "hilt-android-compiler", version.ref = "hilt" }

[plugins]
	hilt = { id = "com.google.dagger.hilt.android", version.ref = "hilt" }
	ksp = { id = "com.google.devtools.ksp", version.ref = "ksp" }
 */ 
 // containers = modules (central place where we return instance of class )
 
 Step 4:
 Create classes that needs to supplied use @Inject constructor 
 example 
 
 @Singleton
class DieselEngine @Inject constructor(): Engine {
    override fun start()= "Engine has started"
}

Step 5: Create @module
example
@Module // creates a container to return instances of class
@InstallIn(SingletonComponent::class)
object EngineModule {


    @Provides
    @Singleton
    fun provideEngine(): Engine = DieselEngine()

}

Step 6: 
@HiltViewModel
class CarViewModel @Inject constructor(
    private val engine: Engine
): ViewModel() {

Step 7:
 val carViewModel: CarViewModel = hiltViewModel()

Step 8:
Configure Hilt 
	8.1 
		@AndroidEntryPoint
		class MainActivity
	8.2 
    @HiltAndroidApp
	class CarApp: Application() {
	}

	8.3 Register application name in manifest
    <application
        android:name=".CarApp"
 
 
