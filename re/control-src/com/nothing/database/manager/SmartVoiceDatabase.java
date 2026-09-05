package com.nothing.database.manager;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.nothing.database.dao.DeviceItemDao;
import com.nothing.database.dao.GptItemDao;
import com.nothing.database.dao.OTAFirmwareDao;
import com.nothing.database.dao.ProfileItemDao;
import com.nothing.database.dao.WidgetItemDao;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: SmartVoiceDatabase.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&\u00a8\u0006\u000f"}, d2 = {"Lcom/nothing/database/manager/SmartVoiceDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "getOTAFirmwareDao", "Lcom/nothing/database/dao/OTAFirmwareDao;", "getDeviceItemDao", "Lcom/nothing/database/dao/DeviceItemDao;", "getGptItemDao", "Lcom/nothing/database/dao/GptItemDao;", "getWidgetItemDao", "Lcom/nothing/database/dao/WidgetItemDao;", "getProfileDao", "Lcom/nothing/database/dao/ProfileItemDao;", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class SmartVoiceDatabase extends RoomDatabase {
    private static final String ADDRESS_SQLITE = "`address` TEXT NOT NULL, ";
    private static final String ADD_TIPS_SQLITE = "ALTER TABLE device ADD COLUMN tipsShow INTEGER NOT NULL DEFAULT 0";
    private static final String ADD_WIDGET_TYPE_SQLITE = "ALTER TABLE widget_item ADD COLUMN widgetType INTEGER NOT NULL DEFAULT 0";
    private static final int EIGHT = 8;
    private static final int ELEVEN = 11;
    private static final int FIVE = 5;
    private static final int FOUR = 4;
    private static final int FOURTEEN = 14;
    private static SmartVoiceDatabase INSTANCE = null;
    private static final int NINE = 9;
    private static final String SELECT_FROM_DEVICE = "select * from device";
    private static final int SEVEN = 7;
    private static final int SIX = 6;
    private static final int TEN = 10;
    private static final int THIRTEEN = 13;
    private static final int THREE = 3;
    private static final int TWELVE = 12;
    private static final int TWO = 2;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Migration MIGRATION_13_14 = new Migration() { // from class: com.nothing.database.manager.SmartVoiceDatabase$Companion$MIGRATION_13_14$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("ALTER TABLE profile ADD COLUMN source INTEGER NOT NULL DEFAULT 0");
        }
    };
    private static final Migration MIGRATION_12_13 = new Migration() { // from class: com.nothing.database.manager.SmartVoiceDatabase$Companion$MIGRATION_12_13$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            if (db.query("select * from device").getColumnIndex("otaTipsTime") == -1) {
                db.execSQL("ALTER TABLE device ADD COLUMN otaTipsTime INTEGER NOT NULL DEFAULT 0");
            }
        }
    };
    private static final Migration MIGRATION_11_12 = new Migration() { // from class: com.nothing.database.manager.SmartVoiceDatabase$Companion$MIGRATION_11_12$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            if (db.query("select * from device").getColumnIndex("smartDialTips") == -1) {
                db.execSQL("ALTER TABLE device ADD COLUMN smartDialTips INTEGER NOT NULL DEFAULT 0");
            }
        }
    };
    private static final Migration MIGRATION_10_11 = new Migration() { // from class: com.nothing.database.manager.SmartVoiceDatabase$Companion$MIGRATION_10_11$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("CREATE TABLE IF NOT EXISTS `gpt_device` (`address` TEXT NOT NULL, `chatGpt` INTEGER NOT NULL , `showTips` INTEGER NOT NULL, PRIMARY KEY(`address`))");
        }
    };
    private static final Migration MIGRATION_9_10 = new Migration() { // from class: com.nothing.database.manager.SmartVoiceDatabase$Companion$MIGRATION_9_10$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            if (db.query("select * from device").getColumnIndex("otaTips") == -1) {
                db.execSQL("ALTER TABLE device ADD COLUMN otaTips TEXT");
            }
        }
    };
    private static final Migration MIGRATION_8_9 = new Migration() { // from class: com.nothing.database.manager.SmartVoiceDatabase$Companion$MIGRATION_8_9$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            if (db.query("select * from device").getColumnIndex("homeTips") == -1) {
                db.execSQL("ALTER TABLE device ADD COLUMN homeTips INTEGER NOT NULL DEFAULT 0");
            }
        }
    };
    private static final Migration MIGRATION_7_8 = new Migration() { // from class: com.nothing.database.manager.SmartVoiceDatabase$Companion$MIGRATION_7_8$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("DROP TABLE IF EXISTS profile_name");
            db.execSQL("CREATE TABLE IF NOT EXISTS `profile` (`name` TEXT NOT NULL,`address` TEXT NOT NULL, `data` TEXT NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT)");
            if (db.query("select * from device").getColumnIndex("guideShow") == -1) {
                db.execSQL("ALTER TABLE device ADD COLUMN guideShow INTEGER NOT NULL DEFAULT 0");
            }
        }
    };
    private static final Migration MIGRATION_6_7 = new Migration() { // from class: com.nothing.database.manager.SmartVoiceDatabase$Companion$MIGRATION_6_7$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("CREATE TABLE IF NOT EXISTS `profile_name` (`id` INTEGER NOT NULL, `address` TEXT NOT NULL, `profileName` TEXT NOT NULL, `index` INTEGER NOT NULL, PRIMARY KEY(`id`))");
            if (db.query("select * from widget_item").getColumnIndex("widgetType") == -1) {
                db.execSQL("ALTER TABLE widget_item ADD COLUMN widgetType INTEGER NOT NULL DEFAULT 0");
            }
            if (db.query("select * from device").getColumnIndex("tipsShow") == -1) {
                db.execSQL("ALTER TABLE device ADD COLUMN tipsShow INTEGER NOT NULL DEFAULT 0");
            }
        }
    };
    private static final Migration MIGRATION_5_6_1 = new Migration() { // from class: com.nothing.database.manager.SmartVoiceDatabase$Companion$MIGRATION_5_6_1$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            if (db.query("select * from widget_item").getColumnIndex("widgetType") == -1) {
                db.execSQL("ALTER TABLE widget_item ADD COLUMN widgetType INTEGER NOT NULL DEFAULT 0");
            }
            if (db.query("select * from device").getColumnIndex("tipsShow") == -1) {
                db.execSQL("ALTER TABLE device ADD COLUMN tipsShow INTEGER NOT NULL DEFAULT 0");
            }
        }
    };
    private static final Migration MIGRATION_5_6 = new Migration() { // from class: com.nothing.database.manager.SmartVoiceDatabase$Companion$MIGRATION_5_6$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("ALTER TABLE widget_item ADD COLUMN widgetType INTEGER NOT NULL DEFAULT 0");
        }
    };
    private static final Migration MIGRATION_4_5 = new Migration() { // from class: com.nothing.database.manager.SmartVoiceDatabase$Companion$MIGRATION_4_5$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("ALTER TABLE device ADD COLUMN tipsShow INTEGER NOT NULL DEFAULT 0");
        }
    };
    private static final Migration MIGRATION_3_4 = new Migration() { // from class: com.nothing.database.manager.SmartVoiceDatabase$Companion$MIGRATION_3_4$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("CREATE TABLE IF NOT EXISTS `temp_device` (`name` TEXT NOT NULL, `address` TEXT NOT NULL, `connected` INTEGER NOT NULL, `deviceVersion` TEXT, `modelId` TEXT, `sn` TEXT, PRIMARY KEY(`address`))");
            db.execSQL("CREATE TABLE IF NOT EXISTS `temp_firmware` (`address` TEXT NOT NULL, `updateStatus` INTEGER NOT NULL, `fileSize` INTEGER, `serverVersion` TEXT NOT NULL, `downloadUrl` TEXT NOT NULL, `filePath` TEXT, `codes` TEXT NOT NULL, `fileMD5` TEXT NOT NULL, PRIMARY KEY(`address`))");
            db.execSQL("CREATE TABLE IF NOT EXISTS `temp_widget` (`widget_app_id` INTEGER NOT NULL, `address` TEXT NOT NULL, `model_id` TEXT NOT NULL, `widget_theme` INTEGER NOT NULL, PRIMARY KEY(`widget_app_id`))");
            db.execSQL("INSERT INTO 'temp_device' (name,address,connected,deviceVersion,modelId)SELECT name,address,connected,deviceVersion,modelId FROM device");
            db.execSQL("INSERT INTO 'temp_firmware' (updateStatus,fileSize,serverVersion,downloadUrl,filePath,codes,fileMD5,address)SELECT updateStatus,fileSize,serverVersion,downloadUrl,filePath,codes,fileMD5,address FROM ota_firmware_data");
            db.execSQL("INSERT INTO 'temp_widget' (widget_app_id,address,model_id,widget_theme)SELECT widget_app_id,address,model_id,widget_theme FROM widget_item");
            db.execSQL("DROP TABLE device");
            db.execSQL("DROP TABLE ota_firmware_data");
            db.execSQL("DROP TABLE widget_item");
            db.execSQL("ALTER TABLE temp_device RENAME TO device");
            db.execSQL("ALTER TABLE temp_firmware RENAME TO ota_firmware_data");
            db.execSQL("ALTER TABLE temp_widget RENAME TO widget_item");
        }
    };
    private static final Migration MIGRATION_2_3 = new Migration() { // from class: com.nothing.database.manager.SmartVoiceDatabase$Companion$MIGRATION_2_3$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("CREATE TABLE 'temp_widget_item' ('widget_app_id' INTEGER PRIMARY KEY NOT NULL DEFAULT 0,'address' TEXT NOT NULL,'model_id' TEXT NOT NULL,'widget_theme' INTEGER NOT NULL DEFAULT 0)");
            db.execSQL("INSERT INTO 'temp_widget_item' (widget_app_id,address,model_id,widget_theme)SELECT widget_app_id,address,model_id,widget_id FROM widget_item");
            db.execSQL("DROP TABLE widget_item");
            db.execSQL("ALTER TABLE temp_widget_item RENAME TO widget_item");
        }
    };

    public abstract DeviceItemDao getDeviceItemDao();

    public abstract GptItemDao getGptItemDao();

    public abstract OTAFirmwareDao getOTAFirmwareDao();

    public abstract ProfileItemDao getProfileDao();

    public abstract WidgetItemDao getWidgetItemDao();

    /* JADX INFO: compiled from: SmartVoiceDatabase.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u0082T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/nothing/database/manager/SmartVoiceDatabase$Companion;", "", "<init>", "()V", "INSTANCE", "Lcom/nothing/database/manager/SmartVoiceDatabase;", "TWO", "", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "ELEVEN", "TWELVE", "THIRTEEN", "FOURTEEN", "SELECT_FROM_DEVICE", "", "ADDRESS_SQLITE", "ADD_TIPS_SQLITE", "ADD_WIDGET_TYPE_SQLITE", "getInstance", "context", "Landroid/content/Context;", "MIGRATION_13_14", "Landroidx/room/migration/Migration;", "getMIGRATION_13_14", "()Landroidx/room/migration/Migration;", "MIGRATION_12_13", "MIGRATION_11_12", "MIGRATION_10_11", "MIGRATION_9_10", "MIGRATION_8_9", "MIGRATION_7_8", "MIGRATION_6_7", "MIGRATION_5_6_1", "MIGRATION_5_6", "MIGRATION_4_5", "MIGRATION_3_4", "MIGRATION_2_3", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SmartVoiceDatabase getInstance(Context context) {
            SmartVoiceDatabase smartVoiceDatabase;
            Intrinsics.checkNotNullParameter(context, "context");
            synchronized (Reflection.getOrCreateKotlinClass(SmartVoiceDatabase.class)) {
                smartVoiceDatabase = SmartVoiceDatabase.INSTANCE;
                if (smartVoiceDatabase == null) {
                    Context applicationContext = context.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                    RoomDatabase roomDatabaseBuild = Room.databaseBuilder(applicationContext, SmartVoiceDatabase.class, "smartVoice").allowMainThreadQueries().addMigrations(SmartVoiceDatabase.MIGRATION_2_3).addMigrations(SmartVoiceDatabase.MIGRATION_3_4).addMigrations(SmartVoiceDatabase.MIGRATION_4_5).addMigrations(SmartVoiceDatabase.MIGRATION_5_6).addMigrations(SmartVoiceDatabase.MIGRATION_5_6_1).addMigrations(SmartVoiceDatabase.MIGRATION_6_7).addMigrations(SmartVoiceDatabase.MIGRATION_7_8).addMigrations(SmartVoiceDatabase.MIGRATION_8_9).addMigrations(SmartVoiceDatabase.MIGRATION_9_10).addMigrations(SmartVoiceDatabase.MIGRATION_10_11).addMigrations(SmartVoiceDatabase.MIGRATION_11_12).addMigrations(SmartVoiceDatabase.MIGRATION_12_13).addMigrations(SmartVoiceDatabase.INSTANCE.getMIGRATION_13_14()).fallbackToDestructiveMigration().build();
                    Companion companion = SmartVoiceDatabase.INSTANCE;
                    SmartVoiceDatabase.INSTANCE = (SmartVoiceDatabase) roomDatabaseBuild;
                    smartVoiceDatabase = (SmartVoiceDatabase) roomDatabaseBuild;
                }
            }
            return smartVoiceDatabase;
        }

        public final Migration getMIGRATION_13_14() {
            return SmartVoiceDatabase.MIGRATION_13_14;
        }
    }
}
