package com.nothing.database.manager;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.nothing.database.dao.DeviceItemDao;
import com.nothing.database.dao.DeviceItemDao_Impl;
import com.nothing.database.dao.GptItemDao;
import com.nothing.database.dao.GptItemDao_Impl;
import com.nothing.database.dao.OTAFirmwareDao;
import com.nothing.database.dao.OTAFirmwareDao_Impl;
import com.nothing.database.dao.ProfileItemDao;
import com.nothing.database.dao.ProfileItemDao_Impl;
import com.nothing.database.dao.WidgetItemDao;
import com.nothing.database.dao.WidgetItemDao_Impl;
import com.nothing.earbase.control.GptProviderHelper;
import com.nothing.os.device.provider.GptContentProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public final class SmartVoiceDatabase_Impl extends SmartVoiceDatabase {
    private volatile DeviceItemDao _deviceItemDao;
    private volatile GptItemDao _gptItemDao;
    private volatile OTAFirmwareDao _oTAFirmwareDao;
    private volatile ProfileItemDao _profileItemDao;
    private volatile WidgetItemDao _widgetItemDao;

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(final DatabaseConfiguration config) {
        return config.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(new RoomOpenHelper(config, new RoomOpenHelper.Delegate(14) { // from class: com.nothing.database.manager.SmartVoiceDatabase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(final SupportSQLiteDatabase db) {
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(final SupportSQLiteDatabase db) {
                db.execSQL("CREATE TABLE IF NOT EXISTS `ota_firmware_data` (`address` TEXT NOT NULL, `updateStatus` INTEGER NOT NULL, `fileSize` INTEGER, `serverVersion` TEXT NOT NULL, `downloadUrl` TEXT NOT NULL, `filePath` TEXT, `codes` TEXT NOT NULL, `fileMD5` TEXT NOT NULL, PRIMARY KEY(`address`))");
                db.execSQL("CREATE TABLE IF NOT EXISTS `device` (`name` TEXT NOT NULL, `address` TEXT NOT NULL, `connected` INTEGER NOT NULL, `deviceVersion` TEXT, `modelId` TEXT, `sn` TEXT, `tipsShow` INTEGER NOT NULL, `guideShow` INTEGER NOT NULL, `homeTips` INTEGER NOT NULL, `otaTips` TEXT, `smartDialTips` INTEGER NOT NULL, `otaTipsTime` INTEGER NOT NULL, PRIMARY KEY(`address`))");
                db.execSQL("CREATE TABLE IF NOT EXISTS `widget_item` (`widget_app_id` INTEGER NOT NULL, `address` TEXT NOT NULL, `model_id` TEXT NOT NULL, `widget_theme` INTEGER NOT NULL, `widgetType` INTEGER NOT NULL, PRIMARY KEY(`widget_app_id`))");
                db.execSQL("CREATE TABLE IF NOT EXISTS `profile` (`name` TEXT NOT NULL, `address` TEXT NOT NULL, `data` TEXT NOT NULL, `source` INTEGER NOT NULL DEFAULT 0, `id` INTEGER PRIMARY KEY AUTOINCREMENT)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `gpt_device` (`address` TEXT NOT NULL, `chatGpt` INTEGER NOT NULL, `showTips` INTEGER NOT NULL, PRIMARY KEY(`address`))");
                db.execSQL(RoomMasterTable.CREATE_QUERY);
                db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '19dd0486dc121b8cb31d294cd4f86ce4')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(final SupportSQLiteDatabase db) {
                db.execSQL("DROP TABLE IF EXISTS `ota_firmware_data`");
                db.execSQL("DROP TABLE IF EXISTS `device`");
                db.execSQL("DROP TABLE IF EXISTS `widget_item`");
                db.execSQL("DROP TABLE IF EXISTS `profile`");
                db.execSQL("DROP TABLE IF EXISTS `gpt_device`");
                List list = SmartVoiceDatabase_Impl.this.mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onDestructiveMigration(db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onCreate(final SupportSQLiteDatabase db) {
                List list = SmartVoiceDatabase_Impl.this.mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onCreate(db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(final SupportSQLiteDatabase db) {
                SmartVoiceDatabase_Impl.this.mDatabase = db;
                SmartVoiceDatabase_Impl.this.internalInitInvalidationTracker(db);
                List list = SmartVoiceDatabase_Impl.this.mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onOpen(db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPreMigrate(final SupportSQLiteDatabase db) {
                DBUtil.dropFtsSyncTriggers(db);
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public RoomOpenHelper.ValidationResult onValidateSchema(final SupportSQLiteDatabase db) {
                HashMap map = new HashMap(8);
                map.put("address", new TableInfo.Column("address", "TEXT", true, 1, null, 1));
                map.put("updateStatus", new TableInfo.Column("updateStatus", "INTEGER", true, 0, null, 1));
                map.put("fileSize", new TableInfo.Column("fileSize", "INTEGER", false, 0, null, 1));
                map.put("serverVersion", new TableInfo.Column("serverVersion", "TEXT", true, 0, null, 1));
                map.put("downloadUrl", new TableInfo.Column("downloadUrl", "TEXT", true, 0, null, 1));
                map.put("filePath", new TableInfo.Column("filePath", "TEXT", false, 0, null, 1));
                map.put("codes", new TableInfo.Column("codes", "TEXT", true, 0, null, 1));
                map.put("fileMD5", new TableInfo.Column("fileMD5", "TEXT", true, 0, null, 1));
                TableInfo tableInfo = new TableInfo("ota_firmware_data", map, new HashSet(0), new HashSet(0));
                TableInfo tableInfo2 = TableInfo.read(db, "ota_firmware_data");
                if (!tableInfo.equals(tableInfo2)) {
                    return new RoomOpenHelper.ValidationResult(false, "ota_firmware_data(com.nothing.database.entity.OTAFirmware).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
                }
                HashMap map2 = new HashMap(12);
                map2.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, 1));
                map2.put("address", new TableInfo.Column("address", "TEXT", true, 1, null, 1));
                map2.put("connected", new TableInfo.Column("connected", "INTEGER", true, 0, null, 1));
                map2.put("deviceVersion", new TableInfo.Column("deviceVersion", "TEXT", false, 0, null, 1));
                map2.put("modelId", new TableInfo.Column("modelId", "TEXT", false, 0, null, 1));
                map2.put("sn", new TableInfo.Column("sn", "TEXT", false, 0, null, 1));
                map2.put("tipsShow", new TableInfo.Column("tipsShow", "INTEGER", true, 0, null, 1));
                map2.put("guideShow", new TableInfo.Column("guideShow", "INTEGER", true, 0, null, 1));
                map2.put("homeTips", new TableInfo.Column("homeTips", "INTEGER", true, 0, null, 1));
                map2.put("otaTips", new TableInfo.Column("otaTips", "TEXT", false, 0, null, 1));
                map2.put("smartDialTips", new TableInfo.Column("smartDialTips", "INTEGER", true, 0, null, 1));
                map2.put("otaTipsTime", new TableInfo.Column("otaTipsTime", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo3 = new TableInfo("device", map2, new HashSet(0), new HashSet(0));
                TableInfo tableInfo4 = TableInfo.read(db, "device");
                if (!tableInfo3.equals(tableInfo4)) {
                    return new RoomOpenHelper.ValidationResult(false, "device(com.nothing.database.entity.DeviceItem).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfo4);
                }
                HashMap map3 = new HashMap(5);
                map3.put("widget_app_id", new TableInfo.Column("widget_app_id", "INTEGER", true, 1, null, 1));
                map3.put("address", new TableInfo.Column("address", "TEXT", true, 0, null, 1));
                map3.put("model_id", new TableInfo.Column("model_id", "TEXT", true, 0, null, 1));
                map3.put("widget_theme", new TableInfo.Column("widget_theme", "INTEGER", true, 0, null, 1));
                map3.put("widgetType", new TableInfo.Column("widgetType", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo5 = new TableInfo("widget_item", map3, new HashSet(0), new HashSet(0));
                TableInfo tableInfo6 = TableInfo.read(db, "widget_item");
                if (!tableInfo5.equals(tableInfo6)) {
                    return new RoomOpenHelper.ValidationResult(false, "widget_item(com.nothing.database.entity.WidgetItem).\n Expected:\n" + tableInfo5 + "\n Found:\n" + tableInfo6);
                }
                HashMap map4 = new HashMap(5);
                map4.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, 1));
                map4.put("address", new TableInfo.Column("address", "TEXT", true, 0, null, 1));
                map4.put("data", new TableInfo.Column("data", "TEXT", true, 0, null, 1));
                map4.put("source", new TableInfo.Column("source", "INTEGER", true, 0, "0", 1));
                map4.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, 1));
                TableInfo tableInfo7 = new TableInfo("profile", map4, new HashSet(0), new HashSet(0));
                TableInfo tableInfo8 = TableInfo.read(db, "profile");
                if (!tableInfo7.equals(tableInfo8)) {
                    return new RoomOpenHelper.ValidationResult(false, "profile(com.nothing.database.entity.ProfileItem).\n Expected:\n" + tableInfo7 + "\n Found:\n" + tableInfo8);
                }
                HashMap map5 = new HashMap(3);
                map5.put("address", new TableInfo.Column("address", "TEXT", true, 1, null, 1));
                map5.put(GptProviderHelper.CHATGPT, new TableInfo.Column(GptProviderHelper.CHATGPT, "INTEGER", true, 0, null, 1));
                map5.put(GptProviderHelper.SHOWTIPS, new TableInfo.Column(GptProviderHelper.SHOWTIPS, "INTEGER", true, 0, null, 1));
                TableInfo tableInfo9 = new TableInfo(GptContentProvider.TABLE_NAME, map5, new HashSet(0), new HashSet(0));
                TableInfo tableInfo10 = TableInfo.read(db, GptContentProvider.TABLE_NAME);
                if (!tableInfo9.equals(tableInfo10)) {
                    return new RoomOpenHelper.ValidationResult(false, "gpt_device(com.nothing.database.entity.GptItem).\n Expected:\n" + tableInfo9 + "\n Found:\n" + tableInfo10);
                }
                return new RoomOpenHelper.ValidationResult(true, null);
            }
        }, "19dd0486dc121b8cb31d294cd4f86ce4", "699d7ea24066bce03175e87aa57ab7dc")).build());
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "ota_firmware_data", "device", "widget_item", "profile", GptContentProvider.TABLE_NAME);
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `ota_firmware_data`");
            writableDatabase.execSQL("DELETE FROM `device`");
            writableDatabase.execSQL("DELETE FROM `widget_item`");
            writableDatabase.execSQL("DELETE FROM `profile`");
            writableDatabase.execSQL("DELETE FROM `gpt_device`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap map = new HashMap();
        map.put(OTAFirmwareDao.class, OTAFirmwareDao_Impl.getRequiredConverters());
        map.put(DeviceItemDao.class, DeviceItemDao_Impl.getRequiredConverters());
        map.put(GptItemDao.class, GptItemDao_Impl.getRequiredConverters());
        map.put(WidgetItemDao.class, WidgetItemDao_Impl.getRequiredConverters());
        map.put(ProfileItemDao.class, ProfileItemDao_Impl.getRequiredConverters());
        return map;
    }

    @Override // androidx.room.RoomDatabase
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> getAutoMigrations(final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
        return new ArrayList();
    }

    @Override // com.nothing.database.manager.SmartVoiceDatabase
    public OTAFirmwareDao getOTAFirmwareDao() {
        OTAFirmwareDao oTAFirmwareDao;
        if (this._oTAFirmwareDao != null) {
            return this._oTAFirmwareDao;
        }
        synchronized (this) {
            if (this._oTAFirmwareDao == null) {
                this._oTAFirmwareDao = new OTAFirmwareDao_Impl(this);
            }
            oTAFirmwareDao = this._oTAFirmwareDao;
        }
        return oTAFirmwareDao;
    }

    @Override // com.nothing.database.manager.SmartVoiceDatabase
    public DeviceItemDao getDeviceItemDao() {
        DeviceItemDao deviceItemDao;
        if (this._deviceItemDao != null) {
            return this._deviceItemDao;
        }
        synchronized (this) {
            if (this._deviceItemDao == null) {
                this._deviceItemDao = new DeviceItemDao_Impl(this);
            }
            deviceItemDao = this._deviceItemDao;
        }
        return deviceItemDao;
    }

    @Override // com.nothing.database.manager.SmartVoiceDatabase
    public GptItemDao getGptItemDao() {
        GptItemDao gptItemDao;
        if (this._gptItemDao != null) {
            return this._gptItemDao;
        }
        synchronized (this) {
            if (this._gptItemDao == null) {
                this._gptItemDao = new GptItemDao_Impl(this);
            }
            gptItemDao = this._gptItemDao;
        }
        return gptItemDao;
    }

    @Override // com.nothing.database.manager.SmartVoiceDatabase
    public WidgetItemDao getWidgetItemDao() {
        WidgetItemDao widgetItemDao;
        if (this._widgetItemDao != null) {
            return this._widgetItemDao;
        }
        synchronized (this) {
            if (this._widgetItemDao == null) {
                this._widgetItemDao = new WidgetItemDao_Impl(this);
            }
            widgetItemDao = this._widgetItemDao;
        }
        return widgetItemDao;
    }

    @Override // com.nothing.database.manager.SmartVoiceDatabase
    public ProfileItemDao getProfileDao() {
        ProfileItemDao profileItemDao;
        if (this._profileItemDao != null) {
            return this._profileItemDao;
        }
        synchronized (this) {
            if (this._profileItemDao == null) {
                this._profileItemDao = new ProfileItemDao_Impl(this);
            }
            profileItemDao = this._profileItemDao;
        }
        return profileItemDao;
    }
}
