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
import com.nothing.caseble.NothingCaseParser;
import com.nothing.database.old.DeviceDao;
import com.nothing.database.old.DeviceDao_Impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public final class SmartDatabase_Impl extends SmartDatabase {
    private volatile DeviceDao _deviceDao;

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(final DatabaseConfiguration config) {
        return config.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(new RoomOpenHelper(config, new RoomOpenHelper.Delegate(9) { // from class: com.nothing.database.manager.SmartDatabase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(final SupportSQLiteDatabase db) {
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(final SupportSQLiteDatabase db) {
                db.execSQL("CREATE TABLE IF NOT EXISTS `device` (`name` TEXT NOT NULL, `address` TEXT NOT NULL, `color_type` INTEGER NOT NULL, `device_type` INTEGER NOT NULL, `rank` INTEGER NOT NULL, `date` INTEGER NOT NULL, `delete` INTEGER NOT NULL, `connected` INTEGER NOT NULL, `deviceVersion` TEXT NOT NULL, PRIMARY KEY(`address`))");
                db.execSQL("CREATE TABLE IF NOT EXISTS `ota_breakpoint_resume` (`address` TEXT NOT NULL, `file_md5` TEXT NOT NULL, `codes` TEXT NOT NULL, PRIMARY KEY(`address`))");
                db.execSQL("CREATE TABLE IF NOT EXISTS `ota_breakpoint_down` (`address` TEXT NOT NULL, `savePath` TEXT NOT NULL, `downloadVersion` TEXT NOT NULL, `fileSize` INTEGER NOT NULL, `downloadSize` INTEGER NOT NULL, `isValid` INTEGER NOT NULL, PRIMARY KEY(`address`))");
                db.execSQL("CREATE TABLE IF NOT EXISTS `widgets_id` (`appWidgetId` INTEGER NOT NULL, `address` TEXT NOT NULL, `deviceColor` INTEGER NOT NULL, `widgetTheme` INTEGER NOT NULL, PRIMARY KEY(`appWidgetId`))");
                db.execSQL(RoomMasterTable.CREATE_QUERY);
                db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '2776352bc70e1b1bfabc66da7b6abcba')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(final SupportSQLiteDatabase db) {
                db.execSQL("DROP TABLE IF EXISTS `device`");
                db.execSQL("DROP TABLE IF EXISTS `ota_breakpoint_resume`");
                db.execSQL("DROP TABLE IF EXISTS `ota_breakpoint_down`");
                db.execSQL("DROP TABLE IF EXISTS `widgets_id`");
                List list = SmartDatabase_Impl.this.mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onDestructiveMigration(db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onCreate(final SupportSQLiteDatabase db) {
                List list = SmartDatabase_Impl.this.mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onCreate(db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(final SupportSQLiteDatabase db) {
                SmartDatabase_Impl.this.mDatabase = db;
                SmartDatabase_Impl.this.internalInitInvalidationTracker(db);
                List list = SmartDatabase_Impl.this.mCallbacks;
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
                HashMap map = new HashMap(9);
                map.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, 1));
                map.put("address", new TableInfo.Column("address", "TEXT", true, 1, null, 1));
                map.put("color_type", new TableInfo.Column("color_type", "INTEGER", true, 0, null, 1));
                map.put(NothingCaseParser.KEY_DEVICE_TYPE, new TableInfo.Column(NothingCaseParser.KEY_DEVICE_TYPE, "INTEGER", true, 0, null, 1));
                map.put("rank", new TableInfo.Column("rank", "INTEGER", true, 0, null, 1));
                map.put("date", new TableInfo.Column("date", "INTEGER", true, 0, null, 1));
                map.put("delete", new TableInfo.Column("delete", "INTEGER", true, 0, null, 1));
                map.put("connected", new TableInfo.Column("connected", "INTEGER", true, 0, null, 1));
                map.put("deviceVersion", new TableInfo.Column("deviceVersion", "TEXT", true, 0, null, 1));
                TableInfo tableInfo = new TableInfo("device", map, new HashSet(0), new HashSet(0));
                TableInfo tableInfo2 = TableInfo.read(db, "device");
                if (!tableInfo.equals(tableInfo2)) {
                    return new RoomOpenHelper.ValidationResult(false, "device(com.nothing.database.old.entity.Device).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
                }
                HashMap map2 = new HashMap(3);
                map2.put("address", new TableInfo.Column("address", "TEXT", true, 1, null, 1));
                map2.put("file_md5", new TableInfo.Column("file_md5", "TEXT", true, 0, null, 1));
                map2.put("codes", new TableInfo.Column("codes", "TEXT", true, 0, null, 1));
                TableInfo tableInfo3 = new TableInfo("ota_breakpoint_resume", map2, new HashSet(0), new HashSet(0));
                TableInfo tableInfo4 = TableInfo.read(db, "ota_breakpoint_resume");
                if (!tableInfo3.equals(tableInfo4)) {
                    return new RoomOpenHelper.ValidationResult(false, "ota_breakpoint_resume(com.nothing.database.old.entity.OTABreakpointResume).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfo4);
                }
                HashMap map3 = new HashMap(6);
                map3.put("address", new TableInfo.Column("address", "TEXT", true, 1, null, 1));
                map3.put("savePath", new TableInfo.Column("savePath", "TEXT", true, 0, null, 1));
                map3.put("downloadVersion", new TableInfo.Column("downloadVersion", "TEXT", true, 0, null, 1));
                map3.put("fileSize", new TableInfo.Column("fileSize", "INTEGER", true, 0, null, 1));
                map3.put("downloadSize", new TableInfo.Column("downloadSize", "INTEGER", true, 0, null, 1));
                map3.put("isValid", new TableInfo.Column("isValid", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo5 = new TableInfo("ota_breakpoint_down", map3, new HashSet(0), new HashSet(0));
                TableInfo tableInfo6 = TableInfo.read(db, "ota_breakpoint_down");
                if (!tableInfo5.equals(tableInfo6)) {
                    return new RoomOpenHelper.ValidationResult(false, "ota_breakpoint_down(com.nothing.database.old.entity.OTABreakpointDown).\n Expected:\n" + tableInfo5 + "\n Found:\n" + tableInfo6);
                }
                HashMap map4 = new HashMap(4);
                map4.put("appWidgetId", new TableInfo.Column("appWidgetId", "INTEGER", true, 1, null, 1));
                map4.put("address", new TableInfo.Column("address", "TEXT", true, 0, null, 1));
                map4.put("deviceColor", new TableInfo.Column("deviceColor", "INTEGER", true, 0, null, 1));
                map4.put("widgetTheme", new TableInfo.Column("widgetTheme", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo7 = new TableInfo("widgets_id", map4, new HashSet(0), new HashSet(0));
                TableInfo tableInfo8 = TableInfo.read(db, "widgets_id");
                if (!tableInfo7.equals(tableInfo8)) {
                    return new RoomOpenHelper.ValidationResult(false, "widgets_id(com.nothing.database.old.entity.WidgetsID).\n Expected:\n" + tableInfo7 + "\n Found:\n" + tableInfo8);
                }
                return new RoomOpenHelper.ValidationResult(true, null);
            }
        }, "2776352bc70e1b1bfabc66da7b6abcba", "a072ce9deec12178be837ebd53ae9408")).build());
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "device", "ota_breakpoint_resume", "ota_breakpoint_down", "widgets_id");
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `device`");
            writableDatabase.execSQL("DELETE FROM `ota_breakpoint_resume`");
            writableDatabase.execSQL("DELETE FROM `ota_breakpoint_down`");
            writableDatabase.execSQL("DELETE FROM `widgets_id`");
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
        map.put(DeviceDao.class, DeviceDao_Impl.getRequiredConverters());
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

    @Override // com.nothing.database.manager.SmartDatabase
    public DeviceDao getDeviceDao() {
        DeviceDao deviceDao;
        if (this._deviceDao != null) {
            return this._deviceDao;
        }
        synchronized (this) {
            if (this._deviceDao == null) {
                this._deviceDao = new DeviceDao_Impl(this);
            }
            deviceDao = this._deviceDao;
        }
        return deviceDao;
    }
}
