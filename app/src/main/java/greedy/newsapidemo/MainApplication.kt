package greedy.newsapidemo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 *
 * MainApplication is fully-qualified name for a subclass of {@link android.app.Application} that
 * the system instantiates before any other class when an app's process starts.
 *
 * This base class which takes care of injecting members into the Android class as well as handling
 * instantiating the proper Hilt components at the right point in the lifecycle.
 *
 * Annotation as @HiltAndroidApp will make the MainApplication class injectable and triggers Hilt's
 * code generation.
 *
 * @author greedy
 * @since  13 Jun 2021
 */
@HiltAndroidApp
class MainApplication : Application()