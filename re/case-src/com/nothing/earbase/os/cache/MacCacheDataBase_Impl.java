package com.nothing.earbase.os.cache;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public final class MacCacheDataBase_Impl extends MacCacheDataBase {
    private volatile MacCacheDao _macCacheDao;

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(final DatabaseConfiguration config) {
        return config.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(new RoomOpenHelper(config, new RoomOpenHelper.Delegate(4) { // from class: com.nothing.earbase.os.cache.MacCacheDataBase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(final SupportSQLiteDatabase db) {
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(final SupportSQLiteDatabase db) {
                db.execSQL("CREATE TABLE IF NOT EXISTS `mac_cache` (`address` TEXT NOT NULL, `modelId` TEXT, `modelInt` INTEGER NOT NULL, `deviceType` INTEGER NOT NULL, `leftBattery` INTEGER NOT NULL, `rightBattery` INTEGER NOT NULL, `caseBattery` INTEGER NOT NULL, `firmwareVersion` TEXT, `autoUpdate` INTEGER NOT NULL, `timestap` INTEGER NOT NULL, PRIMARY KEY(`address`))");
                db.execSQL(RoomMasterTable.CREATE_QUERY);
                db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '4130d98d302505ff938ac98f72d39f77')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(final SupportSQLiteDatabase db) {
                db.execSQL("DROP TABLE IF EXISTS `mac_cache`");
                List list = MacCacheDataBase_Impl.this.mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onDestructiveMigration(db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onCreate(final SupportSQLiteDatabase db) {
                List list = MacCacheDataBase_Impl.this.mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onCreate(db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(final SupportSQLiteDatabase db) {
                MacCacheDataBase_Impl.this.mDatabase = db;
                MacCacheDataBase_Impl.this.internalInitInvalidationTracker(db);
                List list = MacCacheDataBase_Impl.this.mCallbacks;
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
                HashMap map = new HashMap(10);
                map.put("address", new TableInfo.Column("address", "TEXT", true, 1, null, 1));
                map.put("modelId", new TableInfo.Column("modelId", "TEXT", false, 0, null, 1));
                map.put("modelInt", new TableInfo.Column("modelInt", "INTEGER", true, 0, null, 1));
                map.put("deviceType", new TableInfo.Column("deviceType", "INTEGER", true, 0, null, 1));
                map.put("leftBattery", new TableInfo.Column("leftBattery", "INTEGER", true, 0, null, 1));
                map.put("rightBattery", new TableInfo.Column("rightBattery", "INTEGER", true, 0, null, 1));
                map.put("caseBattery", new TableInfo.Column("caseBattery", "INTEGER", true, 0, null, 1));
                map.put("firmwareVersion", new TableInfo.Column("firmwareVersion", "TEXT", false, 0, null, 1));
                map.put("autoUpdate", new TableInfo.Column("autoUpdate", "INTEGER", true, 0, null, 1));
                map.put("timestap", new TableInfo.Column("timestap", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo = new TableInfo("mac_cache", map, new HashSet(0), new HashSet(0));
                TableInfo tableInfo2 = TableInfo.read(db, "mac_cache");
                if (!tableInfo.equals(tableInfo2)) {
                    return new RoomOpenHelper.ValidationResult(false, "mac_cache(com.nothing.earbase.os.cache.entity.MacCacheEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
                }
                return new RoomOpenHelper.ValidationResult(true, null);
            }
        }, "4130d98d302505ff938ac98f72d39f77", "f7e29479588b4fa1773d7e1ecae64981")).build());
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "mac_cache");
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `mac_cache`");
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
        map.put(MacCacheDao.class, MacCacheDao_Impl.getRequiredConverters());
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

    @Override // com.nothing.earbase.os.cache.MacCacheDataBase
    public MacCacheDao getMacDao() {
        MacCacheDao macCacheDao;
        if (this._macCacheDao != null) {
            return this._macCacheDao;
        }
        synchronized (this) {
            if (this._macCacheDao == null) {
                this._macCacheDao = new MacCacheDao_Impl(this);
            }
            macCacheDao = this._macCacheDao;
        }
        return macCacheDao;
    }
}
