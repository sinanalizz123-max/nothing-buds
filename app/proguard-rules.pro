# Nothing Buds release keeps. R8 full mode is on; the Kyant backdrop library
# ships its own consumer rules, so only app-side dynamic entry points go here.

# Foreground service, receivers and QS tile are referenced from AndroidManifest.
-keep public class com.nothingbuds.service.BudsService
-keep public class com.nothingbuds.service.BootReceiver
-keep public class com.nothingbuds.service.BluetoothConnectionReceiver
-keep public class com.nothingbuds.service.BudsCompanionService
-keep public class com.nothingbuds.qs.AncTileService

# Companion-device association callbacks referenced by the framework.
-keep public class com.nothingbuds.data.CompanionPairing { *; }

# Inner classes accessed across boundaries (Binder, receivers).
-keepattributes InnerClasses, EnclosingMethod
