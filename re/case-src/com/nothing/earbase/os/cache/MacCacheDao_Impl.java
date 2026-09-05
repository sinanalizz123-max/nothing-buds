package com.nothing.earbase.os.cache;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.nothing.earbase.os.cache.entity.MacCacheEntity;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public final class MacCacheDao_Impl implements MacCacheDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<MacCacheEntity> __insertionAdapterOfMacCacheEntity;
    private final EntityDeletionOrUpdateAdapter<MacCacheEntity> __updateAdapterOfMacCacheEntity;

    public MacCacheDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfMacCacheEntity = new EntityInsertionAdapter<MacCacheEntity>(__db) { // from class: com.nothing.earbase.os.cache.MacCacheDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `mac_cache` (`address`,`modelId`,`modelInt`,`deviceType`,`leftBattery`,`rightBattery`,`caseBattery`,`firmwareVersion`,`autoUpdate`,`timestap`) VALUES (?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final MacCacheEntity entity) {
                if (entity.getAddress() == null) {
                    statement.bindNull(1);
                } else {
                    statement.bindString(1, entity.getAddress());
                }
                if (entity.getModelId() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getModelId());
                }
                statement.bindLong(3, entity.getModelInt());
                statement.bindLong(4, entity.getDeviceType());
                statement.bindLong(5, entity.getLeftBattery());
                statement.bindLong(6, entity.getRightBattery());
                statement.bindLong(7, entity.getCaseBattery());
                if (entity.getFirmwareVersion() == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindString(8, entity.getFirmwareVersion());
                }
                statement.bindLong(9, entity.getAutoUpdate());
                statement.bindLong(10, entity.getTimestap());
            }
        };
        this.__updateAdapterOfMacCacheEntity = new EntityDeletionOrUpdateAdapter<MacCacheEntity>(__db) { // from class: com.nothing.earbase.os.cache.MacCacheDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `mac_cache` SET `address` = ?,`modelId` = ?,`modelInt` = ?,`deviceType` = ?,`leftBattery` = ?,`rightBattery` = ?,`caseBattery` = ?,`firmwareVersion` = ?,`autoUpdate` = ?,`timestap` = ? WHERE `address` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final MacCacheEntity entity) {
                if (entity.getAddress() == null) {
                    statement.bindNull(1);
                } else {
                    statement.bindString(1, entity.getAddress());
                }
                if (entity.getModelId() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getModelId());
                }
                statement.bindLong(3, entity.getModelInt());
                statement.bindLong(4, entity.getDeviceType());
                statement.bindLong(5, entity.getLeftBattery());
                statement.bindLong(6, entity.getRightBattery());
                statement.bindLong(7, entity.getCaseBattery());
                if (entity.getFirmwareVersion() == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindString(8, entity.getFirmwareVersion());
                }
                statement.bindLong(9, entity.getAutoUpdate());
                statement.bindLong(10, entity.getTimestap());
                if (entity.getAddress() == null) {
                    statement.bindNull(11);
                } else {
                    statement.bindString(11, entity.getAddress());
                }
            }
        };
    }

    @Override // com.nothing.earbase.os.cache.MacCacheDao
    public long saveEntity(final MacCacheEntity entity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfMacCacheEntity.insertAndReturnId(entity);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.nothing.earbase.os.cache.MacCacheDao
    public int updateEntity(final MacCacheEntity entity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfMacCacheEntity.handle(entity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.nothing.earbase.os.cache.MacCacheDao
    public MacCacheEntity getCacheEntity(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from mac_cache where address =? ", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        MacCacheEntity macCacheEntity = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "address");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "modelId");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "modelInt");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deviceType");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "leftBattery");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rightBattery");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "caseBattery");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "firmwareVersion");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "autoUpdate");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestap");
            if (cursorQuery.moveToFirst()) {
                macCacheEntity = new MacCacheEntity(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getInt(columnIndexOrThrow3), cursorQuery.getInt(columnIndexOrThrow4), cursorQuery.getInt(columnIndexOrThrow5), cursorQuery.getInt(columnIndexOrThrow6), cursorQuery.getInt(columnIndexOrThrow7), cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8), cursorQuery.getInt(columnIndexOrThrow9), cursorQuery.getLong(columnIndexOrThrow10));
            }
            return macCacheEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.nothing.earbase.os.cache.MacCacheDao
    public MacCacheEntity getAirpods(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from mac_cache where address =? and deviceType = 1", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        MacCacheEntity macCacheEntity = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "address");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "modelId");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "modelInt");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deviceType");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "leftBattery");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rightBattery");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "caseBattery");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "firmwareVersion");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "autoUpdate");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestap");
            if (cursorQuery.moveToFirst()) {
                macCacheEntity = new MacCacheEntity(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getInt(columnIndexOrThrow3), cursorQuery.getInt(columnIndexOrThrow4), cursorQuery.getInt(columnIndexOrThrow5), cursorQuery.getInt(columnIndexOrThrow6), cursorQuery.getInt(columnIndexOrThrow7), cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8), cursorQuery.getInt(columnIndexOrThrow9), cursorQuery.getLong(columnIndexOrThrow10));
            }
            return macCacheEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.nothing.earbase.os.cache.MacCacheDao
    public MacCacheEntity getNothingEar(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from mac_cache where address =? and deviceType = 0", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        MacCacheEntity macCacheEntity = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "address");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "modelId");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "modelInt");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deviceType");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "leftBattery");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rightBattery");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "caseBattery");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "firmwareVersion");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "autoUpdate");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestap");
            if (cursorQuery.moveToFirst()) {
                macCacheEntity = new MacCacheEntity(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getInt(columnIndexOrThrow3), cursorQuery.getInt(columnIndexOrThrow4), cursorQuery.getInt(columnIndexOrThrow5), cursorQuery.getInt(columnIndexOrThrow6), cursorQuery.getInt(columnIndexOrThrow7), cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8), cursorQuery.getInt(columnIndexOrThrow9), cursorQuery.getLong(columnIndexOrThrow10));
            }
            return macCacheEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
